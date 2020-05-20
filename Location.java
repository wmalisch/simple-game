/**
 * Location class is used to represent a simple x and y coordinate location
 * object. It is used as a support class to the Pixel class
 * 
 * @author Will Malisch
 *
 */
public class Location {

	/* Attribute Declarations */
	private int x;
	private int y;

	/**
	 * Constructor creates a location object with x and y coordinates
	 * 
	 * @param x
	 *            is the x coordinate
	 * @param y
	 *            is the y coordinate
	 */
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * xCoord Method returns the x coordinate
	 * 
	 * @return x coordinate
	 */
	public int xCoord() {
		return this.x;
	}

	/**
	 * yCoord Method returns the y coordinate
	 * 
	 * @return y coordinate
	 */
	public int yCoord() {
		return this.y;
	}

	/**
	 * compareTo Method evaluates this location object against another to check
	 * which is greater, less than, or equal
	 * 
	 * @param p
	 *            is the location you want to compare with
	 * @return -1 if this object is less than p, 0 if equal, 1 if greater
	 */
	public int compareTo(Location p) {
		if (x < p.xCoord() || (x == p.xCoord() && y < p.yCoord())) {
			return -1;
		} else if (x == p.xCoord() && y == p.yCoord()) {
			return 0;
		} else {
			return 1;
		}
	}

}
