package flow.backend.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "extensions")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Extension {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "extension", nullable = false)
    private String extension;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "is_checked", nullable = false)
    private boolean isChecked;

}
