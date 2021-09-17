class Point{
	
	private int x;
	private int y;
	
	//setter
	public void setX(int newX){
		x = newX;
	}
	public void setY(int newY){
		y = newY;
	}

	public void print(){
		System.out.printf("현재좌표는 %d, %d입니다.",x,y);
	}


}

public class P195_4 {
	public static void main(String[] args)	{
		
		Point p = new Point();
		
		p.setX(1);
		p.setY(1);
		p.print();
	}
}
