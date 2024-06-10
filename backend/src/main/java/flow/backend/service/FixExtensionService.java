package flow.backend.service;

import flow.backend.dto.request.ExtensionRequest;
import flow.backend.dto.response.ExtensionResponse;
import flow.backend.entitiy.Extension;
import flow.backend.repository.ExtensionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class FixExtensionService extends AbstractExtensionService{

    public FixExtensionService(ExtensionRepository extensionRepository) {
        super(extensionRepository);
    }

    @Override
    protected String getExtensionType() {
        return "Fix";
    }

    // 고정 확장자 활성화
    public ExtensionResponse addExtension(ExtensionRequest extensionRequest) {

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
            .checked(true)
            .result(extensionName + " 고정 확장자가 활성화 되었습니다.")
            .build();
    }

    // 고정 확장자 비활성화
    public ExtensionResponse deleteExtension(ExtensionRequest extensionRequest) {
        String extensionName = extensionRequest.getExtension();
        Extension extension = extensionRepository.findByExtension(extensionName);

        String extensionType = extension.getType();
        boolean isChecked = extension.isChecked();

        if (isChecked) {
            extension.setChecked(false);
            extensionRepository.save(extension);
        }

        return ExtensionResponse.builder()
            .extension(extensionName)
            .type(extensionType)
            .checked(false)
            .result(extensionName + " 고정 확장자가 비활성화 되었습니다.")
            .build();

    }


}
