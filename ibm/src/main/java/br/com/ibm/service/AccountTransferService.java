package br.com.ibm.service;

import java.util.List;

import br.com.ibm.model.Account;
import br.com.ibm.model.Transfer;

public interface AccountTransferService {

	public List<Account> getAllAccounts();

	public boolean transferAccount(Transfer transfer);

}
