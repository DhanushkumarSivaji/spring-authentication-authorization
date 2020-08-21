package com.dhanush.controller;

import java.security.Principal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dhanush.entity.Role;
import com.dhanush.entity.Transaction;
import com.dhanush.entity.User;
import com.dhanush.service.ProductService;
import com.dhanush.service.TransactionService;
import com.dhanush.service.UserService;

@RestController
public class UserController {

	 @Autowired
	    private UserService userService;

	    @Autowired
	    private ProductService productService;

	    @Autowired
	    private TransactionService transactionService;

	    @PostMapping("/api/user/registration")
	    public ResponseEntity<?> register(@RequestBody User user){
	        if(userService.findByUsername(user.getUsername())!=null){
	            return new ResponseEntity<>(HttpStatus.CONFLICT);
	        }
			//default role.
	        user.setRole(Role.USER);
	        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
	    }

	    @GetMapping("/api/user/login")
	    public ResponseEntity<?> getUser(Principal principal){
			//principal = httpServletRequest.getUserPrincipal.
	        if(principal == null){
	            //logout will also use here so we should return ok http status.
	            return ResponseEntity.ok(principal);
	        }
//	        UsernamePasswordAuthenticationToken authenticationToken =
//	                (UsernamePasswordAuthenticationToken) principal;
//	        User user = userService.findByUsername(authenticationToken.getName());
//	        user.setToken(tokenProvider.generateToken(authenticationToken));

	        return new ResponseEntity<>(userService.findByUsername(principal.getName()), HttpStatus.OK);
	    }


	    @PostMapping("/api/user/purchase")
	    public ResponseEntity<?> purchaseProduct(@RequestBody Transaction transaction){
	        transaction.setPurchaseDate(LocalDateTime.now());
	         transactionService.saveTransaction(transaction);
	         return new ResponseEntity<>(transaction, HttpStatus.CREATED);
	    }

	    @GetMapping("/api/user/products")
	    public ResponseEntity<?> getAllProducts(){
	        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
	    }
}
