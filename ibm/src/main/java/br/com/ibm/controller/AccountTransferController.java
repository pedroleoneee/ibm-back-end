package br.com.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ibm.model.Account;
import br.com.ibm.model.Transfer;
import br.com.ibm.service.AccountTransferService;

@RestController
public class AccountTransferController {

	@Autowired
	AccountTransferService accountTransferService;

	@CrossOrigin
	@RequestMapping(value = "/transfer", method = RequestMethod.POST)
	public ResponseEntity<Void> transfer(@RequestBody Transfer transfer, UriComponentsBuilder ucBuilder) {

		boolean transferSuccess = accountTransferService.transferAccount(transfer);
		if (transferSuccess) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

	}

	@CrossOrigin
	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	public ResponseEntity<List<Account>> accounts(UriComponentsBuilder ucBuilder) {

		List<Account> listAccount = accountTransferService.getAllAccounts();
		return new ResponseEntity<List<Account>>(listAccount, HttpStatus.OK);

	}

}
