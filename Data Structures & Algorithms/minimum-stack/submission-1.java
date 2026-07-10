class MinStack {

    ArrayList<Integer> aList;
    Deque<Integer> dq;

    public MinStack() {
        aList = new ArrayList<>();
        dq = new ArrayDeque<>();
    }

    public void push(int val) {
        aList.add(val);

        // Store every new minimum, including duplicates
        if (dq.isEmpty() || val <= dq.peekLast()) {
            dq.offerLast(val);
        }
    }

    public void pop() {
        int element = aList.remove(aList.size() - 1);

        // Remove from minimum history only when the popped value
        // is the current minimum
        if (element == dq.peekLast()) {
            dq.pollLast();
        }
    }

    public int top() {
        return aList.get(aList.size() - 1);
    }

    public int getMin() {
        return dq.peekLast();
    }
}