class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hmap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            int[] array = new int[26];

            String current = strs[i];

            for (int k = 0; k < current.length(); k++) {
                char ch = current.charAt(k);
                array[ch - 'a']++;
            }

            String key = Arrays.toString(array);
            hmap.computeIfAbsent(key, k -> new ArrayList<>()).add(current);
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : hmap.entrySet()) {
            List<String> value = entry.getValue();
            result.add(value);
        }

        return result;
    }
}
