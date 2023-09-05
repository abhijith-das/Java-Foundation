package com.nissan.bean;

import java.util.Random;
import java.util.Scanner;

public class Bank {

	private int Accno, ATMPin;
	private String custName, accType, eMail;

	private long phNo;
	private double balance, minBalance;

	public Bank() {
		super();
		Random random = new Random();
		
		this.Accno = 100000000 + random.nextInt(900000000);
		
		
		//Reserving 123456789 for login for admin
		
		while(this.Accno == 123456789)
			this.Accno = 100000000 + random.nextInt(900000000);
		
		
		this.ATMPin = 1000 + random.nextInt(10000);

	}

//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	} 

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {

		try {

			if (custName.length() > 30)
				throw new Exception("Customer Name should be less than 30 characters");
			else if (custName.matches("[0-9]+"))
				throw new Exception("Name cannot contain digits");
			else
				this.custName = custName;
		} catch (Exception e) {
			System.out.println("Enter customer number again: ");
			Scanner inp = new Scanner(System.in);
			String name = inp.nextLine();
			setCustName(name);
		}

	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		try {
			if (accType.equalsIgnoreCase("savings") || accType.equalsIgnoreCase("Current")) {

				this.accType = accType;
			} else
				throw new Exception("Account can be only savings or current");
		} catch (Exception e) {
			System.out.println("Enter Account type again: ");
			Scanner sc = new Scanner(System.in);
			String type = sc.nextLine();
			setAccType(type);
		}
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public long getPhNo() {
		return phNo;
	}

	public void setPhNo(long phNo) {
		try {
			String str = String.valueOf(phNo);
			if (str.length() != 10)
				throw new Exception("Phone number should be 10 digits");
			else if (!str.matches("[0-9]+"))
				throw new Exception("Phone number should contain digits only");
			else
				this.phNo = phNo;
		} catch (Exception e) {
			System.out.println("Enter phone number again: ");
			Scanner scan = new Scanner(System.in);
			long ph = scan.nextLong();
			setPhNo(ph);
		}
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {

		try {
			String str = String.valueOf(phNo);
			if (!str.matches("[0-9]+"))
				throw new Exception("Balance should contain digits only");
			else
				this.balance = balance;
		} catch (Exception e) {
			System.out.println("Enter balance again: ");
			Scanner scan = new Scanner(System.in);
			double bal = scan.nextDouble();
			setBalance(bal);
		}
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	
	
	
	public int getAccno() {
		return Accno;
	}

	public void setAccno(int accno) {
		Accno = accno;
	}

	public int getATMPin() {
		return ATMPin;
	}

	public void setATMPin(int aTMPin) {
		ATMPin = aTMPin;
	}

	@Override
	public String toString() {
		return "Bank [Accno=" + Accno + ", ATMPin=" + ATMPin + ", custName=" + custName + ", accType=" + accType
				+ ", eMail=" + eMail + ", phNo=" + phNo + ", balance=" + balance + ", minBalance=" + minBalance + "]";
	}

}
