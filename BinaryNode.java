/**
 * BinaryNode class represents a BinaryNode with links to a left and right
 * child, a parent, and holds a data value of type Pixel. It is a support class
 * for the BinarySearchTree class
 * 
 * @author Will Malisch, 250846447
 *
 */
public class BinaryNode {
	/* Attribut4e Declarations */
	private Pixel value;
	private BinaryNode left;
	private BinaryNode right;
	private BinaryNode parent;

	/**
	 * Constructor creates a BinaryNode with null values in all fields. Essentially
	 * just creates space in memory for a BN object
	 */
	public BinaryNode() {
		value = null;
		left = null;
		right = null;
		parent = null;
	}

	/**
	 * Constructor creates a BinaryNode with values for left, right, parent, and
	 * value, given by the parameters
	 * 
	 * @param value
	 *            is the data value of this node, type Pixel
	 * @param left
	 *            is the left child node of this node
	 * @param right
	 *            is the right child node of this node
	 * @param parent
	 *            is the parent node of this node
	 */
	public BinaryNode(Pixel value, BinaryNode left, BinaryNode right, BinaryNode parent) {
		this.value = value;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}

	/**
	 * getParent Method retrieves the parent of this node
	 * 
	 * @return parent
	 */
	public BinaryNode getParent() {
		return parent;
	}

	/**
	 * setParent Method sets the parent of this node
	 * 
	 * @param p
	 *            is the node being set as the parent
	 */
	public void setParent(BinaryNode p) {
		parent = p;
	}

	/**
	 * setLeft Method sets the left of this node
	 * 
	 * @param p
	 *            is the node being set as the left
	 */
	public void setLeft(BinaryNode p) {
		left = p;
	}

	/**
	 * setRight Method sets the right of this node
	 * 
	 * @param p
	 *            is the node being set as the right
	 */
	public void setRight(BinaryNode p) {
		right = p;
	}

	/**
	 * setData Method sets the data of this node
	 * 
	 * @param value
	 *            is the Pixel data
	 */
	public void setData(Pixel value) {
		this.value = value;
	}

	/**
	 * isLeaf Method tests if this node is a leaf
	 * 
	 * @return true if the node is a leaf
	 */
	public boolean isLeaf() {
		if (this.left == null && this.right == null) {
			return true;
		}
		return false;
	}

	/**
	 * getData returns the data of this node
	 * 
	 * @return the data of this node
	 */
	public Pixel getData() {
		return value;
	}

	/**
	 * getLeft returns the left of this node
	 * 
	 * @return the left node
	 */
	public BinaryNode getLeft() {
		return left;
	}

	/**
	 * getRight returns the right of this node
	 * 
	 * @return the right node
	 */
	public BinaryNode getRight() {
		return right;
	}
}
