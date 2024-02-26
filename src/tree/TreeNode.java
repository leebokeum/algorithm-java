package tree;

/**
 * 이진 트리
 */
public class TreeNode {
	public int data;      
	public TreeNode left;    
	public TreeNode right; 
	public TreeNode parent;
	private int size;

	public TreeNode(int d) {
		data = d;
		size = 1;
	}

	/**
	 * 왼쪽 자식에 노드 추가
	 */
	private void setLeftChild(TreeNode left) {
		this.left = left;
		if (left != null) {
			left.parent = this;
		}
	}

	/**
	 * 오른쪽 자식에 노드 추가
	 */
	private void setRightChild(TreeNode right) {
		this.right = right;
		if (right != null) {
			right.parent = this;
		}
	}

	/**
	 * InOrder 방식으로 데이터 추가
	 */
	public void insertInOrder(int d) {
		if (d <= data) {
			if (left == null) {
				setLeftChild(new TreeNode(d));
			} else {
				left.insertInOrder(d);
			}
		} else {
			if (right == null) {
				setRightChild(new TreeNode(d));
			} else {
				right.insertInOrder(d);
			}
		}
		size++;
	}

	/**
	 * 트리 전체 사이즈
	 */
	public int size() {
		return size;
	}

	/**
	 * 이진 검색 트리인지 여부
	 */
	public boolean isBST() {
		if (left != null) {
			if (data < left.data || !left.isBST()) {
				return false;
			}
		}
		
		if (right != null) {
			if (data >= right.data || !right.isBST()) {
				return false;
			}
		}		
		
		return true;
	}

	/**
	 * 트리의 높이
	 */
	public int height() {
		int leftHeight = left != null ? left.height() : 0;
		int rightHeight = right != null ? right.height() : 0;
		return 1 + Math.max(leftHeight, rightHeight);
	}

	/**
	 * 데이터 찾기 (이진 검색 트리라고 가정)
	 */
	public TreeNode find(int d) {
		if (d == data) {
			return this;
		} else if (d <= data) {
			return left != null ? left.find(d) : null;
		} else if (d > data) {
			return right != null ? right.find(d) : null;
		}
		return null;
	}

	/**
	 * 최소 검색 이진트리 만들기
	 */
	private static TreeNode createMinimalBST(int arr[], int start, int end){
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		n.setLeftChild(createMinimalBST(arr, start, mid - 1));
		n.setRightChild(createMinimalBST(arr, mid + 1, end));
		return n;
	}

	/**
	 * 최소 검색 이진트리 만들기
	 */
	public static TreeNode createMinimalBST(int[] array) {
		return createMinimalBST(array, 0, array.length - 1);
	}

	/**
	 * 출력하기
	 */
	public void print() {
		BTreePrinter.printNode(this);
	}

	/**
	 * inorder 방식으로 데이터 출력
	 */
	private void inOrder(TreeNode node) {
		if (node != null) {
			inOrder(node.left);
			System.out.printf(node.data + ", ");
			inOrder(node.right);
		}
	}

	/**
	 * preOrder 방식으로 데이터 출력
	 */
	private void preOrder(TreeNode node) {
		if (node != null) {
			System.out.printf(node.data + ", ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	/**
	 * PostOrder 방식으로 데이터 출력
	 */
	private void postOrder(TreeNode node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.printf(node.data + ", ");
		}
	}

	/**
	 * inorder 방식으로 데이터 출력
	 */
	public void printInOrder() {
		System.out.printf("inorder 출력 : ");
		inOrder(this);
	}

	/**
	 * preOrder 방식으로 데이터 출력
	 */
	public void printPreOrder() {
		System.out.printf("preOrder 출력 : ");
		preOrder(this);
	}

	/**
	 * PostOrder 방식으로 데이터 출력
	 */
	public void printPostOrder() {
		System.out.printf("postOrder 출력 : ");
		postOrder(this);
	}

	public TreeNode getIthNode(int i) {
		int leftSize = left == null ? 0 : left.size();
		if (i < leftSize) {
			return left.getIthNode(i);
		} else if (i == leftSize) {
			return this;
		} else {
			return right.getIthNode(i - (leftSize + 1));
		}
	}


} 
