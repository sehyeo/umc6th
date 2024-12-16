package umc6th.spring6th.service.MemberService;

import java.util.Optional;
import umc6th.spring6th.domain.Member;

public class MemberQueryService {
    Optional<Member> findMember(Long id);
}
