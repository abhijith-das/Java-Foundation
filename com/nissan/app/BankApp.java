package com.nissan.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.nissan.bean.AdminClass;
import com.nissan.bean.Bank;
import com.nissan.bean.CustomerClass;

public class BankApp {

	static ArrayList<Bank> b = new ArrayList<>();

	static AdminClass admin = new AdminClass();

	static CustomerClass cust = new CustomerClass();

	public static int index = 0;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		Scanner scan = new Scanner(System.in);
		char mainOpt = 'y';
		try {
			do {
				System.out.println("Welcome!");
				System.out.println("Enter Account Number: ");
				int acno = scan.nextInt();
				System.out.println("Enter Password: ");
				String pass = sc.nextLine();
				try {
					if (acno == 123456789 && pass.equalsIgnoreCase("admin")) {
						int choice;

						do {
							Scanner scanMenu = new Scanner(System.in);

							System.out.println(
									"Hello Admin!\nMenu\n1.Add Customer\n2.Update Customer\n3.Delete Customer\n4."
											+ "Display the list of all Customers\n5.Display Customer Details of a specific Customer\n6.Exit\nEnter your choice: ");
							choice = Integer.parseInt(scanMenu.next());

							switch (choice) {
							case 1:
								try {
									b.add(admin.addCustomer());
									index++;
								} catch (Exception e) {
									System.out.println(e);
								}
								break;
							case 2:
								System.out.println("Enter Account number: ");
								Scanner s = new Scanner(System.in);
								int temp = s.nextInt();
								boolean find = false;
								for (Bank obj : b) {
									if (obj.getAccno() == temp) {
										admin.updateCustomer(obj);
										find = true;
									}
								}
								if (!find)
									System.out.println("Enter valid account number!!");

								break;

							case 3:
								System.out.println("Enter Account number to be deleted: ");
								Scanner sca = new Scanner(System.in);
								int t = sca.nextInt();
								boolean findDelete = false;
								int index = 0;
								for (Bank obj : b) {
									if (obj.getAccno() == t) {
										index = b.indexOf(obj);

										findDelete = true;
									}
								}
								if (!findDelete)
									System.out.println("Enter valid account number!!");
								else
									b.remove(index);
									System.out.println("Account removed successfully");

								break;

							case 4:
								for (Bank obj : b) {
									admin.displayAll(obj);
								}
								break;

							case 5:
								System.out.println("Enter Account number to search: ");
								Scanner scanAcc = new Scanner(System.in);
								temp = scanAcc.nextInt();
								for (Bank obj : b) {
									admin.displayAccount(obj);
								}

								break;
							case 6:
								System.out.println("Logging Out...");
								break;
							default:
								System.out.println("Invalid choice");
								break;
							}

						} while (choice != 6);

					}

					else {
						System.out.println("Welcome Client");
						int opt;
						Bank tempCust = null;
						for (Bank obj : b) {
							if (obj.getAccno() == acno) {
								tempCust = obj;
							}
						}

						do {
							System.out.println(
									"Menu\n1.Deposit\n2.Withdrw\n3.Show balance\n4.Transfer Funds\n5.Exit\nEnter your choice: ");
							Scanner scanOpt = new Scanner(System.in);
							opt = scanOpt.nextInt();

							switch (opt) {

							case 1:
								System.out.println("Enter amount to deposit: ");
								double amt = scanOpt.nextDouble();
								if (amt > 50000) {
									System.out.println("Enter PAN Number: ");
									Scanner scanPan = new Scanner(System.in);
									String PAN = scanPan.nextLine();
								}
								cust.deposit(tempCust, amt);
								break;
							case 2:
								System.out.println("Ener amount to withdraw: ");
								double withdrawAmt = scanOpt.nextDouble();
								if (withdrawAmt > 50000) {
									System.out.println("Enter PAN Number: ");
									Scanner scanPan = new Scanner(System.in);
									String PAN = scanPan.nextLine();
								}
								cust.withdraw(tempCust, withdrawAmt);

							case 3:
								System.out.println("Balance is: " + tempCust.getBalance());
								break;

							case 4:
								System.out.println("Enter receiver Account number: ");
								Scanner scanAcc = new Scanner(System.in);
								int recAccNo = scanAcc.nextInt();
								Bank receiver = null;
								for (Bank obj : b) {
									if (obj.getAccno() == recAccNo) {
										receiver = obj;
									}
								}

								System.out.println("Enter amount to be transferred: ");
								double sentAmt = scanAcc.nextDouble();
								cust.transferFunds(tempCust, receiver, sentAmt);
							case 5:
								System.out.println("Thank you!!!");
								break;
							default:
								System.out.println("Invalid entry");

							}
						} while (opt != 5);

					}

				} catch (Exception e) {
					System.out.println(e);
				}

				System.out.println("Do you want to exit application\nEnter y to continue using the application: ");
				Scanner scanChar = new Scanner(System.in);
				mainOpt = scanChar.next().charAt(0);
			} while (mainOpt == 'y' || mainOpt == 'Y');
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
