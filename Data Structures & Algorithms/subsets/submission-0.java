class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // 1, 2, 3
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, current, result);
        return result;
    }

    public void backtrack(
        int[] nums, 
        int start, 
        List<Integer> current, 
        List<List<Integer>> result) {
        if (start >= nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[start]);
        backtrack(nums, start + 1, current, result);
        current.remove(current.size() - 1);
        backtrack(nums, start + 1, current, result);
    }
}
