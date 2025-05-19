package umc6th.spring6th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc6th.spring6th.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
