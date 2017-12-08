package passwordgenerator;/*
 * @author T848
 */

import pojo.Password;
import pojo.Procedure;
import pojo.User;

import java.util.Calendar;

public class Passgen {

    // Format and range specified for pin and unique identifier
    private final int LENGTH_UID = 15;
    private final int MIN_RANGE_UID = 0;
    private final int MAX_RANGE_UID = 15;
    private final int MAX_RANGE_PIN = 4;
    private final int MIN_RANGE_PIN = 0;

    // Getting all the objects
    
    // Date of birth object for generating password using date of birth
    Dob dob = new Dob();
    // Password checking class
    Check check = new Check();
    // Generation of password using Name
    Name name = new Name();
    // Password decryptor
    Decrypt decrypter = new Decrypt();
    // Encryption class duh
    Encrypt encrypt = new Encrypt();

   // Storing data being used for creation of password
    private int USER_DATE;
    private int USER_MONTH;
    private int USER_YEAR;
    private int USER_CHOICE_DATE;
    private int USER_CHOICE_MONTH;
    private int USER_CHOICE_YEAR;
    private String USER_FIRST;
    private String USER_SECOND;
    private int USER_CHOICE_1 = 1;
    private int USER_CHOICE_2 = 4;
    private int sumOfFirstName;
    private int sumOfSecondName;
    private String USER_UNIQUE_MODIFIER;

    // Data to be used by Decrypt and Encrypt
     static String PARSED_USER_ID;
     static int USER_PIN;

    // Items to be sent back
    private String encryptedPassword;
    private String Password;

    // Dycrypting the password
    private void decrypt() {


        // Decrypting password generating using DOB
        decrypter.reverseDOB(new StringBuilder(encryptedPassword));

        // Update values recieved after decrypting 
        DecrypterUpdateValues();
        
        // Generate a new DOB password using the new values provided
        generateUsingDob();

    }
    
    // updates the values of global variables after decrypting
    private void DecrypterUpdateValues() {

        USER_DATE = decrypter.getDate();
        USER_MONTH = decrypter.getMonth();
        USER_YEAR = decrypter.getYear();
        USER_CHOICE_DATE = decrypter.getColor1();
        USER_CHOICE_MONTH = decrypter.getColor2();
        USER_CHOICE_YEAR = decrypter.getColor3();

    }

    // if the strength of passwords is equal try changing dob of user to get different passwords
    private void increaseDob() {

        if ((USER_DATE <= 99) && (USER_MONTH <= 99)) {

            USER_DATE++;
            USER_MONTH++;
            USER_CHOICE_YEAR++;

        }

    }

    // Process to generate password using date of birth of the user
    private String generateUsingDob() {
        String passwordDob;

        // Create password using DOB
        passwordDob = dob.getPassword(USER_DATE, USER_MONTH, USER_YEAR, USER_CHOICE_DATE, USER_CHOICE_MONTH,
                USER_CHOICE_YEAR);


        return passwordDob;

    }


    // Choosing the Best password generated amonsgt both of them
    private String pickBestOne(int strengthDob,int strengthName,String name, String dob){
        String temp = null;

        // if strength of name is greater than strength of DOB
        if (strengthName > strengthDob) { // encrypt
            temp = encrypt.encryptName(name, sumOfFirstName, sumOfSecondName, USER_CHOICE_1, USER_CHOICE_2,
                    USER_PIN, PARSED_USER_ID);
            Password = name;
        }

        // Update values till Dob password is better 
        else if (strengthName == strengthDob && strengthName > 50) {
            increaseDob();
            generatePassword();
        } 
        
        // Default case just encrypt DOB.
        else { 
            temp = encrypt.encryptDOB(dob, USER_DATE, USER_MONTH, USER_YEAR, USER_CHOICE_DATE,
                    USER_CHOICE_MONTH, USER_CHOICE_YEAR, USER_PIN, PARSED_USER_ID);
            Password = dob;
        }

        return temp;
    }
    
    private void choiceSelector(String first) {
        // Store pojo.User's name's length
        String temp;
        int sum = 0;
        int[] pick;
        int lengthOfServiceName;
        char mod[];

        // length of the service name
        lengthOfServiceName = first.length();

        // Converting service name to char array to sum all the characters
        mod = first.toCharArray();

        // Summing up the service name
        for (int i = 0; i < lengthOfServiceName; i++)
            sum += mod[i];

            // conversion to string for other operations
        temp = String.valueOf(sum);

        // Padding process
        if (temp.length() < 4 && temp.length() == 3) {
            temp = temp + "9";
        } else if (temp.length() < 4 && temp.length() == 2) {
            temp = temp + " 99 ";
        } else if (temp.length() < 4 && temp.length() == 1) {
            temp = temp + "999";
        }

        // getting parsed digits for choice
        pick = chooseOne(temp);

        // Updating values
        USER_CHOICE_DATE = pick[0];
        USER_CHOICE_MONTH = pick [1];
        USER_CHOICE_YEAR = pick [2];

    }

    private int[] chooseOne(String temp){
        int[] returnBack = new int[4];

        // Dirty way to do parse 
        for(int i = 0; i < 4 ; i++) {
         
            returnBack[i] = Integer.valueOf(String.valueOf(temp.charAt(i)));
          
            // if greater than 4 then divide by 2 
            if (returnBack[i] > 4)              
                returnBack[i] = returnBack[i] / 2;
          
                // if 0 convert it to 1
            else if(returnBack[i] == 0 ) 
                        returnBack[i] = 1;
        }
        
        return returnBack;
    }

