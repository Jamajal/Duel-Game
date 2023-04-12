import java.util.Random;

public class Character {
	String name;
	int health;
	int strength = 0;
	int agility = 0;

	Character(String name, int level){
		Random random = new Random();
		
		this.name = name;
		this.health = level * 20;
		
		for(int i = 0; i < level; i++) {
			this.strength += (random.nextInt(5) + 1);
			this.agility +=  (random.nextInt(4) + 1);							
		}
	}
	
	void display() {
		System.out.println("Health: " + this.health);
		System.out.println("Strength: " + this.strength);
		System.out.println("Agility: " + this.agility);
	}
	
	int attack() {
		int attackTentative = this.strength + getVariation(5);
		
		if(attackTentative < 0) {
			attackTentative = 0;
		}
		
		System.out.printf("%s try to attack... Value of attack: %d\n", this.name, attackTentative);
		return attackTentative;
	}
	
	int dodge() {
		int dodgeTentative = this.agility + getVariation(5);
		
		if(dodgeTentative < 0) {
			dodgeTentative = 0;
		}
		
		System.out.printf("%s try to dodge... Value of dodge: %d\n", this.name, dodgeTentative);
		return dodgeTentative;
	}
	
	int resolveAttack(int attack, int dodge) {
		int damage = this.strength + getVariation(5);
				
		if (attack >= dodge) {
			System.out.printf("%s hits it's target!!!! It deals %d damage.\n", this.name, damage);
			return damage;
		}
		
		System.out.printf("%s misses!!!!\n", this.name);
		return 0;
	}
	
	void getHit(int damage) {
		this.health -= damage;
	}
	
	boolean isDead() {
		if(this.health <= 0)
			return true;
		
		return false;
	}
	
	int getVariation(int number) {
		Random random = new Random();
		
		int variation = random.nextInt(number+1);
		int variationSignal = random.nextInt(2);
		
		if(variationSignal == 0)
			return variation * -1;
		
		return variation;

	}
}
