package hello.noddy.order.domain.partner;

import java.time.ZonedDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name = "partners")
public class Partner {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String partnerToken;
  private String partnerName;
  private String businessNo;
  private String email;

  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;

  @Enumerated(EnumType.STRING)
  private Status status;

  @Builder
  public Partner(String partnerName, String businessNo, String email) {
    if (partnerName == null) {
      throw new RuntimeException("empty partnerName");
    }
    if (businessNo == null) {
      throw new RuntimeException("empty businessNo");
    }
    if (email == null) {
      throw new RuntimeException("empty email");
    }
    this.partnerToken = "abcde";
    this.partnerName = partnerName;
    this.businessNo = businessNo;
    this.email = email;
    this.status = Status.ENABLE;
    this.createdAt = ZonedDateTime.now();
    this.updatedAt = ZonedDateTime.now();
  }

  @Getter
  @RequiredArgsConstructor
  public enum Status {
    ENABLE("활성화"), DISABLE("비활성화");
    private final String description;
  }

  public void enable() {
    this.status = Status.ENABLE;
  }

  public void disable() {
    this.status = Status.DISABLE;
  }
}