class Solution {
    public List<String> generateParenthesis(int n) {
        //create a String Buffer 
        StringBuffer sb = new StringBuffer();

        //create a res
        List<String> res = new ArrayList<>();

        //create dfs function to recursively generate strings
        dfs(0, 0, sb, res, n);
        return res;
    }

    private void dfs(int open, int close, StringBuffer sb, List<String> res, int n){
        //check base condition
        if (n*2 == sb.length()){
            res.add(sb.toString());
            return;
        }

        //check for open braces count
        if (open < n){
            sb.append("(");
            dfs(open+1, close, sb, res, n);
            //backtrack
            sb.deleteCharAt(sb.length() - 1);
        }

        //check for closing braces count
        if(close < open){
            sb.append(")");
            dfs(open, close+1, sb, res, n);    
            //backtrack
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
