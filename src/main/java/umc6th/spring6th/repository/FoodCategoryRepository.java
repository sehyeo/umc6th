package umc6th.spring6th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc6th.spring6th.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
