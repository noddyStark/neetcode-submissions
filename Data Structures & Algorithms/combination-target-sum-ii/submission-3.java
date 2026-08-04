class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> currentSumList = new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>();
        int currentSum = 0;
        Arrays.sort(candidates);
        backtrack(candidates, target, currentSumList, result, currentSum, 0);

        return new ArrayList<>(result);
    }

    public void backtrack(int[] candidates, int target, List<Integer> currentSumList,
        Set<List<Integer>> result, int currentSum, int start) {

        if (currentSum == target) {
            result.add(new ArrayList<>(currentSumList));
            return;
        }

        if (currentSum > target || start >= candidates.length) {
            return;
        }

        currentSum += candidates[start];
        currentSumList.add(candidates[start]);
        backtrack(candidates, target, currentSumList, result, currentSum, start + 1);
        currentSum -= candidates[start];
        currentSumList.remove(currentSumList.size() - 1);

        // Exclude candidates[start] and all duplicate values.
        int nextStart = start + 1;

        while (nextStart < candidates.length &&
               candidates[nextStart] == candidates[start]) {
            nextStart++;
        }

        backtrack(candidates, target, currentSumList, result, currentSum, nextStart);
    }
}
