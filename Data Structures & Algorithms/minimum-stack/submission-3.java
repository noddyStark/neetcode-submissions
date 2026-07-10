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
        System.out.println("dq = " + dq);
    }
    
    public void pop() {
        int element = aList.remove(aList.size() - 1);
        
        // Remove from minimum history only when the popped value
        // is the current minimum
        if (dq.peekLast() == element) {
            dq.pollLast();
        }
    }
    
    public int top() {
        int top = aList.get(aList.size() - 1);
        return top;
    }
    
    public int getMin() {
        return dq.peekLast();
    }
}
