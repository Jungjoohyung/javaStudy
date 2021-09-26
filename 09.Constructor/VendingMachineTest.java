/*
	���Ǳ�
	-���� �ִ´�.
	-���� ���� -> ����� ����.
	-�ܵ�

*/
class VendingMachine{
	public DrinkBox cokeBox = new DrinkBox (new Drink("coke"),800,20);
	public DrinkBox vitaBox = new DrinkBox (new Drink("vita"),500,20);
	public DrinkBox waterBox = new DrinkBox (new Drink("water"),600,15);
	public Calculator cal = new Calculator(0);

	public void DrinkBox(){
		
	}

	public void Calculator(){
	
	}


	public void inputMoney(int money){
		cal.setMoney(cal.getMoney() + money);
		System.out.println("�Ա�: " + money);
	}

	public Drink choiceDrink(String drinkName){
		int price = 0;
		switch(drinkName){
			case "coke":
				price = cokeBox.getDrinkPrice();
				if(cal.calc(price)==false){
					return null;				
				}
				return cokeBox.getOneDrink();
			case "vita":
				price = vitaBox.getDrinkPrice();
				if(cal.calc(price)==false){
					return null;				
				}
				return vitaBox.getOneDrink();
			case "water":
				price = waterBox.getDrinkPrice();
				if(cal.calc(price)==false){
					return null;				
				}
				return waterBox.getOneDrink();
			default :
				return null;
		}
	}
	public int getChange(){
		System.out.println("�ܾ��� ��ȯ�Ǿ����ϴ�.");
		System.out.println("���� �ݾ�:"+cal.getMoney());
		return cal.getChange();
	}

	
}
class Calculator{
	private int money;
	
	public Calculator(int money){
		setMoney(money);
	}

	public int getMoney(){
		return money;
	}
	
	public int getChange(){
		int change = this.getMoney();
		this.initMoney();
		return change;
	}
	private void initMoney(){
		this.money = 0;
	}
	public void setMoney(int money){
		this.money = money;
	}


	public boolean calc(int price){
		
		if(this.money - price<0){
			return false;
		} 
		this.money -= price; 
		return true;
	}
	public String toString (){
		return " �ܾ�: " + getChange();
	}


}

class DrinkBox{
	private int drinkPrice;
	private int drinkNum;
	private Drink drink;

	public DrinkBox(Drink drink,int drinkPrice,int drinkNum){
		setDrink(drink);
		setDrinkPrice(drinkPrice);
		setDrinkNum(drinkNum);
	}

	public Drink getDrink(){
		return drink;
	}
	public int getDrinkPrice(){
		return drinkPrice;
	}
	public int getDrinkNum(){
		return drinkNum;
	}


	public void setDrink(Drink drink){
		this.drink = drink;
	}
	public void setDrinkPrice(int drinkPrice){
		this.drinkPrice = drinkPrice;
	}
	public void setDrinkNum(int drinkNum){
		this.drinkNum = drinkNum;
	}

	public Drink getOneDrink(){
		if(drinkNum-1 < 0){
			return null;
		}
		drinkNum -= 1 ;
		return new Drink(drink.getDrinkName());
	}
	public String toString(){
		return "�̸�: " + drink.getDrinkName() + " ����: " + drinkPrice +"���: " + drinkNum;
	}
}
class Drink {
	private String drinkName;
	//private String drinkTemperature;

	public Drink(String drinkName){
		setDrinkName(drinkName);
	}

	public String getDrinkName(){
		return drinkName;
	}
	
	public void setDrinkName(String drinkName){
		this.drinkName = drinkName;
	}
}

class VendingMachineTest {
	public static void main(String[] args)	{
		
		VendingMachine v = new VendingMachine();
		
		v.inputMoney(10000);
		v.choiceDrink("vita");
		v.choiceDrink("vita");
		v.choiceDrink("water");
		System.out.println(v.vitaBox.toString());
		System.out.println(v.cal);
		v.getChange();
	}
}
