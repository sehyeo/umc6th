package umc6th.spring6th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc6th.spring6th.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
