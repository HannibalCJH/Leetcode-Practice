public class Solution {
    public bool VerifyPreorder(int[] preorder) 
    {
        if(preorder == null || preorder.Length == 0)
            return true;
        
        int minValue = Int32.MinValue;
        int top = -1;
        foreach(int num in preorder)
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
