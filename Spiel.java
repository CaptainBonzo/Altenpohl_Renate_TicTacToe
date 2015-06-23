import java.util.Scanner;


public class Spiel {

	public static void main(String[] args) {
		Board board = new Board();
		Scanner scan =new Scanner(System.in);
		
		
		while(!board.hasWinner() ){
			board.print();
			
			String next = board.next;
			System.out.println(next+", please enter coordinates: x, y  ");
			
			int x = scan.nextInt();
			int y = scan.nextInt();
			
			
			
			
			try {
				board.setMark(next, x, y);
			} catch (InvalidPositionException e) {
				e.printStackTrace();
			}
			
			
		}
		scan.close();
		
	}

}
