class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(nums, target, 0, 0, current, result);

        return result;
    }

    private void backtrack(int[] nums, int target, int currSum, int start, List<Integer> current,
        List<List<Integer>> result) {

        // Found a valid combination.
        if (currSum == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Sum is too large or no numbers remain.
        if (currSum > target || start == nums.length) {
            return;
        }

        /*
ROOT: [], sum=0, start=0

├── take 2: [2], sum=2, start=0
│   │
│   ├── take 2: [2,2], sum=4, start=0
│   │   │
│   │   ├── take 2: [2,2,2], sum=6, start=0
│   │   │   │
│   │   │   ├── take 2: [2,2,2,2], sum=8, start=0
│   │   │   │   │
│   │   │   │   ├── take 2: [2,2,2,2,2], sum=10
│   │   │   │   │   └── ❌ sum > 9
│   │   │   │   │
│   │   │   │   └── skip 2: [2,2,2,2], sum=8, start=1
│   │   │   │       │
│   │   │   │       ├── take 5: [2,2,2,2,5], sum=13
│   │   │   │       │   └── ❌ sum > 9
│   │   │   │       │
│   │   │   │       └── skip 5: [2,2,2,2], sum=8, start=2
│   │   │   │           │
│   │   │   │           ├── take 6: [2,2,2,2,6], sum=14
│   │   │   │           │   └── ❌ sum > 9
│   │   │   │           │
│   │   │   │           └── skip 6: [2,2,2,2], sum=8, start=3
│   │   │   │               │
│   │   │   │               ├── take 9: [2,2,2,2,9], sum=17
│   │   │   │               │   └── ❌ sum > 9
│   │   │   │               │
│   │   │   │               └── skip 9: [2,2,2,2], sum=8, start=4
│   │   │   │                   └── ❌ no candidates left
│   │   │   │
│   │   │   └── skip 2: [2,2,2], sum=6, start=1
│   │   │       │
│   │   │       ├── take 5: [2,2,2,5], sum=11
│   │   │       │   └── ❌ sum > 9
│   │   │       │
│   │   │       └── skip 5: [2,2,2], sum=6, start=2
│   │   │           │
│   │   │           ├── take 6: [2,2,2,6], sum=12
│   │   │           │   └── ❌ sum > 9
│   │   │           │
│   │   │           └── skip 6: [2,2,2], sum=6, start=3
│   │   │               │
│   │   │               ├── take 9: [2,2,2,9], sum=15
│   │   │               │   └── ❌ sum > 9
│   │   │               │
│   │   │               └── skip 9: [2,2,2], sum=6, start=4
│   │   │                   └── ❌ no candidates left
│   │   │
│   │   └── skip 2: [2,2], sum=4, start=1
│   │       │
│   │       ├── take 5: [2,2,5], sum=9
│   │       │   └── ✅ valid combination
│   │       │
│   │       └── skip 5: [2,2], sum=4, start=2
│   │           │
│   │           ├── take 6: [2,2,6], sum=10
│   │           │   └── ❌ sum > 9
│   │           │
│   │           └── skip 6: [2,2], sum=4, start=3
│   │               │
│   │               ├── take 9: [2,2,9], sum=13
│   │               │   └── ❌ sum > 9
│   │               │
│   │               └── skip 9: [2,2], sum=4, start=4
│   │                   └── ❌ no candidates left
│   │
│   └── skip 2: [2], sum=2, start=1
│       │
│       ├── take 5: [2,5], sum=7, start=1
│       │   │
│       │   ├── take 5: [2,5,5], sum=12
│       │   │   └── ❌ sum > 9
│       │   │
│       │   └── skip 5: [2,5], sum=7, start=2
│       │       │
│       │       ├── take 6: [2,5,6], sum=13
│       │       │   └── ❌ sum > 9
│       │       │
│       │       └── skip 6: [2,5], sum=7, start=3
│       │           │
│       │           ├── take 9: [2,5,9], sum=16
│       │           │   └── ❌ sum > 9
│       │           │
│       │           └── skip 9: [2,5], sum=7, start=4
│       │               └── ❌ no candidates left
│       │
│       └── skip 5: [2], sum=2, start=2
│           │
│           ├── take 6: [2,6], sum=8, start=2
│           │   │
│           │   ├── take 6: [2,6,6], sum=14
│           │   │   └── ❌ sum > 9
│           │   │
│           │   └── skip 6: [2,6], sum=8, start=3
│           │       │
│           │       ├── take 9: [2,6,9], sum=17
│           │       │   └── ❌ sum > 9
│           │       │
│           │       └── skip 9: [2,6], sum=8, start=4
│           │           └── ❌ no candidates left
│           │
│           └── skip 6: [2], sum=2, start=3
│               │
│               ├── take 9: [2,9], sum=11
│               │   └── ❌ sum > 9
│               │
│               └── skip 9: [2], sum=2, start=4
│                   └── ❌ no candidates left
│
└── skip 2: [], sum=0, start=1
    │
    ├── take 5: [5], sum=5, start=1
    │   │
    │   ├── take 5: [5,5], sum=10
    │   │   └── ❌ sum > 9
    │   │
    │   └── skip 5: [5], sum=5, start=2
    │       │
    │       ├── take 6: [5,6], sum=11
    │       │   └── ❌ sum > 9
    │       │
    │       └── skip 6: [5], sum=5, start=3
    │           │
    │           ├── take 9: [5,9], sum=14
    │           │   └── ❌ sum > 9
    │           │
    │           └── skip 9: [5], sum=5, start=4
    │               └── ❌ no candidates left
    │
    └── skip 5: [], sum=0, start=2
        │
        ├── take 6: [6], sum=6, start=2
        │   │
        │   ├── take 6: [6,6], sum=12
        │   │   └── ❌ sum > 9
        │   │
        │   └── skip 6: [6], sum=6, start=3
        │       │
        │       ├── take 9: [6,9], sum=15
        │       │   └── ❌ sum > 9
        │       │
        │       └── skip 9: [6], sum=6, start=4
        │           └── ❌ no candidates left
        │
        └── skip 6: [], sum=0, start=3
            │
            ├── take 9: [9], sum=9
            │   └── ✅ valid combination
            │
            └── skip 9: [], sum=0, start=4
                └── ❌ no candidates left
        */

        // Choice 1: include nums[start].
        // Keep start unchanged because the number can be reused.
        current.add(nums[start]);
        currSum += nums[start];

        backtrack(nums, target, currSum, start, current, result);

        // Undo the choice.
        current.remove(current.size() - 1);
        currSum -= nums[start];

        // Choice 2: skip nums[start].
        backtrack(nums, target, currSum, start + 1, current, result);
    }
}