package q2;

import puzzle.Move;
/**
 * 
 * @author csc207student 
 *
 */
public class Moves implements Move {
	
	private int to;
	private int from;
	
	/**
	 * Construct a new Moves object with a "from" and "to" referring to the numbered Jugs       
	 * IS-A Move <br>    											
	 * HAS-A from, to <br>
	 * RESPONDS-TO getFrom, getTo, toString <br>
	 * @param from 		number of Jug where move is executed from
	 * @param content	number of Jug where move is executed to
	 **/
	public Moves(int from, int to) {
		this.from = from;
		this.to = to;
	}
	
	/**
	 * Return the number of Jug where the move is executed from
	 * @return 	"from" Jug number
	 **/
	public int getFrom() {
		return this.from;
	}
	
	/**
	 * Return the number of Jug where the move is executed to
	 * @return 	"to" Jug number
	 **/
	public int getTo() {
		return this.to;
	}
	
	/**
	 * Return a string representation of a move
	 * @return 	String representation of a move
	 **/
	public String toString() {
		String s = "Move from:" + this.from + " to:" + this.to;
		return s;
	}

}
