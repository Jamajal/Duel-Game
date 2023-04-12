
public class Warrior extends Character{

	Warrior(String name, int level){
		super(name, level);
	}
	
	void display() {
		System.out.println("------------------");
		System.out.println(this.name);
		System.out.printf("PV: %d\n", this.health);
		System.out.printf("Strength: %d\n", this.strength);
		System.out.printf("Agility: %d\n", this.agility);
		System.out.println("------------------\n");
	}
}
