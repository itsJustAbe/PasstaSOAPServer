package passwordgenerator;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Created by t848 on 20-Jul-16.
 */

class Encrypt {


    private Boolean isDate = false;

    // Color choices made for the user
    private int colorDate;
    private int colorMonth;
    private int colorYear;
    private int colorFirstName;
    private int colorSecondName;

    // Other Information to be put in
    private String uniqueId;
    private int Pin;
    private int sumFirstName;
    private int sumSecondName;

    //IF INPUT IS DATE OF BIRTH
    String encryptDOB(String genPassword, int Date, int Month, int Year, int colorDate, int colorMonth, int colorYear, int pin, String parsedId) {

        // Setting up uniqueIdentifier and Pin
        this.uniqueId = parsedId;
        this.Pin = pin;

        // Setting DOB true
        isDate = true;
        this.colorDate = colorDate;
        this.colorMonth = colorMonth;
        this.colorYear = colorYear;

        // HASHING THE GENERATED PASSWORD
        StringBuilder hashed = new StringBuilder(BCrypt.hashpw(genPassword, BCrypt.gensalt()));

        // PROCESS LOCATIONS BASED ON PIN

        ThePin get = new ThePin(Pin);
        //  RISKY CODE TO BE EXAMINED RN

        //STRING WHICH WILL BE ENCRYPTED
        StringBuilder ToEncrypt = new StringBuilder(hashed + "92a$11f02$3f9Z3uf.FgHk309");//REDUNDANT BITS ADDED FOR HANDLING ARRAY OUT OF BOUND EXCEPTIONS
        StringBuilder imei = new StringBuilder(uniqueId);

        // ENCRYPTION PROCESS
        addImei(imei, ToEncrypt);//ADDING IMEI TO THE HASH

        // Adding color
        addColor(ToEncrypt);

        // Adding date
        addDate(Date, ToEncrypt);

        // Adding month
        addMonth(Month, ToEncrypt);

        // Adding year
        addYear(Year, ToEncrypt);

        // ToEncrypt.insert(get.loc0,ColorChoice[3]);// ADDING DOB FORMAT BIT
        return new String(ToEncrypt);
    }


    //IF INPUT IS NAME

    String encryptName(String genPassword, int sumFirstName,int sumSecondName, int firstNameChoice, int secondNameChoice, int pin, String parsedId) {

        // Setting up uniqueIdentifier and Pin
        this.uniqueId = parsedId;
        this.Pin = pin;

        // Getting Pin Object
        ThePin get = new ThePin(Pin);

        // Adding values recivedd from main  method
        this.sumFirstName = sumFirstName;
        this.sumSecondName = sumSecondName;
        this.colorFirstName = firstNameChoice;
        this.colorSecondName = secondNameChoice;
        get.location();

        // HASHING THE GENERATED PASSWORD
        StringBuilder hashed = new StringBuilder(BCrypt.hashpw(genPassword, BCrypt.gensalt()));

        // Converting recived IMEI number to stringbuilder to perfomr string operations
        StringBuilder imei = new StringBuilder(uniqueId);

        // Redundant bits added to manage exceptions
        StringBuilder ToEncrypt = new StringBuilder(hashed + "92a$11f02$3f9Z3uf.FgHk309");
        //StringBuilder Encrypted = new StringBuilder();

        //ADDING IMEI TO THE HASH
        addImei(imei, ToEncrypt);

        //ADDING COLOR TO THE HASH
        addColor(ToEncrypt);

        //ADDING NAME TO THE HASH
        addName(ToEncrypt);

        //ADDING NAME TO THE HASH
        addName1(ToEncrypt);

        System.out.println("Encrypted password  = " + ToEncrypt);

        return new String(ToEncrypt);
    }

    // ADDING NAME TO THE HASHED PASSWORD
    private void addName(StringBuilder x) {
        ThePin get = new ThePin(Pin);

        StringBuilder sumOfFirstName = new StringBuilder(String.valueOf(sumFirstName));
        x.insert(get.loc9, sumOfFirstName.charAt(0));
        x.insert(get.loc7, sumOfFirstName.charAt(1));
        x.insert(get.loc5, sumOfFirstName.charAt(2));
    }

    private void addName1(StringBuilder x) {
        ThePin get = new ThePin(Pin);

        StringBuilder sumOfSecondName = new StringBuilder(String.valueOf(sumSecondName));
        x.insert(get.loc1, sumOfSecondName.charAt(0));
        x.insert(get.loc9, sumOfSecondName.charAt(1));
        x.insert(get.loc7, sumOfSecondName.charAt(2));
    }
    // NAME PROCESS OF ADDING BITS TO THE HASHED PASSWORD

    //ADDING DATE TO THE HASHED PASSWORD
    private void addDate(int d, StringBuilder x) {
        ThePin get = new ThePin(Pin);

        System.out.println("date = " + d);
        if (d < 10) {
            StringBuilder date = new StringBuilder(0 + String.valueOf(d));//SAMPLE MONTH
            //LOCATIONS
            x.insert(get.loc1, date.charAt(0));
            x.insert(get.loc2, date.charAt(1));
        } else {
            StringBuilder date = new StringBuilder(String.valueOf(d));//SAMPLE MONTH
            x.insert(get.loc1, date.charAt(0));
            x.insert(get.loc2, date.charAt(1));
        }
    }

