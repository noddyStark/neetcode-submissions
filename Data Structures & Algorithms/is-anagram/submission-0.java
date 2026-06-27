class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> charToCount = new HashMap<>();

        for (char ch : s.toCharArray()) {
            charToCount.put(ch, charToCount.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            if(!charToCount.containsKey(ch)) {
                return false;
            } else {
                charToCount.put(ch, charToCount.get(ch) - 1);

                if (charToCount.get(ch) == 0) {
                    charToCount.remove(ch);
                }
            }
        }

        return charToCount.size() == 0;
    }
}
