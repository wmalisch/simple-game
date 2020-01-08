/**
 * Pixel is a class for pixels of jpg images. It is used to identify the pixel
 * colour and location
 * 
 * @author Will Malisch, 250846447
 *
 */
public class Pixel {
	/* Attribute Declarations */
	private Location p;
	private int colour;

	/**
	 * Constructor creates a Pixel object with its location and colour
	 * 
	 * @param p
	 *            is the location of the pixel
	 * @param colour
	 *            is the colour of the pixel
	 */
	public Pixel(Location p, int colour) {
		this.p = p;
		this.colour = colour;
	}

	/**
	 * getLocation Method returns the location of the pixel
	 * 
	 * @return the location
	 */
	public Location getLocation() {
		return p;
	}

	/**
	 * getColor Method returns the colour of the pixel
	 * 
	 * @return the colour
	 */
	public int getColor() {
		return colour;
	}

}
