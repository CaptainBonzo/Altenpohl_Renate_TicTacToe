import org.junit.*; 
import static org.junit.Assert.*; 

public class BoardTest {
	Board board = new Board();
	
	
	@Test
	public void emptyBoard(){
		board.print();
		assertFalse(board.hasWinner());
	}
	
	@Test
	public void validNoWinner(){
		
		
		try {
			board.setMark("x",0,0);
			board.setMark("o",1,0);
			board.setMark("x",2,0);
			board.setMark("o",0,1);
			board.setMark("x",1,1);
			board.setMark("o",2,1);
			board.setMark("o",0,2);
			board.setMark("x",1,2);
			board.setMark("o",2,2);
			
			
			assertFalse( board.hasWinner() );
			
			board.print();
		} catch (InvalidPositionException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void validFoundWinner(){
		try {
			board.setMark("x",0,0);
			board.setMark("o",1,0);
			board.setMark("x",1,1);
			board.setMark("o",2,2);
			board.setMark("x",0,2);
			
			board.setMark("o",0,1);
			board.setMark("x",2,0);
			
			assertTrue( board.hasWinner() );
		} catch (InvalidPositionException e) {
			
			e.printStackTrace();
		}
		board.print();
	}
	
	@Test
	public void invalidMark(){
		try{
			board.setMark("y",0,0);
			
		} catch(InvalidPositionException e){
			e.printStackTrace();
		}
		
	}
}
