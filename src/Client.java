import java.util.*;
import java.io.*;
import java.net.*;

public class Client 
{
	static Socket client;
	static final int PORT = 9999;
	
	

	public static void main(String[] args) 
	{
		try
		{
			client = new Socket("localhost", PORT);
			Scanner input = new Scanner(client.getInputStream());
			Scanner input1 = new Scanner(System.in);
			PrintStream ps = new PrintStream(client.getOutputStream());
			
			
			int id = input.nextInt();
			System.out.println("Player " + id + " connected!");
			
			while(true)
			{
				String board[][] = new String[5][5];
			
				
				
				for(int row=0; row<5; row++)
				{
					for(int column=0; column<5; column++)
					{
						board[row][column] = input.next();
					}
				}
				
				for(int row=0; row<5; row++)
				{
					for(int column=0; column<5; column++)
					{
						System.out.print(" | " + board[row][column] + " | ");
					}
					System.out.println("");
					System.out.println("");
				}
				
				
				System.out.println("Select the Row to hit from (A = 0) (B = 1) (C = 2) (D = 3) (E = 4) etc");
				int row = input1.nextInt();
				System.out.println("Select the Column to hit from (0,1,2,3,4) etc");
				int column = input1.nextInt();
				ps.println(row);
				ps.println(column);
				System.out.println("");
				System.out.println("");
				System.out.println("");
				
				
//				int hits = input.nextInt();
//				System.out.println("Player hits: " + hits);
				
				

				
				
				
				
				
				
				
				
			}
			
			
			
			
		}
		
		catch(Exception e)
		{
			System.err.println("Error connecting to server");
		}
		

	}

}
