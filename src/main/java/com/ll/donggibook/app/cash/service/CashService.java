package com.ll.donggibook.app.cash.service;

import com.ll.donggibook.app.cash.entity.CashLog;
import com.ll.donggibook.app.cash.repository.CashLogRepository;
import com.ll.donggibook.app.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashService {
    private final CashLogRepository cashLogRepository;

    public CashLog addCash(Member member, long price, String relTypeCode, long relId, CashLog.EvenType eventType) {
        CashLog cashLog = CashLog.builder()
                .member(member)
                .price(price)
                .relTypeCode(relTypeCode)
                .relId(relId)
                .eventType(eventType)
                .build();

        cashLogRepository.save(cashLog);

        return cashLog;
    }
}
