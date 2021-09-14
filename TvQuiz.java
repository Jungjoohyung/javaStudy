/*
	TV를 모델링하고 적당한 멤버변수(최소 4개)와 메서드(최소 3개)를 구현하시오.
	멤버변수- 크기,화질,색상,음향
	메서드 - 소리, 채널 , 전원
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
			System.out.println(getInfo() + "채널" + channel + "를 틉니다.");
		}else{
			System.out.println("티비가 꺼져있습니다.");
		}
	}

	//need to change... similar to boolean channelNum(int num)...
	void volumeNum(){
		if(power==true){
			System.out.println(getInfo() + "볼륨을 " + volume + "로 맞춥니다.");
		}else{
			System.out.println("티비가 꺼져있습니다.");
		}
	}

	String getInfo(){
		return "색깔이 "+ color +"인 티비에 ";
	}
} 

public class TvQuiz {
	public static void main(String[] args) {
		
		
		Tv t = new Tv();
		t.power = false;
		t.channel = 34;
		t.volume = 27;
		t.color = "은색";
		t.powerOnOff();
		t.channelNum();
		t.volumeNum();
		
	}
}