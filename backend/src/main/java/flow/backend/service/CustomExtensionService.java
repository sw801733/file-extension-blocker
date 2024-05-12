package flow.backend.service;

import flow.backend.dto.request.ExtensionRequest;
import flow.backend.dto.response.ExtensionResponse;
import flow.backend.entitiy.Extension;
import flow.backend.repository.ExtensionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomExtensionService {

    private final ExtensionRepository extensionRepository;

    // 커스텀 확장자 추가
    public ExtensionResponse addCustomExtension(ExtensionRequest extensionRequest) {

        String extensionName = extensionRequest.getExtension();

        // 확장자가 이미 존재하는 경우, 예외 메시지를 포함한 응답을 반환
        Extension existingExtension = extensionRepository.findByExtension(extensionName);
        if (existingExtension != null) {
            throw new IllegalArgumentException(extensionName + " 확장자는 이미 존재합니다.");
        }

        Extension extension = Extension.builder()
            .extension(extensionName)
            .type("Custom")
            .isChecked(true)
            .build();
        extensionRepository.save(extension);

        return ExtensionResponse.builder()
            .extension(extensionName)
            .type("Custom")
            .checked(true)
            .result(extensionName + " 커스텀 확장자가 추가 되었습니다.")
            .build();
    }

    // 커스텀 확장자 삭제
    public ExtensionResponse deleteCustomExtension(ExtensionRequest extensionRequest) {
        String extensionName = extensionRequest.getExtension();
        Extension extension = extensionRepository.findByExtension(extensionName);

        String extensionType = extension.getType();
        boolean isChecked = extension.isChecked();

        if (isChecked) {
            extensionRepository.delete(extension);
        }

        return ExtensionResponse.builder()
            .extension(extensionName)
            .type(extensionType)
            .checked(false)
            .result(extensionName + " 커스텀 확장자가 삭제 되었습니다.")
            .build();

    }

    // 추가한 커스텀 확장자 모두 조회
    public List<ExtensionResponse> findAllEnableCustomExtensions() {
        List<Extension> extensions = extensionRepository.findByTypeAndIsCheckedTrue("Custom");

        return extensions.stream().map(extension
            -> ExtensionResponse.builder()
            .type("Custom")
            .extension(extension.getExtension())
            .checked(extension.isChecked())
            .build()
        ).collect(Collectors.toList());
    }
}
