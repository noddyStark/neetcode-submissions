class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> charCount = new HashMap<>();
        int maxFreq = 0;
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, charCount.get(ch));

            /*
            end - start + 1 -> gives me the length of the substring till now
            maxFreq -> is the maximum frequency of one of the character till now

            so if I substract the length of the substring till now and maxFreq, if the output of 
            (end - start + 1) - (maxFreq) > if this result is greater than k, that means our window has become invalid
            because we are only allowed to do at most k replacements, and if this value is greater than k. that means
            we can not do replacements for those substring.
            " A A A B A B B"
              0 1 2 3 4 5 6

            */

            while (end - start + 1 - maxFreq > k) {
                char leftChar = s.charAt(start);
                charCount.put(leftChar, charCount.get(leftChar) - 1);

                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
