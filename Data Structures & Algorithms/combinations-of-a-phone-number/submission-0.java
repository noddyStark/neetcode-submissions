/*
        3 -> def
        4 -> ghi

                        []
                      /    \
    {d,e,f} [d]      3      4
                  / | \
                 g  h  i
*/
class Solution {
    HashMap<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        backtrack(digits, result, 0, new StringBuilder());
        return result;
    }

    public void backtrack(String digits, List<String> result, int index, StringBuilder sb) {

        if (digits.length() == 0) {
            return;
        }
        
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String alphabets = map.get(digits.charAt(index));
        index++;

        for (int i = 0; i < alphabets.length(); i++) {
            char ch = alphabets.charAt(i);

            sb.append(ch);

            backtrack(digits, result, index, sb);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
