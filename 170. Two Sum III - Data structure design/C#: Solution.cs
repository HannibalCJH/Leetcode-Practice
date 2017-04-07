public class TwoSum {
    List<int> list;
    Dictionary<int, int> map;

    /** Initialize your data structure here. */
    public TwoSum() 
    {
        list = new List<int>();
        map = new Dictionary<int, int>();
    }
    
    /** Add the number to an internal data structure.. */
    public void Add(int number) 
    {
        if(map.ContainsKey(number))
        {
            map[number]++;
        }
        else
        {
            map.Add(number, 1);
            list.Add(number);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public bool Find(int value) 
    {
        for(int i = 0; i < list.Count; i++)
        {
            int num1 = list[i], num2 = value - num1;
            if(num1 == num2 && map[num1] > 1 || num1 != num2 && map.ContainsKey(num2))
                return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.Add(number);
 * bool param_2 = obj.Find(value);
 */
