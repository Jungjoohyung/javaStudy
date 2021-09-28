class Circle {
	
	private double radius; 
	private String color;
	//������
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
		return "������: " + radius + ", ���� ����:" +getArea();
	}
}
class Cylinder extends Circle{
	private double height;
	//������
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
		//obj1��ü ����
		Cylinder obj1 = new Cylinder();
		//���Ӽ� ȣ��
		System.out.println(obj1.getRadius());
		System.out.println(obj1.getArea());
		System.out.println(obj1.getHeight());
		System.out.println(obj1.getVolume());
		//obj2��ü����
		Cylinder obj2 = new Cylinder(5.0,3.0);
		//���Ӽ� ȣ��
		System.out.println(obj2.getRadius());
		System.out.println(obj2.getArea());
		System.out.println(obj2.getHeight());
		System.out.println(obj2.getVolume());
	

	}
}
