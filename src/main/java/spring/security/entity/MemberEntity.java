package spring.security.entity;

import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring.security.contrant.Role;
import spring.security.dto.MemberDto;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "sec_member_04")
public class MemberEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    //username, password, role

    @Column(name = "name" , length = 255, unique = true)
    private String email; //user username

    @Column(nullable = false)
    private String password; // User Password -> passwordEncoder -> 반드시 암호화 해야한다.

    //role
    @Enumerated(EnumType.STRING)
    private Role role;

    public static MemberEntity toMemberEntity(MemberDto memberDto, PasswordEncoder passwordEncoder) {
                MemberEntity memberEntity = MemberEntity.builder()
                .email(memberDto.getEmail())
                .password(passwordEncoder.encode(memberDto.getPassword()))
                .role(Role.MEMBER)
                        //반드시 비밀번호 암호화 필수!
                .build();
        return memberEntity;
    }
}
