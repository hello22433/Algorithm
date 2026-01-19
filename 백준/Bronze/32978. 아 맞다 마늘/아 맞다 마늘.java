import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String ingredientRequired = sc.next();
            set.add(ingredientRequired);
        }

        for (int i = 0; i < n-1; i++) {
            String ingredientPutIn = sc.next();
            set.remove(ingredientPutIn);
        }

        for (String ingredientNotIncluded : set) {

            System.out.println(ingredientNotIncluded);
        }




    }
}