class Solution {

    public String encode(List<String> strs) {
       //iterate through string array
       //use string builder 
       StringBuilder sb = new StringBuilder();
       for (String s : strs){
            sb.append(s.length()).append("#").append(s);
       }
       return sb.toString();
    }

    public List<String> decode(String str) {
       List<String> res = new ArrayList<>();

       //use two pointers to track before and after hash
       int i = 0;
       while (i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            String word = str.substring(j+1, j+length+1);
            res.add(word);
            i = j+length+1;
       }
       return res;
    }
}
