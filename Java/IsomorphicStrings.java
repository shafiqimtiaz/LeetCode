import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            Character c1 = s.charAt(i);
            Character c2 = t.charAt(i);

            if ((mapST.containsKey(c1) && !mapST.get(c1).equals(c2))
                    || (mapTS.containsKey(c2) && !mapTS.get(c2).equals(c1))) return false;

            mapST.put(c1, c2);
            mapTS.put(c2, c1);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s.toLowerCase(), t.toLowerCase()));
    }
}
