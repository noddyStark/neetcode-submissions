class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // a b c
        // l e [c a b] e e
        //      ^   ^

        int len_S1 = s1.length();
        int len_S2 = s2.length();

        if (len_S1 > len_S2) {
            return false;
        }

        int[] freqArray = new int[26];
        int[] freqWindow = new int[26];

        for (int i = 0; i < len_S1; i++) {
            freqArray[s1.charAt(i) - 'a']++;
            freqWindow[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(freqArray, freqWindow)) {
            return true;
        }

        for (int end = len_S1; end < len_S2; end++) {

            char newChar = s2.charAt(end);
            char oldChar = s2.charAt(end - len_S1);

            freqWindow[newChar - 'a']++;
            freqWindow[oldChar - 'a']--;

            if (Arrays.equals(freqArray, freqWindow)) {
                return true;
            }
        }

        return false;
    }
}
