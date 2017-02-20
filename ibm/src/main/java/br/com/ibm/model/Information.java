package br.com.ibm.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "information")
public class Information {

	@Id
	@Column(name = "idinformation")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String action;
	private Long account_idaccount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}


	public Long getAccount_idaccount() {
		return account_idaccount;
	}

	public void setAccount_idaccount(Long account_idaccount) {
		this.account_idaccount = account_idaccount;
	}

}
