class Movie{
	String title;
	String director;
	int year;
	int grade;


	void print(){
		System.out.println("영화 제목:"+ title + "평점 : " + grade + "감독 : " + director + "발표된 연도 : " + year);
	}
}

public class MovieTest {
	public static void main(String[] args)	{
		Movie m = new Movie();

		m.setDirector("피터 잭슨");
		m.setGrade(9);
		m.setTitle("반지의 제왕");
		m.setYear(2001);

		m.print();
	}
}
