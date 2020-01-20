package q1;
/**
 * 
 * @author csc207student 
 *
 */
public class JugPuzzle {
	
	private Jug j0;
	private Jug j1;
	private Jug j2;
	private int moves;
	
	/**
	 * Construct a new JugPuzzle with three Jugs (j0, j1 and j2) and 0 moves performed
	 * @since j0 has a capacity of 8 and is initially full
	 * @since j1 has a capacity of 5 and is initially empty
	 * @since j2 has a capacity of 3 and is initially empty
	 */
	public JugPuzzle() {
		this.moves = 0;
		this.j0 = new Jug(8);
		this.j0.fill(8);
		this.j1 = new Jug(5);
		this.j2 = new Jug(3);
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
	 * @return	void 
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
		this.moves += 1;
	}
	
	/**
	 * Return total number of moves performed in JugPuzzle
	 * @return 	Total number of moves
	 **/
	public int getMoves(){
	    return this.moves; 
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
	     String s = this.getMoves() + "  " + 
	    		 	"0:" + this.j0.toString() + " " + 
	    		 	"1:" + this.j1.toString() + " " +
	    		 	"2:" + this.j2.toString(); 
	     return s;
	}
	
}
