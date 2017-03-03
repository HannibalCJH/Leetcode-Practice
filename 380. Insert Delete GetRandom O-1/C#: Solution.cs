public class RandomizedSet {
    List<int> items;
    Dictionary<int, int> map;
    Random rand;
    
    
    /** Initialize your data structure here. */
    public RandomizedSet() 
    {
        items = new List<int>();
        map = new Dictionary<int, int>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public bool Insert(int val) 
    {
        if(map.ContainsKey(val))
            return false;
        map.Add(val, items.Count);
        items.Add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public bool Remove(int val) 
    {
        if(!map.ContainsKey(val))
            return false;
        int loc = map[val];
        if(loc != items.Count - 1)
        {
            int lastItem = items[items.Count - 1];
            items[loc] = lastItem;
            map[lastItem] = loc;
        }
        items.RemoveAt(items.Count - 1);
        map.Remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int GetRandom() 
    {
        return items[rand.Next(items.Count)];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * bool param_1 = obj.Insert(val);
 * bool param_2 = obj.Remove(val);
 * int param_3 = obj.GetRandom();
 */
