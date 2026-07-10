class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Set<String> set = new HashSet<>();

        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        for (int i = 0; i < tokens.length; i++) {
            String element = tokens[i];

            if (!set.contains(element)) {
                stack.push(element);
            } else {
                System.out.println("INITIAL stack = " + stack);

                if (element.equals("+") && !stack.isEmpty()) {
                    int first = Integer.valueOf(stack.pop());
                    System.out.println("FIRST = " + first  + " stack = " + stack);
                    if (!stack.isEmpty()) {
                        int second = Integer.valueOf(stack.pop());
                        first = first + second;
                    }
                    stack.push(String.valueOf(first));
                }
                System.out.println("+ stack = " + stack);

                if (element.equals("*") && !stack.isEmpty()) {
                    int first = Integer.valueOf(stack.pop());
                    if (!stack.isEmpty()) {
                        int second = Integer.valueOf(stack.pop());
                        first = first * second;
                    }
                    stack.push(String.valueOf(first));
                }

                System.out.println("* stack = " + stack);

                if (element.equals("-") && !stack.isEmpty()) {
                    int first = Integer.valueOf(stack.pop());
                    if (!stack.isEmpty()) {
                        int second = Integer.valueOf(stack.pop());
                        first = second - first;
                    }
                    stack.push(String.valueOf(first));
                }

                System.out.println("- stack = " + stack);

                if (element.equals("/") && !stack.isEmpty()) {
                    int first = Integer.valueOf(stack.pop());
                    if (!stack.isEmpty()) {
                        int second = Integer.valueOf(stack.pop());
                        first = second/first;
                    }
                    stack.push(String.valueOf(first));
                }

                System.out.println("/ stack = " + stack);
            }
        }

        return Integer.valueOf(stack.pop());
    }
}
