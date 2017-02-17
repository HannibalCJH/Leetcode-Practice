public class Solution {
    // 指针模拟栈
    // 时间复杂度O(n)，空间复杂度O(1)
    public boolean verifyPreorder(int[] preorder) 
    {
        if(preorder == null || preorder.length == 0)
            return true;
        
        int minValue = Integer.MIN_VALUE;
        int top = -1;
        for(int num : preorder)
        {
            if(num < minValue)
                return false;
            while(top >= 0 && num > preorder[top])
            {
                minValue = preorder[top--];
            }
            preorder[++top] = num;
        }
        return true;
    }
}
