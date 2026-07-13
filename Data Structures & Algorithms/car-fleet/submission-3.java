/*
--------c1---------------c2-----------------target---
--------s1---------------s2--------------------------

position = [4,1,0,7], speed = [2,2,1,1]

(4,2) ,(1,2), (0,1), (7,1)

        4   6   8   10
  1   3   5   7   9 10
0 1 2 3 4 5 6 7 8 9 10
              7 8 9 10

*/

class Solution {
    class Pair {
        int carPosition;
        int carSpeed;

        public Pair(int carPosition, int carSpeed) {
            this.carPosition = carPosition;
            this.carSpeed = carSpeed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        Pair[] carPosAndSpeed = new Pair[position.length];

        for (int i = 0; i < position.length; i++) {
            int pos = position[i];
            int spe = speed[i];

            carPosAndSpeed[i] = new Pair(pos, spe);
        }

        // Sort from the car closest to the target
        // to the car farthest from the target.
        Arrays.sort(carPosAndSpeed, (car1, car2) -> Integer.compare(car2.carPosition, car1.carPosition));

        // (4,2) ,(1,2), (0,1), (7,1)

        // after sorting => (7,1), (4,2) ,(1,2), (0,1)

        Stack<Double> stack = new Stack<>();

        for (Pair car : carPosAndSpeed) {
            double timeToReach = (double)(target - car.carPosition) / car.carSpeed;

            // First car always creates a fleet
            if (stack.isEmpty()) {
                stack.push(timeToReach);
                continue;
            }

            if (timeToReach <= stack.peek()) {
                continue;
            }

            if (timeToReach > stack.peek()) {
                stack.push(timeToReach);
            }
        }

        return stack.size();
    }
}
