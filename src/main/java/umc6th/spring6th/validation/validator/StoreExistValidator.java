package umc6th.spring6th.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Optional;
import org.springframework.stereotype.Component;
import umc6th.spring6th.apiPayload.code.status.ErrorStatus;
import umc6th.spring6th.domain.Store;
import umc6th.spring6th.service.StoreService.StoreQueryService;
import umc6th.spring6th.validation.annotation.ExistStore;

@Component
public class StoreExistValidator implements ConstraintValidator<ExistStore, Long> {
    private final StoreQueryService storeQueryService;

    public void initialize(ExistStore constraintAnnotation) {
        super.initialize(constraintAnnotation);
    }

    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Optional<Store> target = this.storeQueryService.findStore(value);
        if (target.isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        } else {
            return true;
        }
    }

    public StoreExistValidator(final StoreQueryService storeQueryService) {
        this.storeQueryService = storeQueryService;
    }
}
