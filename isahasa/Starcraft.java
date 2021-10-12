interface IAttack{
	void attack(Unit unit);
	int getPower();
	int getX();
	int getY();
	int getRange();
	String getName();
	void setPower(int power);
}


abstract class  AttackImpl implements IAttack {
	private int power;
	private int x;
	private int y;
	private int range;
	private String name;

	public AttackImpl(int power){
		setPower(power);
	}

	@Override
	public int getPower(){
		return power;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getRange(){
		return range;
	}
	public String getName(){
		return name;
	}
	
	public void setPower(int power){
		this.power = power;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void setRange(int range){
		this.range = range;
	}
	public void setName(String name){
		this.name = name;
	}
}
class AttackGround extends AttackImpl{
	public AttackGround(int power){
		super(power);
	}

	public void attack(Unit unit){
		if((getX() - unit.getX() <= getRange()) && (getY() - unit.getY() <= unit.getRange())) {
			if(unit.isFly()) {
				System.out.println("*** " + getName() + "은 공중유닛을 공격할 수 없습니다. ***");
			} else if(unit.getShield() != 0) {
				// 공격이 대상의 보호막보다 높다면 체력도 감소
				if(getPower() > unit.getShield()) {
					unit.setHp(unit.getHp() - (getPower() - unit.getArmor()- unit.getShield()));
					unit.setShield(0);
				} else {
					// 보호막 감소
					unit.setShield(unit.getShield() - (getPower() - unit.getArmor()));
				}
			// 체력 감소
			} else if(unit.getHp() != 0) {
				unit.setHp(unit.getHp() - (getPower() - unit.getArmor()));
			} else {
				System.out.println("*** 공격할 대상이 없습니다. ***");
			} 
		} else {
			System.out.println("*** 대상이 공격범위 밖에 있습니다. ***");
		}
	}


}
class AttackFly extends AttackImpl{
	public AttackFly(int power){
		super(power);
	}

	public void attack(Unit unit){
		if((getX() - unit.getX() <= getRange()) && (getY() - unit.getY() <= getRange())) {
			// 대상에 보호막이 있다면
			if(unit.getShield() != 0) {
				// 공격이 대상의 보호막보다 높다면 체력도 감소
				if((getPower()) > unit.getShield()) {
					unit.setHp(unit.getHp() - ((getPower())  - unit.getArmor()- unit.getShield()));
					unit.setShield(0);
				} else {
					// 보호막 감소
					unit.setShield(unit.getShield() - ((getPower()) - unit.getArmor()));
				}
			// 체력 감소
			} else if(unit.getHp() != 0) {
				unit.setHp(unit.getHp() - ((getPower()) - unit.getArmor()));
			} else {
				System.out.println("*** 공격할 대상이 없습니다. ***");
			}
		} else {
			System.out.println("*** 사거리 밖에 있습니다. ***");
		}
	}
}

interface IMove {
	void move(int x, int y);
	int getX();
	int getY();
	
}
abstract class MoveImpl implements IMove{
	private String name;
	private int x;
	private int y;
	
	public MoveImpl(int x,int y){
		setX(x);
		setY(y);
	}
	@Override
	public int getX(){
		return x;
	}
	@Override
	public int getY(){
		return y;
	}
	public String getName(){
		return name;
	}

	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void setName(String name){
		this.name = name;
	}
}
class MoveGround extends MoveImpl{
	public MoveGround(int x, int y){
		super(x,y);
	}
	public void move(int x, int y){
		setX(x);
		setY(y);
		System.out.println(getName()+"이 ("+ x +","+ y +")으로 지상으로 이동");
	}
}

class MoveFly extends MoveImpl{
	public MoveFly(int x, int y){
		super(x,y);
	}
	public void move(int x, int y){
		setX(x);
		setY(y);
		System.out.println(getName()+"이 ("+ x +","+ y +")으로 공중으로 이동");
	}
}

abstract class Unit{

	//멤버변수
	protected IAttack iattack;
	private IMove imove;
	private String name;
	private int hp;
	private int maxHp;
	private boolean fly;
	private int shield;
	private int range;
	private int armor;
	private int x;
	private int y;
	//생성자
	public Unit(String name, int hp, int maxHp,boolean fly, int armor){
		setName(name);
		setHp(hp);
		setMaxHp(maxHp);
		setFly(fly);
		setArmor(armor);
	}
	//getter
	public IAttack getIattack(){
		return iattack;
	}
	public IMove getImove(){
		return imove;
	}
	public String getName(){
		return name;
	}
	public int getHp(){
		return hp;
	}	
	public int getMaxHp(){
		return maxHp;
	}
	public int getShield(){
		return shield;
	}
	public int getRange(){
		return range;
	}
	public boolean isFly(){
		return fly;
	}
	public int getArmor(){
		return armor;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	//setter
	public void setIattack(IAttack iattack){
		this.iattack = iattack;
	}
	public void setImove(IMove imove){
		this.imove = imove;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setHp(int hp){
		this.hp = hp;
	}
	public void setMaxHp(int maxHp){
		this.maxHp = maxHp;
	}
	public void setShield(int shield){
		this.shield = shield;
	}
	public void setRange(int range){
		this.range = range;
	}
	public void setFly(boolean fly){
		this.fly = fly;
	}
	public void setArmor(int armor){
		this.armor = armor;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y; 
	}
	// 정보 출력
	@Override
	public String toString() {
		String info = "유닛명 : " + name + "\n";
		info += "체력 : " + hp + " / " + maxHp + "\n" ;
		info += "방어력 : " + armor + "\n";
		info += "공중 유닛: "+ fly+"\n";
		return info;
	}
	public void PerformAttack(){
	
	}
	public void PerformMove(){
	
	}

}

class Medic extends Unit{
	private int mana;
	private int maxMana;
	//생성자
	public Medic(){
		super("Medic",60,60,false,1);
		setMana(200);
		setMaxMana(200);
		setImove(new MoveGround(1,1));
		
	}
	//getter
	public int getMana(){
		return mana;
	}
	public int getMaxMana(){
		return maxMana;
	}
	public void setMana(int mana){
		this.mana = mana;
	}
	public void setMaxMana(int maxMana){
		this.maxMana = maxMana;
	}
	
	// 출력
	@Override
	public String toString() {
		String info = super.toString();
		info += "마나 : " + mana + " / " + maxMana + "\n";
		return info;
	}

	public void heal(Unit unit) {
		// 공중 유닛 치료 불가
		if(unit.isFly()) {
			System.out.println("*** " + getName() + "은 공중유닛을 치료할 수 없습니다. ***");
		} else if((getX() - unit.getX() <= getRange()) && (getY() - unit.getY() <= getRange())) {
			if(unit.getHp() != 0) {		// 죽은 유닛 치료 불가
				if(unit.getHp() < unit.getMaxHp() && getMana() > 0) {
					setMana(mana - 1);
					unit.setHp(unit.getHp() + 2);
					if(unit.getHp() > unit.getMaxHp()) {	// 최대 체력 초과 불가
						unit.setHp(unit.getMaxHp());
					}
				}
			}
		} else {
			System.out.println("*** 대상이 치료 범위 밖에 있습니다. ***");
		}
	}

}

class Zealot extends Unit{
	private int maxShield;
	//생성자
	public Zealot(){
		super("Zealot",100,100,false,1);
			setShield(60);
			setMaxShield(60);
			setRange(1);
			setImove(new MoveGround(12,12));
			setIattack(new AttackGround(8));
	}
	//getter
	public int getMaxShield(){
		return maxShield;
	}
	//setter
	public void setMaxShield(int maxShield){
		this.maxShield = maxShield;
	}

	// 출력
	@Override
	public String toString() {
		String info = super.toString();
		info += "공격력 : " + iattack.getPower() + ", 공격 사거리 : " + getRange() + "\n";
		info += "보호막 : " + getShield() + " / " + getMaxShield() + "\n";
		return info;
	}

}

class Mutal extends Unit{
	private int splashDamage;
	
	public Mutal(){
		super("Mutal",120,120 ,true,0);
			setSplashDamage(3);
			setRange(3);
			setImove(new MoveFly(6,6));
			setIattack(new AttackGround(8));
			setIattack(new AttackFly(9));
	}
	public int getSplashDamage(){
		return splashDamage;
	}

	public void setSplashDamage(int splashDamage){
		this.splashDamage = splashDamage;
	}


	public void splash() {
		iattack.setPower(iattack.getPower() / getSplashDamage());
	}
	
	// 2마리 동시 공격
	public void attack(Unit unit1, Unit unit2) {
		iattack.attack(unit1);
		splash();
		iattack.attack(unit2);
	}

	// 3마리 동시 공격
	public void attack(Unit unit1, Unit unit2, Unit unit3) {
		iattack.attack(unit1);
		splash();
		iattack.attack(unit2);
		splash();
		iattack.attack(unit3);
	}

}

class Starcraft {
	public static void main(String[] args) {
		Medic md1 = new Medic();
		Zealot z1 = new Zealot();
		Zealot z2 = new Zealot();
		Mutal mu1 = new Mutal();
		Mutal mu2 = new Mutal();
		
		System.out.println(z2);
		mu1.attack(z1,z2,mu2);
		System.out.println(z1);

		
	
		
	}
}
