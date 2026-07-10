class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 30,38,30,36,35,40,28
        // 1,4,1,2,1,0,0

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int currentTemp = temperatures[i];

            if (stack.isEmpty()) {
                stack.push(i);
            } else {

                if (currentTemp > temperatures[stack.peek()]) {
                    while (!stack.isEmpty() && currentTemp > temperatures[stack.peek()]) {
                    System.out.println("Index = " + i + " currentTemp = " + currentTemp + " top = " + temperatures[stack.peek()]);
                        result[stack.peek()] = i - stack.peek();
                        stack.pop();
                    }
                     stack.push(i);

                    System.out.println("Index = " + i + " stack = " + stack);
                } else {
                    stack.push(i);
                }
            }
        }

        /*

        // 30,38,30,36,35,40,28
        // 1,4,1,2,1,0,0

        i = 0
        stack.puhs(i)
        stack = [0]

        i = 1
        38 > 30
        int index = stack.pop();
        result[0] = 1 - 0;
        stack.push(i);
        stack = [1]

        i = 2
        30 < 38
        stack.push(i);
        stack = [1, 2]

        i = 3
        36 > 30
        int index = stack.pop(); // 2
        result[2] = 3 - 2 = 1
        stack.push(i);
        stack = [1, 3]

        i = 4
        35 < 36
        stack.push(i);
        stack = [1, 3, 4]

        i = 5
        40 > 35
        int index = stack.pop(); // 4
        result[4] = 5 - 4 = 1
        stack.puhs()
        */

        return result;
    }
}
