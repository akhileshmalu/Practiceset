/**
 * @author: Akhilesh Maloo
 * @date: 10/21/20.
 */
public class DiameterBST {

     public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }


    int subTree = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int depth = depth(root);
        return Math.max(subTree, depth);
    }

    public int depth(TreeNode root) {
        if(root == null)
            return 0;

        int lDepth = depth(root.left);
        int rDepth = depth(root.right);
        subTree = Math.max(subTree, lDepth+rDepth);
        System.out.println(root.val + " - " + lDepth + " - " + rDepth + " - " + subTree);
        return Math.max(lDepth, rDepth) +1;
    }

    public static void main(String[] args) {
        DiameterBST bst = new DiameterBST();
        DiameterBST.TreeNode node = new DiameterBST.TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(bst.diameterOfBinaryTree(node));
    }
}
