package umc6th.spring6th.service.MemberService;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import umc6th.spring6th.apiPayload.code.status.ErrorStatus;
import umc6th.spring6th.apiPayload.exception.handler.FoodCategoryHandler;
import umc6th.spring6th.converter.MemberConverter;
import umc6th.spring6th.converter.MemberPreferConverter;
import umc6th.spring6th.domain.FoodCategory;
import umc6th.spring6th.domain.Member;
import umc6th.spring6th.domain.mapping.MemberPrefer;
import umc6th.spring6th.repository.FoodCategoryRepository;
import umc6th.spring6th.repository.MemberRepository;
import umc6th.spring6th.web.dto.MemberRequestDTO;

@Service
public class MemberCommandServiceImpl implements MemberCommandService {
    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = (List)request.getPreferCategory().stream().map((category) -> {
            return (FoodCategory)this.foodCategoryRepository.findById(category).orElseThrow(() -> {
                return new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND);
            });
        }).collect(Collectors.toList());
        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);
        memberPreferList.forEach((memberPrefer) -> {
            memberPrefer.setMember(newMember);
        });
        return (Member)this.memberRepository.save(newMember);
    }

    public MemberCommandServiceImpl(final MemberRepository memberRepository, final FoodCategoryRepository foodCategoryRepository) {
        this.memberRepository = memberRepository;
        this.foodCategoryRepository = foodCategoryRepository;
    }
}
