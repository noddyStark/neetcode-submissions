class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> hmap = new HashMap<>();
        int[] answer = new int[2];

        for (int i=0; i<nums.length; i++) {
            hmap.put(nums[i], i);
        }
        /*
        1 -> 0
        3 -> 1
        4 -> 2
        2 -> 3
        */

        for (int i=0; i<nums.length; i++) {
            int complement = target - nums[i];

            if (hmap.containsKey(complement) 
            && i != hmap.get(complement)) {
                answer[0] = i;
                answer[1] = hmap.get(complement);
                break;
            }
        }

        return answer;
    }
}
