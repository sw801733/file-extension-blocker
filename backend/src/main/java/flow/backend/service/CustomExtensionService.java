package flow.backend.service;

import flow.backend.repository.ExtensionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomExtensionService {

    private final ExtensionRepository extensionRepository;


}
