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
		String info = "���� �ܾ��� " + balance + "�� �Դϴ�.";
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
		
		System.out.println("�۱� ��");
		System.out.println(ba.getOwner() + "�� �ܾ�: " + ba);
		System.out.println(oa.getOwner() + "�� �ܾ�: " + oa);
		System.out.println("�۱� ��");
		
		ba.transfer(8000, oa);
		
		System.out.println(ba.getOwner() + "�� �ܾ�: " + ba);
		System.out.println(oa.getOwner() + "�� �ܾ�: " + oa);
 }

}