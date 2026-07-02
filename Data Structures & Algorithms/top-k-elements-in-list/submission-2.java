class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        /*
        1 -> 3
        2 -> 2
        3 -> 1
        */

        System.out.println("map = " + map);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            pq.add(new int[] {value, key});
            // System.out.println("key = " + key + " value = " + value);
        }
        pq.forEach(arr -> System.out.println(arr[0] + ", " + arr[1]));

        int j = 0;
        int[] result = new int[k];

        while (!pq.isEmpty() && j < k) {
            int[] temp = pq.poll();
            System.out.println("key = " + temp[1] + " value = " + temp[0]);
            result[j] = temp[1];
            j++;
        }

        return result;
    }
}
