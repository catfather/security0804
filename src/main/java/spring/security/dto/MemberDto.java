package spring.security.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import spring.security.contrant.Role;
import spring.security.entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto  {


    private Long id;
    //username, password, role
    private String email; //user username

    private String password; // User Password -> passwordEncoder -> 반드시 암호화 해야한다.

    private Role role;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;
}
