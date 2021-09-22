package hello.noddy.order.domain.partner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService {

  private final PartnerReader partnerReader;
  private final PartnerStore partnerStore;

  @Override
  @Transactional
  public PartnerInfo registerPartner(PartnerCommand command) {
    // 1. command -> initPartner로 만든다.
    // 2. initParter save to DB
    // 3. Partner -> PartnerInfo And return

    var initPartner = command.toEntity();
    Partner partner = partnerStore.store(initPartner);
    return new PartnerInfo(partner);
  }

  @Override
  @Transactional(readOnly = true)
  public PartnerInfo getPartnerInfo(String partnerToken) {
    // 1. partnerTOken으로 partner를 읽는다.
    // 2. Partner -> PartnerInfo AND return
    Partner partner = partnerReader.getPartner(partnerToken);
    return new PartnerInfo(partner);
  }

  @Override
  @Transactional
  public PartnerInfo enablePartner(String partnerToken) {
    // 1. partnerToken으로 partner를 가져온다.
    // 2. 파트너를 활성화한다.
    Partner partner = partnerReader.getPartner(partnerToken);
    partner.enable();
    return new PartnerInfo(partner);
  }

  @Override
  @Transactional
  public PartnerInfo disablePartner(String partnerToken) {
    Partner partner = partnerReader.getPartner(partnerToken);
    partner.disable();
    return new PartnerInfo(partner);
  }
}
