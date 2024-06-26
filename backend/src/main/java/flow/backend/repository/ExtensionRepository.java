package flow.backend.repository;

import flow.backend.entitiy.Extension;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtensionRepository extends JpaRepository<Extension, Long>{
    // 선택한 고정 확장자 or 커스텀 확장자 모두 조회
    List<Extension> findByTypeAndIsCheckedTrue(String type);

    // 특정 확장자 조회
    Extension findByExtension(String extension);



}
