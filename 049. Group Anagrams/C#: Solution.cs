public class Solution {
    public IList<IList<string>> GroupAnagrams(string[] strs) 
    {
        IList<IList<string>> result = new List<IList<string>>();
        if(strs == null || strs.Length == 0)
            return result;
        
        Dictionary<string, List<string>> map = new Dictionary<string, List<string>>();
        foreach(string str in strs)
        {
            char[] charArray = str.ToCharArray();
            Array.Sort(charArray);
            string key = new string(charArray);
            if(map.ContainsKey(key))
            {
                map[key].Add(str);
            }
            else
            {
                List<string> temp = new List<string>();
                temp.Add(str);
                map.Add(key, temp);
            }
        }
        
        foreach(string key in map.Keys)
        {
            result.Add(map[key]);    
        }
        return result;
    }
}
