
// multiple values for the same key
// can store different value for different timeStamp for the same key
/*

K -> V1 T1
K -> V2 T2

*/

class Pair {
    int timeStamp;
    String value;

    public Pair(int timeStamp, String value) {
        this.timeStamp = timeStamp;
        this.value = value;
    }
}

class TimeMap {
    HashMap<String, List<Pair>> mapOfKeyToValue;

    public TimeMap() {
        mapOfKeyToValue = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!mapOfKeyToValue.containsKey(key)) {
            mapOfKeyToValue.put(key, new ArrayList<>());
        }

        mapOfKeyToValue.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!mapOfKeyToValue.containsKey(key)) {
            return "";
        }

        List<Pair> existingPairs = mapOfKeyToValue.get(key);

        int start = 0;
        int end = existingPairs.size() - 1;

        String result = "";

        while (start <= end) {
            int mid = start + (end - start) / 2;

            Pair currentPair = existingPairs.get(mid);

            if (currentPair.timeStamp == timestamp) {
                return currentPair.value;
            }

            if (currentPair.timeStamp < timestamp) {
                // This is a valid answer, but there may be a later
                // timestamp that is still <= the requested timestamp.
                result = currentPair.value;
                start = mid + 1;
            } else {
                // current timestamp is too large.
                end = mid - 1;
            }
        }

        return result;
    }
}
