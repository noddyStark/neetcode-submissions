class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> currentList = new ArrayList<>();
        backtrack(nums, result, currentList, 0);

        return new ArrayList<>(result);

    }

    public void backtrack(int[] nums, Set<List<Integer>> result, List<Integer> currentList, int start) {

        if (start >= nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        currentList.add(nums[start]);
        backtrack(nums, result, currentList, start + 1);
        currentList.removeLast();
        backtrack(nums, result, currentList, start + 1);
    }
}
