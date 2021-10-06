/*
	���ݰ� ���� �����ϸ� ���� �ڵ����̴�.

*/



class Car {
	private int price;
	private String model;
	private String color;
	private String maker;
	
	public Car(int price, String model,String color,String maker){
		setPrice(price);
		setModel(model);
		setColor(color);
		setMaker(maker);
	}
	public int getPrice(){
		return price;
	}

	public String getModel(){
		return model;
	}	
	public String getColor(){
		return color;
	}
	public String getMaker(){
		return maker;
	}

	public void setPrice(int price){
		this.price = price;
	}
	public void setModel(String model){
		this.model = model;
	}
	public void setColor(String color){
		this.color = color;
	}
	public void setMaker(String maker){
		this.maker = maker;
	}

	@Override

	public boolean equals(Object o){
		if (o == null || ! (o instanceof Car)){
			return false;
		} 
		Car c = (Car)o;
		
		return (price == c.getPrice() && model.equals(c.getModel()));

	}
	

}

class EqualsQuiz {
	public static void main(String[] args)	{
			Car c1 = new Car(3000,"�ҳ�Ÿ","��","����");
			Car c2 = new Car(4000,"�׷���","��","����");
			Car c3 = new Car(3000,"�ҳ�Ÿ","��","����");
			Car c4 = new Car(4000,"�ƹݶ�","��","����");
			
			System.out.println(c1.equals(c2));
			System.out.println(c1.equals(c3));
			System.out.println(c1.equals(c4));
			

			
	}
}
