class Circle{ 
	private double r;
	private int cx;
	private int cy;

	
	public double area(){
		return 3.14*r*r;
	}
	//getter

	public double getR(){
		return r;
	}
	
	public int getCx(){
		return cx;
	}

	public int getCy(){
		return cy;
	}
	
	//setter
	
	public void setR(double newR){
		r = newR;		
	}

	public void setX(int newCx){
		cx = newCx;
	}

	public void setY(int newCy){
		cy = newCy;
	}
}

public class P195_1 {
	public static void main(String[] args)	{
		
		Circle cir = new Circle();
		
		cir.setR(2);
		System.out.println("¿øÀÇ ³ÐÀÌ´Â : " + cir.area());
		
	}
}
