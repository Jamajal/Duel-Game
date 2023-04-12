
public class Player extends Character{
	int healingPotion = 3;
	int maxHealth;
	
	Player(String name, int level){
		super(name, level);
		maxHealth = health;
	}
	
	void heal() {
		if(this.healingPotion > 0 && (this.health + 20) <= maxHealth) {
			System.out.printf("%s drinks an healing potion! It heals 20 points\n", this.name);
			this.health += 20;
			this.healingPotion--;			
		}
		else {
			System.out.printf("%s is out of potions\n", this.name);
		}
	}
	
	void display() {
		System.out.println("------------------");
		System.out.println(this.name);
		System.out.printf("PV: %d\n", this.health);
		System.out.printf("Strength: %d\n", this.strength);
		System.out.printf("Agility: %d\n", this.agility);
		System.out.printf("Remaining healing potion: %d\n", this.healingPotion);
		System.out.println("------------------\n");
	}
}
