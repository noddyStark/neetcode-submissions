class Solution {
    public boolean isValid(String s) {
        /*

        ) -> (
        ] -> [
        } -> {


        |  |
        |  |
        |  |
        |__|

        ([{

        */

        if (s.length() == 1) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                // ch == } || ) || ]
                char mappingBracket = map.get(ch);

                if (!stack.isEmpty()) {
                    char lastPush = stack.peek();

                    if (lastPush == mappingBracket) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
