class Solution {
    public String minWindow(String s, String t) {
        /*
        X -> 1
        Y -> 1
        Z -> 1
        */

        if (s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> targetMap = new HashMap<>();

        for (char ch : t.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        int start = 0;
        int minLength = Integer.MAX_VALUE;
        Map<Character, Integer> windowMap = new HashMap<>();
        String ans = "";

        // O U Z O D Y X A Z V
        // X Y Z
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);

            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

            while (containsAllCharacters(windowMap, targetMap)) {
                int len = end - start + 1;

                if (len < minLength) {
                    minLength = len;
                    ans = s.substring(start, end + 1);
                }

                char startChar = s.charAt(start);

                windowMap.put(startChar, windowMap.get(startChar) - 1);

                if (windowMap.get(startChar) == 0) {
                    windowMap.remove(startChar);
                }

                start++;
            }
        }

        return ans;
    }

    public boolean containsAllCharacters(
        Map<Character, Integer> windowMap, Map<Character, Integer> targetMap) {
        for (char ch : targetMap.keySet()) {
            if (windowMap.getOrDefault(ch, 0) < targetMap.get(ch)) {
                return false;
            }
        }

        return true;
    }
}
