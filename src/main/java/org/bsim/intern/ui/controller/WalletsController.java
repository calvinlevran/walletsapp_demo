package org.bsim.intern.ui.controller;

import org.bsim.intern.service.iservice.IWalletsService;
import org.bsim.intern.shared.dto.WalletsDTO;
import org.bsim.intern.ui.model.request.WalletRequest;
import org.bsim.intern.ui.model.response.WalletResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@Service
@RestController
@RequestMapping("/api/v1/wallets")
public class WalletsController {

    @Autowired
    IWalletsService walletsService;

    @GetMapping(path = "/{userid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<WalletResponse> getAllWallets(@PathVariable String userid){
        List<WalletsDTO> walletsData = walletsService.getAllWalletsData(userid);

        return new ModelMapper().map(walletsData, new TypeToken<List<WalletResponse>>(){}.getType());
    }

    @GetMapping(path = "/{userid}/balance", produces = {MediaType.APPLICATION_JSON_VALUE})
    public long getTotalBalance(@PathVariable String userid){
        long totalBalance = walletsService.getTotalBalance(userid);
        return totalBalance;
    }

    // create new wallet
    @PostMapping(path = "/{userid}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public WalletResponse addNewWallet(@PathVariable String userid,@RequestBody WalletRequest walletRequest){
        ModelMapper mapper = new ModelMapper();

        WalletsDTO walletsDTO = mapper.map(walletRequest, WalletsDTO.class);
        WalletsDTO createdWallet = walletsService.addNewWalletData(userid, walletsDTO);

        return mapper.map(createdWallet, WalletResponse.class);
    }
    //produce itu balikan, consumes itu inputan
    @PutMapping(path = "/{userid}/{walletid}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public WalletResponse updateWalletAmount(@PathVariable String userid,
                                             @PathVariable String walletid,
                                             @RequestBody WalletRequest walletRequest){
        ModelMapper mapper = new ModelMapper();
        //WalletRequest --> WalletsDTO
        WalletsDTO walletDTO = mapper.map(walletRequest, WalletsDTO.class);
        WalletsDTO updateWallet = walletsService.updateWalletData(userid, walletid, walletDTO);
        return mapper.map(updateWallet, WalletResponse.class);
    }
}
