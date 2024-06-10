package flow.backend.service;

import flow.backend.dto.request.ExtensionRequest;
import flow.backend.dto.response.ExtensionResponse;
import java.util.List;

public interface ExtensionService {
    public ExtensionResponse addExtension(ExtensionRequest extensionRequest);
    public ExtensionResponse deleteExtension(ExtensionRequest extensionRequest);
    List<ExtensionResponse> findAllEnabledExtensions();
}
