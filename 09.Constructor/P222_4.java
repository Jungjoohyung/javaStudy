class Movie{
	private String name;
	private String director;
	private String producer;

	public Movie(){
	
	}

	public Movie(String name,String director,String producer){
		setName(name);
		setDirector(director);
		setProducer(producer);
	}

	public String getName(){
		return name;
	}

	public String getDirector(){
		return director;
	}

	public String getProducer(){
		return producer;
	}

	public void setName(String name){
		this.name = name;
	}
	public void setDirector(String director){
		this.director = director;
	}

	public void setProducer(String producer){
		this.producer = producer;
	}

	public String toString(){
		return "제목: " + name + " 감독: " + director + " 제작사: " + producer ;
	}


}

class  P222_4
{
	public static void main(String[] args) 
	{
		Movie m1 = new Movie();
		Movie m2 = new Movie("다크나이트","크리스토퍼 놀란","디즈니");
		System.out.println(m1);
		System.out.println(m2);
	}
}
