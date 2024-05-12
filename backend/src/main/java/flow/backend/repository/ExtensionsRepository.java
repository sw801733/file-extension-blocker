package flow.backend.repository;

import flow.backend.entitiy.Extensions;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtensionsRepository extends JpaRepository<Extensions, Long>{
    // 선택한 고정 확장자 or 커스텀 확장자 모두 조회
    List<Extensions> findByTypeAndCheckedTrue(String type);



}
