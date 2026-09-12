class Solution {
    public int numDecodings(String s) {
        //using rolling DP and fixed array
        int[] res = new int[s.length() + 1];
        // s[i] -> string index
        // dp[i] -> number of ways to decode the string from s[0..i-1]
        // 0 index -> empty string can be decode 1 way by doing nothing
        res[0] = 1;
        // 1st index -> if the first string char is a valid decodable value from "1"->"26"
        //              decode as 1
        res[1] = s.charAt(0) != '0' ? 1 : 0;

        //iterate from 2nd string char to the end
        for (int i = 2; i <= s.length(); i++){
            //get the actual substring -> s[i-1, ..i]
             int lastChar = Integer.parseInt(s.substring(i-1, i));
            // s[i-2, ...i]
             int lastTwoChar = Integer.parseInt(s.substring(i-2, i));
            //check for number of ways to decode previous char / chars
            //to formulate current number of ways to decode current char
            if (lastChar >= 1 && lastChar < 10){
              //currentstate = prevstate + prev char
              res[i] +=  res[i-1];
            }
            if (lastTwoChar >= 10 && lastTwoChar <= 26){
              //currentstate = prevstate + prev char
              res[i] +=  res[i-2];
            }            
        }

        return res[s.length()];
    }
}
