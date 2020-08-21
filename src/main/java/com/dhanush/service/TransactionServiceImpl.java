package com.dhanush.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhanush.entity.Transaction;
import com.dhanush.repository.TransactionRepository;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
	 @Autowired
	    private TransactionRepository transactionRepository;

	    @Override
	    public Transaction saveTransaction(final Transaction transaction){
	        return transactionRepository.save(transaction);
	    }

	    @Override
	    public Long numberOfTransactions(){
	        return transactionRepository.count();
	    }

	    @Override
	    public List<Transaction> findAllTransactions(){
	        return transactionRepository.findAll();
	    }
}
