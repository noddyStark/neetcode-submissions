class KthLargest {

    PriorityQueue<Integer> minHeap;
    int kthLargest;

    public KthLargest(int k, int[] nums) {
        this.kthLargest = k;
        this.minHeap = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);

        if (minHeap.size() > kthLargest) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
