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
				System.out.println("*** " + getName() + "�� ���������� ������ �� �����ϴ�. ***");
			} else if(unit.getShield() != 0) {
				// ������ ����� ��ȣ������ ���ٸ� ü�µ� ����
				if(getPower() > unit.getShield()) {
					unit.setHp(unit.getHp() - (getPower() - unit.getArmor()- unit.getShield()));
					unit.setShield(0);
				} else {
					// ��ȣ�� ����
					unit.setShield(unit.getShield() - (getPower() - unit.getArmor()));
				}
			// ü�� ����
			} else if(unit.getHp() != 0) {
				unit.setHp(unit.getHp() - (getPower() - unit.getArmor()));
			} else {
				System.out.println("*** ������ ����� �����ϴ�. ***");
			} 
		} else {
			System.out.println("*** ����� ���ݹ��� �ۿ� �ֽ��ϴ�. ***");
		}
	}


}
class AttackFly extends AttackImpl{
	public AttackFly(int power){
		super(power);
	}

	public void attack(Unit unit){
		if((getX() - unit.getX() <= getRange()) && (getY() - unit.getY() <= getRange())) {
			// ��� ��ȣ���� �ִٸ�
			if(unit.getShield() != 0) {
				// ������ ����� ��ȣ������ ���ٸ� ü�µ� ����
				if((getPower()) > unit.getShield()) {
					unit.setHp(unit.getHp() - ((getPower())  - unit.getArmor()- unit.getShield()));
					unit.setShield(0);
				} else {
					// ��ȣ�� ����
					unit.setShield(unit.getShield() - ((getPower()) - unit.getArmor()));
				}
			// ü�� ����
			} else if(unit.getHp() != 0) {
				unit.setHp(unit.getHp() - ((getPower()) - unit.getArmor()));
			} else {
				System.out.println("*** ������ ����� �����ϴ�. ***");
			}
		} else {
			System.out.println("*** ��Ÿ� �ۿ� �ֽ��ϴ�. ***");
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
		System.out.println(getName()+"�� ("+ x +","+ y +")���� �������� �̵�");
	}
}

class MoveFly extends MoveImpl{
	public MoveFly(int x, int y){
		super(x,y);
	}
	public void move(int x, int y){
		setX(x);
		setY(y);
		System.out.println(getName()+"�� ("+ x +","+ y +")���� �������� �̵�");
	}
}

abstract class Unit{

	//�������
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
	//������
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
	// ���� ���
	@Override
	public String toString() {
		String info = "���ָ� : " + name + "\n";
		info += "ü�� : " + hp + " / " + maxHp + "\n" ;
		info += "���� : " + armor + "\n";
		info += "���� ����: "+ fly+"\n";
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
	//������
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
	
	// ���
	@Override
	public String toString() {
		String info = super.toString();
		info += "���� : " + mana + " / " + maxMana + "\n";
		return info;
	}

	public void heal(Unit unit) {
		// ���� ���� ġ�� �Ұ�
		if(unit.isFly()) {
			System.out.println("*** " + getName() + "�� ���������� ġ���� �� �����ϴ�. ***");
		} else if((getX() - unit.getX() <= getRange()) && (getY() - unit.getY() <= getRange())) {
			if(unit.getHp() != 0) {		// ���� ���� ġ�� �Ұ�
				if(unit.getHp() < unit.getMaxHp() && getMana() > 0) {
					setMana(mana - 1);
					unit.setHp(unit.getHp() + 2);
					if(unit.getHp() > unit.getMaxHp()) {	// �ִ� ü�� �ʰ� �Ұ�
						unit.setHp(unit.getMaxHp());
					}
				}
			}
		} else {
			System.out.println("*** ����� ġ�� ���� �ۿ� �ֽ��ϴ�. ***");
		}
	}

}

class Zealot extends Unit{
	private int maxShield;
	//������
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

	// ���
	@Override
	public String toString() {
		String info = super.toString();
		info += "���ݷ� : " + iattack.getPower() + ", ���� ��Ÿ� : " + getRange() + "\n";
		info += "��ȣ�� : " + getShield() + " / " + getMaxShield() + "\n";
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
	
	// 2���� ���� ����
	public void attack(Unit unit1, Unit unit2) {
		iattack.attack(unit1);
		splash();
		iattack.attack(unit2);
	}

	// 3���� ���� ����
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
