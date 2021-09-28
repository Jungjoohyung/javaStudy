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
		return "�̸�: " + name + ", ����: " + age+ "��";
	}

	public String getProfession(){
		return "����������";
	}
	//5
	public static void main(String[] args){
		Human h1 = new Human("����",18);
		Human h2 = new Human("����",21);
		Human h3 = new Human("���",50);
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
		return super.toString()+", ���� ����: "+this.major ;
	}
	public String getProfession(){
		return "���ð���";
	}

	//10

	public static void main(String args[]){
		Student s1 = new Student("����",21,"��ǻ��");		
		Student s2 = new Student("����",22,"�濵");
		Student s3 = new Student("����",24,"����");
		
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		System.out.println(s3.toString());
		System.out.println(s1.getProfession());
		
	}
}
