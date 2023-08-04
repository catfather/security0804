package spring.security.config;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.security.entity.MemberEntity;
import spring.security.repository.MemberRepository;


/* TODO
 이 서비스는 db 테이블에 접근해 입력받은 사용자 정보(form)을 비교 하는 서비스임
 비교해서 일치하면 user->userDetails 객체에 공유 시킴
 */

@Service
@AllArgsConstructor
@RequiredArgsConstructor

public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //우리는 email로 확인할꺼니까~ email이 unique임

        MemberEntity memberEntity = memberRepository.findByEmail(email).orElseThrow(()->{
            throw new IllegalArgumentException("정보가 없음;;");
        });



        return User.builder()
                .username(memberEntity.getEmail())
                .password(memberEntity.getPassword())
                .roles(memberEntity.getRole().toString())
                .build();

        //User 객체의 빌더로 가져온 email,pw를 리턴함
    }
}
