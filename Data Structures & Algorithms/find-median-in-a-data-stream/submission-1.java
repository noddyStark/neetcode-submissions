class MedianFinder {
    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        Collections.sort(list);

        int size = list.size();

        if (size % 2 == 0) {
            int mid1 = size / 2 - 1;
            int mid2 = size / 2;

            return ((long) list.get(mid1) + list.get(mid2)) / 2.0;
        }

        return list.get(size / 2);
    }
}