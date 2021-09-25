class Dog{
	private String dogName;
	public String dogBreed;
	private int dogAge;
	
	public Dog(String dogName,int dogAge){
		this.dogName = dogName;
		this.dogAge = dogAge;
	}

	public Dog(String dogName,String dogBreed,int dogAge){
		this.dogName = dogName;
		this.dogBreed = dogBreed;
		this.dogAge = dogAge;
	}

	public String getDogName(){
		return dogName;
	}

	public String getDogBreed(){
		return dogBreed;
	}
	public int getDogAge(){
		return dogAge;
	}

	public void setDogName(String dogName){
		this.dogName = dogName;
	}

	public void setDogBreed(String dogBreed){
		this.dogBreed = dogBreed;
	}

	public void setDogAge(int dogAge){
		this.dogAge = dogAge;
	}
	
	public String toString (){
		return "�̸�: " + dogName + " ����: " + dogBreed + " ����: " + dogAge;
	}
}


class P221_1 {
	public static void main(String[] args)	{
		Dog d1 = new Dog("�ٴҶ�",3);
		System.out.println(d1);
		Dog d2 = new Dog("����","���",5);
		System.out.println(d2);
		
	}
}
