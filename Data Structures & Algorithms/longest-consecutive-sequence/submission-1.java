class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;

        for (int num : set) {

            int currentLength = 1;
            int currentNum = num;

            if (!set.contains(num - 1)) {
                
                while (set.contains(currentNum + 1)) {
                    currentLength = currentLength + 1;
                    currentNum = currentNum + 1;
                }

                maxLen = Math.max(maxLen, currentLength);
            }
        }

        return maxLen;
    }
}
