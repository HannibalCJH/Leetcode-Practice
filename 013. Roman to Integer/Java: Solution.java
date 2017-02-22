public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public int romanToInt(String s) 
    {
        int result = 0;
        // 1. 罗马数字中较小的字母在较大的字母之前意味着较大的字母减去较小的字母，
        // 2. 较小的字母在较大的字母之后意味着较大的字母加上较小的字母,
        // 3. 而且前面最多只有1个较小字母
	for(int i = 0; i < s.length(); i++) 
	{
	    char ch = s.charAt(i);
	    // 当前字母比后一个字母小则符合条件1，应该减去这个字母
	    if(i + 1 < s.length() && getVal(ch) < getVal(s.charAt(i + 1))) 
	        result -= getVal(ch);
	    else
	        // 当前字母比后一个大或者一样大则符合条件2，应该加上这个字母
	        result += getVal(ch);
	}
	return result;
    }
    
    public int getVal(char ch) 
    {
        switch(ch) 
	{
    	    case 'I':
    	        return 1;
    	    case 'V':
    		return 5;
    	    case 'X':
    		return 10;
    	    case 'L':
    		return 50;
    	    case 'C':
    	        return 100;
    	    case 'D':
    		return 500;
    	    case 'M':
    		return 1000;
    	    default:
    		return 0;
	}
    }
}
