class Box{
	private int width;
	private int length;
	private int height;
	private boolean empty = false;

	public Box(){
		this.width = 1;
		this.length = 1;
		this.height = 1;
		this.empty = true;
	}

	public Box (int width, int length,int height){
		this.width = width;
		this.length = length;
		this.height = height;
		this.empty = true;

	}	

	public int getWidth(){
		return width;
	}

	public int getLength(){
		return length;
	}

	public int getHeight(){
		return height;
	}

	public boolean getEmpty(){
		return empty;
	}

	public void setWidth(int width){
		this.width = width;
	}
	
	public void setLength(int length){
		this.length = length;
	}

	public void setHeigth(int height){
		this.height = height;
	}

	public void setEmpty(boolean empty){
		this.empty = empty;
	}

		
	public void openBox() {
		empty = !empty;
	}

	public void emptyCheck() {
		if (empty == true){
		   System.out.println("이 박스는 비어있습니다."); 
		}else{
		   System.out.println("이 박스는 비어있지 않습니다.");
		}
	}

	public String toString(){
		return "가로: " + width + ", 세로: " + length + ", 높이:  " + height  ;
 	}

}

class P221_3 {
	public static void main(String[] args)	{
		
		Box b1 = new Box(5,6,7);
		b1.emptyCheck();
		System.out.println(b1);
		
		
		Box b2 = new Box();
		b2.emptyCheck();
		System.out.println(b2);
			
	}
}
