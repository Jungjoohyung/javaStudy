/*
	
*/
class Engine{
	int displacement;
	double weight;

	public Engine(int displacement,double weight){
		setDisplacement(displacement);
		setWeight(weight);
	}

	//getter
	
	public int getDisplacement(){
		return displacement;	
	}

	public double getWeight(){
		return weight;
	}

	//setter

	public void setDisplacement(int diplacement){
		this.displacement = displacement;
	}
	public void setWeight(double weight){
		this.weight = weight;
	}

	//toString

	public String toString(){
		return "("+displacement+"cc" + ", 무게: " + weight + "kg."+")" ;  
	}	
}

class Car {
	private String manufacturer;
	private int price;
	private Engine engine;
	public Car(String manufacturer, int price, Engine engine){
		setManufacturer(manufacturer);
		setPrice(price);
		setEngine(engine);
	}
	//getter
	
	public Engine getEngine(){
		return engine;
	}

	public String getManufacturer(){
		return manufacturer;
	}

	public int getPrice(){
		return price;
	}
	
	//setter
	
	public void setEngine(Engine engine){
		this.engine = engine;
	}

	public void setManufacturer(String manufacturer){
		this.manufacturer = manufacturer;
	}

	public void setPrice(int price){
		this.price = price;
	}


	//toString
	
	public String toString(){
		return "자동차:(제조사: " + manufacturer + ", 가격: " + price + "만원" + ", 엔진: " + engine + ")";    
	}
}




class CarQuiz {
	public static void main(String[] args)	{
		Engine e = new Engine(1500,900.0);
		Car c = new Car("현대",2000,e);
		System.out.println(c);
	}
}
