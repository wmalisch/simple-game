/**
 * GraphicalFigure is a class that represents a figure for a game board. It
 * stores basic details of an image such as width, height, top left corner pixel
 * position and more. GraphicalFigures class implements the GraphicalFigureADT.
 * 
 * @author Will Malisch
 *
 */
//public class GraphicalFigure implements GraphicalFigureADT {
//	/* Attribute Declarations */
//	private int id;
//	private int width;
//	private int height;
//	private String type;
//	private Location pos;
//	private BinarySearchTree r;
//
//	/**
//	 * Constructor creates a GraphicalFigure object with all its basic information,
//	 * and initializes a Binary Search Tree to store the pixel contents
//	 * 
//	 * @param id
//	 *            name of the graphical figure
//	 * @param width
//	 *            is the width in pixels
//	 * @param height
//	 *            is the height in pixels
//	 * @param type
//	 *            can be either fixed, user, target or computer and designates it
//	 *            movement patterns
//	 * @param pos
//	 *            is the Location of its top left corner on the board
//	 */
//	public GraphicalFigure(int id, int width, int height, String type, Location pos) {
//		this.id = id;
//		this.width = width;
//		this.height = height;
//		this.type = type;
//		this.pos = pos;
//		this.r = new BinarySearchTree();
//	}
//
//	/**
//	 * getWidth is an accessor method that returns the width of the figure
//	 * 
//	 * @return width
//	 */
//	public int getWidth() {
//		return width;
//	}
//
//	/**
//	 * getHeight is an accessor method that returns the height of the figure
//	 * 
//	 * @return height
//	 */
//	public int getHeight() {
//		return height;
//	}
//
//	/**
//	 * getType is an accessor method that returns the type of the figure
//	 * 
//	 * @return type
//	 */
//	public String getType() {
//		return type;
//	}
//
//	/**
//	 * getId is an accessor method that returns the id of the figure
//	 * 
//	 * @return id
//	 */
//	public int getId() {
//		return id;
//	}
//
//	/**
//	 * getOffset is an accessor method that returns the offset of the figure
//	 * 
//	 * @return offset
//	 */
//	public Location getOffset() {
//		return pos;
//	}
//
//	/**
//	 * setOffset is an setter method that returns offset of the figure
//	 */
//	public void setOffset(Location value) {
//		pos = value;
//	}
//
//	/**
//	 * setType is an setter method that returns type of the figure
//	 */
//	public void setType(String t) {
//		type = t;
//	}
//
//	/**
//	 * addPixel adds a pixel object to the Binary Search Tree of this object
//	 * 
//	 * @throws DuplicatedKeyException
//	 *             if the pixel being added is already in the tree
//	 * 
//	 * @param pix
//	 *            is the pixel being added
//	 */
//	public void addPixel(Pixel pix) throws DuplicatedKeyException {
//		try {
//			r.put(r.getRoot(), pix);
//		} catch (DuplicatedKeyException e) {
//			System.out.println("Duplicated value");
//		}
//	}
//
//	/**
//	 * intersects tests whether two figures have overlapping pixels. It tests if the
//	 * corners of both figures have gone into the boundaries of other objects
//	 * 
//	 * @param gobj
//	 *            is the object you are testing to see if there is an intersection
//	 *            with
//	 * 
//	 * @return true if there is an intersection
//	 */
//	public boolean intersects(GraphicalFigure gobj) {
//		int x = this.getOffset().xCoord();
//		int y = this.getOffset().yCoord();
//		Location tL = new Location(x, y);
//		Location tR = new Location(x + width - 1, y);
//		Location bL = new Location(x, y + height - 1); 
//		Location bR = new Location(x + width - 1, y + height - 1);
//
//		int w = gobj.getOffset().xCoord();
//		int z = gobj.getOffset().yCoord();
//		int widthGobj = gobj.getWidth();
//		int heightGobj = gobj.getHeight();
//		Location tL1 = new Location(w, z);
//		Location tR1 = new Location(w + widthGobj - 1, z);
//		Location bL1 = new Location(w, z + heightGobj - 1);
//		Location bR1 = new Location(w + widthGobj - 1, z + heightGobj - 1);
//		
//		boolean testGobj = (!gobj.findPixel(tL) && !gobj.findPixel(tR) && !gobj.findPixel(bL) && !gobj.findPixel(bR));
//		boolean testThis = (!this.findPixel(tL1) && !this.findPixel(tR1) && !this.findPixel(bL1)
//				&& !this.findPixel(bR1));
//		if (testGobj && testThis) {
//			return false;
//		} else {
//			return true;
//		}
//	}
//
//	/**
//	 * findPixel is a private helper method for intersects. It checks if a figure
//	 * contains a specific pixel.
//	 * 
//	 * @param p
//	 *            is the location of the pixel you are testing for
//	 * @return true if a pixel in the figure has the same location data as p
//	 */
//	private boolean findPixel(Location p) {
//		int x = pos.xCoord();
//		int wX = x + width;
//		int y = pos.yCoord();
//		int hY = y + height;
//		int pX = p.xCoord();
//		int pY = p.yCoord();
//		return (x <= pX && pX < wX && y <= pY && pY < hY);
//	}
//
//}
public class GraphicalFigure implements GraphicalFigureADT 
{
	private int id, width, height;
	private String type;
	private Location pos;
	private BinarySearchTree tree;
	
