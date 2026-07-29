class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];

        PriorityQueue<Pair> minHeap =
            new PriorityQueue<>((a, b) -> (a.distanceFromOrigin - b.distanceFromOrigin));

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            int distance = x * x + y * y;

            minHeap.offer(new Pair(point, distance));
        }

        int index = 0;

        while (!minHeap.isEmpty() && index < k) {
            Pair pair = minHeap.poll();
            result[index] = pair.point;
            index++;
        }

        return result;
    }
}
class Pair {
    int[] point;
    int distanceFromOrigin;

    public Pair(int[] point, int distanceFromOrigin) {
        this.point = point;
        this.distanceFromOrigin = distanceFromOrigin;
    }
}
