package org.bsim.intern.service.impl;

import org.bsim.intern.io.entity.UserEntity;
import org.bsim.intern.io.entity.WalletsEntity;
import org.bsim.intern.io.irepository.UserRepository;
import org.bsim.intern.io.irepository.WalletsRepository;
import org.bsim.intern.service.iservice.IWalletsService;
import org.bsim.intern.shared.dto.UserDTO;
import org.bsim.intern.shared.dto.WalletsDTO;
import org.bsim.intern.shared.utils.GenerateRandomPublicId;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletsServiceImpl implements IWalletsService {

    @Autowired
    WalletsRepository walletsRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    GenerateRandomPublicId generateRandomPublicId;

    @Override
    public List<WalletsDTO> getAllWalletsData(String userid) {
        List<WalletsEntity> walletsData = walletsRepository.findAllByUser(userRepository.findByUserid(userid));

        return new ModelMapper().map(walletsData, new TypeToken<List<WalletsDTO>>(){}.getType());
    }

    @Override
    public long getTotalBalance(String userid) {
        List<WalletsEntity> walletsData = walletsRepository.findAllByUser(userRepository.findByUserid(userid));
        if(walletsData==null)
            return 0L;
        long totalBalance=0;
        for(WalletsEntity walletsEntity:walletsData){
            totalBalance += walletsEntity.getBalance();
        }
        return totalBalance;
    }

    @Override
    public WalletsDTO addNewWalletData(String userid, WalletsDTO walletsDTO){
        ModelMapper mapper = new ModelMapper();

        //generate Wallet Id
        walletsDTO.setWalletId(generateRandomPublicId.generateUserId(30));
        //Get User
        UserEntity userData = userRepository.findByUserid(userid);
        // Set User
        walletsDTO.setUser(mapper.map(userData, UserDTO.class));
        // walletsEntity
        WalletsEntity entity = mapper.map(walletsDTO, WalletsEntity.class);
        // save data to database (dengan table wallet)
        WalletsEntity storedData = walletsRepository.save(entity);

        return mapper.map(storedData, WalletsDTO.class);
    }

    @Override
    public WalletsDTO updateWalletData(String userid, String walletid, WalletsDTO walletsDTO) {
        WalletsEntity walletData = walletsRepository.findByWalletId(walletid);
        if(walletData==null)
            return null;
        // update nohp (or) balance
        walletData.setNoHP(walletsDTO.getNoHP());
        walletData.setBalance(walletsDTO.getBalance());

        WalletsEntity updateData = walletsRepository.save(walletData);
        return new ModelMapper().map(updateData, WalletsDTO.class);
    }
}
