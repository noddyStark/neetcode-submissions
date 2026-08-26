class Solution {
    public int appendCharacters(String s, String t) {
        Deque<Character> queue = new ArrayDeque<>();

        for (char ch : t.toCharArray()) {
            queue.offerLast(ch);
        }

        for (int i = 0; i < s.length(); i++) {
            // Stop early if the queue is already empty
            if (queue.isEmpty()) {
                break;
            }
            char ch = s.charAt(i);

            if (ch == queue.peekFirst()) {
                queue.pollFirst();
            }
        }

        return queue.size();
    }
}