package com.springexam.spring_boot_crud.service;

import com.springexam.spring_boot_crud.entity.Account;
import com.springexam.spring_boot_crud.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    // Create or Update
    public Account saveAccount(Account account) {
        return repository.save(account);
    }

    // Get all accounts
    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    // Get account by ID
    public Account getAccountById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Delete account
    public void deleteAccount(Long id) {
        repository.deleteById(id);
    }
}
