package com.hibicode.prepaid.controller;

import com.hibicode.prepaid.controller.dto.AccountDto;
import com.hibicode.prepaid.controller.dto.RechargeDto;
import com.hibicode.prepaid.controller.error.ResourceNotFoundException;
import com.hibicode.prepaid.controller.mapper.AccountWebMapper;
import com.hibicode.prepaid.repository.AccountRepository;
import com.hibicode.prepaid.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private RechargeService rechargeService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountWebMapper accountWebMapper;

    @GetMapping("/{number}")
    public AccountDto getAccount(@PathVariable String number) {
        return accountWebMapper.mapToResource(
                accountRepository
                        .findById(number)
                        .orElseThrow(ResourceNotFoundException::new));
    }

    @PostMapping("/{number}/recharges")
    @ResponseStatus(HttpStatus.CREATED)
    public void recharge(@PathVariable String number, @RequestBody RechargeDto rechargeDto) {
        rechargeService.recharge(number, rechargeDto.getAmount());
    }

}
