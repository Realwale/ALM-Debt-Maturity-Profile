package org.vfd.alm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vfd.alm.entity.OverdraftAccount;
import org.vfd.alm.service.OverdraftAccountService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/overdraft-accounts")
public class OverdraftAccountController {

    private final OverdraftAccountService overdraftAccountService;

    @GetMapping
    public ResponseEntity<List<OverdraftAccount>> getAllOverdraftAccounts() {
        return new ResponseEntity<>(overdraftAccountService.getAllOverdraftAccounts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OverdraftAccount> getOverdraftAccountById(@PathVariable Long id) {
        OverdraftAccount account = overdraftAccountService.getOverdraftAccountById(id);
        if(account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<OverdraftAccount> createOverdraftAccount(@RequestBody OverdraftAccount overdraftAccount) {
        return new ResponseEntity<>(overdraftAccountService.saveOrUpdateOverdraftAccount(overdraftAccount), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OverdraftAccount> updateOverdraftAccount(@PathVariable Long id, @RequestBody OverdraftAccount overdraftAccount) {
        // Logic to check the existence of the account before updating can be added
        return new ResponseEntity<>(overdraftAccountService.saveOrUpdateOverdraftAccount(overdraftAccount), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOverdraftAccount(@PathVariable Long id) {
        overdraftAccountService.deleteOverdraftAccountById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
