import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Game 
{
	public static String language = "german";
	public static String region = "US";
	public static String lang = "en";
	
	private static Locale locale = new Locale(lang,region);
	private static ResourceBundle rba = ResourceBundle.getBundle("LanguageBundle", locale);
	private static ResourceBundle rbb;
	
	private static int round = 1;
	private static String playerOrBot;
	
	private static Players playerOne = new Players();
	private static Players playerTwo = new Players();
	private static Bot bot = new Bot();
	private static DataTransfer trans;
	private static Mathematik2 mathe = new Mathematik2();
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) 
	{

		System.out.println(rba.getString("askForLanguage"));
		
		language = scan.nextLine();
		
		if(language.equalsIgnoreCase("deutsch")|| language.equalsIgnoreCase("german") || language.equalsIgnoreCase("de") || language.equalsIgnoreCase("ger"))
			{
			language = "deutsch";
			lang = "de";
			region = "DE";
			}
		else
		{
			language = "english";
			lang = "en";
			region = "US";
		}
	
		locale = new Locale(lang,region);
		rbb = ResourceBundle.getBundle("LanguageBundle", locale);
		System.out.println(rbb.getString("languageSetTo"));
		
		System.out.println(rbb.getString("pOB"));
		playerOrBot = scan.nextLine();
		
		if(playerOrBot.equalsIgnoreCase("playermode") || playerOrBot.equalsIgnoreCase("spielermodus"))
		{
			playerOrBot = "player";
		}
		else
		{
			playerOrBot = "bot";
		}
		
		System.out.println(rbb.getString("askP1ForName"));
		playerOne.setName(scan.nextLine());
		
		if(playerOrBot.equalsIgnoreCase("player"))
		{
		System.out.println(rbb.getString("askP2ForName"));
		playerTwo.setName(scan.nextLine());
		
		
		while(playerOne.getLifes() > 0 && playerTwo.getLifes() > 0)
		{
			
			int guess;
			System.out.println(rbb.getString("round") + " " + round);
			calcPosition();
			trans = mathe.getAufgabe();
			
			if(trans.getOperator() == '+')System.out.println(rbb.getString("question") + " " + trans.getAufgabe1() + Character.toString(trans.getOperator()) + trans.getAufgabe2() + " ?");
			if(trans.getOperator() == '-')System.out.println(rbb.getString("question") + " " + trans.getAufgabe1() + Character.toString(trans.getOperator()) + trans.getAufgabe2() + " ?");
			if(trans.getOperator() == '*')System.out.println(rbb.getString("question") + " " + trans.getAufgabe1() + Character.toString(trans.getOperator()) + trans.getAufgabe2() + " ?");
			if(trans.getOperator() == '/')System.out.println(rbb.getString("question") + " " + trans.getAufgabe1() + Character.toString(trans.getOperator()) + trans.getAufgabe2() + " ?");
							
			
			if(round % 2 != 0)
			{
				guess = playerOne.getGuess();
				if(guess != trans.getSolution())
				{
					System.err.println(rbb.getString("wrong"));
					playerOne.looseLifes();						
				} 
				else
				{
					System.out.println(rbb.getString("right"));
				}
			}
			else
			{
				guess = playerTwo.getGuess();
				if(guess != trans.getSolution())
				{
					System.err.println(rbb.getString("wrong"));
					playerTwo.looseLifes();						
				} 
				else
				{
					System.out.println(rbb.getString("right"));
				}
			}
			
			round++;
		
			if(playerOne.getLifes() > 0)
			{
				System.out.println(rbb.getString("winP1"));
			}
			else if(playerTwo.getLifes() > 0)
			{
				System.out.println(rbb.getString("winP2"));
			}
			
		}//WHILE
		}
		else
		{
			while(playerOne.getLifes() > 0 && bot.getLifes() > 0)
			{
				
				int guess;
				System.out.println(rbb.getString("round") + " " + round);
				calcPosition();
				trans = mathe.getAufgabe();
				
				if(trans.getOperator() == '+')System.out.println(rbb.getString("question") + " " + trans.getAufgabe1() + Character.toString(trans.getOperator()) + trans.getAufgabe2() + " ?");
				if(trans.getOperator() == '-')System.out.println(rbb.getString("question") + " " + trans.getAufgabe1() + Character.toString(trans.getOperator()) + trans.getAufgabe2() + " ?");
				if(trans.getOperator() == '*')System.out.println(rbb.getString("question") + " " + trans.getAufgabe1() + Character.toString(trans.getOperator()) + trans.getAufgabe2() + " ?");
				if(trans.getOperator() == '/')System.out.println(rbb.getString("question") + " " + trans.getAufgabe1() + Character.toString(trans.getOperator()) + trans.getAufgabe2() + " ?");
								
				
				if(round % 2 != 0)
				{
					guess = playerOne.getGuess();
					if(guess != trans.getSolution())
					{
						System.err.println(rbb.getString("wrong"));
						playerOne.looseLifes();						
					} 
					else
					{
						System.out.println(rbb.getString("right"));
					}
				}
				else
				{
					guess = bot.getGuess(trans.getSolution());
					if(guess != trans.getSolution())
					{
						System.err.println(rbb.getString("wrong"));
						bot.looseLifes();						
					} 
					else
					{
						System.out.println(rbb.getString("right"));
					}
				}
				
				round++;
			
				if(playerOne.getLifes() > 0)
				{
					System.out.println(rbb.getString("winP1"));
				}
				else if(bot.getLifes() > 0)
				{
					System.out.println(rbb.getString("winBot"));
				}
				
			}//WHILE
		}
	}
	
	private static void calcPosition()
	{
		int position;
		
		if(playerOrBot.equalsIgnoreCase("player"))
		{
		if(round % 2 != 0)
		{
		System.out.println(playerOne.getName() + " " + rbb.getString("yourTurn"));
		System.out.println(playerOne.getLifes() + " " + rbb.getString("lifesOver"));
		
		position = playerOne.getLifes() - playerTwo.getLifes();
		
		if(position == 0)
		{
			System.out.println(rbb.getString("draw"));
		}
		else if(position > 0)
		{
			System.out.println(position + " " + rbb.getString("lifesAhead"));
		}
		else
		{
			position *= -1;
			System.out.println(rbb.getString("enemyHad") + " " + position + " " + rbb.getString("enemyHad2"));
		}
		}
		else
		{
			System.out.println(playerTwo.getName() + " " + rbb.getString("yourTurn"));
			System.out.println(playerTwo.getLifes() + " " + rbb.getString("lifesOver"));
			
			position = playerTwo.getLifes() - playerOne.getLifes();
			if(position == 0)
			{
				System.out.println(rbb.getString("draw"));
			}
			else if(position > 0)
			{
				System.out.println(position + " " + rbb.getString("lifesAhead"));
			}
			else
			{
				position *= -1;
				System.out.println(rbb.getString("enemyHad") + " " + position + " " + rbb.getString("enemyHad2"));
			}
		}
		}
		else
		{
			if(round % 2 != 0)
			{
			System.out.println(playerOne.getName() + " " + rbb.getString("yourTurn"));
			System.out.println(playerOne.getLifes() + " " + rbb.getString("lifesOver"));
			
			position = playerOne.getLifes() - playerTwo.getLifes();
			
			if(position == 0)
			{
				System.out.println(rbb.getString("draw"));
			}
			else if(position > 0)
			{
				System.out.println(position + " " + rbb.getString("lifesAhead"));
			}
			else
			{
				position *= -1;
				System.out.println(rbb.getString("enemyHad") + " " + position + " " + rbb.getString("enemyHad2"));
			}
			}
			else
			{
				System.out.println(bot.getName() + " " + rbb.getString("yourTurn"));
				System.out.println(bot.getLifes() + " " + rbb.getString("lifesOver"));
				
				position = bot.getLifes() - playerOne.getLifes();
				if(position == 0)
				{
					System.out.println(rbb.getString("draw"));
				}
				else if(position > 0)
				{
					System.out.println(position + " " + rbb.getString("lifesAhead"));
				}
				else
				{
					position *= -1;
					System.out.println(rbb.getString("enemyHad") + " " + position + " " + rbb.getString("enemyHad2"));
				}
			}
		}
	}

}
