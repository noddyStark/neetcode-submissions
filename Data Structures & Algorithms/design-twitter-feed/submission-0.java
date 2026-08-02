class Pair {
    int userId;
    int tweetId;
    long counter;

    public Pair(int userId, int tweetId, long counter) {
        this.userId = userId;
        this.tweetId = tweetId;
        this.counter = counter;
    }
}

class Twitter {

    // followerId -> users they follow
    private Map<Integer, Set<Integer>> userRelation;

    // Contains every tweet, newest tweet first
    private PriorityQueue<Pair> userAndTweets;

    private long counter;

    public Twitter() {
        userRelation = new HashMap<>();
        userAndTweets = new PriorityQueue<>((a, b) -> Long.compare(b.counter, a.counter));
        counter = 0;
    }

    public void postTweet(int userId, int tweetId) {
        Pair pair = new Pair(userId, tweetId, counter);
        userAndTweets.offer(pair);
        counter++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();

        Set<Integer> followees = userRelation.getOrDefault(userId, Collections.emptySet());

        // Temporarily store removed tweets so the heap can be restored.
        List<Pair> removedTweets = new ArrayList<>();

        while (!userAndTweets.isEmpty() && result.size() < 10) {
            Pair pair = userAndTweets.poll();
            removedTweets.add(pair);

            // Include the user's own tweets and tweets from followed users.
            if (pair.userId == userId || followees.contains(pair.userId)) {
                result.add(pair.tweetId);
            }
        }

        // Restore every removed tweet.
        userAndTweets.addAll(removedTweets);

        return result;
    }

    public void follow(int followerId, int followeeId) {
        // Following yourself is unnecessary because your own tweets are always included.
        if (followerId == followeeId) {
            return;
        }

        userRelation.computeIfAbsent(followerId, id -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = userRelation.get(followerId);

        if (followees != null) {
            followees.remove(followeeId);
        }
    }
}