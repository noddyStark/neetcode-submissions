class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // speed = 2
        // 0, 4, 3, 2 at hour 1
        // 0, 2, 3, 2 at hour 2
        // 0, 0, 3, 2 at hour 3
        // 0, 0, 1, 2 at hour 4
        // 0, 0, 0, 2 at hour 5
        // 0, 0, 0, 0 at hour 6

        int maxSpeedOfEatingBananas = 0;
        int minSpeedToEatAll = Integer.MAX_VALUE;

        for (int pile : piles) {
            maxSpeedOfEatingBananas = Math.max(maxSpeedOfEatingBananas, pile);
        }

        /*
        arr = [1 2 3 4]
               0 1 2 3

        low = 0
        high = 3
        mid = 1
        */

        return getMinimumSpeed(piles, 1, maxSpeedOfEatingBananas, h, minSpeedToEatAll);
    }

    public int getMinimumSpeed(int[] piles, int low, int high, int h, int minSpeedToEatAll) {

        if (low > high) {
            return minSpeedToEatAll;
        }

        int mid = low + (high - low) / 2;

        int timeTaken = getTotalTimeToEat(piles, mid);

        if (timeTaken > h) {
            // speed is too slow
            return getMinimumSpeed(piles, mid + 1, high, h, minSpeedToEatAll);
        } else {
            // This speed works, but maybe a smaller speed also works
            minSpeedToEatAll = Math.min(minSpeedToEatAll, mid);
            return getMinimumSpeed(piles, low, mid - 1, h, minSpeedToEatAll);
        }
    }

    public int getTotalTimeToEat(int[] piles, int speed) {
        int timeTaken = 0;

        for (int i = 0; i < piles.length; i++) {
            int dividend = piles[i] / speed;
            int remainder = piles[i] % speed;

            if (remainder == 0) {
                timeTaken += dividend;
            } else {
                timeTaken += dividend + 1;
            }
        }

        return timeTaken;
    }
}
