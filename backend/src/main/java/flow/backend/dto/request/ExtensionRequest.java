package flow.backend.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExtensionRequest {
    private String extension;
    private String type;
    private boolean checked;
}
