import java.net.*;
import java.io.*;
import java.util.*;

public class Server 
{
	static ServerSocket server;
	static Socket client1;
	static Socket client2;
	static final int PORT = 9999;

	public static void main(String[] args) 
	{
		try
		{
			server = new ServerSocket(PORT);
			client1 = server.accept();
			client2 = server.accept();
			
			PrintStream ps1 = new PrintStream(client1.getOutputStream());
			PrintStream ps2 = new PrintStream(client2.getOutputStream());
			Scanner input1 = new Scanner(client1.getInputStream());
			Scanner input2 = new Scanner(client2.getInputStream());
			
			int id1 = 1;
			int id2 = 2;
			int p1hits = 0;
			int p2hits = 0;
			
			ps1.println(id1);
			ps2.println(id2);
			
			
			
			Random rand = new Random();
			int hitBoard[][] = new int[5][5];
			for(int i=0; i<5; i++)
			{
				for(int j=0; j<5; j++)
				{
					hitBoard[i][j] = rand.nextInt(2) + 0;
				}
			}
			
			
			
				
				String board[][] = new String [5][5];
				
				board[0][0] = "A0";
				board[0][1] = "A1";
				board[0][2] = "A2";
				board[0][3] = "A3";
				board[0][4] = "A4";
				
				board[1][0] = "B0";
				board[1][1] = "B1";
				board[1][2] = "B2";
				board[1][3] = "B3";
				board[1][4] = "B4";
				
				board[2][0] = "C0";
				board[2][1] = "C1";
				board[2][2] = "C2";
				board[2][3] = "C3";
				board[2][4] = "C4";
				
				board[3][0] = "D0";
				board[3][1] = "D1";
				board[3][2] = "D2";
				board[3][3] = "D3";
				board[3][4] = "D4";
				
				board[4][0] = "E0";
				board[4][1] = "E1";
				board[4][2] = "E2";
				board[4][3] = "E3";
				board[4][4] = "E4";
			
				
				
				
				for(int row=0; row<5; row++)
				{
					for(int column=0; column<5; column++)
					{
						ps1.println(board[row][column]);
						ps2.println(board[row][column]);
					}
				}
			while(true)
			{
				
				int c1row = input1.nextInt();
				int c1column = input1.nextInt();
				int c2row = input2.nextInt();
				int c2column = input2.nextInt();
				
				if(hitBoard[c1row][c1column] == 1)
				{
					p1hits++;
					board[c1row][c1column] = "X";
					board[c2row][c2column] = "X";
					
					for(int row=0; row<5; row++)
					{
						for(int column=0; column<5; column++)
						{
							ps1.println(board[row][column]);
							ps2.println(board[row][column]);
						}
					}
				}
				
				else if(hitBoard[c2row][c2column] == 1)
				{
					p2hits++;
					board[c1row][c1column] = "X";
					board[c2row][c2column] = "X";
					
					for(int row=0; row<5; row++)
					{
						for(int column=0; column<5; column++)
						{
							ps1.println(board[row][column]);
							ps2.println(board[row][column]);
						}
					}
				}
				
				else
				{
					board[c1row][c1column] = "X";
					board[c2row][c2column] = "X";
					
					for(int row=0; row<5; row++)
					{
						for(int column=0; column<5; column++)
						{
							ps1.println(board[row][column]);
							ps2.println(board[row][column]);
						}
					}
				}
				
				
//				ps1.println(p1hits);
//				ps2.println(p2hits);
				
				
				
			
			}
	
		}
		
		catch(Exception e)
		{
			System.err.println("Server Error");
		}
		

	}

}