    // this method update global variables values once all the data is received 
    private void updateValues(User info, String service) {

        // Calender Object to translate Date of birth
        Calendar calObject = Calendar.getInstance();
        calObject.setTimeInMillis(info.getBirthdate());

        // Update Values
        USER_DATE = calObject.get(Calendar.DAY_OF_MONTH);
        USER_MONTH = calObject.get(Calendar.MONTH);
        USER_YEAR = calObject.get(Calendar.YEAR);
        USER_UNIQUE_MODIFIER = info.getUserID();
        USER_FIRST = info.getFirstName();
        USER_SECOND = info.getLastName();

    }

    // Process of generating the password using Name of the user
    private String generateUsingName() {
        String passwordName;

        // Create password using Name
        passwordName = name.getPassword(USER_FIRST, USER_SECOND, USER_CHOICE_1, USER_CHOICE_2);

        sumOfFirstName = name.getSumOfFirstName();
        sumOfSecondName = name.getSumOfSecondName();

        System.out.println("sum of first number in Passgen = " + sumOfFirstName);
        System.out.println("sum of second number in Passgen = " + sumOfSecondName);

        return passwordName;
    }

    // Parsing unique id of the user to pin and IMEI
    private void uniqueIdParser() {
        /*
        *we need to do some string manipulationhence stringbuilders
        */
        StringBuilder idReceived = new StringBuilder(USER_UNIQUE_MODIFIER);
        StringBuilder uniqueIdentifier = new StringBuilder();

        // Taking out all the Digits from the string
        for (int i = 0; i < idReceived.length(); i++)
            if (Character.isDigit(idReceived.charAt(i)))
                uniqueIdentifier.append(idReceived.charAt(i));

        // if the length is shorter than 15
        // Then add padding as digit 6 
        if (uniqueIdentifier.length() < LENGTH_UID) {
            while (uniqueIdentifier.length() < LENGTH_UID)
                uniqueIdentifier.append("6");
            PARSED_USER_ID = new String(uniqueIdentifier);
        } 
        // if length of parsed string is more than the maximum acceptable length
        // Then take out the substring by using range provided

        else if (uniqueIdentifier.length() > LENGTH_UID) {
            PARSED_USER_ID = uniqueIdentifier.substring(MIN_RANGE_UID, MAX_RANGE_UID);
        } 
        
        // If there is no problem then just use the parsed string as it is.
        else
            PARSED_USER_ID = new String(uniqueIdentifier);

        // Set PIN and UniqueIdentfier
        USER_PIN = Integer.valueOf(uniqueIdentifier.substring(MIN_RANGE_PIN, MAX_RANGE_PIN));

        // test print remove before deployment 
        System.out.println("ID Parsed = " + uniqueIdentifier);
        System.out.println("pin Parsed = " + USER_PIN);

    }

    // Process to generate password
    private void generatePassword() {

        // variables
        String name, dob;
         int strengthName, strengthDob;

        // Generate  password using Dob
        dob = generateUsingDob();

        // Generate using name
        name = generateUsingName();
        //name = "disabled name for now";

        // Check strength of both
        strengthName = check.strength(name);
        strengthDob = check.strength(dob);

        // Using the Strength pick the best password to be used 
        encryptedPassword = pickBestOne(strengthDob,strengthName,name,dob);
        
        // Display
        System.out.println("Strength of password dob = " + strengthDob);
        System.out.println("Strength of password name = " + strengthName);

    }

    public Password decryptPassword(Procedure procedure) {
       
        // parse the acquired user ID
        uniqueIdParser();

        // set Encrypted password
        encryptedPassword = procedure.getProcedure();

        // Decrypt values before generating
        decrypt();

        //Generate pojo.User pojo.Password
        Password = generateUsingDob();

        Password password = new Password();

        // Setup all the data to be sent back to the client
        password.setPassword(this.Password);
        password.setOwner(procedure.getOwner());
        password.setId(procedure.getId());
        password.setServiceName(procedure.getServiceName());
        
        // Flushing values
        PARSED_USER_ID = null;
        USER_PIN = 0;

        return password;
    }


    public Procedure encryptPassword(User userInfo, String service) {// MAIN FUNCTION
        // Update values
        updateValues(userInfo, service);
        // parse the acquired user ID
        uniqueIdParser();
        // Parse choices
        choiceSelector(service);
        // pojo.Procedure to generate password for Dob
        generatePassword();

        // Set up data to be sent back to the client
        Procedure procedure = new Procedure();
        procedure.setServiceName(service);
        procedure.setOwner(userInfo.getUserID());
        procedure.setProcedure(this.encryptedPassword);

        // Flushing values
        PARSED_USER_ID = null;
        USER_PIN = 0;

        return procedure;
    }

        /*else if(a[0].equals("3")){
        
            third.namePlusDob();
            System.out.println("\n your password is " + third.pass);// DISPLAYING GENERATED PASSWORD
            int a = check.strength(third.pass);//CHECKING FOR PASSWORD STRENGTH
            System.out.println(""+a);
        
        }*/

        public String getUserID(){
            return PARSED_USER_ID;
    }
        public int getPin(){
            return USER_PIN;
    }

}
