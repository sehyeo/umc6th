package umc6th.spring6th.converter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import umc6th.spring6th.domain.Member;
import umc6th.spring6th.domain.enums.Gender;
import umc6th.spring6th.web.dto.MemberRequestDTO;
import umc6th.spring6th.web.dto.MemberResponseDTO;
import umc6th.spring6th.web.dto.MemberResponseDTO.JoinResultDTO;

public class MemberConverter {
    public MemberConverter() {
    }

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return JoinResultDTO.builder().memberId(member.getId()).createdAt(LocalDateTime.now()).build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request) {
        Gender gender = null;
        switch (request.getGender()) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
        }

        return Member.builder().address(request.getAddress()).specAddress(request.getSpecAddress()).gender(gender).name(request.getName()).memberPreferList(new ArrayList()).build();
    }
}
