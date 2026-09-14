class Solution {
    public String longestPalindrome(String s) {
         if (s.length() == 0)return "";
         String longestPalindromicSubstring = "";
         for (int i = 0; i < s.length(); i++){ 
                String evenPalindromicSubstring = getPalindromicSubstring(i, i+1, s);
                String oddPalindromicSubstring = getPalindromicSubstring(i, i, s);
                int evenLen = evenPalindromicSubstring.length();
                int oddLen = oddPalindromicSubstring.length();
                if (evenLen >= longestPalindromicSubstring.length()){
                    longestPalindromicSubstring = evenPalindromicSubstring;
                }
                if (oddLen >= longestPalindromicSubstring.length()){
                    longestPalindromicSubstring = oddPalindromicSubstring;
                }
         }
         return longestPalindromicSubstring;
    }

    private String getPalindromicSubstring(int start, int end, String s){
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start+1, end);
    }
}
