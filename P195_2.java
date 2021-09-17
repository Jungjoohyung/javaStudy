class Book{
	
	private String title;
	private String author;
	
	//getter
	public String getTitle(){
		return title;
	} 
	
	public String getAuthor(){
		return author;
	}

	//setter
	public void setTitle(String newTitle){
		title = newTitle;
	}
	
	public void setAuthor(String newAuthor){
		author = newAuthor;
	}
	
	public String toString(){
		String info = "제목: " + title + "\n";
		info +="지은이 : " + author + "\n";
		return info;
	}
	
	public void print(){
		System.out.println(toString());
	}
		

}



public class P195_2 {
	public static void main(String[] args)	{
	
		Book b = new Book();
		
		b.setTitle("반지의 제왕");
		b.setAuthor("J.R.R. 톨킨");
		b.print();
	}
}
