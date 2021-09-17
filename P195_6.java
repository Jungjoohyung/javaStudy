class BankAccount {
	
	private int accountNumber;
	private String Owner;
	private int balance;
	 
	public String getOwner() {
		return Owner;
	}
	
	public void setOwner(String o) {
		Owner = o;
	}

	public void deposit(int amount) {
		balance += amount;
	}
	
	public void withdraw(int amount) {
		balance -= amount;
	}
	
	public void transfer(int amount, BankAccount otherAccount) {
		balance -= amount;
		otherAccount.balance += amount;
	}
	
	public String toString() {
		String info = "현재 잔액은 " + balance + "원 입니다.";
		return info;
	}

	public void print(){
		System.out.println(toString());
	}
}

public class P195_6 {
	public static void main(String[] args) {
		
		BankAccount ba = new BankAccount();
		BankAccount oa = new BankAccount();
	
		ba.setOwner("BANK ACCOUNT");
		oa.setOwner("OTHER ACCOUNT");

		ba.deposit(10000);
		
		System.out.println("송금 전");
		System.out.println(ba.getOwner() + "의 잔액: " + ba);
		System.out.println(oa.getOwner() + "의 잔액: " + oa);
		System.out.println("송금 후");
		
		ba.transfer(8000, oa);
		
		System.out.println(ba.getOwner() + "의 잔액: " + ba);
		System.out.println(oa.getOwner() + "의 잔액: " + oa);
 }

}