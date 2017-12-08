public class TestingGround{

   public static void main(String[] a){
    int[] test;    
     test = choiceSelector(a[0]);
     
     for(int i = 0 ; i < 4; i++) System.out.println(" Parsed = "+test[i]);
    
    }
    private static int[] choiceSelector(String first) {
        // Store pojo.User's name's length
        String temp;
        int sum = 0;
        int[] pick;
        int lengthOfServiceName;
        char mod[];

        // Contains length of first name
        lengthOfServiceName = first.length();

        // Converting first name to char array to process operations on it
        mod = first.toCharArray();

        // Summing up the first name 
        for (int i = 0; i < lengthOfServiceName; i++) sum += mod[i];

            temp = String.valueOf(sum);
            System.out.println("parsed string = "+ temp);

            if(temp.length() < 4 && temp.length() == 3){
                temp = temp + "9";
            }else if(temp.length() < 4 && temp.length() == 2){
                temp = temp + " 99 ";
            }else if(temp.length() < 4 && temp.length() == 1){
                temp = temp + "999";
            }

            pick = chooseOne(temp);
            System.out.println("char to be sent = " + temp);

            return pick;
    }

    private static int[] chooseOne(String temp){
        int[] returnBack = new int[4];
        System.out.println("recived char = " + temp);


        for(int i = 0; i < 4 ; i++) {
            returnBack[i] = Integer.valueOf(String.valueOf(temp.charAt(i)));
            if (returnBack[i] > 4)
                returnBack[i] = returnBack[i] / 2;
                else if(returnBack[i] == 0 ) returnBack[i] = 1;
                System.out.println("recived integer value = " + returnBack[i]);
        }
        
        return returnBack;
    }
}