package com.nissan.bean;

import java.util.Scanner;

public class AdminClass implements Admin {

	@Override
	public Bank addCustomer() throws Exception {
		// TODO Auto-generated method stub
		Bank b = new Bank();
		Scanner inp = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Customer Name: ");
		b.setCustName(inp.nextLine());
		System.out.println("Enter Customer type: ");

		b.setAccType(inp.nextLine());
		System.out.println("Enter balance: ");
		b.setBalance(sc.nextInt());
		System.out.println("Enter minimum balance: ");
		b.setMinBalance(sc.nextInt());
		System.out.println("Enter phone no: ");
		b.setPhNo(sc.nextLong());
		System.out.println("Enter mail id: ");
		b.seteMail(inp.nextLine());
		// System.out.println("Enter password: ");

		// sc.close();
		// inp.close();

		System.out.println("Customer added successfully");
		return b;

	}

	@Override
	public void updateCustomer(Bank obj) {
		// TODO Auto-generated method stub
		System.out.println("Enter Mobile Number: ");
		Scanner scan = new Scanner(System.in);
		obj.setPhNo(scan.nextLong());

		Scanner scanMail = new Scanner(System.in);
		System.out.println("Enter E-Mail id: ");
		obj.seteMail(scanMail.nextLine());

	}

	@Override
	public void displayAll(Bank obj) {
		// TODO Auto-generated method stub

		System.out.println(obj.toString());

	}

	@Override
	public void displayAccount(Bank obj) {
		// TODO Auto-generated method stub
		System.out.println(obj.toString());
		
	}

}
