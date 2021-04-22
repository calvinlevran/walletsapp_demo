package org.bsim.intern.io.irepository;

import org.bsim.intern.io.entity.UserEntity;
import org.bsim.intern.io.entity.WalletsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletsRepository extends JpaRepository<WalletsEntity, Long> {
    List<WalletsEntity> findAllByUser(UserEntity userEntity);
    WalletsEntity findByWalletId(String walletId);
}
