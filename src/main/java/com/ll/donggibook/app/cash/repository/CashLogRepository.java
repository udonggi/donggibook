package com.ll.donggibook.app.cash.repository;

import com.ll.donggibook.app.cash.entity.CashLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashLogRepository extends JpaRepository<CashLog, Long> {
}
