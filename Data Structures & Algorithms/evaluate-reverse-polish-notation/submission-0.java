class Solution {
    public int evalRPN(String[] tokens) {
        HashMap<String, java.util.function.BiFunction<Integer, Integer, Integer>> m = new HashMap<>();
        m.put("+", (a, b) -> a+b);
        m.put("-", (a, b) -> a-b);
        m.put("/", (a, b) -> a/b);
        m.put("*", (a, b) -> a*b);
        Stack<Integer> s = new Stack();
        for (String str : tokens){
            if (!m.containsKey(str)){
                s.push(Integer.parseInt(str));
            } else {
                int b = s.pop();
                int a = s.pop();
                int res = m.get(str).apply(a, b);
                s.push(res);
            }
        }
        return s.pop();
    }
}
