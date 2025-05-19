package umc6th.spring6th.converter;

import java.util.List;
import java.util.stream.Collectors;
import umc6th.spring6th.domain.FoodCategory;
import umc6th.spring6th.domain.mapping.MemberPrefer;

public class MemberPreferConverter {
    public MemberPreferConverter() {
    }

    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList) {
        return (List)foodCategoryList.stream().map((foodCategory) -> {
            return MemberPrefer.builder().foodCategory(foodCategory).build();
        }).collect(Collectors.toList());
    }
}
