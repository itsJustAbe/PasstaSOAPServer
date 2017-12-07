package passwordgenerator;

import java.util.Objects;

// Last character's error to be checked and configured, all done except that GfuckingG
// Error at 199 and hundred's place

public class Option5 {

    // FOR DOB
    public String genWord(int input) { // Process to generate word

        StringBuilder word = new StringBuilder("");// The word chosen

        // Special condition for year
        if (input > 1000) {
            input = input % 100;
        }


        for (int i = 0; i < ones_encoder(input).length(); i++) word.append(ones_encoder(input).charAt(i));

        // Need a better identifier as we will be working on a website not on android
        String IMEI = Passgen.PARSED_USER_ID;//

        // Process to change one letter as capital
        int whereToChange = getTheDigit(IMEI, word);

        // Getting the character to which it has to change
        char pos = word.charAt(whereToChange);

        // Changing the character to capital
        word.setCharAt(whereToChange, (char) (pos - 32));

        return new String(word);

    }

    // FOR NAME
    // Process to generate word
    public String genWord(String name, int x) {
        StringBuilder word = new StringBuilder("");// The word chosen

        // If the number is a pure 100 number eg 100,200, then use this method
        if(x%100==0) word.append(hundreds_encoder(x));

            // Else continue normal procedure
        else for (int i = 0; i < ones_encoder(x).length(); i++) word.append(ones_encoder(x).charAt(i));

        String PartOfName = partOfName(name);// NAME WILL CONTAIN THE INPUT AFTERWARDS , SHIVAM IS USED AS A TEST CASE

        //String IMEI = "492872346603191";// IMEI EXAMPLE
        word = addLastChar(word,x);
        String PartOfWord = partOfName(new String(word));// SEARCHING FOR THE PART TO BE Changed

        word = replacePart(word, PartOfWord, PartOfName);

        System.out.println("after adding = "+word);

        return new String(word);
    }

    // FORMULA TO GET A PLACE IN WORD FOR MAKING CAPITAL
    private int getTheDigit(String x, StringBuilder word) {

        int digit, sum = 0;

        for (int i = 0; i < 15; i++)
            sum = sum + Integer.parseInt(x.charAt(i) + "");//summing all the digits in the imei number

        int length = word.length();// LENGTH OF THE WORD
        digit = sum / length;// DIVIDING THE SUM BY THE LENGTH OF THE WORD

        if (digit >= length) {//  DIVIDING THE OUTPUT AGAIN IF GREATER THAN THE LENGTH
            do {
                digit = digit / length;
            } while (digit > length);
        }

        return digit-1;

    }

