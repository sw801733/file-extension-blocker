package flow.backend.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class ExtensionResponse {

    private String extension;
    private String type;
    private boolean checked;

    private String result;

}
