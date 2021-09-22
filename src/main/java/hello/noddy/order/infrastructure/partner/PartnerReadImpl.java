package hello.noddy.order.infrastructure.partner;

import hello.noddy.order.common.exception.EntityNotFoundException;
import hello.noddy.order.domain.partner.Partner;
import hello.noddy.order.domain.partner.PartnerReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PartnerReadImpl implements PartnerReader {

  private final PartnerRepository partnerRepository;

  @Override
  public Partner getPartner(String partnerToken) {
    return partnerRepository.findByPartnerToken(partnerToken)
        .orElseThrow(EntityNotFoundException::new);
  }
}
