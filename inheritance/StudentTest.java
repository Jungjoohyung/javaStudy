class Student{		
	private String name;//�̸�
	private int number;//�й�
	private String major;//�а�
	private int grade;//�г�
	private double creditsCompleted;//�̼�����
	//������ 
	public Student(){
	
	}
	public Student(String name,int number,String major,int grade,double creditsCompleted){
		
		this.name = name;
		this.number = number;
		this.major = major;
		this.grade = grade;
		this.creditsCompleted = creditsCompleted;
		
	}

	//getter
	public String getName(){
		return name;
	}
	public int getNumber(){
		return number;
	}
	public String getMajor(){
		return major;
	}
	public int getGrade(){
		return grade;
	}
	public double getCreditsCompleted(){
		return creditsCompleted;
	}

	//setter
	public void setName(String name){
		this.name = name;
	}
	public void setNumber(int number){
		this.number = number;
	}
	public void setMajor(String major){
		this.major = major;
	}
	public void setGrade(int grade){
		this.grade = grade;
	}
	public void setCreditsCompleted(double creditsCompleted){
		this.creditsCompleted = creditsCompleted;
	}
	public String toString(){
		return "�̸�: "+ name + ", �й�:"+ number + ", �а�:"+ major +", �г�:"+ grade + ", �̼�����:"+creditsCompleted;
	}

}
class UnderGraduate extends Student{
	private String club;//���Ƹ�
	//������
	public UnderGraduate(){
		super();
	}
	public UnderGraduate(String name,int number,String major,int grade,double creitsCompleted,String club){
		super(name,number,major,grade,creitsCompleted);
		this.club = club;
	}

	//getter
	public String getClub(){
	return club;
	}

	//setter
	public void setClub(String club){
		this.club = club;
	}

	//toString ������
	public String toString(){
		return "�̸�: "+ getName() + ", �й�:"+ getNumber() + ", �а�:"+ getMajor() +", �г�:"+ getGrade()+ 
		", �̼�����:"+getCreditsCompleted() + ", ���Ƹ�: "+club;
	}
}

class Graduate extends Student{
	private String assistant;	//����
	private boolean scholarship; //���б�
	//������
	public Graduate(){
		super();
	}
	public Graduate (String name,int number,String major,int grade,double creditsCompleted,String assistant,int scholarship){
		super(name,number,major,grade,creditsCompleted);
		this.assistant = assistant;
		this.scholarship = ((scholarship == 1)?true:false);
	}

	//getter
	public String getAssistant(){
		return assistant;
	}
	public boolean getScholarship(){
		return scholarship;
	}

	//setter
	public void setAssistant(String assistant){
		this.assistant = assistant;
	}
	public void setScholarship(boolean scholarship){
		this.scholarship = scholarship;
	}

	//toString ������
	public String toString(){
		return "�̸�: "+ getName() + ", �й�:"+ getNumber() + ", �а�:"+ getMajor() +", �г�:"+ getGrade()+ 
			", �̼�����:"+getCreditsCompleted() + ", ����: "+ assistant + ", ���б�: "  +((scholarship == true)?"����":"������"); 
	}

}

class StudentTest {
	public static void main(String[] args)	{
		
		UnderGraduate ug1 = new UnderGraduate("������",76038126,"���а�",4,3.2,"�����������");
		UnderGraduate ug2 = new UnderGraduate("��â��",78382229,"����ġ���",1,4.0,"5pig");
		Graduate g1 = new Graduate("������",75122545,"��ȸ�����а�",2,3.9,"�뿹",1);
		Graduate g2 = new Graduate("�ڱٴ�",75392292,"�濵��",4,4.5,"�뿹",1);
		Graduate g3 = new Graduate("��â��",78382229,"����ġ���",1,4.0,"�뿹",0);
		
		System.out.println(ug1);
		System.out.println(ug2);
		ug1.setClub("õ����");
		
		ug1.setMajor("����");
		
		System.out.println(ug1);
		System.out.println(g1);
		
		g1.setAssistant("Ż��");
		
		g1.setScholarship(false);
		
		System.out.println(g1);
		System.out.println(g2);
		System.out.println(g3);
	
	}
}
