class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int maxLength = 0;
        HashMap<Character, Integer> m = new HashMap<>();
        for (int r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            m.merge(c, 1, Integer::sum);
            int len = 0;
            while (l < r && m.get(c) > 1){
                char ch = s.charAt(l);
                m.computeIfPresent(ch, (k, v) -> v > 0 ? v - 1 : null);
                l++;
            }
            len = r - l + 1;
            maxLength = Math.max(len, maxLength);
        }
        return maxLength;
    }
}
