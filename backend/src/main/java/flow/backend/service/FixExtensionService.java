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
public class FixExtensionService {

    private final ExtensionRepository extensionRepository;

    public ExtensionResponse checkFixExtension(ExtensionRequest extensionRequest) {

        String extensionName = extensionRequest.getExtension();
        String extensionType = extensionRequest.getType();
        boolean isChecked = extensionRequest.isChecked();

        Extension extension = extensionRepository.findByExtension(extensionName);

        if (!isChecked) {
            extension.setChecked(true);
            extensionRepository.save(extension);
        }

        return ExtensionResponse.builder()
            .extension(extensionName)
            .type(extensionType)
            .checked(isChecked)
            .result(extensionName + " 고정 확장자가 추가 되었습니다.")
            .build();
    }

}
