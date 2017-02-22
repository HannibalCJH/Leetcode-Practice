// 双向链表节点定义
class ListNode
{
    int key;
    int val;
    ListNode prev;
    ListNode next;
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
    HashMap<Integer, ListNode> map;

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
        this.map = new HashMap<Integer, ListNode>();
    }
    
    // 时间复杂度O(1)，空间复杂度O(n)
    public int get(int key) 
    {
        // 键值存在
        if(map.containsKey(key))
        {
            ListNode cur = map.get(key);
            // 把访问过的节点移到表头
            moveToHead(cur);
            return cur.val;
        }
        else
            // 键值不存在则返回1
            return -1;
    }
    
    // 时间复杂度O(1)，空间复杂度O(n)
    public void put(int key, int value) 
    {
        // 键值存在
        if(map.containsKey(key))
        {
            ListNode node = map.get(key);
            // 更新键对应的值
            node.val = value;
            // 把访问过的节点移到表头
            moveToHead(node);
        }
        else
        {
            ListNode node = new ListNode(key, value);
            // 容量已经占满，删除末尾节点
            if(size == capacity)
                removeTail();
            else
                // 还有空位则现在节点个数加1
                size++;
            // 新节点加到表头
            addToHead(node);
            // 存入哈希表
            map.put(key, node);
        }
    }
    
    // 移除链表最后一个节点
    private void removeTail()
    {
        ListNode last = tail.prev;
        last.prev.next = tail;
        tail.prev = last.prev;
        map.remove(last.key);
    }
    
    // 将一个节点加到表头
    private void addToHead(ListNode node)
    {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    // 将一个在链表中存在的节点移动到表头
    private void moveToHead(ListNode node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addToHead(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
