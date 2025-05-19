package umc6th.spring6th.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import org.springframework.stereotype.Component;
import umc6th.spring6th.apiPayload.code.status.ErrorStatus;
import umc6th.spring6th.repository.FoodCategoryRepository;
import umc6th.spring6th.validation.annotation.ExistCategories;

@Component
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {
    private final FoodCategoryRepository foodCategoryRepository;

    public void initialize(ExistCategories constraintAnnotation) {
        super.initialize(constraintAnnotation);
    }

    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream().allMatch((value) -> {
            return this.foodCategoryRepository.existsById(value);
        });
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }

    public CategoriesExistValidator(final FoodCategoryRepository foodCategoryRepository) {
        this.foodCategoryRepository = foodCategoryRepository;
    }
}
