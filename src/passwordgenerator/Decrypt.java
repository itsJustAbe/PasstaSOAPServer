package passwordgenerator;

/**
 * Created by t848 on 20-Jul-16.
 */
class Decrypt {
    private String UserId;
    private ThePin get = new ThePin(Passgen.USER_PIN);
    private  int color1;
    private  int color2;
    private  int color3;
    //REMOVE COLOR FROM THE ENCRYPTED PASSWORD
    private  String Year;
    private  String Date;
    private  String Month;
    private  String Name;
    private  String Name1;

    //IF INPUT IS NAME
    public void reverseName(StringBuilder x, int pin) {

        get.location();
        StringBuilder Decrypted = new StringBuilder(x);
        getAndRemoveName(Decrypted);
        getAndRemoveColor3(Decrypted);
        getAndRemoveColor2(Decrypted);
        getAndRemoveColor1(Decrypted);
        getAndRemoveImei(Decrypted);
    }

    //IF INPUT IS DATE OF BIRTH
    void reverseDOB(StringBuilder x) {

        get.location();
        StringBuilder Decrypted = new StringBuilder(x);
        getAndRemoveYear(Decrypted);
        getAndRemoveMonth(Decrypted);
        getAndRemoveDate(Decrypted);
        getAndRemoveColor3(Decrypted);
        getAndRemoveColor2(Decrypted);
        getAndRemoveColor1(Decrypted);
        getAndRemoveImei(Decrypted);
    }

    private void getAndRemoveYear(StringBuilder epass) {
        //getting and deleting YEAR
        StringBuilder temp = new StringBuilder();

        temp.append(epass.charAt(get.loc8));
        epass.deleteCharAt(get.loc8);
        temp.append(epass.charAt(get.loc7));
        epass.deleteCharAt(get.loc7);
        temp.append(epass.charAt(get.loc6));
        epass.deleteCharAt(get.loc6);
        temp.append(epass.charAt(get.loc5));
        epass.deleteCharAt(get.loc5);

        this.Year = String.valueOf(temp.reverse());
    }

    private void getAndRemoveMonth(StringBuilder epass) {
        //getting and deleting MONTH

        StringBuilder temp = new StringBuilder();

        temp.append(epass.charAt(get.loc4));
        epass.deleteCharAt(get.loc4);
        temp.append(epass.charAt(get.loc3));
        epass.deleteCharAt(get.loc3);

        Month = String.valueOf(temp.reverse());

    }

    private void getAndRemoveDate(StringBuilder epass) {
        //getting and deleting DATE
        StringBuilder temp = new StringBuilder();


        temp.append(epass.charAt(get.loc2));
        epass.deleteCharAt(get.loc2);
        temp.append(epass.charAt(get.loc1));
        epass.deleteCharAt(get.loc1);

       Date = String.valueOf(temp.reverse());

    }

    private int parseColor(String c) {
        int parsedColor = 5;

        switch (c) {
        case "00bfa5":
            parsedColor = 1;
            break;

        case "ffd180":
            parsedColor = 2;
            break;

        case "e13352":
            parsedColor = 3;
            break;

        case "00b3c9":
            parsedColor = 4;
            break;
        }

        return parsedColor;
    }

    private void getAndRemoveName(StringBuilder x) {
        StringBuilder temp = new StringBuilder();

        temp.append(x.charAt(get.loc5));
        x.deleteCharAt(get.loc5);
        temp.append(x.charAt(get.loc7));
        x.deleteCharAt(get.loc7);
        temp.append(x.charAt(get.loc9));
        x.deleteCharAt(get.loc9);

        Name = String.valueOf(temp.reverse());
    }

    private void getAndRemoveColor1(StringBuilder pass) {

        StringBuilder color = new StringBuilder();


        //color 1
        color.append(pass.charAt(get.loc5));
        pass.deleteCharAt(get.loc5);
        color.append(pass.charAt(get.loc4));
        pass.deleteCharAt(get.loc4);
        color.append(pass.charAt(get.loc3));
        pass.deleteCharAt(get.loc3);
        color.append(pass.charAt(get.loc2));
        pass.deleteCharAt(get.loc2);
        color.append(pass.charAt(get.loc1));
        pass.deleteCharAt(get.loc1);
        color.append(pass.charAt(get.loc0));
        pass.deleteCharAt(get.loc0);

        color.reverse();

        color1 = parseColor(new String(color));

    }

