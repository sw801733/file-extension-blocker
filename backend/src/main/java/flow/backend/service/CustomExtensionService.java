package flow.backend.service;

import flow.backend.dto.request.ExtensionRequest;
import flow.backend.dto.response.ExtensionResponse;
import flow.backend.entitiy.Extension;
import flow.backend.repository.ExtensionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomExtensionService {

    private final ExtensionRepository extensionRepository;

    public ExtensionResponse addCustomExtension(ExtensionRequest extensionRequest) {

        String extensionName = extensionRequest.getExtension();

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

    public ExtensionResponse deleteCustomExtension(ExtensionRequest extensionRequest) {
        String extensionName = extensionRequest.getExtension();
        String extensionType = extensionRequest.getType();
        boolean isChecked = extensionRequest.isChecked();

        Extension extension = extensionRepository.findByExtension(extensionName);

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
}
