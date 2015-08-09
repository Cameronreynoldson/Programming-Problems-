/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class KthElementBST {
    public static boolean started = false; 
    
    public int kthSmallest(TreeNode root, int k) {
        int[] kthVal = new int[2];
        findKthWithInOrder(root,k,kthVal);
        return kthVal[1];
    }
    
    private static void findKthWithInOrder(TreeNode root, int k, int[] kthVal)
    {
        if(root == null) return;
        
        if(root.left == null)
        {
            started = true; //start counting
        }
        
        findKthWithInOrder(root.left,k,kthVal);
        if(started) kthVal[0]++; 
        if(kthVal[0] == k) kthVal[1] = root.val;
        findKthWithInOrder(root.right,k,kthVal);
    }
}
