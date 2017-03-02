class ListNode 
{
    int key;
    int val;
    int count;
    ListNode prev;
    ListNode next;
    public ListNode(int key, int val, int count) 
    {
        this.key = key;
        this.val = val;
        this.count = count;
    }
}

public class LFUCache {
    // 双向链表中节点的存法示例：1->1->2->2->2->3->3->4，其中数字代表这个节点被访问的频率，被访问次数越多的节点都往后靠，
    // 相同频率的节点中，越往后的表示越是被最新访问过
    // 保存[key, ListNode]，看这个节点是否存在
    HashMap<Integer, ListNode> map;
    // 保存[frequency, lastest node]，对应被访问次数为n的所有节点中，最新被访问过的那个节点
    HashMap<Integer, ListNode> latestNodes;
    ListNode head;
    ListNode tail;
    int capacity;
    int size;
    
    public LFUCache(int capacity) 
    {
        this.capacity = capacity;
        size = 0;
        map = new HashMap<Integer, ListNode>();
        latestNodes = new HashMap<Integer, ListNode>();
        head = new ListNode(-1, -1, 0);
        tail = new ListNode(-1, -1, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    // 时间复杂度O(1)，空间复杂度O(capacity)
    public int get(int key) 
    {
        if(capacity == 0 || !map.containsKey(key))
            return -1;
        ListNode node = map.get(key);
        put(key, node.val);
        return node.val;
    }
    
    // 时间复杂度O(1)，空间复杂度O(capactiy)
    public void put(int key, int value) 
    {
        if(capacity == 0)
            return;
        if(map.containsKey(key)) 
        {
            // 获得key对应的节点
            ListNode cur = map.get(key);
            // 这个节点所属于的被访问的次数中，这个节点是最新的，而且这个次数是目前所有节点中最多的
            if(latestNodes.get(cur.count) == cur && latestNodes.get(cur.count + 1) == null) 
            {
                // 找这个被访问次数中的第二新的节点，如果存在则更新为当前被访问数的最新节点，不然则设置这个访问次数的最新节点为空
                latestNodes.put(cur.count, cur.prev.count == cur.count ? cur.prev : null);
                // 这里不需要删除当前节点即removeNode(cur)，因为在整个双向链表中这个节点已经是最后一个节点，没有被访问次数更多的节点了
                // 增加被访问的次数
                cur.count++;
                // 更新节点的值
                cur.val = value;
                // 开辟一个新的被访问次数的键，当前节点为第一个达到这个次数的节点
                latestNodes.put(cur.count, cur);
            }
            else
            {
                // 这个节点所属于的被访问的次数中，这个节点是最新的
                if(latestNodes.get(cur.count) == cur)
                {
                    // 找这个被访问次数中的第二新的节点，如果存在则更新为当前被访问数的最新节点，不然则为空
                    latestNodes.put(cur.count, cur.prev.count == cur.count ? cur.prev : null);
                }
                // 删除这个节点，等会儿把它往后移到被访问次数加1的节点中的最后一个
                removeNode(cur);
                // 增加被访问的次数
                cur.count++;
                // 更新节点的值
                cur.val = value;
                // 如果没有被访问次数更多的节点了，那就找被访问次数减1的最新被访问的节点
                ListNode lastestNode = latestNodes.get(cur.count) == null ? latestNodes.get(cur.count - 1) : latestNodes.get(cur.count);
                // 把当前节点加到后面
                insertNode(lastestNode, cur);
                // 当前节点是这个被访问次数中最新的节点
                latestNodes.put(cur.count, cur);
            }
        }
        else if(size == capacity) 
        {
            // 第一个节点，也就是被访问次数最少并且是这个最少被访问次数的所有节点中最早被访问过的，也就是题目中LFU节点
            ListNode node = head.next;
            // 删除这个节点
            removeNode(node);
            // 把这个节点从哈希表中删除
            map.remove(node.key);
            // 被删掉的这个节点是该被访问次数的唯一节点，那直接把这个被访问次数的键从lastestNodes表中删掉，
            // 表面没有节点被访问的次数为这个被删掉的次数
            if(latestNodes.get(node.count) == node)
                latestNodes.remove(node.count);
            // 创建这个键值对的新节点，被访问次数初始化为1
            ListNode cur = new ListNode(key, value, 1);
            // 加到表头
            addToHead(cur);
        } 
        else 
        {
            // 增加现有节点的个数
            size++;
            // 创建这个键值对的新节点，被访问次数初始化为1
            ListNode cur = new ListNode(key, value, 1);
            // 加到表头
            addToHead(cur);
        }
    }
    
    public void addToHead(ListNode node)
    {
        if(latestNodes.get(1) == null)
        {
            // 把新加入的节点插入到链表表头
            insertNode(head, node);
        }
        else
        {
            // 得到之前被访问次数是1的最新节点
            ListNode latestNode = latestNodes.get(1);
            // 把当前节点插入到这个节点后面
            insertNode(latestNode, node);
        }
        // 更新被访问1次的节点的最新节点为当前节点
        latestNodes.put(1, node);
        // 把这个节点存入哈希表
        map.put(node.key, node);
    }
    
    public void insertNode(ListNode prev, ListNode cur) 
    {
        ListNode next = prev.next;
        cur.next = next;
        cur.prev = prev;
        prev.next = cur;
        next.prev = cur;
    }
    
    public void removeNode(ListNode node) 
    {
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