	public GraphicalFigure(int id, int width, int height, String type, Location pos)
	{
		this.id = id;
		this.width = width;
		this.height = height;
		this.type = type;
		this.pos = pos;
		tree = new BinarySearchTree();
	}
	
	public int getWidth()
	{
		return(width);
	}
	
	public int getHeight()
	{
		return(height);
	}
	
	public String getType()
	{
		return(type);
	}
	
	public int getId()
	{
		return(id);
	}
	
	public Location getOffset()
	{
		return(pos);
	}
	
	public void setOffset(Location value) 
	{
//		Changes the offset of this figure to the specified value	
		this.pos = value;
	}
	
	public void setType(String t) 
	{
		this.type = t;
	}
	
	public void addPixel(Pixel pix) throws DuplicatedKeyException
	{
//		Inserts pix into the binary search tree associated with this figure. 
//		Throws a DuplicatedKeyException if an error occurs when inserting the Pixel into the tree.
		
			// Insert entry into tree:
			tree.put(tree.getRoot(), pix); //put method throws exception, exception will be thrown from put

	}
	
	public boolean intersects(GraphicalFigure gobj)
	{
//		Returns true if this figure intersects the one specified in the parameter. It returns false otherwise.
//		return();
		
//		int xCoord = getOffset().xCoord();
//		int yCoord = getOffset().yCoord();
//		int x_Coord = gobj.getOffset().xCoord();
//		int y_Coord = gobj.getOffset().xCoord();
//		
//		Pixel smallest = null;
//		
//		try 
//		{
//			smallest
//		}
		
		int x = this.getOffset().xCoord();
		int y = this.getOffset().yCoord();
		
		Location l1 = new Location(x, y);
		Location l2 = new Location(x+width-1, y);
		Location l3 = new Location(x, y+height-1);
		Location l4 = new Location(x+width-1, y+height-1);
		
		int ox = gobj.getOffset().xCoord();
		int oy = gobj.getOffset().yCoord();
		int wd = gobj.getWidth();
		int hehe = gobj.getHeight();
		
		Location ol1 = new Location(ox, oy);
		Location ol2 = new Location(ox+wd-1, oy);
		Location ol3 = new Location(ox, oy+hehe-1);
		Location ol4 = new Location(ox+wd-1, oy+hehe-1);
		if(!gobj.findPixel(l1) && !gobj.findPixel(l2) && !gobj.findPixel(l3) && !gobj.findPixel(l4)&& !this.findPixel(ol1) && !this.findPixel(ol2) && !this.findPixel(ol3) && !this.findPixel(ol4)) {
			return(false);
		}else {
			return true;
		}
	}
	
	private boolean findPixel(Location p)
	{
			if (tree.get(tree.getRoot(), p) == null) {
			return false;
		} else {
			return true;
			}
	}
	
//	private boolean findPixel(Location p) {
//		int x = pos.xCoord();
//		int wX = x + width;
//		int y = pos.yCoord();
//		int hY = y + height;
//		int pX = p.xCoord();
//		int pY = p.yCoord();
//		return (x <= pX && pX < wX && y <= pY && pY < hY);
//	
//	private BinarySearchTree getTree() 
//	{
//		return tree;
//	}

}

