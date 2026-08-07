class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        backtrack(n, current, result);

        return result;
    }

    private void backtrack(int n, StringBuilder current, List<String> result) {

        if (current.length() == 2 * n) {
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