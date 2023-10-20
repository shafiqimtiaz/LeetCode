import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        int n = 6;
        int k = 2;
        List<List<Integer>> result = combine(n, k);
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > n || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        result = combine(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        result.addAll(combine(n - 1, k));
        return result;
    }
}
