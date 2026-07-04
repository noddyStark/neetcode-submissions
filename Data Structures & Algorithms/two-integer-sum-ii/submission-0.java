class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // numbers is sorted and increasing

        int[] result = new int[2];

        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            System.out.println(
                "numbers[start] " + numbers[start] + " numbers[end] = " + numbers[end]);

            if (start != end && (numbers[start] + numbers[end] == target)) {
                result[0] = start+1;
                result[1] = end+1;
                return result;
            } 
             
            while (start < end && start != end && numbers[start] + numbers[end] > target) {
                end--;
            } 
            
            while (start < end && start != end && numbers[start] + numbers[end] < target) {
                start++;
            }

            System.out.println("After all lopps : numbers[start] " + numbers[start]
                + " numbers[end] = " + numbers[end]);
        }

        return result;
    }
}
