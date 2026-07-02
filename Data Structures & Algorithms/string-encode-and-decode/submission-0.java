class Solution {
    HashMap<Integer, List<Character>> map = new HashMap<>();

    int MODULO = 256;

    public String encode(List<String> strs) {
        // "Hello","World"
        // return someString
        // 100

        StringBuilder encodedString = new StringBuilder();

        for (int i = 0; i < strs.size(); i++) {
            String s = strs.get(i);

            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                int hashValue = (int) ch;

                encodedString.append(hashValue);
                encodedString.append(",");
            }

            // marks end of one string
            encodedString.append("#");
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        // 72,101,108,108,111#87,111,114,108,100
        int i = 0;

        while (i < str.length()) {
            // end of one original string
            if (str.charAt(i) == '#') {
                result.add(sb.toString());
                sb = new StringBuilder();
                i++;
            } else {
                int value = 0;

                // read full number until comma
                while (i < str.length() && str.charAt(i) != ',') {
                    value = value * 10 + (str.charAt(i) - '0');
                    i++;
                }

                // skip comma
                i++;

                sb.append((char) value);
            }
        }

        return result;
    }
}

/*
    H -> 72         W -> 87
    e -> 101        o -> 111
    l -> 108        r -> 114
    l -> 108        l -> 108
    o -> 111        d -> 100

Map => {
    72 -> [H]
    101 -> [e]
    108 -> [l,l, 108]
    111 -> [o, o]
    87 -> [W]
    114 -> [r]
    100 -> [d]
}

EncodedString = "72, 101, 108, 108, 111, 87, 111, 114, 108, 100"
*/
