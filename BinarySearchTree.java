/**
 * BinarySearchTree Class is a class that implements a Binary Search Tree of
 * type Pixel. It implements the BinarySearchTreeADT.
 * 
 * @author Will Malisch
 *
 */
public class BinarySearchTree implements BinarySearchTreeADT {
	/* Attribute Declarations */
	private BinaryNode r;

	/**
	 * Constructor creates a Binary Search Tree with node r as root
	 */
	public BinarySearchTree() {
		r = new BinaryNode();
	}

	/**
	 * get Method retrieves the node you request if it is in the tree
	 * 
	 * @param r
	 *            is the root of the BST
	 * @param key
	 *            is the key of the node you want to find
	 * @return the pixel data for the key if it is in the tree, otherwise null
	 */
	public Pixel get(BinaryNode r, Location key) {
		BinaryNode eval = traverse(r, key);
		if (eval.isLeaf())
			return null;
		return eval.getData();
	}

	/**
	 * put Method puts a new item in the binary search tree in a leaf node. It then
	 * sets up the links to new leafs and its parent
	 * 
	 * @param r
	 *            is the root of the BST
	 * @param data
	 *            is the pixel object being added to the tree
	 * @throws DuplicatedKeyException
	 *             if the pixel item is already in the tree
	 */
	public void put(BinaryNode r, Pixel data) throws DuplicatedKeyException {
		BinaryNode eval = traverse(r, data.getLocation());
		if (eval.isLeaf()) {
			setLinks(eval, data);
		} else {
			throw new DuplicatedKeyException();
		}
	}

	/**
	 * setLinks is a private helper method used for adding a new node to the tree.
	 * It sets the links to its parent, and new children
	 * 
	 * @param r
	 *            is the leaf location where a data is being added
	 * @param data
	 *            is the data being added to that location
	 */
	private void setLinks(BinaryNode r, Pixel data) {
		r.setData(data);
		r.setLeft(new BinaryNode());
		r.setRight(new BinaryNode());
		r.getLeft().setParent(r);
		r.getRight().setParent(r);
	}

	/**
	 * traverse is a private helper method that traverses the tree to the requested
	 * location
	 * 
	 * @param r
	 *            is the root of the tree
	 * @param key
	 *            is the location you are looking for
	 * @return the binary node with the location given by key, or a leaf where the
	 *         location would go if it is not in the tree
	 */
	private BinaryNode traverse(BinaryNode r, Location key) {
		if (r.isLeaf())
			return r;
		int compare = r.getData().getLocation().compareTo(key);
		if (compare == 0) {
			return r;
		} else if (compare == 1) {
			return traverse(r.getLeft(), key);
		} else {
			return traverse(r.getRight(), key);
		}
	}

	/**
	 * successor method finds the pixel with the smallest key larger than the one
	 * given. The key does not have to be in the tree, it will return what would be
	 * the next smallest, unless the key is smaller than or equal to the tree's
	 * smallest key
	 * 
	 * @param r
	 *            is the root of the BST
	 * @param key
	 *            is the key of the node you want to find the successor for
	 * 
	 * @return the node of the successor if it exists, otherwise null
	 */
	private boolean pureInternal(BinaryNode r) {
		boolean internal = (!r.getLeft().isLeaf() && !r.getRight().isLeaf());
		return internal;
	}

