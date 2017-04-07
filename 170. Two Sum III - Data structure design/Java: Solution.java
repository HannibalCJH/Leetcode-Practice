public class TwoSum {
    // 列表存数但是不存重复的数，类似集合但是因为集合不支持有序查找所以使用列表
    List<Integer> list;
    // 哈希表存键值对[数，这个数出现的次数]
    Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public TwoSum() 
    {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }
    
    // 时间复杂度O(1)，空间复杂度O(n)
    /** Add the number to an internal data structure.. */
    public void add(int number) 
    {
        // 这个数存在，只需把出现的次数加1，不用加入列表
        if(map.containsKey(number))
        {
            map.put(number, map.get(number) + 1);
        }
        else
        {
            // 这个数第一次出现，计数器为1
            map.put(number, 1);
            // 加入队列
            list.add(number);
        }
    }
    // 时间复杂度O(n)，空间复杂度O(n)
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) 
    {
        // 遍历列表
        for(int i = 0; i < list.size(); i++)
        {
            // 取第一个数为列表的元素，第二个数则是目标数减去第一个数
            int num1 = list.get(i), num2 = value - num1;
            // 找到组合的两种情况
            // 1. 两个数相等的情况下看哈希表中这个数的计数器是不是大于1
            // 2. 两个数不相等那只需要看哈希表中是否存在第二个数就行
            if(num1 == num2 && map.get(num1) > 1 || num1 != num2 && map.containsKey(num2))
                return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
