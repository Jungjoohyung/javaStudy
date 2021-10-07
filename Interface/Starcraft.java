// (range>(unit1.getX()-unit2.getX())>(-range),range>(unit1.getY()-unit2.getY())>(-range))�� <= ��Ÿ� ���
// ������Ʈ ���
// recovery �߰� ��� ���
// uml �ۼ� 

class Unit{
	private String name;
	private int hp;
	private int maxHp;
	private int armor;
	private int x;
	private int y;
	private String race;
	private boolean fly;
	private int shield;
	private int range;
	//race
	//
	public Unit(String name, int hp, int maxHp,int armor, int x, int y, String race, boolean fly){
		setName(name);
		setHp(hp);
		setMaxHp(maxHp);
		setArmor(armor);
		setX(x);
		setY(y);
		setRace(race);
		setFly(fly);
	}
	//
	public String getName(){
		return name;
	}
	public int getHp(){
		return hp;
	}
	public int getMaxHp(){
		return maxHp;
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
	public String getRace(){
		return race;
	}
	public boolean isFly(){
		return fly;
	}
	public int getShield(){
		return shield;
	}
	public int getRange(){
		return range;
	}
	//
	public void setName(String name){
		this.name = name;
	}
	public void setHp(int hp){
		this.hp = hp;
	}
	public void setMaxHp(int maxHp){
		this.maxHp = hp;
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
	public void setRace(String race){
		this.race = race;
	}
	public void setFly(boolean fly){
		this.fly = fly;
	}
	public void setShield(int shield){
		this.shield = shield;
	}
	public void setRange(int range){
		this.range = range;
	}
	//
	@Override
	public String toString(){
		String info = "���� ��: " + name +", ����: " + armor + "\n";
		info += "��ü ü��: " + maxHp + ", ���� ü��: "+hp+"\n" ;
		info += "���� ����: " + fly + ", ���� ��ġ:"+"("+x+","+y+")"+"\n" ;
		return info;
	}

}
interface IAttackableBoth{
	public void attackBoth(Unit unit);
}

interface IAttackableGround{
	public void attackGround(Unit unit);
}
interface IMovableFly{
	public void moveFly(int x, int y);
}
interface IMovableGround{
	public void moveGround(int x, int y);	
}

interface IHealable{
	public void heal(Unit unit);
}

class Medic extends Unit implements IMovableGround,IHealable{
	private int mana;
	private int maxMana;

	public Medic(){
		super("Medic", 60,60,1,1,1,"Terran",false);
		setMana(200);
		setMaxMana(200);
	}
	//
	public int getMana(){
		return mana;
	}
	public int getMaxmana(){
		return maxMana;
	}
	public void setMana(int mana){
		this.mana = mana;
	}
	public void setMaxMana(int maxMana){
		this.maxMana = maxMana;
	}
	
	@Override
	public void heal(Unit unit){
		if(unit.isFly()) {
			System.out.println("*** " + getName() + "�� ���������� ġ���� �� �����ϴ�. ***");
		} else {
			if(unit.getHp() != 0 || getMana() != 0) {		// ���� ���� ġ�� �Ұ�
				if(unit.getHp() < unit.getMaxHp() && getMana() > 0) {
					unit.setHp(unit.getHp() + 2);
					setMana(mana-1);
					if(unit.getHp() > unit.getMaxHp()) {	// �ִ� ü�� �ʰ� �Ұ�
						unit.setHp(unit.getMaxHp());
					}			
				}
			}	
		}
	}

	@Override
	public void moveGround(int x, int y){
		setX(x);
		setY(y);
		System.out.println(getName()+"�� ("+ x +","+ y +")���� �������� �̵�");
	}
	@Override
	public String toString(){
		String info = super.toString();
		info += "��ü ����: " + maxMana + ", ���� ����: " + mana + "\n";
		return info;
		
	}

	



}
class Zealot extends Unit implements IMovableGround, IAttackableGround{
	private int power;
	
	//
	public Zealot(){
		super("Zealot",100,100,1,12,12,"Protoss",false);
		setShield(60);
		setPower(8);
		setRange(5);
	}
	//
	public int getPower(){
		return power;
	}
	
	//
	public void setPower(int power){
		this.power = power;
	}
	
	@Override
	public void moveGround(int x, int y){
		setX(x);
		setY(y);
		System.out.println(getName()+"�� ("+ x +","+ y +")���� �������� �̵�");
	}
	
	
	@Override
	public void attackGround(Unit unit){
		if((getX() - unit.getX() <= getRange()) && (getY() - unit.getY() <= getRange())) {
		if(unit.isFly()) {
			System.out.println("*** " + getName() + "�� ���������� ������ �� �����ϴ�. ***");
		} else if (unit.getShield() != 0){
			if((power*2) > unit.getShield()) {
				unit.setHp(unit.getHp() - ((power*2)  - unit.getArmor()- unit.getShield()));
				unit.setShield(0);
			} else {
				// ��ȣ�� ����
				unit.setShield(unit.getShield() - ((power*2) - unit.getArmor()));
			}
		// ü�� ����
		} else if(unit.getHp() != 0) {
			unit.setHp(unit.getHp() - ((power*2) - unit.getArmor()));
		} else {
			System.out.println("*** ������ ����� �����ϴ�. ***");
			}
		}else {
         System.out.println("*** ����� ���ݹ��� �ۿ� �ֽ��ϴ�. ***");
      }

	
	}
	@Override
	public String toString(){
		String info = super.toString();
		info += "���ݷ�: " +power + ", ���� : "+ getShield() + "\n" ;
		return info;	
	}
	
}
class Mutal extends Unit implements IMovableFly,IAttackableBoth{
	private int power;
	private int splashDamage;

	public Mutal(){
		super("Mutal",120,120,0,6,6,"Zerg",true);
		setPower(9);
		setSplashDamage(3);
	}
	public int getPower(){
		return power;
	}
	public int getSplashDamage(){
		return splashDamage;
	}

	public void setPower(int power){
		this.power = power;
	}
	public void setSplashDamage(int splashDamage){
		this.splashDamage = splashDamage;
	}
	// ���÷��� ������ ����
   public void splash() {
      setPower(getPower() / getSplashDamage());
   }
   
   // 2���� ���� ����
   public void attackBoth(Unit unit1, Unit unit2) {
      attackBoth(unit1);
      splash();
      attackBoth(unit2);
   }

   // 3���� ���� ����
   public void attackBoth(Unit unit1, Unit unit2, Unit unit3) {
      attackBoth(unit1);
      splash();
      attackBoth(unit2);
      splash();
      attackBoth(unit3);
   }
	@Override
	public void attackBoth(Unit unit){
		if (unit.getShield() != 0){
			if((power*2) > unit.getShield()) {
				unit.setHp(unit.getHp() - ((power*2)  - unit.getArmor()- unit.getShield()));
				unit.setShield(0);
			} else {
				// ��ȣ�� ����
				unit.setShield(unit.getShield() - ((power*2) - unit.getArmor()));
			}
		// ü�� ����
		} else if(unit.getHp() != 0) {
			unit.setHp(unit.getHp() - ((power*2) - unit.getArmor()));
		} else {
			System.out.println("*** ������ ����� �����ϴ�. ***");
		}
	}
	
	@Override
	public void moveFly(int x, int y){
		setX(x);
		setY(y);
		System.out.println(getName()+"�� ("+ x +","+ y +")���� �������� �̵�");
	}
	@Override
	public String toString(){
		String info = super.toString();
		info += "���ݷ�: " + power + ", �ļ�Ÿ ���ݷ�: " + splashDamage + "\n";
		return info;
	}
}
class Starcraft {
	public static void main(String[] args){
		
		Medic md1 = new Medic();
		Mutal mt1 = new Mutal();
		Zealot z1 = new Zealot();
		
		//test
		//���� Ȯ��
		System.out.println("====== ���� ���� Ȯ�� ======");
		System.out.println(md1);
		System.out.println(z1);
		System.out.println(mt1);
		// ���� �׽�Ʈ
		System.out.println("\n===== ���� ��� Ȯ�� =====");
		System.out.println("--- �ǵ�, ü�� ���� ---");
		Zealot z2 = new Zealot();
		z2.setShield(6);
		System.out.println(z2);
		z1.attackGround(z2);
		System.out.println(z2);
		z1.attackGround(z2);
		System.out.println(z2);

		System.out.println("\n--- ���� -> ���� ���� ---");
		z1.attackGround(mt1);
		System.out.println(mt1);
		
		// ġ�� �׽�Ʈ
		System.out.println("\n===== ġ�� ��� Ȯ�� =====");
		System.out.println("--- ü�� ���� ---");
		z2.setHp(97);
		System.out.println(z2);
		md1.heal(z2);
		System.out.println(z2);

		System.out.println("\n--- ���� ���� ġ�� ---");
		mt1.setHp(102);
		System.out.println(mt1);
		md1.heal(mt1);
		System.out.println(mt1);

		// ���÷��� �׽�Ʈ
		System.out.println("\n===== ��Ż 1 -> ���� 3 ���� =====");
		Zealot z3 = new Zealot();
		Zealot z4 = new Zealot();
		Zealot z5 = new Zealot();

		mt1.attackBoth(z3, z4, z5);
		System.out.println(z3);
		System.out.println(z4);
		System.out.println(z5);

		Zealot z7 = new Zealot();
		Zealot z6 = new Zealot();

		z7.attackGround(z6);	
		System.out.println(z6);

		z7.moveGround(13, 20);
		z7.attackGround(z6);
		System.out.println(z6);
		System.out.println(z7);

		


		
	}
}
// (range>(unit1.getX()-unit2.getX())>(-range),range>(unit1.getY()-unit2.getY())>(-range))�� <= ��Ÿ�
// ������Ʈ