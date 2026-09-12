class Solution {

    private StringBuffer sb = new StringBuffer();
    
    public String encode(List<String> strs) {
        for (String s : strs){
            var wordLen = s.length();
            sb.append(wordLen).append(';').append(s);    
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int l = 0;
        List<String> res = new ArrayList<>();
        for (int r = 0; r < str.length(); r++){
            char cr = str.charAt(r);
            if (cr == ';'){
                String wordLength = str.substring(l, r);
                int len = Integer.parseInt(wordLength);
                String word = str.substring(r+1, r+len+1);
                res.add(word);
                l = r+len+1;
                r = l-1;
            }
        }
        return res;
    }
}
