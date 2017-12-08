public class TestingGround{

   public static void main(String[] a){
    int test;    
     test = mixSelector(Integer.valueOf(a[0]), Integer.valueOf(a[1]), Integer.valueOf(a[2]));
    System.out.println("selected = "+test);
    
    }
    private static int mixSelector(int Date, int Month, int Year) {
        int sum, pick;

        sum = Date + Month + Year;
        pick = sum % 1000;

        while(pick > 6)
         pick = pick/2;

        return pick;
    }
}