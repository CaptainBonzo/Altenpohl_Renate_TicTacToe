import org.junit.*; 
import static org.junit.Assert.*;
import java.util.*;


public class Board {
	private String[][] game; 
	private String theWinner;
	private String winType;
	public String next;
	
	Board(){
		game = new String[3][3];
		theWinner = null;
		winType =null;
		next = "O";
	}
	
	public void setMark(String mark, int x, int y) throws InvalidPositionException {
		
		if(game[x][y] == null){
			
				if(mark.equalsIgnoreCase("x")){
					next = "O";
					game[x][y] = mark;
				}else{
					next = "X";
					game[x][y] = mark;
				}
				
			
		}
		else{
			throw new InvalidPositionException("An dieser Position ist bereits ein Stein!");
		}
	}
	public int getMarkValue(int x, int y){
		int result = 0;
		if(getMarkLetter(x,y) != null){
			if(game[x][y].equalsIgnoreCase("x")){
				result = 1;
			}
			else if(game[x][y].equalsIgnoreCase("o")){
				result = 2;
			}
		}
		return result;	
	}
	public String getMarkLetter(int x, int y){
		return game[x][y];
	}
	
	public boolean hasWinner(){
		boolean winner = false;
		if(winDiagonals() || ( winRows() || winColumns() ) ){
			winner = true;
		}
		
		return winner;
	}
	public boolean winRows(){
		boolean win = false;
			for(int y=0;y<=2;y++){
				if((getMarkValue(0,y) ==1 || getMarkValue(0,y) ==2 ) && (getMarkValue(0,y)==getMarkValue(1,y) && getMarkValue(2,y)==getMarkValue(1,y) )){
					winType = y +". row";
					theWinner = getMarkLetter(1,y);
					win = true;
				}
			}
			
		return win;
	}
	public boolean winColumns(){
		boolean win = false;
		for(int x=0;x<=2;x++){
			if((getMarkValue(x,0) ==1 || getMarkValue(x,0) ==2 ) && (getMarkValue(x,0)==getMarkValue(x,1) && getMarkValue(x,2)==getMarkValue(x,0) )){
				winType = x+1 + ". column";
				theWinner = getMarkLetter(x,0);
				win = true;
			}
		}
		
		return win;
	}
	public boolean winDiagonals(){
		boolean win = false;
		if( getMarkValue(1,1) ==1 || getMarkValue(1,1) ==2 ){
			if(( getMarkValue(0,0)==getMarkValue(1,1) && getMarkValue(2,2)== getMarkValue(1,1))){
				winType = "left diagonal";
				theWinner = getMarkLetter(1,1);
				win = true;
			}
			else if(getMarkValue(0,2)==(getMarkValue(1,1)) && getMarkValue(2,0)==(getMarkValue(1,1))){
				winType = "right diagonal";
				theWinner = getMarkLetter(1,1);
				win = true;
			}
		}
		return win;
	}
	

	public void print(){
		System.out.println("  x  0---1---2 ");
		System.out.println("y  ------------");
		for(int y=0;y<=2;y++){
			System.out.print(y +" | ");
			for(int x=0;x<=2;x++){
				
				if(getMarkLetter(x,y) != null){
					System.out.print(getMarkLetter(x,y) +" | ");
				}
				else{
					System.out.print("  | ");
				}
			}
			System.out.println("\n   ------------ ");
		}
		if(this.hasWinner()){
			System.out.println( "Winning line: "+ this.winType);
			System.out.println("Winner: "+ this.theWinner +" !");
		}
		
	}
}