    // ADDING MONTH TO THE HASHED PASSWORD
    private void addMonth(int m, StringBuilder x) {
        ThePin get = new ThePin(Pin);

        if (m < 10) {
            StringBuilder month = new StringBuilder(0 + String.valueOf(m));//SAMPLE MONTH
            //LOCATIONS
            x.insert(get.loc3, month.charAt(0));
            x.insert(get.loc4, month.charAt(1));
        } else {
            StringBuilder month = new StringBuilder(String.valueOf(m));//SAMPLE MONTH
            x.insert(get.loc3, month.charAt(0));
            x.insert(get.loc4, month.charAt(1));
        }
    }

    // ADDING YEAR TO THE HASHED PASSWORD
    private void addYear(int y, StringBuilder x) {
        ThePin get = new ThePin(Pin);

        StringBuilder year = new StringBuilder(String.valueOf(y));//SAMPLE YEAR
        //LOCATIONS
        x.insert(get.loc5, year.charAt(0));
        x.insert(get.loc6, year.charAt(1));
        x.insert(get.loc7, year.charAt(2));
        x.insert(get.loc8, year.charAt(3));
    }

    // ADDING IMEI NUMBER TO THE HASHED PASS
    private void addImei(StringBuilder IMEI, StringBuilder Encrypted) {
        ThePin get = new ThePin(Pin);

        // ADDING THE IMEI BETWEEN ENCRYPTED PASSWORD
        Encrypted.insert(get.loc0, IMEI.charAt(0));
        Encrypted.insert(get.loc1, IMEI.charAt(1));
        Encrypted.insert(get.loc2, IMEI.charAt(2));
        Encrypted.insert(get.loc3, IMEI.charAt(3));
        Encrypted.insert(get.loc4, IMEI.charAt(4));
        Encrypted.insert(get.loc5, IMEI.charAt(5));
        Encrypted.insert(get.loc6, IMEI.charAt(6));
        Encrypted.insert(get.loc7, IMEI.charAt(7));
        Encrypted.insert(get.loc8, IMEI.charAt(8));
        Encrypted.insert(get.loc9, IMEI.charAt(9));
        Encrypted.insert(get.loc10, IMEI.charAt(10));
        Encrypted.insert(get.loc0, IMEI.charAt(11));
        Encrypted.insert(get.loc1, IMEI.charAt(12));
        Encrypted.insert(get.loc2, IMEI.charAt(13));
        Encrypted.insert(get.loc3, IMEI.charAt(14));

    }

    // ADDING COLOR TO THE HASHED PASSWORD
    private void addColor(StringBuilder Ipass) {
        ThePin get = new ThePin(Pin);

        StringBuilder[] color = new StringBuilder[4];

        // THE COLORS THAT CAN BE CHOSEN
        color[0] = new StringBuilder("00bfa5");
        color[1] = new StringBuilder("ffd180");
        color[2] = new StringBuilder("e13352");
        color[3] = new StringBuilder("00b3c9");


        // If the procedure to generate password is Name
        if (!isDate) {
            // IF NAME IS CHOSEN FOR INPUT
            StringBuilder ColorCode1 = color[colorFirstName - 1];
            StringBuilder ColorCode2 = color[colorSecondName - 1];


            //COLOR CODE 1
            Ipass.insert(get.loc0, ColorCode1.charAt(0));
            Ipass.insert(get.loc1, ColorCode1.charAt(1));
            Ipass.insert(get.loc2, ColorCode1.charAt(2));
            Ipass.insert(get.loc3, ColorCode1.charAt(3));
            Ipass.insert(get.loc4, ColorCode1.charAt(4));
            Ipass.insert(get.loc5, ColorCode1.charAt(5));

            //COLOR CODE 2
            Ipass.insert(get.loc6, ColorCode2.charAt(0));
            Ipass.insert(get.loc7, ColorCode2.charAt(1));
            Ipass.insert(get.loc8, ColorCode2.charAt(2));
            Ipass.insert(get.loc9, ColorCode2.charAt(3));
            Ipass.insert(get.loc10, ColorCode2.charAt(4));
            Ipass.insert(get.loc0, ColorCode2.charAt(5));
        }
        // If the procedure to generate password is not Name
        else {
            StringBuilder ColorCode1 = color[colorDate - 1];
            StringBuilder ColorCode2 = color[colorMonth - 1];
            StringBuilder ColorCode3 = color[colorYear - 1];

            //COLOR CODE 1
            Ipass.insert(get.loc0, ColorCode1.charAt(0));
            Ipass.insert(get.loc1, ColorCode1.charAt(1));
            Ipass.insert(get.loc2, ColorCode1.charAt(2));
            Ipass.insert(get.loc3, ColorCode1.charAt(3));
            Ipass.insert(get.loc4, ColorCode1.charAt(4));
            Ipass.insert(get.loc5, ColorCode1.charAt(5));

            //COLOR CODE 2
            Ipass.insert(get.loc6, ColorCode2.charAt(0));
            Ipass.insert(get.loc7, ColorCode2.charAt(1));
            Ipass.insert(get.loc8, ColorCode2.charAt(2));
            Ipass.insert(get.loc9, ColorCode2.charAt(3));
            Ipass.insert(get.loc10, ColorCode2.charAt(4));
            Ipass.insert(get.loc0, ColorCode2.charAt(5));

            //COLOR CODE 3
            Ipass.insert(get.loc1, ColorCode3.charAt(0));
            Ipass.insert(get.loc2, ColorCode3.charAt(1));
            Ipass.insert(get.loc3, ColorCode3.charAt(2));
            Ipass.insert(get.loc4, ColorCode3.charAt(3));
            Ipass.insert(get.loc5, ColorCode3.charAt(4));
            Ipass.insert(get.loc6, ColorCode3.charAt(5));

        }
        //THE CHOICE MADE
    }
}
