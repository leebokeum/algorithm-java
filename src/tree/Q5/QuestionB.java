package tree.Q5;

import java.util.concurrent.ThreadLocalRandom;
import tree.TreeNode;

public class QuestionB {
	public static boolean checkBST(TreeNode n, Integer min, Integer max) {
		if (n == null) {
			return true;
		}
		if ((min != null && n.data <= min) || (max != null && n.data > max)) {
			return false;
		}
		if (!checkBST(n.left, min, n.data) ||
			!checkBST(n.right, n.data, max)) {
			return false;
		}
		return true;
	}
		
	public static boolean checkBST(TreeNode n) {
		return checkBST(n, null, null);
	}
	
	public static boolean checkBSTAlternate(TreeNode n) {
		return checkBSTAlternate(n, new IntWrapper(0), new IntWrapper(0));
	}		

	public static boolean checkBSTAlternate(TreeNode n, IntWrapper min, IntWrapper max) {
		/* An alternate, less clean approach. This is not provided in the book, but is used to test the other method. */
		if (n.left == null) {
			min.data = n.data;
		} else {
			IntWrapper leftMin = new IntWrapper(0);
			IntWrapper leftMax = new IntWrapper(0);
			if (!checkBSTAlternate(n.left, leftMin, leftMax)) {
				return false;
			}
			if (leftMax.data > n.data) {
				return false;
			}
			min.data = leftMin.data;
		}
		if (n.right == null) {
			max.data = n.data;
		} else {
			IntWrapper rightMin = new IntWrapper(0);
			IntWrapper rightMax = new IntWrapper(0);
			if (!checkBSTAlternate(n.right, rightMin, rightMax)) {
				return false;
			}
			if (rightMin.data <= n.data) {
				return false;
			}
			max.data = rightMax.data;
		}
		return true;
	}
	
	public static void main(String[] args) {
		/* Simple test -- create one */
		int[] array = {Integer.MIN_VALUE, 3, 5, 6, 10, 13, 15, Integer.MAX_VALUE};
		TreeNode node = TreeNode.createMinimalBST(array);
		//node.left.data = 6; // "ruin" the BST property by changing one of the elements
		node.print();
		boolean isBst = checkBST(node);
		System.out.println(isBst);
	}
}
