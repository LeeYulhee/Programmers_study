class Solution {
    public int solution(String my_string, String is_prefix) {
        if (is_prefix.length() > my_string.length()) return 0;
        String frontString = my_string.substring(0, is_prefix.length());
        return frontString.equals(is_prefix) ? 1 : 0;
    }
}