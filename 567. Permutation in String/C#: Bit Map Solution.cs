public class Solution {
    public bool CheckInclusion(string s1, string s2) 
    {
        if(s1 == null || s2 == null || s1.Length > s2.Length)
            return false;
        
        int[] bitmap = new int[128];
        for(int i = 0; i < s1.Length; i++)
        {
            bitmap[s1[i]]++;
        }
        
        int count = 0;
        int left = 0, right = 0;
        while(right < s2.Length)
        {
            char cur = s2[right];
            if(bitmap[cur] > 0)
            {
                count++;
            }
            bitmap[cur]--;
            while(count == s1.Length)
            {
                if(right - left + 1 == s1.Length)
                    return true;
                
                char leftChar = s2[left];
                if(bitmap[leftChar] == 0)
                {
                    count--;
                }
                bitmap[leftChar]++;
                left++;
            }
            right++;
        }
        return false;
    }
}
