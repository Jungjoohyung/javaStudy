import java.util.*;
class DiceGame{
	
	private int diceFace;
	private int userGuess;
	
	private void checkUserGuess(){
		if( diceFace == userGuess ){
			System.out.println("�¾ҽ��ϴ�.");
		} else {
			//while(diceFace!=userGuess){
				System.out.println("Ʋ�Ƚ��ϴ�.");
				//getUserInput();

			//}
			
		}
	}
	
	private int getUserInput(){
		
		System.out.println("������ �Է��Ͻÿ�: ");
		Scanner s = new Scanner(System.in);
		return s.nextInt();
		
	}

	private int rollDice(){
				
		return (int)(Math.random()*6)+1;
	}

	
	public void startPlaying() {
		diceFace = rollDice();

		do{
		userGuess = getUserInput();
		checkUserGuess();
		} while(diceFace != userGuess);

	}	
	
	
}



public class DiceGameTest {
	public static void main(String[] args)	{
		DiceGame game = new DiceGame();
		game.startPlaying();
	}
}
