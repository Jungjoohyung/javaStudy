// (range>(unit1.getX()-unit2.getX())>(-range),range>(unit1.getY()-unit2.getY())>(-range))가 <= 사거리 고민
// 더블히트 고민
// recovery 추가 방법 고민
// uml 작성 

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
		String info = "유닛 명: " + name +", 방어력: " + armor + "\n";
		info += "전체 체력: " + maxHp + ", 현재 체력: "+hp+"\n" ;
		info += "공중 유닛: " + fly + ", 현재 위치:"+"("+x+","+y+")"+"\n" ;
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
			System.out.println("*** " + getName() + "은 공중유닛을 치료할 수 없습니다. ***");
		} else {
			if(unit.getHp() != 0 || getMana() != 0) {		// 죽은 유닛 치료 불가
				if(unit.getHp() < unit.getMaxHp() && getMana() > 0) {
					unit.setHp(unit.getHp() + 2);
					setMana(mana-1);
					if(unit.getHp() > unit.getMaxHp()) {	// 최대 체력 초과 불가
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
		System.out.println(getName()+"이 ("+ x +","+ y +")으로 지상으로 이동");
	}
	@Override
	public String toString(){
		String info = super.toString();
		info += "전체 마나: " + maxMana + ", 현재 마나: " + mana + "\n";
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
		System.out.println(getName()+"이 ("+ x +","+ y +")으로 지상으로 이동");
	}
	
	
	@Override
	public void attackGround(Unit unit){
		if((getX() - unit.getX() <= getRange()) && (getY() - unit.getY() <= getRange())) {
		if(unit.isFly()) {
			System.out.println("*** " + getName() + "은 공중유닛을 공격할 수 없습니다. ***");
		} else if (unit.getShield() != 0){
			if((power*2) > unit.getShield()) {
				unit.setHp(unit.getHp() - ((power*2)  - unit.getArmor()- unit.getShield()));
				unit.setShield(0);
			} else {
				// 보호막 감소
				unit.setShield(unit.getShield() - ((power*2) - unit.getArmor()));
			}
		// 체력 감소
		} else if(unit.getHp() != 0) {
			unit.setHp(unit.getHp() - ((power*2) - unit.getArmor()));
		} else {
			System.out.println("*** 공격할 대상이 없습니다. ***");
			}
		}else {
         System.out.println("*** 대상이 공격범위 밖에 있습니다. ***");
      }

	
	}
	@Override
	public String toString(){
		String info = super.toString();
		info += "공격력: " +power + ", 쉴드 : "+ getShield() + "\n" ;
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
	// 스플래시 데미지 감소
   public void splash() {
      setPower(getPower() / getSplashDamage());
   }
   
   // 2마리 동시 공격
   public void attackBoth(Unit unit1, Unit unit2) {
      attackBoth(unit1);
      splash();
      attackBoth(unit2);
   }

   // 3마리 동시 공격
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
				// 보호막 감소
				unit.setShield(unit.getShield() - ((power*2) - unit.getArmor()));
			}
		// 체력 감소
		} else if(unit.getHp() != 0) {
			unit.setHp(unit.getHp() - ((power*2) - unit.getArmor()));
		} else {
			System.out.println("*** 공격할 대상이 없습니다. ***");
		}
	}
	
	@Override
	public void moveFly(int x, int y){
		setX(x);
		setY(y);
		System.out.println(getName()+"이 ("+ x +","+ y +")으로 공중으로 이동");
	}
	@Override
	public String toString(){
		String info = super.toString();
		info += "공격력: " + power + ", 후속타 공격력: " + splashDamage + "\n";
		return info;
	}
}
class Starcraft {
	public static void main(String[] args){
		
		Medic md1 = new Medic();
		Mutal mt1 = new Mutal();
		Zealot z1 = new Zealot();
		
		//test
		//유닛 확인
		System.out.println("====== 생성 유닛 확인 ======");
		System.out.println(md1);
		System.out.println(z1);
		System.out.println(mt1);
		// 공격 테스트
		System.out.println("\n===== 공격 기능 확인 =====");
		System.out.println("--- 실드, 체력 감소 ---");
		Zealot z2 = new Zealot();
		z2.setShield(6);
		System.out.println(z2);
		z1.attackGround(z2);
		System.out.println(z2);
		z1.attackGround(z2);
		System.out.println(z2);

		System.out.println("\n--- 지상 -> 공중 공격 ---");
		z1.attackGround(mt1);
		System.out.println(mt1);
		
		// 치료 테스트
		System.out.println("\n===== 치료 기능 확인 =====");
		System.out.println("--- 체력 증가 ---");
		z2.setHp(97);
		System.out.println(z2);
		md1.heal(z2);
		System.out.println(z2);

		System.out.println("\n--- 공중 유닛 치료 ---");
		mt1.setHp(102);
		System.out.println(mt1);
		md1.heal(mt1);
		System.out.println(mt1);

		// 스플래시 테스트
		System.out.println("\n===== 뮤탈 1 -> 질럿 3 공격 =====");
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
// (range>(unit1.getX()-unit2.getX())>(-range),range>(unit1.getY()-unit2.getY())>(-range))가 <= 사거리
// 더블히트