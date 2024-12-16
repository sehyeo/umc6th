package umc6th.spring6th.service.MemberService;

import umc6th.spring6th.domain.Member;
import umc6th.spring6th.web.dto.MemberRequestDTO;

public class MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
