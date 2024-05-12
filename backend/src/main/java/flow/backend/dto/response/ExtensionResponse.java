package flow.backend.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExtensionResponse {

    private String extension;
    private String type;
    private boolean checked;

    private String result;

}
