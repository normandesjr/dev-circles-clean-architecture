package com.hibicode.prepaid.adapter.in.web;

import com.hibicode.prepaid.adapter.in.web.error.ResourceNotFoundException;
import com.hibicode.prepaid.adapter.in.web.mapper.AccountWebMapper;
import com.hibicode.prepaid.adapter.in.web.resource.AccountResource;
import com.hibicode.prepaid.adapter.in.web.resource.RechargeResource;
import com.hibicode.prepaid.application.port.in.GetAccountQuery;
import com.hibicode.prepaid.application.port.in.RechargeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private GetAccountQuery getAccount;

    @Autowired
    private RechargeUseCase rechargeUseCase;

    @Autowired
    private AccountWebMapper accountWebMapper;

    @GetMapping("/{number}")
    public AccountResource getAccount(@PathVariable String number) {
        return accountWebMapper.mapToResource(
                getAccount
                        .getByNumber(number)
                        .orElseThrow(ResourceNotFoundException::new));
    }

    @PostMapping("/{number}/recharges")
    @ResponseStatus(HttpStatus.CREATED)
    public void recharge(@PathVariable String number, @RequestBody RechargeResource rechargeResource) {
        rechargeUseCase.recharge(number, rechargeResource.getAmount());
    }

}
