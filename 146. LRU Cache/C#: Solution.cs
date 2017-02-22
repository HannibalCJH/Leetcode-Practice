// 双向链表节点定义
class ListNode
{
    public int key;
    public int val;
    public ListNode prev;
    public ListNode next;
    public ListNode(int key, int val)
    {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

public class LRUCache {
    ListNode head;
    ListNode tail;
    int size;
    int capacity;
    Dictionary<int, ListNode> map;
    
    public LRUCache(int capacity)
    {
        // head和tail只作为指针，不属于整个双向链表里的节点
        head = new ListNode(-1, 0);
        tail = new ListNode(-1, 0);
        head.next = tail;
        tail.prev = head;
        // 当前节点个数
        this.size = 0;
        // Cache的容量
        this.capacity = capacity;
        // 初始化哈希表
        this.map = new Dictionary<int, ListNode>();
    }
    
    // 时间复杂度O(1)，空间复杂度O(n)
    public int Get(int key) 
    {
        // 键值存在
        if(map.ContainsKey(key))
        {
            ListNode cur = map[key];
            // 把访问过的节点移到表头
            MoveToHead(cur);
            return cur.val;
        }
        else
            // 键值不存在则返回1
            return -1;
    }
    
    // 时间复杂度O(1)，空间复杂度O(n)
    public void Put(int key, int value) 
    {
        // 键值存在
        if(map.ContainsKey(key))
        {
            ListNode node = map[key];
            // 更新键对应的值
            node.val = value;
            // 把访问过的节点移到表头
            MoveToHead(node);
        }
        else
        {
            ListNode node = new ListNode(key, value);
            // 容量已经占满，删除末尾节点
            if(size == capacity)
                RemoveTail();
            else
                // 还有空位则现在节点个数加1
                size++;
            // 新节点加到表头
            AddToHead(node);
            // 存入哈希表
            map.Add(key, node);
        }    
    }
    
    // 移除链表最后一个节点
    private void RemoveTail()
    {
        ListNode last = tail.prev;
        last.prev.next = tail;
        tail.prev = last.prev;
        map.Remove(last.key);
    }
    
    // 将一个节点加到表头
    private void AddToHead(ListNode node)
    {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    // 将一个在链表中存在的节点移动到表头
    private void MoveToHead(ListNode node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        AddToHead(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.Get(key);
 * obj.Put(key,value);
 */
