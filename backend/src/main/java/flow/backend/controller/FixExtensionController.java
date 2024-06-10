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
@RequestMapping("/api/fix-extension")
@RequiredArgsConstructor
public class FixExtensionController {

    private final ExtensionService fixExtensionService;

    // 메서드에 따른 Controller 구분

    @PostMapping("/{extension}")
    public ResponseEntity<ExtensionResponse> enableFixExtension(@PathVariable String extension) {
        ExtensionRequest extensionRequest = ExtensionRequest.builder()
            .extension(extension)
            .build();
        ExtensionResponse response = fixExtensionService.addExtension(extensionRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping ("/{extension}")
    public ResponseEntity<ExtensionResponse> disableFixExtension(@PathVariable String extension) {
        ExtensionRequest extensionRequest = ExtensionRequest.builder()
            .extension(extension)
            .build();
        ExtensionResponse response = fixExtensionService.deleteExtension(extensionRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ExtensionResponse>> findAllFixExtension() {
        List<ExtensionResponse> responses = fixExtensionService.findAllEnabledExtensions();
        return ResponseEntity.ok(responses);
    }
}
