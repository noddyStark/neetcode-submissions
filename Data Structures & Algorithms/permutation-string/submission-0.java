class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // a b c
        // l e [c a b] e e
        //      ^   ^

        int lenOfS1 = s1.length();
        int lenOfS2 = s2.length();

        if (lenOfS1 > lenOfS2) {
            return false;
        }

        HashMap<Character, Integer> mapOfS1 = new HashMap<>();
        HashMap<Character, Integer> mapOfS2 = new HashMap<>();

        for (int i = 0; i < lenOfS1; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            mapOfS1.put(ch1, mapOfS1.getOrDefault(ch1, 0) + 1);
            mapOfS2.put(ch2, mapOfS2.getOrDefault(ch2, 0) + 1);
        }

        if (mapOfS1.equals(mapOfS2)) {
            return true;
        }

        int start = 0;

        for (int end = lenOfS1; end < lenOfS2; end++) {
            char newChar = s2.charAt(end);
            mapOfS2.put(newChar, mapOfS2.getOrDefault(newChar, 0) + 1);

            char oldChar = s2.charAt(start);
            mapOfS2.put(oldChar, mapOfS2.get(oldChar) - 1);

            if (mapOfS2.get(oldChar) == 0) {
                mapOfS2.remove(oldChar);
            }

            start++;

            if (mapOfS1.equals(mapOfS2)) {
                return true;
            }
        }

        return false;
    }
}
