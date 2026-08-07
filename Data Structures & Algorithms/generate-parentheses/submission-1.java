class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        // backtrack(n, new StringBuilder(), result);
        backtrack1(n, result, new StringBuilder(), 0, 0);


        return result;
    }

    public void backtrack1(int n, List<String> result, StringBuilder sb, int open, int close) {

        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append('(');
            // open = 0 => (
            // open = 1 => ((
            // open = 2 => (((
            backtrack1(n, result, sb, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(')');
            backtrack1(n, result, sb, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private void backtrack(int n, StringBuilder current, List<String> result) {

        if (current.length() == 2 * n) {
            // isValid = O(2n)
            if(isValid(current.toString())) {
                result.add(current.toString());
            }
            return;
        }

        current.append("(");
        backtrack(n, current, result);
        current.deleteCharAt(current.length() - 1);

        current.append(")");
        backtrack(n, current, result);
        current.deleteCharAt(current.length() - 1);
    }

    public boolean isValid(String s) {
        int counter = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                counter++;
            } else {
                counter--;
            }

            if (counter < 0) {
                return false;
            }
        }

        return counter == 0;
    }
}