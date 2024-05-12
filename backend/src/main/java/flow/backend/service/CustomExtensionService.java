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

    public ExtensionResponse enableCustomExtension(ExtensionRequest extensionRequest) {

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
            .result(extensionName + " 커스텀 확장자가 활성화 되었습니다.")
            .build();
    }
}
