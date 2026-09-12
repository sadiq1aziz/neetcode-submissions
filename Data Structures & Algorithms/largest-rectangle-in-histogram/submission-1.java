class Solution {
    public int largestRectangleArea(int[] heights) {
        
        //increasing order of height indices
        Stack <Integer> stack = new Stack<>();

        //process each height for which we have a zero added
        int [] inp = new int[heights.length+1];
        for (int i = 0; i < heights.length; i++){
            inp[i] = heights[i];
        }

        int maxArea = 0;

        for (int i = 0; i < inp.length; i++){

            //flesh out left and right bounds
            //find the element smaller than the max height of the stack
            while (!stack.isEmpty() && inp[i] < inp[stack.peek()]){
                int height = inp[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;
                int diff = right - left - 1;
                int area = diff*height;
                maxArea = Math.max(area, maxArea);
            }

            stack.push(i);
        }

        return maxArea;

    }
}
