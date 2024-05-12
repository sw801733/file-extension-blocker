package flow.backend.repository;

import flow.backend.entitiy.Extension;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtensionsRepository extends JpaRepository<Extension, Long>{
    // 선택한 고정 확장자 or 커스텀 확장자 모두 조회
    List<Extension> findByTypeAndCheckedTrue(String type);



}
