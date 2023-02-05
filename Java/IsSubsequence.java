public class IsSubsequence {

    public static void main(String[] args) {
        String s = "ace";
        String t = "abcde";

        System.out.println(isSubsequence(s.toLowerCase(), t.toLowerCase()));
    }

    public static boolean isSubsequence(String s, String t) {
        int s_pointer = 0, t_pointer = 0;
        while (t_pointer < t.length() && s_pointer < s.length()) {
            if (t.charAt(t_pointer) == s.charAt(s_pointer)) {
                s_pointer++;
            }
            t_pointer++;
        }
        return s_pointer == s.length();
    }
}
