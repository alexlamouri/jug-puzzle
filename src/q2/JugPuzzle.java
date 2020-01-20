package q2;

import puzzle.Puzzle;
import puzzle.States;
import q2.Jug;
import q2.Moves;
/**
 * 
 * @author csc207student 
 *
 */
public class JugPuzzle extends Puzzle {
	
	private Jug j0;
	private Jug j1;
	private Jug j2;
	private static Moves[] allPossibleMoves = new Moves[] {new Moves(0,1), new Moves(0,2), 
															new Moves(1,0), new Moves(1,2), 
															new Moves(2,0), new Moves(2,1)};
	
	/**
	 * Construct a new JugPuzzle object with three jugs j0, j1, j2 with respective capacities of 8, 5 and 3 respectively. <br>
	 * Initially, j0 is full and j1 and j2 are empty. <br> <br>      
	 * IS-A puzzle <br>                 											
	 * HAS-A content, capacity <br>
	 * RESPONDS-TO JugSelect, move, isPuzzleSolved, toString, makeTemp, nextStates <br>
	 * @param capacity	Maximum liquid capacity of Jug
	 * @param content	Current liquid content of Jug
	 **/
	public JugPuzzle() {
		this.j0 = new Jug(8, 8);
		this.j0.fill(8);
		this.j1 = new Jug(5, 0);
		this.j2 = new Jug(3, 0);
	}
	
	/**
	 * Construct a new JugPuzzle with given Jug objects <br> <br>
	 * Jug HAS-A Jug object j0, Jug object j1, Jug object j2
	 * Jug RESPONDS-TO isEmpty, isFull, getContent, getCapacity, fill, empty, toString
	 * @param j0	Jug Object
	 * @param j1	Jug Object
	 * @param j2	Jug Object
	 **/
	public JugPuzzle(Jug j0, Jug j1, Jug j2) {
		this.j0 = j0;
		this.j1 = j1;
		this.j2 = j2;
	}
	
	/**
	 * Select Jug according to the Jug Number
	 * @param 	JugNumber	Number of selected Jug
	 * @return	Selected Jug Object
	 **/
	public Jug JugSelect(int JugNumber) {
		Jug JugSelected = null;
		if (JugNumber==0) {
			JugSelected = this.j0;
		}
		if (JugNumber==1) {
			JugSelected = this.j1;
		}
		if (JugNumber==2) {
			JugSelected = this.j2;
		}
		return JugSelected;
	}

	/**
	 * Transfer liquid between two jugs
	 * @param 	from 	Number of origin jug
	 * @param 	to 		Number of destination jug
	 **/
	public void move(int from, int to){
		Jug fromJug = JugSelect(from);
		Jug toJug = JugSelect(to);
		
		if (fromJug!=toJug) {
			while ((!(fromJug.isEmpty()))&&(!(toJug.isFull()))) {
				fromJug.empty(1);
				toJug.fill(1);
			}
		}
	}
	
	/**
	 * Return whether JugPuzzle is solved or not
	 * @return 	boolean
	 **/
	public boolean isPuzzleSolved() {
		if ((this.j0.getContent() == 4) && (this.j1.getContent() == 4)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Return a string representation of JugPuzzle
	 * @return 	String representation of JugPuzzle
	 **/
	public String toString(){
	     String s = "0:" + this.j0.toString() + " " + 
	    		 	"1:" + this.j1.toString() + " " +
	    		 	"2:" + this.j2.toString(); 
	     return s;
	}
	
	/**
	 * Return a deep copy of a JugPuzzle object
	 * @return 	deep copy of a JugPuzzle object
	 **/
	public JugPuzzle makeTemp() {
		
		JugPuzzle tempPuzzle = new JugPuzzle(new Jug(8, this.j0.getContent()), 
											new Jug(5, this.j1.getContent()), 
											new Jug(3, this.j2.getContent()));
		return tempPuzzle;
		
	}
	
	/**
	 * Generate the next states of JugPuzzle by applying all possible moves to the current state of JugPuzzle
	 * @return 	void
	 **/
	public void nextStates(States states) {
		for (Moves m : allPossibleMoves) {
			JugPuzzle tempPuzzle = this.makeTemp();
			tempPuzzle.move(m.getFrom(), m.getTo());
			states.add(tempPuzzle, m);
		}
	}
			
}
