package org.bsim.intern.io.irepository;

import org.bsim.intern.io.entity.TransactionsEntity;
import org.bsim.intern.io.entity.WalletsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionsRepository extends JpaRepository<TransactionsEntity, Long> {
    List<TransactionsEntity> findAllByWalletsEntity(WalletsEntity walletsEntity);

    TransactionsEntity findAllByTransactionsId(String transactionId);
}
