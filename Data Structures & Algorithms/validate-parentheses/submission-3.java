class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char [] str = s.toCharArray();
        Map<Character, Character> m = new HashMap<>();
        m.put('(', ')');
        m.put('{', '}');
        m.put('[', ']');

        for (Character st : str){
            if (m.containsKey(st)){
                stack.push(st);
            } else {
                if (stack.isEmpty() || !m.get(stack.peek()).equals(st)){
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
