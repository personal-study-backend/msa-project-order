package hello.noddy.order.domain;

import java.time.ZonedDateTime;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {

  // @CreatedDate -> 스프링에서 제공 (LocalDateTime만 지원)
  @CreationTimestamp // 하이버네이트가 제공
  private ZonedDateTime createdAt;

  // @LastModifiedDate
  @UpdateTimestamp
  private ZonedDateTime updatedAt;
}
