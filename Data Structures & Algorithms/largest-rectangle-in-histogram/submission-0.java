class Solution {
    public int largestRectangleArea(int[] heights) {
        //use stack to track increasing order of height indices
        Stack<Integer> stack = new Stack<>();

        //res
        int maxArea = 0;

        //to process all bars, insert a zero at the end of the array
        int [] newArr = new int [heights.length + 1];
        for (int i = 0; i < heights.length; i++){
            newArr[i] = heights[i];
        }
        newArr[newArr.length - 1] = 0;

        //iterate through arr
        for (int i = 0; i < newArr.length; i++){
            while ( !stack.isEmpty() && (newArr[i] < newArr[stack.peek()])){
                int height = newArr[stack.pop()];
                int rightBoundary = i;
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                int width = rightBoundary - leftBoundary - 1;
                int area  = width*height;
                maxArea = Math.max(area, maxArea);
            }
            //push indices
            stack.push(i);
        }

        return maxArea;
    }
}
