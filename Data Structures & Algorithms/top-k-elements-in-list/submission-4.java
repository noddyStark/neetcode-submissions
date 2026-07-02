class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        /*
        1 -> 3
        2 -> 2
        3 -> 1
        */

        List<List<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int freq = entry.getValue();
            int key = entry.getKey();

            buckets.get(freq).add(key);
        }

        /*
        1 -> [1]
        2 -> [2]
        3 -> [3]
        */

        int[] result = new int[k];
        int count = 0;

        for (int freq = buckets.size() - 1; freq >= 0; freq--) {
            List<Integer> numsWithSameFreq = buckets.get(freq);

            for (int num : numsWithSameFreq) {
                result[count] = num;
                count++;

                if (count == k) {
                    return result;
                }
            }
        }

        return result;
    }
}
