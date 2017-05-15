public class MedianFinder {
    // 大顶堆保存数据流较小的一半
    PriorityQueue<Integer> maxHeap;
    // 小顶堆保存数据流较大的一半
    PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public MedianFinder() 
    {
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }
    
    // 时间复杂度O(logn)，空间复杂度O(n)
    public void addNum(int num) 
    {
        // 把加进来的数先放入较大的一半并自动排序
        minHeap.offer(num);
        // 堆顶是这一半较大数中的最小的数
        int min = minHeap.poll();
        // 把堆顶加入较小的一半并自动排序
        maxHeap.offer(min);
        // 检查两个堆的大小，保证较大的一半的个数大于等于较小的一半
        if(maxHeap.size() > minHeap.size())
        {
            minHeap.offer(maxHeap.poll());
        }
    }
    
    // 时间复杂度O(1)，空间复杂度O(n)
    public double findMedian() 
    {
        // 偶数个的情况，中位数为两个堆顶除以2
        if(maxHeap.size() == minHeap.size())
        {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        else
        {
            // 奇数个情况，因为我们控制较大的一半的个数大于等于较小的一半，所以中位数是较大一半的最小的数 
            return minHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
