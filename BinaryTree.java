
public class BinaryTree implements BinarySearchTreeADT {

	@Override
	public BinaryNode getRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pixel get(BinaryNode r, Location key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(BinaryNode r, Pixel data) throws DuplicatedKeyException {
		// TODO Auto-generated method stub

	}

	private BinaryNode find(BinaryNode r, Location key) {
		if (r.isLeaf()) {
			return r;
		} else if (r.getData().getLocation().compareTo(key) == 0) {
			return r;
		} else if (r.getData().getLocation().compareTo(key) == -1) {
			return find(r.getRight(), key);
		} else {
			return find(r.getLeft(), key);
		}
	}

	@Override
	public void remove(BinaryNode r, Location key) throws InexistentKeyException {

	}

	@Override
	public Pixel successor(BinaryNode r, Location key) {
		BinaryNode node = find(r, key);
		if (r.isLeaf()) {
			return null;

			// Tree with one node
		} else if (r.getLeft().isLeaf() && r.getRight().isLeaf()) {
			if (node == r.getLeft()) {
				return r.getData();
			} else {
				return null;
			}

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
	}

	private boolean pureInternal(BinaryNode r) {
		boolean internal = (!r.getLeft().isLeaf() && !r.getRight().isLeaf());
		return internal;
	}

	private boolean notInternal(BinaryNode r) {
		boolean notInternal = (r.isLeaf() || (r.getLeft().isLeaf() && r.getRight().isLeaf()));
		return notInternal;
	}

	@Override
	public Pixel predecessor(BinaryNode r, Location key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pixel smallest(BinaryNode r) throws EmptyTreeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pixel largest(BinaryNode r) throws EmptyTreeException {
		// TODO Auto-generated method stub
		return null;
	}

}
