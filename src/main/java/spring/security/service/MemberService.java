package spring.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.security.dto.MemberDto;
import spring.security.entity.MemberEntity;
import spring.security.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    public void memberInsert(MemberDto memberDto) {

        MemberEntity memberEntity =
                MemberEntity.toMemberEntity(memberDto, passwordEncoder);

        Long memberId = memberRepository.save(memberEntity).getId();
        MemberEntity memberEntity1 = memberRepository.findById(memberId)
                .orElseThrow(()->{
            throw new IllegalArgumentException("생성되지 않음!");
        });

    }
}
