package br.com.ibm.serviceImpl;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ibm.dao.AccountTransferDao;
import br.com.ibm.model.Account;
import br.com.ibm.model.Information;
import br.com.ibm.model.Transfer;
import br.com.ibm.service.AccountTransferService;

@Service("accountTransferService")
public class AccountTransferServiceImpl implements AccountTransferService {

	@Autowired
	AccountTransferDao accountTransferDao;

	@Override
	public List<Account> getAllAccounts() {
		return accountTransferDao.getAllAccounts();
	}

	@Override
	
	public boolean transferAccount(Transfer transfer) {
		
		Account accountCredit = accountTransferDao.getDataAccount(transfer.getCreditAccount());
		if (accountCredit != null) {
			Account accountDebit = accountTransferDao.getDataAccount(transfer.getDebitAccount());
			if (accountDebit != null) {
				if (accountDebit.getValue() >= transfer.getValueTransfer()) {
					accountDebit.setValue(accountDebit.getValue() - transfer.getValueTransfer());
					accountCredit.setValue(accountCredit.getValue() + transfer.getValueTransfer());
		
					JSONObject obj = new JSONObject();
			        obj.put("type_action", "Transação");
			        obj.put("account_origin_id", accountDebit.getId());
			        obj.put("account_origin_number_account", accountDebit.getNumber_account());
			        obj.put("account_destiny_id", accountCredit.getId());
			        obj.put("account_destiny_number_account", accountCredit.getNumber_account());
			        obj.put("value", transfer.getValueTransfer());
			        
					Information information = new Information();
					information.setAction(obj.toJSONString());
					information.setAccount_idaccount(transfer.getDebitAccount());
					
					accountTransferDao.updateTransfer(accountDebit, accountCredit, information);
					return true;
				}
			}
		}
		return false;
	}
}
