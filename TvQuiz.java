/*
	TV�� �𵨸��ϰ� ������ �������(�ּ� 4��)�� �޼���(�ּ� 3��)�� �����Ͻÿ�.
	�������- ũ��,ȭ��,����,����
	�޼��� - �Ҹ�, ä�� , ����
*/
class Tv {
	boolean power; 
	int channel;
	int volume;
	String color;
	
	/* 
	   power variable state change action must be declared.
	   e.g) someone can change power variable state.
	   like this.
	   if(power==true) {
	   		power=false;
	   		System.out.println("Tv Power Off");
	   } else {
	    	power=true;
	    	System.out.println("Tv Power On");
	   }
	*/
	void powerOnOff(){
		if(power==true){
			System.out.println("ON");
		}else{
			System.out.println("Off");
		}
	
	}

	//need arguments. e.g) boolean cahnnelNum(int num) ... 
	void channelNum(){
		if(power==true){
			System.out.println(getInfo() + "ä��" + channel + "�� Ƶ�ϴ�.");
		}else{
			System.out.println("Ƽ�� �����ֽ��ϴ�.");
		}
	}

	//need to change... similar to boolean channelNum(int num)...
	void volumeNum(){
		if(power==true){
			System.out.println(getInfo() + "������ " + volume + "�� ����ϴ�.");
		}else{
			System.out.println("Ƽ�� �����ֽ��ϴ�.");
		}
	}

	String getInfo(){
		return "������ "+ color +"�� Ƽ�� ";
	}
} 

public class TvQuiz {
	public static void main(String[] args) {
		
		
		Tv t = new Tv();
		t.power = false;
		t.channel = 34;
		t.volume = 27;
		t.color = "����";
		t.powerOnOff();
		t.channelNum();
		t.volumeNum();
		
	}
}