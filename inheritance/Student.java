//1
class Human{ 
	private String name;
	private int age;
	//12
	/*
	protected String name;
	protected int age;
	public String name;
	public int age;
	*/
	//2
	public Human(String name, int age){ 
		super();
		this.name = name;
		this.age= age;
	}
	//3
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}

	public void setName(String name){
		this.name = name;
	}
	public void setAge(int age){
		this.age = age;
	}
	//4
	
	public String toString(){
		return "이름: " + name + ", 나이: " + age+ "세";
	}

	public String getProfession(){
		return "현재의직업";
	}
	//5
	public static void main(String[] args){
		Human h1 = new Human("춘향",18);
		Human h2 = new Human("몽룡",21);
		Human h3 = new Human("사또",50);
		System.out.println(h1.toString());
		System.out.println(h2.toString());
		System.out.println(h3.toString());
	}

}
//6
class Student extends Human{
	String major;
	//7
	public Student(String name, int age, String major){
		super(name,age);
		this.major=major;
	}
	//8
	public String getMajor(){
		return major;
	}
	public void setMajor(String major){
		this.major = major;
	}
	//9
	@Override
	public String toString(){
		return super.toString()+", 현재 상태: "+this.major ;
	}
	public String getProfession(){
		return "자택경비원";
	}

	//10

	public static void main(String args[]){
		Student s1 = new Student("명진",21,"컴퓨터");		
		Student s2 = new Student("미현",22,"경영");
		Student s3 = new Student("용준",24,"경제");
		
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		System.out.println(s3.toString());
		System.out.println(s1.getProfession());
		
	}
}
