
/*
	TV�� �𵨸��ϰ� ������ �������(�ּ� 4��)�� �޼���(�ּ� 3��)�� �����Ͻÿ�.
	�������- ũ��,ȭ��,����,����
	�޼��� - �Ҹ�, ä�� , ����
*/

public class Tv {
	
	//enum list (�������ε�.. �̰� �ȹ��������??) �ȹ���ٸ�..... int �� short  ������ ���� �����ϰ� HD = 0, FHD = 1 ... �̷������� �����ص���.
	//�ٸ� �̰� �ȹ���ٸ� ���� �ʱ⿡ ���� �����ߴ� ����Ƽ�� �÷��� �ƴ� ��츦 �����ؼ� ������ ����ִ��� �����ϴ��� �߰� �۾��� ����� �Ҳ���.
	public enum Quality {
		HD, FHD, QHD, UHD_4K, UHD_8K
	}
	
	//�� �÷���... ����� Ÿ������ �ϰ���... 
	public enum Color {
		CRT, LCD, Q_LED, O_LED
	}
	
	private boolean power;
	private int channel;
	private int volume;
	
	//���� ����� enum type���� ��� ������ �����Ѱ�.
	private Quality quality;
	private Color color; //����ü color�� �� �ִ°���..? �����̶� ���ΰ�.....
	
	
	//Constructor Area (���� this �� ����ٸ� �Ķ���͸� �̷��� ������ �ʾ��� ��...)
	public Tv(Quality q, Color c) {
		quality = q;
		color = c;
		power = false;
		channel = 3; //�� tvn�� ���Ͷ�..
		volume = 10; //�⺻���� 10 �������.
	}
	
	public Tv() {
		//�����ڿ����� this�� Tv()�� �ǹ��Ѵ�. �̰� ���� ������� �Ŷ��.. �����Ǵµ�... å ã�ƺ�. �����ִ���
		this(Quality.FHD, Color.CRT);
	}
	
	public Tv(Quality q) {
		this(q, Color.CRT);
	}
	
	public Tv(Color c) {
		this(Quality.FHD, c);
	}
	//End of constructor...
	
	//private methods area. -> �������� private�� �������Ƿ� �׳� public, private ����... �ص� �Ǳ� �ϰڴٸ�.. ���� ���Ŵϱ� �����Ұ� �����غ�.
	private int getValidChannel(int number) {
		int result = number;
		
		//result�� ���ϳ� number�� ���ϳ�.. �׳��� �׳�.
		if(number > 999) {
			result = 1;
		} else if(number <= 0) {
			result = 999;
		}
		
		return result;
	}
	
	//���� private member�� power�� �̰ɷ� ��Ʈ���ϴ°� �ǹٸ���? �����̰� ����ϴ� ������ �־����.
	//�� �������� ���迡���� �ʿ��� �� ������ method�� ����ȭ �ϴ°� �������� ���鿡�� �ξ� �����ϴ���. power�� ���°� ������ true, false �ۿ� ������
	//����, power�� ���°� �پ����� �� �ִٸ�(���������� �������� ����), ���� ��������� �� �޼ҵ忡�� �����Ѵٸ� �ҽ��� ��ġ�Ⱑ ��������ٴ� ������ �־�.
	//������ �� method�� ���ٰ��ؼ� ���� �׷� ���������� ��������. �̰� �� �ƴϾ�, ���ʿ� checkPower�� ���ϰ��� boolean���� true, falase�� �Ҽ������Ƿ�
	//���� ���� power�� type�� ���� �Ǿ������� �ᱹ �굵 ������ ������ϰ���.. �׷��ٸ�,,, �� method�� ���� �κп����� ��� ����Ǿ�� �ϴ� �κ��� �־�
	//�̷��� �κ��� ��ȭ�ϴ°� ���� ���� �ʰ� ��� ���, �߻�ȭ, �������̽� ���� ���ؼ� ������� �����ϰ� ������ �� �־�. �̰� ���߿� �ɵ��ְ� ����غ����� ��Ʈ��.
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
			System.out.println("Power OFF. TV�� ���ϴ�.");
			power = false;
		} else {
			System.out.println("Power On. TV�� �մϴ�.");
			power = true;
		}
	}
	
	public void channelChange(int number) {
		
		if(number > 999 || number <= 0) {
			System.out.println("Invalid Channel Number. �׵� ä���� �����");
			return;
		}
		
		channel = number;
		System.out.printf("ä�� �̵� : %d ��ä�η� ��!\n", channel);
	}
	
	//���⼭ �����غ��� �� �κ��� �ݺ��Ǵ� �κ��� �ִ�.(channelUp, Down����) �̰� ��� �������� �����غ�.. �������� ����� ��������. �ʰ� �ƴ� ���ĸ����ε� ������ ������ ����� ����.
	public void channelUp() {
		
		if(!checkPower()) {
			System.out.println("TV�� �����־��");
			return;
		}
		
		int moveChannel = getValidChannel(channel + 1);		
		channelChange(moveChannel);
	}
	
	public void channelDown() {
		
		if(!checkPower()) {
			System.out.println("TV�� �����־��");
			return;
		}
		
		int movechannel = getValidChannel(channel -1);
		channelChange(movechannel);
	}
	
	//������� �����غ���.. ��.. �ݺ��Ǵ°� �� ���̳�.. ? ����� �Ǿ���.
	public void volumeUp() {
		
		if(!checkPower()) {
			System.out.println("TV�� �����־��");
			return;
		}
		
		if(isValidVolume(volume+1)) {
			volume++;
		}
		//���� ���������� �ƽ� ���� �̻����� �ص� ���� �� �������ݾ�?
		System.out.printf("Volume : %d �Դϴ�\n", volume);
	}
	
	public void volumeDown() {
		if(!checkPower()) {
			System.out.println("TV�� �����־��");
			return;
		}
		
		if(isValidVolume(volume -1)) {
			volume--;
		}
		
		System.out.printf("Volume : %d �Դϴ�\n", volume);
	}
} 

public class TvQuiz {
	
	public static void main(String[] args) {
		
		
		//TODO ...
		
	}
}