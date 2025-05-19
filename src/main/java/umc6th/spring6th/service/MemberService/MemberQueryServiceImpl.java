package umc6th.spring6th.service.MemberService;

import umc6th.spring6th.domain.Member;
import umc6th.spring6th.repository.MemberRepository;

import java.util.Optional;

public class MemberQueryServiceImpl {
    private final MemberRepository memberRepository;

    public Optional<Member> findMember(Long id) {
        return this.memberRepository.findById(id);
    }

    public MemberQueryServiceImpl(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
}
