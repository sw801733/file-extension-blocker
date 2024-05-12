package flow.backend.controller;

import flow.backend.dto.request.ExtensionRequest;
import flow.backend.dto.response.ExtensionResponse;
import flow.backend.service.FixExtensionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fix-extension")
@RequiredArgsConstructor
public class FixExtensionController {

    private final FixExtensionService fixExtensionService;

    @PostMapping("/")
    public ResponseEntity<ExtensionResponse> enableFixExtension(@RequestBody ExtensionRequest request) {
        ExtensionResponse response = fixExtensionService.enableFixExtension(request);
        return ResponseEntity.ok(response);
    }
}
