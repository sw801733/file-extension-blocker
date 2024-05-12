package flow.backend.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ExtensionRequest {
    private String extension;
    private String type;
    private boolean checked;
}
