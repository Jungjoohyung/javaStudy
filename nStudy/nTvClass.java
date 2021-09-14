
/*
	TV를 모델링하고 적당한 멤버변수(최소 4개)와 메서드(최소 3개)를 구현하시오.
	멤버변수- 크기,화질,색상,음향
	메서드 - 소리, 채널 , 전원
*/

public class Tv {
	
	//enum list (열거형인데.. 이거 안배웠으려나??) 안배웠다면..... int 나 short  정도로 대충 생각하고 HD = 0, FHD = 1 ... 이런식으로 생각해도됨.
	//다만 이걸 안배웠다면 뭔가 초기에 내가 생각했던 퀄리티와 컬러가 아닌 경우를 생각해서 에러를 뱉어주던지 보정하던지 추가 작업을 해줘야 할꺼임.
	public enum Quality {
		HD, FHD, QHD, UHD_4K, UHD_8K
	}
	
	//난 컬러를... 모니터 타입으로 하겠음... 
	public enum Color {
		CRT, LCD, Q_LED, O_LED
	}
	
	private boolean power;
	private int channel;
	private int volume;
	
	//위에 선언된 enum type으로 멤버 변수를 선언한거.
	private Quality quality;
	private Color color; //도대체 color는 왜 있는거지..? 색감이란 뜻인가.....
	
	
	//Constructor Area (원래 this 를 배웠다면 파라미터를 이렇게 하지는 않았을 것...)
	public Tv(Quality q, Color c) {
		quality = q;
		color = c;
		power = false;
		channel = 3; //난 tvn이 조터라..
		volume = 10; //기본으로 10 잡아주자.
	}
	
	public Tv() {
		//생성자에서의 this는 Tv()를 의미한다. 이건 원래 배워야할 거라고.. 생각되는데... 책 찾아봐. 나와있는지
		this(Quality.FHD, Color.CRT);
	}
	
	public Tv(Quality q) {
		this(q, Color.CRT);
	}
	
	public Tv(Color c) {
		this(Quality.FHD, c);
	}
	//End of constructor...
	
	//private methods area. -> 어제까진 private를 몰랐으므로 그냥 public, private 없이... 해도 되긴 하겠다만.. 오늘 배운거니까 복습할겸 생각해봐.
	private int getValidChannel(int number) {
		int result = number;
		
		//result로 비교하나 number로 비교하나.. 그놈이 그놈.
		if(number > 999) {
			result = 1;
		} else if(number <= 0) {
			result = 999;
		}
		
		return result;
	}
	
	//과연 private member인 power를 이걸로 컨트롤하는게 옳바를까? 망설이고 고민하는 습관이 있어야함.
	//내 개인적인 경험에서는 필요할 것 같으면 method로 정형화 하는게 유지보수 측면에서 훨씬 유리하다임. power의 형태가 지금은 true, false 밖에 없지만
	//만약, power의 상태가 다양해질 수 있다면(현실적으론 없겠지만 말야), 직접 멤버변수를 각 메소드에서 제어한다면 소스를 고치기가 힘들어진다는 단점이 있어.
	//하지만 꼭 method로 뺀다고해서 마냥 그런 유지보수가 쉬워진다. 이건 또 아니야, 애초에 checkPower의 리턴값은 boolean으로 true, falase만 할수있으므로
	//만약 뭔가 power의 type이 변경 되었을때는 결국 얘도 변경을 해줘야하겠지.. 그렇다면,,, 이 method를 쓰는 부분에서도 모두 변경되어야 하는 부분이 있어
	//이러한 부분을 완화하는건 내일 부터 너가 배울 상속, 추상화, 인터페이스 등을 통해서 어느정도 느슨하게 변경할 수 있어. 이건 나중에 심도있게 고민해봐야할 파트야.
	private boolean checkPower() {		
		return power;
	}
	
	private boolean isValidVolume(int vol) {
		if(vol >= 30 || vol < 0) {
			return false;
		}
		return true;
	}
	
	//public methods area
	public void powerOnOff() {
		if(power == true) {
			System.out.println("Power OFF. TV를 끕니다.");
			power = false;
		} else {
			System.out.println("Power On. TV를 켭니다.");
			power = true;
		}
	}
	
	public void channelChange(int number) {
		
		if(number > 999 || number <= 0) {
			System.out.println("Invalid Channel Number. 그딴 채널은 없어요");
			return;
		}
		
		channel = number;
		System.out.printf("채널 이동 : %d 번채널로 쓩!\n", channel);
	}
	
	//여기서 생각해봐야 할 부분은 반복되는 부분이 있다.(channelUp, Down에서) 이걸 어떻게 개선할지 생각해봐.. 여러가지 방법이 있을꺼야. 너가 아는 지식만으로도 개선이 가능한 방법도 있음.
	public void channelUp() {
		
		if(!checkPower()) {
			System.out.println("TV가 꺼져있어용");
			return;
		}
		
		int moveChannel = getValidChannel(channel + 1);		
		channelChange(moveChannel);
	}
	
	public void channelDown() {
		
		if(!checkPower()) {
			System.out.println("TV가 꺼져있어용");
			return;
		}
		
		int movechannel = getValidChannel(channel -1);
		channelChange(movechannel);
	}
	
	//여기까지 구성해보면.. 어.. 반복되는게 또 보이네.. ? 고민이 되야함.
	public void volumeUp() {
		
		if(!checkPower()) {
			System.out.println("TV가 꺼져있어용");
			return;
		}
		
		if(isValidVolume(volume+1)) {
			volume++;
		}
		//보통 볼륨같은건 맥스 볼륨 이상으로 해도 볼륨 값 보여주잖아?
		System.out.printf("Volume : %d 입니당\n", volume);
	}
	
	public void volumeDown() {
		if(!checkPower()) {
			System.out.println("TV가 꺼져있어용");
			return;
		}
		
		if(isValidVolume(volume -1)) {
			volume--;
		}
		
		System.out.printf("Volume : %d 입니당\n", volume);
	}
} 

public class TvQuiz {
	
	public static void main(String[] args) {
		
		
		//TODO ...
		
	}
}