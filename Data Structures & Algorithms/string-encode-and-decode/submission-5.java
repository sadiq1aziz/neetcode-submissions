class Solution {

    public String encode(List<String> strs) {
        StringBuffer sb  = new StringBuffer();
        for (String str : strs){
            sb.append(str.length()).append(";").append(str);
        }
        return sb.toString();

    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int left = 0;
        for (int right = 0; right < str.length(); right++){
            char c = str.charAt(right);
            if (c == ';'){
                //excludes right index so actually includes right - 1
                String len = str.substring(left, right);
                int lenNum = Integer.parseInt(len);
                String word = str.substring(right + 1, right + 1 + lenNum);
                res.add(word);
                left = right + 1 + lenNum;
            }
        }
        return res;
    }
}
