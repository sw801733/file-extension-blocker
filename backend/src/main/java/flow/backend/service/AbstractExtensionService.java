package flow.backend.service;

import flow.backend.dto.response.ExtensionResponse;
import flow.backend.entitiy.Extension;
import flow.backend.repository.ExtensionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public abstract class AbstractExtensionService {

    protected final ExtensionRepository extensionRepository;

    protected abstract String getExtensionType();

    public List<ExtensionResponse> findAllEnableCustomExtensions() {
        List<Extension> extensions = extensionRepository.findByTypeAndIsCheckedTrue(getExtensionType());

        return extensions.stream().map(extension
            -> ExtensionResponse.builder()
            .type(getExtensionType())
            .extension(extension.getExtension())
            .checked(extension.isChecked())
            .build()
        ).collect(Collectors.toList());
    }

}
