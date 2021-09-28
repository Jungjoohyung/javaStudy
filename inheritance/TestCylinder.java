class Circle {
	
	private double radius; 
	private String color;
	//积己磊
	public Circle(){
	
	}
	public Circle(double radius){
		super();
		this.radius = radius;
	}
	//getter
	public double getRadius(){
		return radius;
	}
	public String getColor(){
		return color;
	}
	//setter
	public void setRaius(double radius){
		this.radius = radius;
	}
	public void setColor(){
		this.color = color;
	}
	//getArea
	public double getArea(){
		return 3.14 * radius * radius;
	}
	//toString
	public String toString(){
		return "馆瘤抚: " + radius + ", 盔狼 承捞:" +getArea();
	}
}
class Cylinder extends Circle{
	private double height;
	//积己磊
	public Cylinder(){
		
	}
	
	public Cylinder(double radius){
		super(radius);
	}
	public Cylinder(double radius, double height){
		super(radius);
		this.height = height;
	}
	//getHeight
	public double getHeight(){
		return height;
	}
	//getVolume
	public double getVolume(){
		return super.getArea()*this.height;
	}		
}
		
class TestCylinder {
	public static void main(String[] args)	{
		//obj1按眉 积己
		Cylinder obj1 = new Cylinder();
		//葛电加己 龋免
		System.out.println(obj1.getRadius());
		System.out.println(obj1.getArea());
		System.out.println(obj1.getHeight());
		System.out.println(obj1.getVolume());
		//obj2按眉积己
		Cylinder obj2 = new Cylinder(5.0,3.0);
		//葛电加己 龋免
		System.out.println(obj2.getRadius());
		System.out.println(obj2.getArea());
		System.out.println(obj2.getHeight());
		System.out.println(obj2.getVolume());
	

	}
}
