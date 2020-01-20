package q2;
/**
 * 
 * @author csc207student 
 *
 */
public class Jug {
	
	private int content;
	private int capacity;
	
	/**
	 * Construct a new Jug object with a given liquid quantity and maximum liquid capacity <br> <br>
	 * Jug HAS-A content, capacity <br>
	 * Jug RESPONDS-TO isEmpty, isFull, getContent, getCapacity, fill, empty, toString <br>
	 * @param capacity	Maximum liquid capacity of Jug
	 * @param content	Current liquid content of Jug
	 **/
	public Jug(int capacity, int content) {
		this.capacity = capacity;
		this.content = content;
	}
	
	/**
	 * Return whether Jug is empty of liquid or not
	 * @return	boolean 
	 **/
	public boolean isEmpty() {
		return this.getContent() == 0;
	}
	
	/**
	 * Return whether Jug is full of liquid or not
	 * @return	boolean 
	 **/
	public boolean isFull() {
		return this.getContent() == this.getCapacity();
	}
	
	/**
	 * Returns the current liquid content of Jug
	 * @return	Current liquid content of jug
	 **/
	public int getContent() {
		return this.content;
	}
	
	/**
	 * Returns the maximum liquid content of Jug
	 * @return	Maximum liquid content of jug
	 **/
	public int getCapacity() {
		return this.capacity;
	}
	
	/**
	 * Fills Jug of liquid
	 * @param 	liquid	amount of liquid filled
	 * @return	void
	 **/
	public void fill(int liquid) {
		if (this.getContent() + liquid <= this.getCapacity()) {
			this.content += liquid;
		}
	}
	
	/**
	 * Empties Jug of liquid
	 * @param 	liquid	amount of liquid emptied
	 * @return	void
	 **/
	public void empty(int liquid) {
		if (this.getContent() - liquid >= 0) {
			this.content -= liquid;
		}
	}
	
	/**
	 * Returns a String representation of Jug
	 * @return	String representation of Jug
	 **/
	public String toString() {
		String s = "(" + this.getContent() + "/" + this.getCapacity() + ")";
		return s;
	}
}