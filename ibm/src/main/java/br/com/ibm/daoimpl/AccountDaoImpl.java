package br.com.ibm.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;


import br.com.ibm.dao.AccountTransferDao;
import br.com.ibm.model.Account;
import br.com.ibm.model.Information;

@Repository("accountTransferDao")
public class AccountDaoImpl  implements AccountTransferDao{
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getAllAccounts() {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Account> taskList = session.createQuery("from Account").list();
		return taskList;
	}

	@Override
	public Account getDataAccount(Long creditAccount) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		Account account = (Account) session.createQuery("from Account where idaccount like :idaccount ").setParameter("idaccount", creditAccount).uniqueResult();
		tx.commit();
		if(null != account)
			return account;
		else
			return null;
	}

	@Override
	public void updateTransfer(Account accountDebit, Account accountCredit, Information information) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		session.update(accountDebit);
		session.update(accountCredit);
		session.persist(information);
		tx.commit();

		
	}
}
