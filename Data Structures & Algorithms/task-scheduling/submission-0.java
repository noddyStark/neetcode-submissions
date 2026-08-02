class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequency = new int[26];

        for (char ch : tasks) {
            frequency[ch - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));

        for (int count : frequency) {
            if (count > 0) {
                maxHeap.offer(count);
            }
        }

        int totalCycles = 0;

        while (!maxHeap.isEmpty()) {
            // Store tasks used during the current cooldown window.
            List<Integer> remainingTasks = new ArrayList<>();

            int tasksExecuted = 0;

            // One cooldown window has n + 1 positions.
            for (int i = 0; i < n + 1 && !maxHeap.isEmpty(); i++) {
                int count = maxHeap.poll();
                count--;

                if (count > 0) {
                    remainingTasks.add(count);
                }

                tasksExecuted++;
            }

            // Add used tasks back after the cooldown window.
            for (int count : remainingTasks) {
                maxHeap.offer(count);
            }

            if (maxHeap.isEmpty()) {
                // No more tasks remain, so no trailing idle time is needed.
                totalCycles += tasksExecuted;
            } else {
                // Tasks remain, so this entire window is used,
                // including any idle positions.
                totalCycles += n + 1;
            }
        }
        return totalCycles;
    }
}
