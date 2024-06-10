package flow.backend.controller;

import flow.backend.dto.request.ExtensionRequest;
import flow.backend.dto.response.ExtensionResponse;

import flow.backend.service.ExtensionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/custom-extension")
@RequiredArgsConstructor
public class CustomExtensionController {

    private final ExtensionService customExtensionService;


    // 메서드에 따른 Controller 구분

    @PostMapping("/{extension}")
    public ResponseEntity<ExtensionResponse> addCustomExtension(@PathVariable String extension) {
        try {
            ExtensionRequest extensionRequest = ExtensionRequest.builder()
                .extension(extension)
                .build();
            ExtensionResponse response = customExtensionService.addExtension(extensionRequest);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                .badRequest()
                .body(ExtensionResponse.builder()
                    .result(e.getMessage())
                    .build());
        }
    }

    @DeleteMapping("/{extension}")
    public ResponseEntity<ExtensionResponse> deleteCustomExtension(@PathVariable String extension) {
        ExtensionRequest extensionRequest = ExtensionRequest.builder()
            .extension(extension)
            .build();
        ExtensionResponse response = customExtensionService.deleteExtension(extensionRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ExtensionResponse>> findAllCustomExtension() {
        List<ExtensionResponse> responses = customExtensionService.findAllEnabledExtensions();
        return ResponseEntity.ok(responses);
    }
}
