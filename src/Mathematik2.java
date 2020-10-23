import java.util.ArrayList;
import java.util.Random;

public class Mathematik2
{

	private boolean debug = true;
	private int teilaufgabe1;
	private int teilaufgabe2;
	private char rechenzeichen;
	private int solution;
	
	Random ran = new Random();
	DataTransfer trans; 
	
	ArrayList<Integer> multiplication = new ArrayList<Integer>();
	ArrayList<Integer> division = new ArrayList<Integer>();
	ArrayList<Integer> division2 = new ArrayList<Integer>();
	ArrayList<Integer> plus = new ArrayList<Integer>();
	ArrayList<Integer> minus = new ArrayList<Integer>();
	ArrayList<Character> operator = new ArrayList<Character>();
	
	
	public Mathematik2()
	{
		
	multiplication.add(1); // 0
	multiplication.add(2); // 1
	multiplication.add(3); // 2
	multiplication.add(4); // 3
	multiplication.add(5); // 4
	multiplication.add(6); // 5
	multiplication.add(7); // 6
	multiplication.add(8); // 7
	multiplication.add(9); // 8
	multiplication.add(10); //9
	
	division.add(250);
	division2.add(25);
		
	division.add(68);
	division2.add(4);
	
	division.add(820);
	division2.add(205);
	
	division.add(666);
	division2.add(6);
	
	division.add(63);
	division2.add(7);
	
	division.add(76);
	division2.add(4);
	
	division.add(39);
	division2.add(3);
	
	division.add(95);
	division2.add(5);
	
	division.add(72);
	division2.add(4);
	
	division.add(144);
	division2.add(8);
	
	plus.add(ran.nextInt(10000)+1);
	plus.add(ran.nextInt(10000)+1);
	plus.add(ran.nextInt(10000)+1);
	plus.add(ran.nextInt(10000)+1);
	plus.add(ran.nextInt(10000)+1);
	plus.add(ran.nextInt(10000)+1);
	plus.add(ran.nextInt(10000)+1);
	plus.add(ran.nextInt(10000)+1);
	plus.add(ran.nextInt(10000)+1);
	plus.add(ran.nextInt(10000)+1);
	
	minus.add(ran.nextInt(10000)+1);
	minus.add(ran.nextInt(10000)+1);
	minus.add(ran.nextInt(10000)+1);
	minus.add(ran.nextInt(10000)+1);
	minus.add(ran.nextInt(10000)+1);
	minus.add(ran.nextInt(10000)+1);
	minus.add(ran.nextInt(10000)+1);
	minus.add(ran.nextInt(10000)+1);
	minus.add(ran.nextInt(10000)+1);
	minus.add(ran.nextInt(10000)+1);
	minus.add(ran.nextInt(10000)+1);
	
	operator.add('+');
	operator.add('-');
	operator.add('*');
	operator.add('/');
	
	}
	
	public void addNumbers()
	{
		for(int i = 0; i < 11; i++)
		{
			plus.add(ran.nextInt(10000)+1);
			minus.add(ran.nextInt(10000)+1);
		}
	}
	
	public DataTransfer getAufgabe()
	{
		setAufgabe();
		setSolution();
		trans = new DataTransfer(teilaufgabe1, teilaufgabe2, rechenzeichen, solution);
		
		return trans; 
	}
	
	
	private void setAufgabe()
	{
		
		int op;
		int x;
		int y;
		
		op = ran.nextInt(4);
		
		if(op == 0)
		{
			//	+
			x = ran.nextInt(plus.size() - 1);
			y = ran.nextInt(plus.size() - 1);
			teilaufgabe1 = plus.get(x);
			teilaufgabe2 = plus.get(y);
			rechenzeichen = operator.get(0);
		}
		if(op == 1)
		{
			//	-
			x = ran.nextInt(minus.size() - 1);
			y = ran.nextInt(minus.size() - 1);
			teilaufgabe1 = minus.get(x);
			teilaufgabe2 = minus.get(y);
			rechenzeichen = operator.get(1);
		}
		if(op == 2)
		{
			//	*
			x = ran.nextInt(multiplication.size() - 1);
			y = ran.nextInt(multiplication.size() - 1);
			teilaufgabe1 = multiplication.get(x);
			teilaufgabe2 = multiplication.get(y);
			rechenzeichen = operator.get(2);
			
		}
		if(op == 3)
		{
			//	/
			x = ran.nextInt(division.size() - 1);
			teilaufgabe1 = division.get(x);
			teilaufgabe2 = division2.get(x);
			rechenzeichen = operator.get(3);
		}
	}
	
	private void setSolution()
	{
		switch(rechenzeichen)
		{
		case '+':
			solution = teilaufgabe1 + teilaufgabe2;
			break;
		case '-':
			solution = teilaufgabe1 - teilaufgabe2;
			break;
		case '*':
			solution = teilaufgabe1 * teilaufgabe2;
			break;
		case '/':
			solution = teilaufgabe1 / teilaufgabe2;
			break;
		}
		
		if(debug == true)System.out.println("Ergebnis= " + solution + " Aufgabe war= " + teilaufgabe1 + " " + rechenzeichen + " " + teilaufgabe2);
	}
}
