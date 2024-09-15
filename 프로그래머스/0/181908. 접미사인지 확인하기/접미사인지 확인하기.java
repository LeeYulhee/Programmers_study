class Solution {
    public int solution(String my_string, String is_suffix) {
        if(is_suffix.length() > my_string.length()) return 0;
        String endString = my_string.substring(my_string.length() - is_suffix.length());
        return endString.equals(is_suffix)? 1 : 0;
    }
}