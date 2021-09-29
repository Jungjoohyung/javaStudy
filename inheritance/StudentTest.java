class Student{		
	private String name;//이름
	private int number;//학번
	private String major;//학과
	private int grade;//학년
	private double creditsCompleted;//이수학점
	//생성자 
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
		return "이름: "+ name + ", 학번:"+ number + ", 학과:"+ major +", 학년:"+ grade + ", 이수학점:"+creditsCompleted;
	}

}
class UnderGraduate extends Student{
	private String club;//동아리
	//생성자
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

	//toString 재정의
	public String toString(){
		return "이름: "+ getName() + ", 학번:"+ getNumber() + ", 학과:"+ getMajor() +", 학년:"+ getGrade()+ 
		", 이수학점:"+getCreditsCompleted() + ", 동아리: "+club;
	}
}

class Graduate extends Student{
	private String assistant;	//조교
	private boolean scholarship; //장학금
	//생성자
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

	//toString 재정의
	public String toString(){
		return "이름: "+ getName() + ", 학번:"+ getNumber() + ", 학과:"+ getMajor() +", 학년:"+ getGrade()+ 
			", 이수학점:"+getCreditsCompleted() + ", 조교: "+ assistant + ", 장학금: "  +((scholarship == true)?"받음":"못받음"); 
	}

}

class StudentTest {
	public static void main(String[] args)	{
		
		UnderGraduate ug1 = new UnderGraduate("정주형",76038126,"법학과",4,3.2,"형사법연구소");
		UnderGraduate ug2 = new UnderGraduate("김창건",78382229,"물리치료과",1,4.0,"5pig");
		Graduate g1 = new Graduate("유동균",75122545,"사회복지학과",2,3.9,"노예",1);
		Graduate g2 = new Graduate("박근대",75392292,"경영대",4,4.5,"노예",1);
		Graduate g3 = new Graduate("김창건",78382229,"물리치료과",1,4.0,"노예",0);
		
		System.out.println(ug1);
		System.out.println(ug2);
		ug1.setClub("천리안");
		
		ug1.setMajor("없음");
		
		System.out.println(ug1);
		System.out.println(g1);
		
		g1.setAssistant("탈주");
		
		g1.setScholarship(false);
		
		System.out.println(g1);
		System.out.println(g2);
		System.out.println(g3);
	
	}
}