    // HANDLING THE ONES PLACE
    private String ones_encoder(int x) {
        StringBuilder enCode = new StringBuilder();
        int remainder = x % 10;

        switch (remainder) {
            case 1:
                enCode.append((char) 101);
                enCode.append((char) 107);
                break;
            case 2:
                if (x / 100 == 0)
                    enCode.append("do");
                else {
                    enCode.append((char) 98);
                    enCode.append((char) 97);
                }
                break;
            case 3:
                if (x / 100 == 0)
                    enCode.append("teen");
                else {
                    enCode.append((char) 116);
                    enCode.append((char) 114);
                }
                break;
            case 4:
                if (x / 100 == 0)
                    enCode.append("char");
                else {
                    enCode.append((char) 99);
                    enCode.append((char) 111);
                }
                break;
            case 5:
                enCode.append((char) 112);
                enCode.append((char) 97);
                if (x / 100 == 0)
                    enCode.append("nch");
                break;
            case 6:
                enCode.append((char) 99);
                enCode.append((char) 104);
                if (x / 100 == 0)
                    enCode.append("e");
                break;
            case 7:
                enCode.append((char) 115);
                if (x / 100 == 0)
                    enCode.append('a');
                enCode.append((char) 116);
                break;
            case 8:
                enCode.append((char) 97);
                if (x / 100 == 0)
                    enCode.append("a");
                enCode.append((char) 116);
                if (x / 100 == 0)
                    enCode.append("h");
                break;
            case 9:
                if (x / 100 == 0)
                    enCode.append("nau");

                else {
                    enCode.append((char) 117);
                    enCode.append((char) 110);
                    x = x + 10;
                }
                break;
        }

        tens_encoder(enCode, x);
        return String.valueOf(enCode);
    }
    // HANDLING THE TENS PLACE
    private void tens_encoder(StringBuilder s, int b){
        //checking  if the number comes from Name
        if(b>100) b = b%100;

        // Adding 2 characters if the tens place is 0 (fixed on 22 Jan,17)
        if (b/10==0) s.append("ah");
        else{
            int  multiple = b / 10;
            multiple = multiple % 10;
            switch (multiple) {
                case 0:
                    s.append("ah ");
                    break;
                case 1:
                    if (b == 10) s.append("dass");
                    else s.append("arah");
                    break;
                case 2:
                    if (b == 20) s.append("bees");
                    else s.append("ees");
                    break;
                case 3:
                    if (b == 30) s.append("tess");
                    else s.append("tis");
                    break;
                case 4:
                    if (b == 40) s.append("chali");
                    else s.append("tlis");
                    break;
                case 5:
                    if (b == 50) s.append("panja");
                    else s.append("awan");
                    break;
                case 6:
                    if (b == 60) s.append("sath");
                    else s.append("sath");
                    break;
                case 7:
                    if (b == 70) s.append("sata");
                    else s.append("atar");
                    break;
                case 8:
                    if (b == 80) s.append("assi");
                    else s.append("assi");
                    break;
                case 9:
                    if (b == 90) s.append("nabae");
                    else if(b==99) s.append("nanwe");
                    else s.append("anwe");
                    break;
                case 10:
                    s.append("ssau");
                    break;
            }}
    }

    //HANDLING PURE 100 CASES JUST 10 FROM 0-1000

    //HARDCODED SHIT YES ITS REQUIRED
    private StringBuilder hundreds_encoder(int x){

        StringBuilder enCode = new StringBuilder();
        int c = x/100;
        switch(c) {
            case 1:
                enCode.append("ekhan");
                break;
            case 2:
                enCode.append("dohan");
                break;
            case 3:
                enCode.append("tehan");
                break;
            case 4:
                enCode.append("chahan");
                break;
            case 5:
                enCode.append("pachan");
                break;
            case 6:
                enCode.append("chehan");
                break;
            case 7:
                enCode.append("sathan");
                break;
            case 8:
                enCode.append("atthan");
                break;
            case 9:
                enCode.append("nuhan");
                break;
            case 10:
                enCode.append("hazar");
                break;
        }


        return enCode;
    }




    // FOR 3 DIGIT NUMBERS IE NAME CLASS
    private StringBuilder addLastChar(StringBuilder word,int x){

        char put ;// the chosen character goes here
        char[] Consonant = {'b','c','d','g','j','k','l','m','n','p'};// LIST OF COSONANTS TO BE USED
        char[] vowel = {'a','y','i','e','o','q','A','u','E','I'};// LIST OF VOWELS TO BE USED
        int len = word.length();// LENGTH OF THE WORD
        char c = word.charAt(len-1);
        int f = x/100;
        if     ((c == 'a')||// CHECKING CHARACTER IF ITS CONSONANT OR VOWEL TO PUT A CHARACTER ACCORDINGLY
                (c == 'o') ||
                (c == 'u') ||
                (c == 'i') ||
                (c == 'e')){

            // Putting a consonant since there is a vowel as the last character in the generated word
            put = Consonant[f];
        }else put = vowel[f];

        word.append(put);

        return word;
    }

    // NAME EXCLUSIVE
    private StringBuilder replacePart(StringBuilder word, String PartOfWord, String PartOfName) {


        for (int i = 0; i < word.length()-2; i++) {
            if (Objects.equals(word.substring(i, i + 3), PartOfWord)) {
                word.replace(i,i+3,PartOfName);
            }
        }


        return word;
    }

