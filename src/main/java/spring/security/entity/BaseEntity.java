package spring.security.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import spring.security.contrant.Role;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public class BaseEntity {

   @CreationTimestamp
   @Column(updatable = false, name = "create_date")
   private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(insertable = false, name = "update_date")
    private LocalDateTime updateDate;
}
