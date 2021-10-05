/*
	퀴즈 
	-다음을 구현하라
	-Shape 클래스를 정의한다.
	-Shape 은 면적을 구할 수 있다.
	
	-Rectangle , Triangle , Circle을 구현하라.
	-위 클래스들은 알맞은 멤버변수와 toString()을 가진다.
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
		return "높이: "+ height +"가로: "+ width + " 넓이:" +getArea() ;	
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
		return  "밑변: "+ bottom+ " 높이: " + height +" 넓이:" +getArea();
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
		return  "반지름: "+ getRadius()+" 넓이:" +getArea();
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
