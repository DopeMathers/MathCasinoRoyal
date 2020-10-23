import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

public class Bot extends Player
{

	Locale locale = new Locale(Game.lang,Game.region);
	ResourceBundle lang = ResourceBundle.getBundle("LanguageBundle", locale);
	
	private String[] name = {lang.getString("botname1"),lang.getString("botname2"),lang.getString("botname3"),lang.getString("botname4")};
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
		System.err.println(lang.getString("error2"));
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
