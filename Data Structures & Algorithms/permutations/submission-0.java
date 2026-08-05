class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> uniqueElemets = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();

        backtrack(nums, result, uniqueElemets, currList);

        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> result, Set<Integer> uniqueElemets, List<Integer> currList) {

        if (currList.size() == nums.length) {
            result.add(new ArrayList<>(currList));
            // result = [[1,2,3]]
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            // ele = 2

            if (uniqueElemets.contains(ele)) {
                continue;
            }

            uniqueElemets.add(ele);
            // uniqueElemets = [1]
            // uniqueElemets = [1, 2]
            // uniqueElemets = [1, 2, 3]
            currList.add(ele);
            // currList = [1]
            // currList = [1, 2]
            // currList = [1, 2, 3]

            backtrack(nums, result, uniqueElemets, currList);

            uniqueElemets.remove(ele);
            // uniqueElemets = [1, 2]
            currList.remove(currList.size() - 1);
            // currList = [1, 2]
        }
    }
}
