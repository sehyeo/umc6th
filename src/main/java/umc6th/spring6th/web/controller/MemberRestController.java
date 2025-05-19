package umc6th.spring6th.web.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc6th.spring6th.apiPayload.ApiResponse;
import umc6th.spring6th.converter.MemberConverter;
import umc6th.spring6th.domain.Member;
import umc6th.spring6th.service.MemberService.MemberCommandService;
import umc6th.spring6th.web.dto.MemberRequestDTO;
import umc6th.spring6th.web.dto.MemberResponseDTO;

@RestController
@RequestMapping({"/members"})
public class MemberRestController {
    private final MemberCommandService memberCommandService;

    @PostMapping({"/"})
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.@Valid JoinDto request) {
        Member member = this.memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    public MemberRestController(final MemberCommandService memberCommandService) {
        this.memberCommandService = memberCommandService;
    }
}

