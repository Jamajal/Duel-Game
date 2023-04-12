import java.util.*;

public class Main {

	public static void main(String[] args) {
		Player player = new Player("Heroi", 3);
		Warrior enemy = new Warrior("Orc", 3);
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("Welcome to my duel game! Good lucky!!!\n");
		player.display();
		enemy.display();
		
		while(!player.isDead() && !enemy.isDead()) {		
			int attackResult, attackTentative, dodgeTentative;
			
			System.out.printf("%s current life: %d\nRemaining potions: %d\n\n", player.name, player.health, player.healingPotion);			
			System.out.println("Choose 1 to attack or 2 to heal.");

			int choice = scanner.nextInt();
			if(choice != 1 && choice != 2) {
				System.out.println("You type the wrong choice! Try again.");
				continue;
			}
			
			System.out.println("\n" + player.name + " turn:");
			
			if(choice == 1) {
				System.out.println("--------------------");
				attackTentative = player.attack();
				dodgeTentative = enemy.dodge();
				
				attackResult = player.resolveAttack(attackTentative, dodgeTentative);
				enemy.getHit(attackResult);
				System.out.println("--------------------\n");
			}
			
			else {
				System.out.println("--------------------");
				player.heal();
				System.out.printf("%s new PV: %d\n", player.name, player.health);
				System.out.println("--------------------\n");
			}
			
			System.out.println("\n" + enemy.name + " turn:");
			System.out.println("--------------------");
			attackTentative = enemy.attack();
			dodgeTentative = player.dodge();
			
			attackResult = enemy.resolveAttack(attackTentative, dodgeTentative);
			player.getHit(attackResult);
			System.out.println("--------------------\n");			
			
		}
		
		if(player.isDead())
			System.out.print("You lose!");
		else {
			System.out.println("You win!");
		}
		
		scanner.close();
	}
}

