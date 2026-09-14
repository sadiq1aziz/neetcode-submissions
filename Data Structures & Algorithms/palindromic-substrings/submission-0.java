class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0){
             return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            count += checkPalindromicSubstring(i, i, s);
            count += checkPalindromicSubstring(i, i+1, s);
        }
        
        return count;
    }

    private int checkPalindromicSubstring(int start, int end, String s){
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            count++;
            start--;
            end++;
        }
        return count;
    }
}
