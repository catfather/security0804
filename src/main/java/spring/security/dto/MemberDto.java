package spring.security.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import spring.security.contrant.Role;
import spring.security.entity.BaseEntity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto  {


    private Long id;
    //username, password, role

    @Size(min = 3,max = 255)
    private String email; //user username

    @NotBlank(message = "비밀번호를 입력 필수로!")
    private String password; // User Password -> passwordEncoder -> 반드시 암호화 해야한다.

    private Role role;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;
}
