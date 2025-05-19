package umc6th.spring6th.service.MemberService;

import java.util.Optional;
import umc6th.spring6th.domain.Member;

public interface MemberQueryService {
    Optional<Member> findMember(Long id);
}
