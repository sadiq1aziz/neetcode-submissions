class Solution {
    public boolean isValid(String s) {
        //split the input
        char [] arr = s.toCharArray();

        //create map and store the input
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        //create stack
        Stack<Character> stack = new Stack<>();
        //iterate through the arr and push opening braces to stack

        for (int i = 0; i < arr.length; i++){
            if (map.containsKey(arr[i])){
                stack.push(arr[i]);
            } else {
                if (stack.isEmpty() || !map.get(stack.peek()).equals(arr[i])){
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
