package com.dhanush.service;

import java.util.List;

import com.dhanush.entity.Transaction;

public interface TransactionService {
	Transaction saveTransaction(Transaction transaction);

    Long numberOfTransactions();

    List<Transaction> findAllTransactions();
}
