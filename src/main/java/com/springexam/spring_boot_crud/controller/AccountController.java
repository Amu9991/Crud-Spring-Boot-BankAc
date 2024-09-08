package com.springexam.spring_boot_crud.controller;

import com.springexam.spring_boot_crud.entity.Account;
import com.springexam.spring_boot_crud.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return service.saveAccount(account);
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return service.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return service.getAccountById(id);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable Long id, @RequestBody Account account) {
        Account existingAccount = service.getAccountById(id);
        if (existingAccount != null) {
            existingAccount.setAccountHolderName(account.getAccountHolderName());
            existingAccount.setAccountNumber(account.getAccountNumber());
            existingAccount.setBalance(account.getBalance());
            return service.saveAccount(existingAccount);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        service.deleteAccount(id);
    }
}
