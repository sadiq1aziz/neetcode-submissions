class Solution {

    public String encode(List<String> strs) {
        //this problem will be using a delimiter approach to 
        //encode each string wherein before the delimiter, we have the 
        //length of each string item and after the actual string
        StringBuilder sb = new StringBuilder();
        for (String str : strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        //res
        List<String> res = new ArrayList<>();
        //use custom pointers to iterate through the string
        int i = 0;
        while (i < str.length()){
            int j = i;
            while ( str.charAt(j) != '#'){
                j++;
            }
            //get the length
            int length = Integer.parseInt(str.substring(i, j));
            //get the string using the length post delimiter
            String word = str.substring(j+1, j+1+length);
            //add to res
            res.add(word);
            //update the pointer to move ahead of the word to check for next sequence
            i = j+1+length;            
        }
        return res;
    }
}
