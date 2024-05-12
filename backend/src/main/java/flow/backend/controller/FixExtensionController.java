package flow.backend.controller;

import flow.backend.dto.request.ExtensionRequest;
import flow.backend.dto.response.ExtensionResponse;
import flow.backend.service.FixExtensionService;
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
@RequestMapping("/api/fix-extension")
@RequiredArgsConstructor
public class FixExtensionController {

    private final FixExtensionService fixExtensionService;

    // 메서드에 따른 Controller 구분

    @PostMapping("/")
    public ResponseEntity<ExtensionResponse> enableFixExtension(@RequestBody ExtensionRequest request) {
        ExtensionResponse response = fixExtensionService.enableFixExtension(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping ("/")
    public ResponseEntity<ExtensionResponse> disableFixExtension(@RequestBody ExtensionRequest request) {
        ExtensionResponse response = fixExtensionService.disableFixExtension(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping  ("/")
    public ResponseEntity<List<ExtensionResponse>> findAllFixExtension() {
        List<ExtensionResponse> responses = fixExtensionService.findAllEnableFixExtensions();
        return ResponseEntity.ok(responses);
    }
}
