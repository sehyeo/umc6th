package umc6th.spring6th.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Optional;
import org.springframework.stereotype.Component;
import umc6th.spring6th.apiPayload.code.status.ErrorStatus;
import umc6th.spring6th.domain.Member;
import umc6th.spring6th.service.MemberService.MemberQueryService;
import umc6th.spring6th.validation.annotation.ExistMember;

@Component
public class MemberExistsValidator implements ConstraintValidator<ExistMember, Long> {
    private final MemberQueryService memberQueryService;

    public void initialize(ExistMember constraintAnnotation) {
        super.initialize(constraintAnnotation);
    }

    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Optional<Member> target = this.memberQueryService.findMember(value);
        if (target.isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        } else {
            return true;
        }
    }

    public MemberExistsValidator(final MemberQueryService memberQueryService) {
        this.memberQueryService = memberQueryService;
    }
}
