package umc6th.spring6th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc6th.spring6th.domain.Mission;

public interface MissionRepository  extends JpaRepository<Mission, Long> {
}
