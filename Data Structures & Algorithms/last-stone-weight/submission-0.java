class Solution {
    public int lastStoneWeight(int[] stones) {
        // stones = [2,3,6,2,4]

        // cont till no more than 1 stone

        if (stones.length == 1) {
            return stones[0];
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> (b - a));

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // 2, 3, 6, 2, 4
        // 6, 4, 3, 2, 2

        while (!maxHeap.isEmpty()) { // 2, 2, 1
            int first = maxHeap.poll();
            int second = maxHeap.poll(); 

            int merged = Math.abs(first - second); // 0

            if (merged != 0) {
                maxHeap.offer(merged); // 1
            }

            if (maxHeap.size() == 0 || maxHeap.size() == 1) {
                break;
            }
        }

        return maxHeap.size() == 0 ? 0 : maxHeap.peek();
    }
}
