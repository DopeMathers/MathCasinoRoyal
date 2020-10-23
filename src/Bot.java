import java.util.Random;

public class Bot extends Player
{

	private String[] name = {"Botplayer","Botmen","Botchick","Boterino"};
	Random ran = new Random();
	
	public Bot()
	{
		setName("StringNotInUse");
	}
	
	//Getter und Setter Methods
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
		int random = 0;
		random = ran.nextInt(4)-1;
		super.name = this.name[random];
	}

	@Override
	public void setGuess() 
	{
		System.out.println("Please use 'setGuess(int solution)' for bot!");
	}
	
	public void setGuess(int solution)
	{
		int cach;
		cach = ran.nextInt(100)-1;
		
		if(cach%2 == 0)
		{
			super.guess = solution;
		}
		else
		{
			super.guess = solution - ran.nextInt(155); //Random abziehen damit ergebnis falsch ergibt
		}
		
	}
	
}
