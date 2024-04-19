package kr.mogak.service;

import kr.mogak.dto.request.MemberRequestDto;
import kr.mogak.dto.response.MemberResponseDto;
import kr.mogak.entity.Member;
import kr.mogak.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private MemberRepository memberRepository;
    public MemberResponseDto login(MemberRequestDto memberRequest) {
        String inputId = memberRequest.getLoginId();
        String inputPw = memberRequest.getPassword();
        Optional<Member> member = memberRepository.findByLoginIdAndPassword(inputId, inputPw);
        MemberResponseDto memberResponse = new MemberResponseDto();
        // TODO member와 memberResponse 매핑 후 반환
        return memberResponse;
    }
}
