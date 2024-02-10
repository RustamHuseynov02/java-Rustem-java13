package encapsulation1;

public class BankAccount {
	private int accountNumber;
	private double balance;

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		if (balance > 0) {
			System.out.println("Balans var");
		}
		else {
			System.out.println("Balansin 0`na dusub.artirin");
		}
	}

}
