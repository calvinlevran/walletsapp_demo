package org.bsim.intern.ui.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.bsim.intern.io.entity.TransactionsEntity;
import org.bsim.intern.service.iservice.IServiceTransactions;
import org.bsim.intern.shared.dto.TransactionsDto;
import org.bsim.intern.ui.model.request.TransactionsRequest;
import org.bsim.intern.ui.model.response.TransactionsResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionsController {

    private final IServiceTransactions iServiceTransactions;

    public TransactionsController(IServiceTransactions iServiceTransactions) {
        this.iServiceTransactions = iServiceTransactions;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<TransactionsResponse> getAllTransactions(){
        ModelMapper modelMapper = new ModelMapper();
        List<TransactionsResponse> returnValue = new ArrayList<>();

        List<TransactionsDto> transactionsDto = iServiceTransactions.getAllTransactions();

        for(TransactionsDto dto : transactionsDto){
            returnValue.add(modelMapper.map(dto, TransactionsResponse.class));
        }
        return returnValue;
    }

    @PostMapping(path = "/{walletId}",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public TransactionsResponse addNewTransactions(@PathVariable String walletId,
                                                   @RequestBody TransactionsRequest transactionsRequest){

        ModelMapper modelMapper = new ModelMapper();

        TransactionsDto transactionsDto = modelMapper.map(transactionsRequest, TransactionsDto.class);

        TransactionsDto storedValue = iServiceTransactions.addNewTransactions(walletId, transactionsDto);
        TransactionsResponse returnValue  = modelMapper.map(storedValue, TransactionsResponse.class);

        return returnValue;
    }

    @GetMapping(path = "/{walletId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<TransactionsResponse> getAllTransactionsByWalletId(@PathVariable String walletId){
        ModelMapper modelMapper = new ModelMapper();
        List<TransactionsResponse> returnValue = new ArrayList<>();

        List<TransactionsDto> allTransactions = iServiceTransactions.getAllTransactionsByWalletId(walletId);
        for(TransactionsDto dto : allTransactions){
            returnValue.add(modelMapper.map(dto, TransactionsResponse.class));
        }
        return returnValue;
    }

    @PutMapping(path = "/{walletId}/{transactionId}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public TransactionsResponse updateTransactionByTransactionsId(@PathVariable String walletId,
                                                                  @PathVariable String transactionId,
                                                                  @RequestBody TransactionsRequest transactionsRequest){

        ModelMapper modelMapper = new ModelMapper();

        TransactionsDto transactionsDto = modelMapper.map(transactionsRequest, TransactionsDto.class);
        TransactionsDto updatedData = iServiceTransactions.updateTransactionByTransactionsId(walletId, transactionId, transactionsDto);

        return modelMapper.map(updatedData, TransactionsResponse.class);

    }

    @DeleteMapping(path = "/{walletId}/{transactionId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public TransactionsResponse deleteTransactions(@PathVariable String walletId, @PathVariable String transactionId){
        ModelMapper modelMapper = new ModelMapper();

        TransactionsDto transactionsDto = iServiceTransactions.deleteTransactions(walletId, transactionId);
        return modelMapper.map(transactionsDto, TransactionsResponse.class);
    }
}
