package com.nissan.bean;

public interface Admin {

	Bank addCustomer() throws Exception;

	void updateCustomer(Bank obj);

	void displayAll(Bank obj);
	
	void displayAccount(Bank obj);

}
