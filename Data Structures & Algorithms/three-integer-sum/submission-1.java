class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        // -1,0,1,2,-1,-4
        // -4, -1, -1, 0, 1, 2

        for (int i = 0; i < nums.length-2; i++) {
            int first = nums[i];

            int target = -first;

            int start = i + 1;
            int end = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (start < end) {

                int sum = nums[start] + nums[end];

                if (sum == target) {
                    int num1 = first;
                    int num2 = nums[start];
                    int num3 = nums[end];

                    result.add(Arrays.asList(num1, num2, num3));
                    start++;
                    end--;

                    while (start < end && nums[start - 1] == nums[start]) {
                        start++;
                    }

                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }
}
