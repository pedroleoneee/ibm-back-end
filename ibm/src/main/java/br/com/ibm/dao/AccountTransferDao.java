package br.com.ibm.dao;

import java.util.List;

import br.com.ibm.model.Account;
import br.com.ibm.model.Information;

public interface AccountTransferDao {

	public List<Account> getAllAccounts();

	public Account getDataAccount(Long creditAccount);

	public void updateTransfer(Account accountDebit, Account accountCredit, Information information);

}
