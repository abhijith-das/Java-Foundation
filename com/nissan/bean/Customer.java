package com.nissan.bean;

public interface Customer {
	
	void deposit(Bank bnk,double amt);
	
	void withdraw(Bank tempCust, double withdrawAmt);
	
	void transferFunds(Bank tempCust, Bank receiver, double sentAmt);

}
