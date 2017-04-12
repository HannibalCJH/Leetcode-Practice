public class Solution {
    // 时间复杂度O(m+n)，空间复杂度O(1)
    public boolean isMatch(String s, String p) 
    { 
        // i为s的指针，j为p的指针
        int i = 0, j = 0;
        // 上一次出现的'*'的下标，用来回溯
        int star = -1;
        // 对应上一次出现'*'时s字符串的下标，用来回溯
        int sPos = 0;
        // 遍历字符串s
        while(i < s.length())
        {  
            // 如果p的字符是'*'
            while(j < p.length() && p.charAt(j) == '*') 
            {  
            	// 保存'*'的位置然后移动到p的下一个字符，注意是j++而不是++j
            	// '*'只是为可能遇到的不对应做后备，移动到p下一个字符后依然是和s的当前字符比较，所以i不变
            	// 能对应最好，这样'*'就当对应空字符串就行，比如abc和a*bc
            	// 如果有一串'*'，则记录的是最后一个'*'的位置
                star = j++;
                // 记录下'*'出现时s字符串当前的位置
                sPos = i;  
            } 
            // p的长度小于s或者s和p的字符不对应
            if(j == p.length() || (s.charAt(i) != p.charAt(j) && p.charAt(j) != '?')) 
            {  
            	// 在p字符串检查过的部分没有'*'
                if(star < 0) 
                	return false;  
                else 
                {
                    // 有'*'，则用'*'来代替s和j不匹配的部分
                    // 调整i和j来实现回溯
                    // 把j设为'*'位置的下一个
                    j = star + 1;  
                    // 把i设为'*'出现时对应的s字符串的位置
                    i = sPos++;    
                }  
            }
            // s和p的字符对应
            else 
            {  
                i++;  
                j++;  
            }  
        }  
        // s已经遍历完，检查p字符串是不是后面只剩'*'，注意问号不能对应空字符串
        while(j < p.length() && p.charAt(j) == '*')
            j++;  
        return j == p.length();  
    }
}
