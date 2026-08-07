class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();

        backtrack(s, result, current, 0);

        return result;
    }

    public void backtrack(String s, List<List<String>> result, List<String> current, int index) {
        if (index == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = index; end < s.length(); end++) {
            String substring = s.substring(index, end + 1);

            if (isPalindrome(substring)) {
                current.add(substring);

                backtrack(s, result, current, end + 1);

                current.remove(current.size() - 1);

            }
        }
    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
