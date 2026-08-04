class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(nums, target, 0, 0, current, result);

        return result;
    }

    private void backtrack(int[] nums, int target, int currSum, int start, List<Integer> current,
        List<List<Integer>> result) {

        // Found a valid combination.
        if (currSum == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Sum is too large or no numbers remain.
        if (currSum > target || start == nums.length) {
            return;
        }

        /*
                       start
                         ↓
        nums = [2, 5, 6, 9]

                    current
                      []
                    /    \
             take 2      skip 2
               [2]          []
              start=0      start=1
        */

        // Choice 1: include nums[start].
        // Keep start unchanged because the number can be reused.
        current.add(nums[start]);
        currSum += nums[start];

        backtrack(nums, target, currSum, start, current, result);

        // Undo the choice.
        current.remove(current.size() - 1);
        currSum -= nums[start];

        // Choice 2: skip nums[start].
        backtrack(nums, target, currSum, start + 1, current, result);
    }
}