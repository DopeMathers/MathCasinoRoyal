import java.util.InputMismatchException;
import java.util.Scanner;

public class Players extends Player
{
	
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
			System.err.println("NaN, try again! Only Numbers!");
			check = false;
		}
		
		}
		
	}

	
	
}
