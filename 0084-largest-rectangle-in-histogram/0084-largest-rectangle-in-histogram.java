class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxR = 0;
        Stack<int[]> stack = new Stack<>();
        int start = 0;

        for (int i = 0; i < heights.length; i++) {
            start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                int idx = top[0];
                int height = top[1];
                maxR = Math.max(maxR, height * (i - idx));
                start = idx;
            }
            stack.push(new int[] { start, heights[i] });

        }
        for (int[] pair : stack) {
            int idx = pair[0];
            int height = pair[1];
            maxR = Math.max(maxR, height * (heights.length - idx));
        }
        return maxR;

    }
}