    private void getAndRemoveColor2(StringBuilder pass) {

        StringBuilder color = new StringBuilder();
        //color 1
        color.append(pass.charAt(get.loc0));
        pass.deleteCharAt(get.loc0);
        color.append(pass.charAt(get.loc10));
        pass.deleteCharAt(get.loc10);
        color.append(pass.charAt(get.loc9));
        pass.deleteCharAt(get.loc9);
        color.append(pass.charAt(get.loc8));
        pass.deleteCharAt(get.loc8);
        color.append(pass.charAt(get.loc7));
        pass.deleteCharAt(get.loc7);
        color.append(pass.charAt(get.loc6));
        pass.deleteCharAt(get.loc6);

        color.reverse();
        color2 = parseColor(new String(color));
    }

    private void getAndRemoveColor3(StringBuilder pass) {
        StringBuilder color = new StringBuilder();
        //color 1
        color.append(pass.charAt(get.loc6));
        pass.deleteCharAt(get.loc6);
        color.append(pass.charAt(get.loc5));
        pass.deleteCharAt(get.loc5);
        color.append(pass.charAt(get.loc4));
        pass.deleteCharAt(get.loc4);
        color.append(pass.charAt(get.loc3));
        pass.deleteCharAt(get.loc3);
        color.append(pass.charAt(get.loc2));
        pass.deleteCharAt(get.loc2);
        color.append(pass.charAt(get.loc1));
        pass.deleteCharAt(get.loc1);
        color.reverse();

        color3 = parseColor(new String(color));
    }

    private void getAndRemoveImei(StringBuilder pass) {
        //DELETING THE IMEI FROM THE ENCRYPTED PASSWORD
        StringBuilder temp = new StringBuilder();


        temp.append(pass.charAt(get.loc3));
        pass.deleteCharAt(get.loc3);
        temp.append(pass.charAt(get.loc2));
        pass.deleteCharAt(get.loc2);
        temp.append(pass.charAt(get.loc1));
        pass.deleteCharAt(get.loc1);
        temp.append(pass.charAt(get.loc0));
        pass.deleteCharAt(get.loc0);
        temp.append(pass.charAt(get.loc10));
        pass.deleteCharAt(get.loc10);
        temp.append(pass.charAt(get.loc9));
        pass.deleteCharAt(get.loc9);
        temp.append(pass.charAt(get.loc8));
        pass.deleteCharAt(get.loc8);
        temp.append(pass.charAt(get.loc7));
        pass.deleteCharAt(get.loc7);
        temp.append(pass.charAt(get.loc6));
        pass.deleteCharAt(get.loc6);
        temp.append(pass.charAt(get.loc5));
        pass.deleteCharAt(get.loc5);
        temp.append(pass.charAt(get.loc4));
        pass.deleteCharAt(get.loc4);
        temp.append(pass.charAt(get.loc3));
        pass.deleteCharAt(get.loc3);
        temp.append(pass.charAt(get.loc2));
        pass.deleteCharAt(get.loc2);
        temp.append(pass.charAt(get.loc1));
        pass.deleteCharAt(get.loc1);
        temp.append(pass.charAt(get.loc0));
        pass.deleteCharAt(get.loc0);

        UserId = String.valueOf(temp.reverse());
    }

    int getDate() {
        return Integer.parseInt(Date);
    }

    int getMonth() {
        return Integer.parseInt(Month);
    }

    int getYear() {
        return Integer.parseInt(String.valueOf(Year));
    }
    String getUserId(){
        return UserId;
    }


    String getName() {
        return Name;
    }

    String getName1() {
        return Name1;
    }

    int getColor1() {
        return color1;
    }

    int getColor2() {
        return color2;
    }

    int getColor3() {
        return color3;
    }

}
