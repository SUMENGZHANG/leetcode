/**
 *  leetcode 108
 */
public class SortedArrayToBST {
    // 一个有序数组  二分法？？
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length-1);
    
    }

    public TreeNode dfs(int []nums,int left,int right){
        if(left>right) return null;
        int mid = (left+right)/2;
        TreeNode curNode = new TreeNode(nums[mid]);
        curNode.left = dfs(nums, left, mid-1);
        curNode.right = dfs(nums,mid+1,right);
        return curNode;
    }
}
