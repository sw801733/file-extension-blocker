package flow.backend.controller;

import flow.backend.service.CustomExtensionService;
import flow.backend.service.FixExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/custom-extension")
@RequiredArgsConstructor
public class CustomExtensionController {

    private final CustomExtensionService customExtensionService;
}
