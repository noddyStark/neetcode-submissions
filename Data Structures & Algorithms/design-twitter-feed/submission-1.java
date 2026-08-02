
class Twitter {

    private static class Tweet {
        int tweetId;
        int timestamp;
        Tweet next;

        Tweet(int tweetId, int timestamp, Tweet next) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
            this.next = next;
        }
    }

    // userId -> newest tweet posted by that user
    private Map<Integer, Tweet> userTweets;

    // followerId -> set of followee IDs
    private Map<Integer, Set<Integer>> userRelations;

    private int timestamp;

    public Twitter() {
        userTweets = new HashMap<>();
        userRelations = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        Tweet currentHead = userTweets.get(userId);

        Tweet newTweet = new Tweet(
            tweetId,
            timestamp++,
            currentHead
        );

        // New tweet becomes the head of this user's tweet list.
        userTweets.put(userId, newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();

        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.timestamp, a.timestamp)
        );

        // Add the user's newest tweet.
        if (userTweets.containsKey(userId)) {
            maxHeap.offer(userTweets.get(userId));
        }

        // Add the newest tweet from every followed user.
        Set<Integer> followees =
            userRelations.getOrDefault(userId, Collections.emptySet());

        for (int followeeId : followees) {
            Tweet latestTweet = userTweets.get(followeeId);

            if (latestTweet != null) {
                maxHeap.offer(latestTweet);
            }
        }

        // Merge the sorted tweet lists.
        while (!maxHeap.isEmpty() && result.size() < 10) {
            Tweet newestTweet = maxHeap.poll();

            result.add(newestTweet.tweetId);

            // Add the next older tweet from the same user.
            if (newestTweet.next != null) {
                maxHeap.offer(newestTweet.next);
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        userRelations
            .computeIfAbsent(followerId, id -> new HashSet<>())
            .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = userRelations.get(followerId);

        if (followees != null) {
            followees.remove(followeeId);
        }
    }
}