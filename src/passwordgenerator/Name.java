package passwordgenerator;

/**
 *
 * @author T848
 */

public class Name {
    
    // For processing 
    String SUM, SUM1;
     private String pass;
     private static int sumOfFirstName,sumOfSecondName;
     String com;
     
     // Values to test the program
     private String first="";
     private String second="";


     // Operations on the string to be performed
     private void operations() {


         // Store pojo.User's name's length
        int lengthFirstname, lengthSecondName;
        char mod[],mod1[];

        // Contains length of first name
        lengthFirstname = first.length();

        // Contains length of second name 
        lengthSecondName = second.length();

        // Converting first name to char array to process operations on it
        mod = first.toCharArray();

        // Converting second name to char array to process operations on it
        mod1= second.toCharArray();

        // Summing up the first name 
        for(int i = 0 ; i < lengthFirstname ; i++)
            sumOfFirstName += mod[i] + 13;

        // Summing up the second name 
        for(int i = 0 ; i < lengthSecondName ; i++)
            sumOfSecondName += mod1[i] + 5;
    }

    // Providing generated name
    String getPassword(String firstName,String secondName,int colorFirstName,int colorSecondName){

         Switch sw = new Switch();

         // Putting the recived values
        this.first = firstName;
        this.second = secondName;

        // Converting the names to 3 digit numbers
         operations();
    
         // converting the name
         SUM = sw.switcher(colorFirstName,sumOfFirstName, first);
         SUM1 = sw.switcher(colorSecondName, sumOfSecondName, second);

         pass = SUM + SUM1;

         return pass;

    }
    
    public int getSumOfFirstName() {
        return sumOfFirstName;
    }

    public int getSumOfSecondName() {
        return sumOfSecondName;
    }

}
