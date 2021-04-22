package org.bsim.intern.service.iservice;

import org.bsim.intern.shared.dto.WalletsDTO;

import java.util.List;

public interface IWalletsService{
    List<WalletsDTO> getAllWalletsData(String userid);
    long getTotalBalance(String userid);
    WalletsDTO addNewWalletData(String userid, WalletsDTO walletsDTO);
    WalletsDTO updateWalletData(String userid, String walletid, WalletsDTO walletsDTO);
}
