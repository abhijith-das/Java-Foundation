package com.nissan.bean;

public class CustomerClass implements Customer {

	@Override
	public void deposit(Bank tempCust, double amt) {
		double curBalance = tempCust.getBalance();
		tempCust.setBalance(curBalance + amt);
		System.out.println("Amount added successfully!");

		// TODO Auto-generated method stub

	}

	@Override
	public void withdraw(Bank tempCust, double withdrawAmt) {
		// TODO Auto-generated method stub
		double availBalance = tempCust.getBalance() - tempCust.getMinBalance();

		if (withdrawAmt > availBalance)
			System.out.println("Insufficient Funds!!!");

		else {
			tempCust.setBalance(tempCust.getBalance() - withdrawAmt);
		}

	}


	@Override
	public void transferFunds(Bank tempCust, Bank receiver, double sentAmt) {
		// TODO Auto-generated method stub
		
		double availBalance = tempCust.getBalance() - tempCust.getMinBalance();

		if (sentAmt > availBalance)
			System.out.println("Insufficient Funds!!!");
		
		else {
			tempCust.setBalance(tempCust.getBalance() - sentAmt);
			receiver.setBalance(receiver.getBalance() + sentAmt);
			System.out.println("Transfer Successful");
		}

	}

}
