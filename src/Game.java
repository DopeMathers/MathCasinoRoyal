import java.util.Scanner;

public class Game 
{

	private static int round = 1;
	
	private static Players playerOne = new Players();
	private static Players playerTwo = new Players();
	private static DataTransfer trans;
	private static Mathematik2 mathe = new Mathematik2();
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) 
	{

		
		
		System.out.println("Player 1 wie ist dein Name?");
		playerOne.setName(scan.nextLine());
		
		System.out.println("Player 2 wie ist dein Name?");
		playerTwo.setName(scan.nextLine());
		
		while(playerOne.getLifes() > 0 && playerTwo.getLifes() > 0)
		{
			
			int guess;
			System.out.println("Runde: " + round);
			calcPosition();
			trans = mathe.getAufgabe();
			
			if(trans.getOperator() == '+')System.out.println("Was ist " + trans.getAufgabe1() + Character.toString(trans.getOperator()) + trans.getAufgabe2() + " ?");
			if(trans.getOperator() == '-')System.out.println("Was ist " + trans.getAufgabe1() + Character.toString(trans.getOperator()) + trans.getAufgabe2() + " ?");
			if(trans.getOperator() == '*')System.out.println("Was ist " + trans.getAufgabe1() + Character.toString(trans.getOperator()) + trans.getAufgabe2() + " ?");
			if(trans.getOperator() == '/')System.out.println("Was ist " + trans.getAufgabe1() + Character.toString(trans.getOperator()) + trans.getAufgabe2() + " ?");
							
			
			if(round % 2 != 0)
			{
				guess = playerOne.getGuess();
				if(guess != trans.getSolution())
				{
					System.err.println("FALSCH");
					playerOne.looseLifes();						
				} 
				else
				{
					System.out.println("Korrekt");
				}
			}
			else
			{
				guess = playerTwo.getGuess();
				if(guess != trans.getSolution())
				{
					System.err.println("FALSCH");
					playerTwo.looseLifes();						
				} 
				else
				{
					System.out.println("Korrekt");
				}
			}
			
			round++;
		
			if(playerOne.getLifes() > 0)
			{
				System.out.println("Spieler gewinnt");
			}
			else if(playerTwo.getLifes() > 0)
			{
				System.out.println("Cpu gewinnt");
			}
			
		}//WHILE
		
	}
	
	private static void calcPosition()
	{
		int position;
		
		if(round % 2 != 0)
		{
		System.out.println(playerOne.getName() + " du bist an der Reihe!");
		System.out.println(playerOne.getLifes() + " leben übrig");
		
		position = playerOne.getLifes() - playerTwo.getLifes();
		
		if(position == 0)
		{
			System.out.println("Gleichstand");
		}
		else if(position > 0)
		{
			System.out.println(position + " leben vorsprung");
		}
		else
		{
			position *= -1;
			System.out.println("Gegenspieler hat " + position + " leben mehr");
		}
		}
		else
		{
			System.out.println(playerTwo.getName() + " du bist an der Reihe!");
			System.out.println(playerTwo.getLifes() + " leben übrig");
			
			position = playerTwo.getLifes() - playerOne.getLifes();
			if(position == 0)
			{
				System.out.println("Gleichstand");
			}
			else if(position > 0)
			{
				System.out.println(position + " leben vorsprung");
			}
			else
			{
				position *= -1;
				System.out.println("Gegenspieler hat " + position + " leben mehr");
			}
		}
	}

}
