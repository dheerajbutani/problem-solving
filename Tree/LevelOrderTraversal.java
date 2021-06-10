/**
 * Jun 10, 2021
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dheeraj
 *
 */
public class LevelOrderTraversal {
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode();
		TreeNode n2 = new TreeNode();
		TreeNode n3 = new TreeNode();
		TreeNode n4 = new TreeNode();
		TreeNode n5 = new TreeNode();
		TreeNode n6 = new TreeNode();
		TreeNode n7 = new TreeNode();
		n1.val=10;
		n2.val=100;
		n3.val=18;
		n4.val=31;
		n5.val=99;
		n6.val=87;
		n7.val=20;
		n1.left=n2;
		n1.right=n3;
		n2.left=n4;
		n3.left=n5;
		n2.right=n6;
		n6.left=n7;
		List<TreeNode>traversal=getLevelOrderTraversalFor(n1);
		traversal.stream().forEach(System.out::println);
	}
	
	static List<TreeNode> getLevelOrderTraversalFor(TreeNode root){
		ArrayDeque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		List<TreeNode> traversal=new ArrayList<>();
		if(root==null){return traversal;}
		while(!queue.isEmpty()){
			TreeNode current = queue.poll();
			traversal.add(current);
			if(current.left!=null){
			queue.offer(current.left);
			}
			if(current.right!=null){
			queue.offer(current.right);
			}
		}
		
		//TODO: update return statement
		return traversal;
	}
}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TreeNode [val=" + val + "]";
	}
	
}
