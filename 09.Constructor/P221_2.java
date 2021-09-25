class Plane {
	private String producer;
	private String model;
	private int maximumPassenger;
	public static int planes = 0;

	public Plane(){
		this.producer = "불명";
		this.model = "불명";
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
		return "제조사: " + producer + ", 모델명: " + model + ", 최대 승객수: " + maximumPassenger ;
	}
	
}

class P221_2 {
	public static void main(String[] args)	{
		Plane p1 = new Plane();
		System.out.println(p1);
		System.out.println("지금까지 생성된 비행기의 개수:" + Plane.planes);
		Plane p2 = new Plane("대한한공","땅콩",300);
		System.out.println(p2);
		System.out.println("지금까지 생성된 비행기의 개수:" + Plane.planes);
	}
}
