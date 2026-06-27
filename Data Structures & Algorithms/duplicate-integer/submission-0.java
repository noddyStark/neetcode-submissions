class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        
        for (int num : nums){
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            int value = entry.getValue();

            if (value > 1) {
                return true;
            }
        }

        return false;
    }
}