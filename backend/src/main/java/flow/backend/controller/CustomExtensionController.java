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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/custom-extension")
@RequiredArgsConstructor
public class CustomExtensionController {

    private final CustomExtensionService customExtensionService;

    @PostMapping("/")
    public ResponseEntity<ExtensionResponse> addCustomExtension(@RequestBody ExtensionRequest request) {
        ExtensionResponse response = customExtensionService.addCustomExtension(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/")
    public ResponseEntity<ExtensionResponse> deleteCustomExtension(@RequestBody ExtensionRequest request) {
        ExtensionResponse response = customExtensionService.deleteCustomExtension(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<List<ExtensionResponse>> findAllCustomExtension() {
        List<ExtensionResponse> responses = customExtensionService.findAllEnableCustomExtensions();
        return ResponseEntity.ok(responses);
    }
}
