class Movie{
	String title;
	String director;
	int year;
	int grade;


	void print(){
		System.out.println("��ȭ ����:"+ title + "���� : " + grade + "���� : " + director + "��ǥ�� ���� : " + year);
	}
}

public class MovieTest {
	public static void main(String[] args)	{
		Movie m = new Movie();

		m.setDirector("���� �轼");
		m.setGrade(9);
		m.setTitle("������ ����");
		m.setYear(2001);

		m.print();
	}
}
