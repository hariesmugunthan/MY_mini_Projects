package games;

import java.util.Random;
import java.util.Scanner;

class TicTacToe {
	static Scanner o=new Scanner(System.in);
	static char  usersymbol,computersymbol;

	public static void main(String[] args) {
		char[][] board= {{' ',' ',' '},
						 {' ',' ',' '},
						 {' ',' ',' '},};
		printBoard(board);
		CharSelection();
//		PlayerTurn(board,usersymbol);
//		printBoard(board);
//		ComputerTurn(board,computersymbol);
//		printBoard(board);
		while(true) {
			if(validmove(board)) {
				 PlayerTurn(board,usersymbol);
				int win= whosthewinner(board,usersymbol,computersymbol);
				if(win==0) {
					System.out.println("you have won!");
					break;
				}
			}
			if(validmove(board)) {
				ComputerTurn(board,computersymbol);
				int win= whosthewinner(board,usersymbol,computersymbol);
				if(win==1) {
					System.out.println("you lost");
					break;
				}
			}
			
			
		}

	}
	private static void ComputerTurn(char[][] board,char computersymbol) {
		Random r=new Random();
		int place=r.nextInt(9)+1;
		switch (place){
		case 1:
			if(board[0][0]==' ') {
			board[0][0]= computersymbol;
			}else {
				ComputerTurn(board,computersymbol);
			}
			break;
		case 2:
			if(board[0][1]==' ') {
				board[0][1]= computersymbol;
				}else {
					ComputerTurn(board,computersymbol);
				}
			break;
		case 3:
			if(board[0][2]==' ') {
				board[0][2]= computersymbol;
				}else {
					ComputerTurn(board,computersymbol);
				}
			break;
		case 4:
			if(board[1][0]==' ') {
				board[1][0]= computersymbol;
				}else {
					ComputerTurn(board,computersymbol);
				}
			break;
		case 5:
			if(board[1][1]==' ') {
				board[1][1]= computersymbol;
				}else {
					ComputerTurn(board,computersymbol);
				}
			break;
		case 6:
			if(board[1][2]==' ') {
				board[1][2]= computersymbol;
				}else {
					ComputerTurn(board,computersymbol);
				}
			break;
		case 7:
			if(board[2][0]==' ') {
				board[2][0]= computersymbol;
				}else {
					ComputerTurn(board,computersymbol);
				}
			break;
		case 8:
			if(board[2][1]==' ') {
				board[2][1]= computersymbol;
				}else {
					ComputerTurn(board,computersymbol);
				}
			break;
		case 9:
			if(board[2][2]==' ') {
				board[0][0]= computersymbol;
				}else {
					ComputerTurn(board,computersymbol);
				}
			break;
		}
		printBoard(board);
		
	}
	private static void CharSelection() {
		System.out.println("you want to play as X(press 0)||O(press 1): ");
		 int choice=o.nextInt();
		
		if(choice==0) {
			usersymbol='X';
			computersymbol='O';
			
		}
	}
	private static void PlayerTurn(char[][] board,char usersymbol) {
		System.out.println("enter the place(1-9):");
		int place=o.nextInt();
		switch (place){
		case 1:
			board[0][0]= usersymbol;
			break;
		case 2:
			board[0][1]= usersymbol;
			break;
		case 3:
			board[0][2]= usersymbol;
			break;
		case 4:
			board[1][0]= usersymbol;
			break;
		case 5:
			board[1][1]= usersymbol;
			break;
		case 6:
			board[1][2]= usersymbol;
			break;
		case 7:
			board[2][0]= usersymbol;
			break;
		case 8:
			board[2][1]= usersymbol;
			break;
		case 9:
			board[2][2]= usersymbol;
			break;
		default:
			System.out.println("invalid place selection re enter the place");
			PlayerTurn(board,usersymbol);
		}
		printBoard(board);
	}
	private static void printBoard(char[][] board) {
		System.out.println(board[0][0] + "|" +  board[0][1] + "|" +  board[0][2] );
		System.out.println("-+-+-");
		System.out.println(board[1][0] + "|" +  board[1][1] + "|" +  board[1][2] );
		System.out.println("-+-+-");
		System.out.println(board[2][0] + "|" +  board[2][1] + "|" +  board[2][2] );
	}
	private static boolean validmove(char[][] board) {
		int flag=0;
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				if(board[i][j]==' ')
					flag++;
			}
		}
		if(flag>0) {
			return true;
		}
		else
			return false;
	}
	private static int whosthewinner(char[][] board,char usersymbol,char computersymbol) {
		if ((board[0][0] == usersymbol && board [0][1] == usersymbol && board [0][2] == usersymbol) ||
				(board[1][0] == usersymbol && board [1][1] == usersymbol && board [1][2] == usersymbol) ||
				(board[2][0] == usersymbol && board [2][1] == usersymbol && board [2][2] == usersymbol) ||
				
				(board[0][0] == usersymbol && board [1][0] == usersymbol && board [2][0] == usersymbol) ||
				(board[0][1] == usersymbol && board [1][1] == usersymbol && board [2][1] == usersymbol) ||
				(board[0][2] == usersymbol && board [1][2] == usersymbol && board [2][2] == usersymbol) ||
				
				(board[0][0] == usersymbol && board [1][1] == usersymbol && board [2][2] == usersymbol) ||
				(board[0][2] == usersymbol && board [1][1] == usersymbol && board [2][0] == usersymbol) ){
			return 0;
		}
		if ((board[0][0] == computersymbol && board [0][1] ==computersymbol && board [0][2] == computersymbol) ||
				(board[1][0] == computersymbol && board [1][1] == computersymbol && board [1][2] == computersymbol) ||
				(board[2][0] == computersymbol && board [2][1] == computersymbol && board [2][2] == computersymbol) ||
				
				(board[0][0] == computersymbol && board [1][0] == computersymbol && board [2][0] == computersymbol) ||
				(board[0][1] ==computersymbol && board [1][1] == computersymbol && board [2][1] == computersymbol) ||
				(board[0][2] == computersymbol && board [1][2] ==computersymbol && board [2][2] == computersymbol) ||
				
				(board[0][0] == computersymbol && board [1][1] == computersymbol && board [2][2] == computersymbol) ||
				(board[0][2] == computersymbol && board [1][1] == computersymbol && board [2][0] == computersymbol) ){
			return 1;
		}
		return -1;
		
	}

}

