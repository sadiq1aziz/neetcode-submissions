class Solution {

    public String encode(List<String> strs) {
     StringBuilder sb = new StringBuilder();
     for (String s : strs){
        sb.append(s.length()).append(";").append(s);
     }
     return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int pointer = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ';'){
                String len = str.substring(pointer, i);
                int val = Integer.parseInt(len);
                String word = str.substring(i+1, i+val+1);
                //update pointer to target next word length
                pointer = i+val+1;
                //store word
                res.add(word);
            }
        }
        return res;
    }
}
  