	private boolean notInternal(BinaryNode r) {
		boolean notInternal = (r.isLeaf() || (r.getLeft().isLeaf() && r.getRight().isLeaf()));
		return notInternal;
	}
	public Pixel successor(BinaryNode r, Location key) {
		BinaryNode node = traverse(r, key);
		if (r.isLeaf()) {
			return null;

			// Tree with one node
		} else if (r.getLeft().isLeaf() && r.getRight().isLeaf()) {
			if (node == r.getLeft()) {
				return r.getData();
			} else {
				return null;
			}
			// Right leaf or right node with 2 leaves
		} else if (notInternal(node) && node.getParent().getRight() == node) {
			node = node.getParent();
			while (node.getData().getLocation().compareTo(key) == -1) {
				node = node.getParent();
				// This is the case that we are looking for a successor of a value that is
				// larger than the tree's largest value
				if (node == null)
					return null;
			}
			return node.getData();

			// If node is an internal node, move right once, than move left until at last
			// non-leaf node
		} else if (pureInternal(node)) {
			node = node.getRight();
			while (!node.getLeft().isLeaf()) {
				node = node.getLeft();
			}
			return node.getParent().getData();

			// Right leaf or right node with 2 leaves
		} else if (notInternal(node) && node.getParent().getRight() == node) {
			node = node.getParent();
			while (node.getData().getLocation().compareTo(key) == -1) {
				node = node.getParent();
				// This is the case that we are looking for a successor of a value that is
				// larger than the tree's largest value
				if (node == null)
					return null;
			}
			return node.getData();

			// Left leaf or left node with 2 leaves
		} else if (notInternal(node) && node.getParent().getLeft() == node) {
			return node.getParent().getData();

			// Left node with right leaf
		} else if (node.getParent().getLeft() == node && node.getRight().isLeaf()) {
			return node.getParent().getData();

			// Left node with left leaf
		} else if (node.getParent().getLeft() == node && node.getLeft().isLeaf()) {
			node = node.getRight();
			while (!node.getLeft().isLeaf()) {
				node = node.getLeft();
			}
			return node.getData();

			// Right node with left leaf
		} else if (node.getParent().getRight() == node && node.getLeft().isLeaf()) {
			node = node.getRight();
			while (!node.getLeft().isLeaf()) {
				node = node.getLeft();
			}
			return node.getData();

			// Right node with right leaf
		} else if (node.getParent().getRight() == node && node.getRight().isLeaf()) {
			node = node.getParent();
			while (node.getData().getLocation().compareTo(key) == -1) {
				node = node.getParent();
				// This is the case that we are looking for a successor of a value that is
				// larger than the tree's largest value
				if (node == null)
					return null;
			}
			return node.getData();
		} else {

			return null;
		}
//		if (r.isLeaf()) {
//			return null;
//		} else {
//			BinaryNode eval = traverse(r, key);
//			Location tmp = largest(r).getLocation();
//
//			// If the key is equal to the largest value or larger than the largest value
//			// return null
//			if (key.compareTo(tmp) == 1 || key.compareTo(tmp) == 0) {
//				return null;
//
//				// If the key is a left child return its parent
//			} else if (this.isLeftChild(eval)) {
//				if (eval.isLeaf() || lastInternal(eval)) {
//					return eval.getParent().getData();
//				} else if (eval.getRight().isLeaf()) {
//					return eval.getParent().getData();
//				} else {
//					return getSmallest(eval.getRight()).getData();
//				}
//
//				// If the key is a right leaf or right child with right leaf, traverse up
//				// parents until the parent is greater
//				// than the key
//			} else if ((this.isRightChild(eval) && eval.isLeaf())
//					|| (this.isRightChild(eval) && eval.getRight().isLeaf())) {
//				eval = eval.getParent();
//				while (compare(eval, key) == -1 && eval != null) {
//					eval = eval.getParent();
//				}
//				return eval.getData();
//
//				// If the key is a right child, traverse to right, as long as right is not a
//				// leaf
//			} else if (this.isRightChild(eval) && !eval.isLeaf() && !eval.getRight().isLeaf()) {
//				eval = eval.getRight();
//				return getSmallest(eval).getData();
//
//			} else {
//				return null;
//			}
//		}

	}

	/**
	 * compare is a private helper method that performs the steps of compareTo. It
	 * is just so that other public methods do not get so messy.
	 * 
	 * @param r
	 *            is binary node you are comparing with
	 * @param key
	 *            is the key you want to compare to
	 * @return -1 if r's location is less than the key, 1 if greater than the key,
	 *         and 0 if their equal
	 */
	private int compare(BinaryNode r, Location key) {
		return r.getData().getLocation().compareTo(key);
	}

	/**
	 * predecessor method finds the pixel with the largest key smaller than the one
	 * given. The key does not have to be in the tree, it will return what would be
	 * the next largest, unless the key is smaller than or equal to the tree's
	 * smallest key
	 * 
	 * @param r
	 *            is the root of the BST
	 * @param key
	 *            is the key of the node you want to find the predecessor for
	 * 
	 * @return the node of the predecessor if it exists, otherwise null
	 */
	public Pixel predecessor(BinaryNode r, Location key) {
		if (r.isLeaf()) {
			return null;
		} else {
			BinaryNode eval = traverse(r, key);
			Location tmp = smallest(r).getLocation();

			// If the key is equal to the smallest value or smaller than the largest value
			// return null
			if (key.compareTo(tmp) == -1 || key.compareTo(tmp) == 0) {
				return null;

				// If the key is a right child return its parent
			} else if (this.isRightChild(eval)) {
				if (eval.isLeaf() || lastInternal(eval)) {
					return eval.getParent().getData();
				} else if (eval.getLeft().isLeaf()) {
					return eval.getParent().getData();
				} else {
					return getLargest(eval.getLeft()).getData();
				}

				// If the key is a left leaf, traverse up parents until the parent is less
				// than the key
			} else if ((this.isLeftChild(eval) && eval.isLeaf())
					|| (this.isLeftChild(eval) && eval.getLeft().isLeaf())) {
				eval = eval.getParent();
				while (compare(eval, key) == 1 && eval != null) {
					eval = eval.getParent();
				}
				return eval.getData();

				// If the key is a left child, traverse to left once, as long as left is not a
				// leaf
			} else if (this.isLeftChild(eval) && !eval.isLeaf() && !eval.getLeft().isLeaf()) {
				eval = eval.getLeft();
				return getLargest(eval).getData();
			} else {
				return null;
			}
		}
	}

