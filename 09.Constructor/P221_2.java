class Plane {
	private String producer;
	private String model;
	private int maximumPassenger;
	public static int planes = 0;

	public Plane(){
		this.producer = "�Ҹ�";
		this.model = "�Ҹ�";
		this.maximumPassenger = 0;
	}

	public Plane(String producer, String model, int maximumPassenger){
		this.producer = producer;
		this.model = model;
		this.maximumPassenger = maximumPassenger;
		planes++;
	}

	public String getProducer(){
		return producer;
	}
	public String getModel(){
		return model;
	}
	public int getMaximumPassenger(){
		return maximumPassenger;
	}
	public static int getPlanes(){
		return planes;
	}

	public void setProducer(String producer){
		this.producer = producer;
	}
	public void setModel(String model){
		this.model = model;
	}
	public void setMaximumPassenger(int maximumPassenger){
		this.maximumPassenger = maximumPassenger;
	}
	public void setPlanes(int planes){
		this.planes = planes;
	}

	public String toString(){
		return "������: " + producer + ", �𵨸�: " + model + ", �ִ� �°���: " + maximumPassenger ;
	}
	
}

class P221_2 {
	public static void main(String[] args)	{
		Plane p1 = new Plane();
		System.out.println(p1);
		System.out.println("���ݱ��� ������ ������� ����:" + Plane.planes);
		Plane p2 = new Plane("�����Ѱ�","����",300);
		System.out.println(p2);
		System.out.println("���ݱ��� ������ ������� ����:" + Plane.planes);
	}
}
