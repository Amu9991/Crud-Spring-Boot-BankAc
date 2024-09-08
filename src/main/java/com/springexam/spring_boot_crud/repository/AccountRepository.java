package com.springexam.spring_boot_crud.repository;

import com.springexam.spring_boot_crud.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
 public interface AccountRepository  extends JpaRepository<Account, Long> {
}




