class Box {
	private int width;
	private int length;
	private int height;	

	//getter

	public int getWidth(){
		return width;
	}
	
	public int getLength(){
		return length;
	}

	public int getHeight(){
		return height;
	}
	
	//setter

	public void setWidth(int newWidth ){
		width = newWidth;
	}

	public void setLength(int newLength){
		length = newLength;
	}

	public void setHeight(int newHeight){
		height = newHeight;
	}

	public int getVolume(){
		return (width * length * height);
	}

	public String toString(){
		String info = "가로는: " + width + "\n";
		info +="height : " + height + "\n";
		info +="length : " + length + "\n";
		info +="volume : " + getVolume();
		return info;
	}
	
	public void print(){
		System.out.println(toString());
	}
		
	

}



public class BoxTest {
	public static void main(String[] args)	{
		
		Box box1 = new Box();
		box1.setWidth (100);
		box1.setLength(100);
		box1.setHeight(100);
		System.out.println("부피: " + box1.getVolume());
		box1.print();
		Box box2 = new Box();
		box2.setWidth (200);
		box2.setLength(200);
		box2.setHeight(200);
		
		box1 = box2;

		System.out.println("대입 후 가로: " + box1.getWidth() );
		System.out.println("대입 후 세로: " + box1.getLength());
		System.out.println("대입 후 높이: " + box1.getHeight());
	}
}
