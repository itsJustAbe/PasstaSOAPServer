package passwordgenerator;

/**
 * Created by t848 on 17-Feb-16.
 */
public class Check {
    int score;
    int length, num = 0;
    char[] p;

    void length() {
        //1.length
        if (length <= 6) { //weak
            score += 10;
        } else if (length <= 12) { //medium
            score += 20;
        } else { //strong
            score += 30;
        }
    }

    void uclc() {
        int lc = 0, uc = 0;
        for (int i = 0; i < length; i++) {
            if (Character.isLowerCase(p[i])) {
                lc += 1;
            }
            if (Character.isUpperCase(p[i])) {
                uc += 1;
            }
            i++;
        }

        if (lc > 0 && uc > 0) //both lc and uc are present
        {
            score += 10;
            if (lc > 4 || uc > 4) { //good mix
                score += 10;
            }
        }
    }

    void integer() {
        for (int i = 0; i < length; i++) {
            if (Character.isDigit(p[i])) {
                num += 1;
            }

            i++;
        }
        if (num > 0)  //numbers yes no
        {
            score += 10;
            if (num > 4) {  //good mix
                score += 10;
            }

        }
    }


    Integer strength(String a) {
        p = a.toCharArray();
        length = a.length();
        int num = 0;
        float alph, percentage;

        //factors
        length();
        //2.UPPER CASE AND LOWER CASE
        uclc();

        //3.Integers
        integer();

        //4.Concentration(bruteforce)
        alph = length - num;
        percentage = (alph / length) * 100;
        if (percentage >= 60 && percentage < 80) {
            score += 30;
        } else if (percentage >= 40 && percentage < 60) {
            score += 20;
        } else if (percentage < 40){
            score += 10;
        }

        return score;
    }

}
