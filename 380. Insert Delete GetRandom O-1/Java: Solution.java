public class RandomizedSet {
    // 记录当前的存在的值，用来快速获得随机数，哈希表无法用Random快速产生随机
    List<Integer> items;
    // 记录[val, index]，用来快速查询是否存在
    HashMap<Integer, Integer> map;
    // 随机数生成器
    Random rand;
    
    /** Initialize your data structure here. */
    public RandomizedSet() 
    {
        items = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
        rand = new Random();
    }
    
    // 时间复杂度O(1)，空间复杂度O(n)
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) 
    {
        // 已经存在这个值
        if(map.containsKey(val))
            return false;
        // 把这个值加到列表最末尾
        map.put(val, items.size());
        items.add(val);
        return true;
    }
    
    // 时间复杂度O(1)，空间复杂度O(n)
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) 
    {
        // 不存在这个值
        if(!map.containsKey(val))
            return false;
        // 获得这个值在列表中的位置
        int index = map.get(val);
        // 如果不是最后一个元素，把最后一个元素覆盖到当前位置并更新哈希表
        // 不用把需要删除的移动到最后一个位置，因为我们后面要删除最后这个位置
        if(index != items.size() - 1)
        {
            int lastItem = items.get(items.size() - 1);
            items.set(index, lastItem);
            map.put(lastItem, index);
        }
        // 删除列表最后一个元素并删除哈希表中的键
        items.remove(items.size() - 1);
        map.remove(val);
        return true;
    }
    
    // 时间复杂度O(1)，空间复杂度O(n)
    /** Get a random element from the set. */
    public int getRandom() 
    {
        // 获取随机数
        return items.get(rand.nextInt(items.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
