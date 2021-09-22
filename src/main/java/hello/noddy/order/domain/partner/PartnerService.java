package hello.noddy.order.domain.partner;

public interface PartnerService {
  // Command : 명령
  // Criteria : 조회
  // Info : 객체 리턴

  PartnerInfo registerPartner(PartnerCommand command);

  PartnerInfo getPartnerInfo(String partnerToken);

  PartnerInfo enablePartner(String partnerToken);

  PartnerInfo disablePartner(String partnerToken);
}