	/**
	 * remove Method removes the node with the key passed in the argument
	 * 
	 * @param r
	 *            is the root of the tree
	 * @key is the location to be removed
	 * @throws InexistentKeyException
	 *             if the key being looked for does not exist in the tree
	 */
	public void remove(BinaryNode r, Location key) throws InexistentKeyException {
		BinaryNode tmp = traverse(r, key);

		// Inputed root is a leaf
		if (tmp.isLeaf()) {
			throw new InexistentKeyException();

			// If we are removing an internal node with two leaves as children
		} else if (tmp.getLeft().isLeaf() && tmp.getRight().isLeaf()) {
			tmp.setData(null);
			tmp.setLeft(null);
			tmp.setRight(null);

			// If left child is a leaf and right child is not a leaf
		} else if (tmp.getLeft().isLeaf() && !tmp.getRight().isLeaf()) {
			BinaryNode par = tmp.getParent();
			BinaryNode otherChild = tmp.getRight();
			if (par == r) {
				r = otherChild;
				otherChild.setParent(null);
			} else {
				par.setRight(otherChild);
			}

			// If right child is a leaf and left child is not a leaf
		} else if (!tmp.getLeft().isLeaf() && tmp.getRight().isLeaf()) {
			BinaryNode par = tmp.getParent();
			BinaryNode otherChild = tmp.getRight();
			if (tmp == r) {
				r = otherChild;
				otherChild.setParent(null);
			} else {
				par.setRight(otherChild);
			}

			// If your removing an internal node that's children are also internal
		} else if (!tmp.getLeft().isLeaf() && !tmp.getRight().isLeaf()) {
			if (tmp == r) {
				BinaryNode small = this.getSmallest(tmp.getRight());
				r.setData(small.getData());
				small.setLeft(null);
				small.setRight(null);
				small.setData(null);
			} else {
				BinaryNode small = this.getSmallest(tmp.getRight());
				tmp.setData(small.getData());

				if (small.getRight().isLeaf()) {
					small.setLeft(null);
					small.setRight(null);
					small.setData(null);
				} else {
					small.getParent().setLeft(small.getRight());
					small.getRight().setParent(small.getParent());
				}

			}
		} else {
			BinaryNode small = getSmallest(tmp.getRight());
			tmp.setData(small.getData());
			remove(small, small.getData().getLocation());
		}

	}

	/**
	 * isLeftChild is a private helper method that tests whether or not a node is a
	 * left child of its parent
	 * 
	 * @param r
	 *            is the node you want to test for which side it is on
	 * @return True if the node is on the left of its parent
	 */
	private boolean isLeftChild(BinaryNode r) {
		return (r.getParent().getLeft() == r);
	}

	/**
	 * isRightChild is a private helper method that tests whether or not a node is a
	 * right child of its parent
	 * 
	 * @param r
	 *            is the node you want to test for which side it is on
	 * @return True if the node is on the right of its parent
	 */
	private boolean isRightChild(BinaryNode r) {
		return (r.getParent().getRight() == r);
	}

	/**
	 * lastInternal is a private helper method that tests whether or not a node has
	 * two leaf children
	 * 
	 * @param r
	 *            is the node you are testing
	 * @return True if both of its children are leafs
	 */
	private boolean lastInternal(BinaryNode r) {
		return (r.getLeft().isLeaf() && r.getRight().isLeaf());
	}

	/**
	 * smallest Method finds the data of the smallest item in the BST
	 * 
	 * @param r
	 *            is the root of the BST
	 * @throws EmptyTreeException
	 *             if there is nothing in the tree
	 * @return the data of the smallest node
	 */
	public Pixel smallest(BinaryNode r) throws EmptyTreeException {
		if (r.isLeaf()) {
			throw new EmptyTreeException();
		} else {
			return getSmallest(r).getData();
		}
	}

	/**
	 * getSmallest Method is a private helper method for smallest, that returns the
	 * smallest value as a Binary Node instead of the data
	 * 
	 * @param r
	 *            is the root of the tree
	 * @return the smallest Binary Node or a leaf if the tree is empty
	 */
	private BinaryNode getSmallest(BinaryNode r) {
		if (r.isLeaf())
			return r;
		while (!r.getLeft().isLeaf()) {
			r = r.getLeft();
		}
		return r;
	}

	/**
	 * largest Method finds the data of the largest item in the BST
	 * 
	 * @param r
	 *            is the root of the BST
	 * @throws EmptyTreeException
	 *             if there is nothing in the tree
	 * @return the data of the largest node
	 */
	public Pixel largest(BinaryNode r) throws EmptyTreeException {
		if (r.isLeaf()) {
			throw new EmptyTreeException();
		} else {
			return getLargest(r).getData();
		}
	}

	/**
	 * getLargest Method is a helper method for largest, that returns the largest
	 * value as a Binary Node instead of the data
	 * 
	 * @param r
	 *            is the root of the tree
	 * @return the largest Binary Node or a leaf if the tree is empty
	 */
	private BinaryNode getLargest(BinaryNode r) {
		if (r.isLeaf())
			return r;
		while (!r.getRight().isLeaf()) {
			r = r.getRight();
		}
		return r;
	}

	/**
	 * getRoot Method returns the root of this Binary Seach Tree
	 * 
	 * @return the root
	 */
	public BinaryNode getRoot() {
		return this.r;
	}

}
