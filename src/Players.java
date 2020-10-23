import java.util.InputMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Players extends Player
{
	Locale locale = new Locale(Game.lang,Game.region);
	ResourceBundle lang = ResourceBundle.getBundle("LanguageBundle", locale);
	
	@Override
	public int getLifes() 
	{
		return super.lifes;
	}

	@Override
	public String getName() 
	{
		
		return super.name;
	}

	@Override
	public int getGuess()
	{
		setGuess();
		return super.guess;
	}

	@Override
	public void looseLifes()
	{
		super.lifes = super.lifes -1;
	}

	@Override
	public void setName(String name) 
	{
		super.name = name;
	}

	@SuppressWarnings("resource")
	@Override
	public void setGuess() 
	{
		boolean check = false;
		
		while(check == false)
		{
		
		try
		{
		super.guess = new Scanner(System.in).nextInt();
		check = true;
		}
		catch(InputMismatchException e)
		{
			System.err.println(lang.getString("error1"));
			check = false;
		}
		
		}
		
	}

	
	
}
