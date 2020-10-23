
public class DataTransfer 
{

	private int aufgabe1;
	private int aufgabe2;
	private char operator;
	private int solution;
	
	public DataTransfer(int aufgabe1, int aufgabe2, char operator, int solution)
	{
		
		this.aufgabe1 = aufgabe1;
		this.aufgabe2 = aufgabe2;
		this.operator = operator;
		this.solution = solution;
	}

	public int getAufgabe1() 
	{
		return aufgabe1;
	}

	public int getAufgabe2() 
	{
		return aufgabe2;
	}

	public char getOperator() 
	{
		return operator;
	}

	public int getSolution() 
	{
		return solution;
	}
	
}
