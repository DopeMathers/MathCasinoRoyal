public abstract class Player 
{

	public int lifes = 5;
	public String name = "Player";
	public int guess; 
	
	public abstract int getLifes();
	public abstract String getName();
	public abstract int getGuess();
	
	public abstract void looseLifes();
	public abstract void setName(String name);
	public abstract void setGuess();
}