    // Name exclusive
    private String partOfName(String name) {
        String SubName;

        StringBuilder Name = new StringBuilder(name);
        int LengthOfName = name.length();
        String[] sub = new String[LengthOfName];

        if (LengthOfName == 4) {
            sub[0] = Name.substring(0, 3);
            sub[1] = Name.substring(1, 4);
        } else if (LengthOfName == 5) {
            sub[0] = Name.substring(0, 3);
            sub[1] = Name.substring(1, 4);
            sub[2] = Name.substring(2, 5);
        } else if (LengthOfName == 6) {
            sub[0] = Name.substring(0, 3);
            sub[1] = Name.substring(1, 4);
            sub[2] = Name.substring(2, 5);
            sub[3] = Name.substring(3, 6);
        } else if (LengthOfName == 7) {
            sub[0] = Name.substring(0, 3);
            sub[1] = Name.substring(1, 4);
            sub[2] = Name.substring(2, 5);
            sub[3] = Name.substring(3, 6);
            sub[4] = Name.substring(4, 7);
        } else if (LengthOfName == 8) {
            sub[0] = Name.substring(0, 3);
            sub[1] = Name.substring(1, 4);
            sub[2] = Name.substring(2, 5);
            sub[3] = Name.substring(3, 6);
            sub[4] = Name.substring(4, 7);
            sub[5] = Name.substring(5, 8);
        } else if (LengthOfName == 9) {
            sub[0] = Name.substring(0, 3);
            sub[1] = Name.substring(1, 4);
            sub[2] = Name.substring(2, 5);
            sub[3] = Name.substring(3, 6);
            sub[4] = Name.substring(4, 7);
            sub[5] = Name.substring(5, 8);
            sub[6] = Name.substring(6, 9);
        }
        SubName = sub[selectSub(LengthOfName, sub)];// CHOOSING THE SUB STRING WHICH SUITS
        return SubName;
    }

    //Name exclusive
    private int selectSub(int length, String[] sub) {
        int selected=1 ;

        for (int i = 0; i < length-2; i++) {

            if ((sub[i].charAt(0) != 'a') ||// CHECKING THE FIRST LETTER IF ITS A CONSONANT THEREFORE A NOT TRUE CONDITION
                    (sub[i].charAt(0) != 'A') ||
                    (sub[i].charAt(0) != 'o') ||
                    (sub[i].charAt(0) != 'O') ||
                    (sub[i].charAt(0) != 'u') ||
                    (sub[i].charAt(0) != 'U') ||
                    (sub[i].charAt(0) != 'i') ||
                    (sub[i].charAt(0) != 'I') ||
                    (sub[i].charAt(0) != 'e') ||
                    (sub[i].charAt(0) != 'E')) {

                if (sub[i].charAt(1) == 'a' ||// CHECKING FOR A VOWEL
                        sub[i].charAt(1) == 'A' ||
                        sub[i].charAt(1) == 'o' ||
                        sub[i].charAt(1) == 'O' ||
                        sub[i].charAt(1) == 'u' ||
                        sub[i].charAt(1) == 'U' ||
                        sub[i].charAt(1) == 'i' ||
                        sub[i].charAt(1) == 'I' ||
                        sub[i].charAt(1) == 'e' ||
                        sub[i].charAt(1) == 'E') {

                    if (!((sub[i].charAt(2) == 'a') ||// CHECKING THE FIRST LETTER IF ITS A CONSONANT THEREFORE A NOT TRUE CONDITION
                            (sub[i].charAt(2) == 'A') ||
                            (sub[i].charAt(2) == 'o') ||
                            (sub[i].charAt(2) == 'O') ||
                            (sub[i].charAt(2) == 'u') ||
                            (sub[i].charAt(2) == 'U') ||
                            (sub[i].charAt(2) == 'i') ||
                            (sub[i].charAt(2) == 'I') ||
                            (sub[i].charAt(2) == 'e') ||
                            (sub[i].charAt(2) == 'E'))) {

                        selected = i;
                        break;


                    }
                }

            }

        }
        return selected;
    }




}



