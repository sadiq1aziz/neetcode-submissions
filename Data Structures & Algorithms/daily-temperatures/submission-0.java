class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //create a stack to keep track of inceasing indices

        Stack<Integer> stack = new Stack<>();

        //create a res array to keep track of number of days till warmer temp
        int [] res = new int[temperatures.length];
        Arrays.fill(res, 0);

        //iterate through the damn temps
        for (int i = 0; i < temperatures.length; i++){
            //pop off stack if we encounter warmer temp
            //compare top of stack with current temp
            while( !stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int day = stack.pop();
                int numberOfDaysForTempIncrease = i - day;
                res[day] = numberOfDaysForTempIncrease;
            }
            stack.push(i);
        }
        return res;

    }
}
