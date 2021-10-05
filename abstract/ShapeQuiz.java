/*
	���� 
	-������ �����϶�
	-Shape Ŭ������ �����Ѵ�.
	-Shape �� ������ ���� �� �ִ�.
	
	-Rectangle , Triangle , Circle�� �����϶�.
	-�� Ŭ�������� �˸��� ��������� toString()�� ������.
*/
abstract class Shape{
	public abstract int getArea();
}

class Rectangle extends Shape{
	private int width;
	private int height;
	public Rectangle (int height,int width){
		setHeight(height);
		setWidth(width);
	}

	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public void setWidth(int width){
		this.width = width;
	}
	public void setHeight(int height){
		this.height = height;
	}

	
	public int getArea(){
		return height*width;
	}
	@Override
	public String toString(){
		return "����: "+ height +"����: "+ width + " ����:" +getArea() ;	
	}
}	

class Triangle extends Shape{
	private int bottom;
	private int height;

	public Triangle(int bottom,int height){
		setBottom(bottom);
		setHeight(height);
	}
	
	public int getBottom(){
		return bottom;
	}
	public int getHeight(){
		return height;
	}
	public void setBottom(int bottom){
		this.bottom = bottom;
	}
	public void setHeight(int height){
		this.height = height;
	}
	
	public int getArea(){
		return (height * bottom)/2;
	}
	@Override
	public String toString(){
		return  "�غ�: "+ bottom+ " ����: " + height +" ����:" +getArea();
	}

}

class Circle extends Shape{
	private double radius;

	public Circle(int radius){
		setRadius(radius);
	}

	public double getRadius(){
		return radius;
	}
	public void setRadius(double radius){
		this.radius = radius;
	}
	
	public int  getArea(){
		return (int)(radius * radius * 3.14);
	}		
	@Override
	public String toString(){
		return  "������: "+ getRadius()+" ����:" +getArea();
	}
}

 class ShapeQuiz {
 
	public static void main(String[] args) {
		Rectangle r = new Rectangle(2,3);
		System.out.println(r);
		Triangle t = new Triangle (3,2);
		System.out.println(t);
		Circle c = new Circle(2);
		System.out.println(c);
	}
}
