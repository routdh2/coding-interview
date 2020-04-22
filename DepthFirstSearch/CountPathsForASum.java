package coding_interview;
import java.util.*;
public class CountPathsForASum {
	
	public static int countPathsForSum(TreeNode root, int sum) {
		if(root==null)
			return 0;
		return countPaths(root,sum,new LinkedList<Integer>());
	}
	
	private static int countPaths(TreeNode currNode, int sum, LinkedList<Integer> path) {
		if(currNode==null)
			return 0;
		path.add(currNode.val);
		int pathSum=0,pathCount=0;
		ListIterator<Integer> listIterator = path.listIterator(path.size());
		while(listIterator.hasPrevious()) {
			pathSum+=listIterator.previous();
			if(pathSum==sum)
				pathCount++;
		}
		pathCount+=countPaths(currNode.left,sum,path);
		pathCount+=countPaths(currNode.right,sum,path);
		path.remove(path.size()-1);
		return pathCount;
	}

	public static void main(String[] args) {
		TreeNode root = BFSTreeTraversal.createTree();
		System.out.println(countPathsForSum(root, 7));

	}

}
