package passwordgenerator;

/**
 * Created by t848 on 20-Jul-16.
 */
class Decrypt {
    private StringBuilder UserID = new StringBuilder("");
    private ThePin get = new ThePin(Passgen.USER_PIN);
    private static int color1;
    private static int color2;
    private static int color3;
    //REMOVE COLOR FROM THE ENCRYPTED PASSWORD
    private static StringBuilder Year = new StringBuilder("");
    private static StringBuilder Date = new StringBuilder("");
    private static StringBuilder Month = new StringBuilder("");
    private static StringBuilder Name = new StringBuilder("");
    private static StringBuilder Name1 = new StringBuilder("");

    //IF INPUT IS NAME
    public void reverseName(StringBuilder x, int pin) {
        System.out.println("TO DECRYPT THE PASSWORD -");
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
        System.out.println("TO DECRYPT THE PASSWORD -");
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

        Year.append(epass.charAt(get.loc8));
        epass.deleteCharAt(get.loc8);
        Year.append(epass.charAt(get.loc7));
        epass.deleteCharAt(get.loc7);
        Year.append(epass.charAt(get.loc6));
        epass.deleteCharAt(get.loc6);
        Year.append(epass.charAt(get.loc5));
        epass.deleteCharAt(get.loc5);

        Year.reverse();
    }

    private void getAndRemoveMonth(StringBuilder epass) {
        //getting and deleting MONTH

        Month.append(epass.charAt(get.loc4));
        epass.deleteCharAt(get.loc4);
        Month.append(epass.charAt(get.loc3));
        epass.deleteCharAt(get.loc3);

        Month.reverse();

    }

    private void getAndRemoveDate(StringBuilder epass) {
        //getting and deleting DATE

        Date.append(epass.charAt(get.loc2));
        epass.deleteCharAt(get.loc2);
        Date.append(epass.charAt(get.loc1));
        epass.deleteCharAt(get.loc1);

        Date.reverse();

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
        Name.append(x.charAt(get.loc5));
        x.deleteCharAt(get.loc5);
        Name.append(x.charAt(get.loc7));
        x.deleteCharAt(get.loc7);
        Name.append(x.charAt(get.loc9));
        x.deleteCharAt(get.loc9);

        Name.reverse();
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
        UserID.append(pass.charAt(get.loc3));
        pass.deleteCharAt(get.loc3);
        UserID.append(pass.charAt(get.loc2));
        pass.deleteCharAt(get.loc2);
        UserID.append(pass.charAt(get.loc1));
        pass.deleteCharAt(get.loc1);
        UserID.append(pass.charAt(get.loc0));
        pass.deleteCharAt(get.loc0);
        UserID.append(pass.charAt(get.loc10));
        pass.deleteCharAt(get.loc10);
        UserID.append(pass.charAt(get.loc9));
        pass.deleteCharAt(get.loc9);
        UserID.append(pass.charAt(get.loc8));
        pass.deleteCharAt(get.loc8);
        UserID.append(pass.charAt(get.loc7));
        pass.deleteCharAt(get.loc7);
        UserID.append(pass.charAt(get.loc6));
        pass.deleteCharAt(get.loc6);
        UserID.append(pass.charAt(get.loc5));
        pass.deleteCharAt(get.loc5);
        UserID.append(pass.charAt(get.loc4));
        pass.deleteCharAt(get.loc4);
        UserID.append(pass.charAt(get.loc3));
        pass.deleteCharAt(get.loc3);
        UserID.append(pass.charAt(get.loc2));
        pass.deleteCharAt(get.loc2);
        UserID.append(pass.charAt(get.loc1));
        pass.deleteCharAt(get.loc1);
        UserID.append(pass.charAt(get.loc0));
        pass.deleteCharAt(get.loc0);

        UserID.reverse();
    }

    int getDate() {
        return Integer.parseInt(new String(Date));
    }

    int getMonth() {
        return Integer.parseInt(new String(Month));
    }

    int getYear() {
        return Integer.parseInt(String.valueOf(Year));
    }

    String getName() {
        return new String(Name);
    }

    String getName1() {
        return new String(Name1);
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
