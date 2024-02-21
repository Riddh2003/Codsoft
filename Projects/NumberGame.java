package Projects;

import java.util.Random;
import java.util.Scanner;

public class NumberGame{
	Random random = new Random();
	int ranNumber = random.nextInt(10)+1;
	int i = 1;
	boolean exitLoop = false;
	Scanner sc = new Scanner(System.in);
	
//startgmae method
	public int startgame(int round,int score) {
		int point =0 ,chance = 0;
		System.out.println("     *********************");
		System.out.println("     * Round "+round+" is start. *");
		System.out.println("     *********************");
		System.out.println();
		while(i<=5) 
		{		
			int ranNumber = random.nextInt(10)+1;
			System.out.println();
			System.out.print("-->You can guess number : ");
			int guessNumber = sc.nextInt();
			System.out.println();
			if(guessNumber>=1 && guessNumber<=10) 
			{	
				chance++;
				if(guessNumber == ranNumber) 
				{
					point++;
					System.out.println("************************************");
					System.out.println("* You Won this chance, Keep it up. *");
					System.out.println("* Point : "+point+" Chance : "+chance+" Round : "+round+"   *");
					System.out.println("************************************");
					System.out.println("-----------------------------------------------------");
				}
				else 
				{
					System.out.println("************************************");
					System.out.println("* You Loss this Chance, Try again. *");
					System.out.println("* Point : "+point+" Chance : "+chance+" Round : "+round+"   *");
					System.out.println("************************************");
					System.out.println("-----------------------------------------------------");
				}
				i++;
			}
			else 
			{
				System.out.println("Your have to guess between 1 to 10. So try again!!");
				System.out.println("-----------------------------------------------------");
			}
		}
		if(round == 1 || round ==2 || round == 3) {
			if(point >=3) 
			{
				System.out.println("   *******************************");
				System.out.println("   *You Won round"+round+" with "+point+" Points.*");
				System.out.println("   *******************************");
				System.out.println("-----------------------------------------------------");
				System.out.println();
			}
			else 
			{
				System.out.println("     ************************");
				System.out.println("     * You Loss this round. *");
				System.out.println("     ************************");
				System.out.println("-----------------------------------------------------");
				System.out.println();
			}
		}			
		score = point;
		return score;
	}
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		int round = 1,score =0;
		boolean exitLoop = false;
		while(!exitLoop) 
		{
			System.out.println("1.StartGame/PlayAgain\n2.QuitGame");
			System.out.println();
			System.out.println("!!!!Note : In this game 3 rounds are there!!!!!");
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.print("-->Enter the Choice :  ");
			int ch1 = sc1.nextInt();
			System.out.println("----------------------------------------------------------------------------------------");
			if(ch1<1 || ch1>2)break;
			switch(ch1) {
			case 1 :
				while(round<=3) {						 
					 NumberGame ng = new NumberGame();
					 score += ng.startgame(round,score);
					 round ++;
				 }
				if(score >10) {
					System.out.println("   ***********************************");
					System.out.println("   * You won this game with "+score+" Points. *");
					System.out.println("   ***********************************");
					System.out.println("-----------------------------------------------------");
					System.out.println();
				}
				else {
					System.out.println("   ************************************");
					System.out.println("   * Your socre is "+score+" so you loss game. *");
					System.out.println("   ************************************");
					System.out.println("-----------------------------------------------------");
					System.out.println();
				}
				break;
			case 2 : exitLoop = true;
				break;
			}	
		}	
		System.out.println();
		System.out.println("   ************************************");
		System.out.println("   * Thank You for playing this game  *");
		System.out.println("   ************************************");
	}
}
