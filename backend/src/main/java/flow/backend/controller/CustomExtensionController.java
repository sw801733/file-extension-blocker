package flow.backend.controller;

import flow.backend.dto.request.ExtensionRequest;
import flow.backend.dto.response.ExtensionResponse;
import flow.backend.service.CustomExtensionService;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/custom-extension")
@RequiredArgsConstructor
public class CustomExtensionController {

    private final CustomExtensionService customExtensionService;


    // 메서드에 따른 Controller 구분

    @PostMapping("/")
    public ResponseEntity<ExtensionResponse> addCustomExtension(@RequestParam("extension") String extension) {
        ExtensionRequest extensionRequest = ExtensionRequest.builder()
            .extension(extension)
            .build();
        ExtensionResponse response = customExtensionService.addCustomExtension(extensionRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/")
    public ResponseEntity<ExtensionResponse> deleteCustomExtension(@RequestParam("extension") String extension) {
        ExtensionRequest extensionRequest = ExtensionRequest.builder()
            .extension(extension)
            .build();
        ExtensionResponse response = customExtensionService.deleteCustomExtension(extensionRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<List<ExtensionResponse>> findAllCustomExtension() {
        List<ExtensionResponse> responses = customExtensionService.findAllEnableCustomExtensions();
        return ResponseEntity.ok(responses);
    }
}
