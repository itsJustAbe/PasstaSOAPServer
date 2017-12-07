package passwordgenerator;

/**
 * Created by techn on 26-Dec-16.
 */
public class ThePin {
        private int a;// FIRST DIGIT
        private int b;// SECOND DIGIT
        private int c;// THIRD DIGIT
        private int d;// LAST DIGIT
        private int pin;

        ThePin(int x) {
            x = pin;
            location();
        }

        // Store locations in these variables 
        int loc0, loc1, loc2, loc3, loc4, loc5, loc6, loc7, loc8, loc9, loc10;


        void location() {
            int num = pin;//storing the pin in num

            takeOut(num);//separating the 4 digits

            int sum = a + b + c + d;//SUM OF ALL THE DIGITS OF PIN

            if (sum <= 15) ifLow();//IF THE SUM IS LESS THAN 15
            else procedure();//THE PROCEDURE

        }

        private void ifLow() {
            //IF ANY OF THE DIGIT IS 0 THEN TURN IT INTO 8
            if (a == 0) a = 8;
            if (b == 0) b = 8;
            if (c == 0) c = 8;
            if (d == 0) d = 8;
           
            // THEN CHECK
            if ((a + b + c + d) > 15){
                // If sum is greater than 15 then start procedure
                procedure();
            }
            else {
                while ((a + b + c + d) < 15) {
                    if (a < 9) {
                        a++;
                        if (a + b + c + d > 15) {
                            procedure();
                            break;
                        }
                    }
                    if (b < 9) {
                        b++;
                        if (a + b + c + d > 15) break;

                    }
                    if (c < 9) {
                        c++;
                        if (a + b + c + d > 15) break;

                    }
                    if (d < 9) {
                        d++;
                        if (a + b + c + d > 15) break;

                    }
                }
                procedure();
            }
        }

        //SEPERATE THE DIGITS OF THE PIN FOR PROCESSING
        private void takeOut(int num) {
            d = num % 10;//LAST DIGIT OF PIN
            c = (num / 10) % 10;//SECOND LAST OF THE PIN
            b = (num / 100) % 10;//SECOND DIGIT OF THE PIN
            a = num / 1000;//FIRST DIGIT OF THE PIN
        }

        private void procedure() {
            //LOCATION 0-10
            loc0 = first0();
            loc1 = first1();
            loc2 = first2();
            loc3 = first3();
            loc4 = first4();
            loc5 = second1();
            loc6 = second2();
            loc7 = second3();
            loc8 = third1();
            loc9 = third2();
            loc10 = third3();
        }

        //A-B(0)
        private int first0() {
            // Default value if If else ladder doesnt output a result
            int loc = 1;

            if (a > b && (a - b > b - c) && (a - b > c - d) && (a - b > d - a)) loc = a - b;
            else if (b > c && (b - c > c - d) && (b - c > c - d) && (b - c > d - a)) loc = b - c;
            else if (c > d && (c - d > a - b) && (a - b > b - c) && (a - b > d - a)) loc = c - d;
            else if (d > a && (d - a > a - b) && (d - a > b - c) && (d - a > c - d)) loc = d - a;

            return loc;
        }

        //A(1)
        private int first1() {
            // Default Value
            int loc = 3;

            if (a != 0) loc = a;
            else if (b != 0) loc = b;
            else if (c != 0) loc = c;
            else if (d != 0) loc = d;

            return loc;
        }

        //A+B(2)
        private int first2() {
            // Default value
            int loc = 14;
            if ((a + b) > c && (a + b) > d) loc = a + b;

            else if ((b + c) > a && (c + b) > d) loc = c + b;

            else if ((a + d) > b && (a + d) > c) loc = a + d;

            else if ((c + d) > a && (c + d) > b) loc = c + d;


            return loc;

        }

        //A+B+C(3)
        private int first3() {
            // Default value 
            int loc = 18;

            if ((a + b + c) > (a + d) && (a + b + c) > (c + d) && ((a + b + c) > (b + d)))
                loc = a + b + c;
            else if ((a + b + d) > (a + c) && (a + b + d) > (c + d) && ((a + b + d) > (b + c)))
                loc = a + b + d;
            else if ((c + b + d) > (a + d) && (d + b + c) > (c + a) && ((d + b + c) > (b + a)))
                loc = c + b + d;
            else if ((a + d + c) > (a + d) && (a + d + c) > (c + d) && ((a + d + c) > (b + d)))
                loc = a + d + c;

            return loc;

        }

        // A+B+C+D(4)
        private int first4() {
            // Default value 
            int loc;
            return loc = a + b + c + d;
        }

        //A+(B*C)(5)
        private int second1() {
            // Default value 
            int loc = 40;
            if (a + (b * c) > (a + b + d))
                loc = a + (b * c);
            else if (b + (a * c) > (a + b + d))
                loc = b + (a * c);
            else if (c + (a * b) > (a + b + d))
                loc = c + (a * b);


            return loc;
        }

        //D+(B*C)(6)
        private int second2() {
            // Default value 
            int loc = 42;
            if (d + (b * c) > (a + b + c))
                loc = d + (b * c);
            else if (b + (d * c) > (a + b + c))
                loc = b + (d * c);
            else if (c + (d * b) > (a + b + c))
                loc = c + (d * b);
            return loc;
        }

        //D+(A*C)(7)
        private int second3() {
            // Default value 
            int loc = 45;

            if (d + (a * c) > (a + b + c)) loc = d + (a * c);

            else if (a + (d * c) > (a + b + c)) loc = a + (d * c);

            else if (c + (a * b) > (a + b + c)) loc = c + (a * b);

            return loc;
        }

        // A*B(8)
        private int third1() {
            // Default value 
            int loc = 21;//EXCEPTIONAL CASE

            if ((a * b) > (a + b + c)) loc = a * b;
            else if ((b * c > (a + b + c)))
                loc = b * c;
            else if ((c * d > (a + b + c)))
                loc = c * d;
            else if ((a * d) > (a + b + c))
                loc = a * d;
            else if ((c * a) > (a + b + c))
                loc = c * a;
            else if ((d * b) > (a + b + c))
                loc = d * b;

            return loc;
        }

        //A*A(9)
        private int third2() {
            // Default value
            int loc = 80;

            if ((a * a > b * b) && (a * a > c * c) && (a * a > d * d)) loc = a * a;
            else if ((b * b > c * c) && (c * c > d * d)) loc = b * b;
            else if (c * c > d * d) loc = b * b;
            else loc = d * d;// D IS THE LARGEST NUMBER IF THIS HAPPENS

            return loc;
        }

        //A*A*A(10)
        private int third3() {
            // Default value 
            int loc = 90;
            if (a > 1 && a <= 4) loc = a * a * a;
            else if (b > 1 && b <= 4) loc = b * b * b;
            else if (c > 1 && c <= 4) loc = c * c * c;
            else if (d > 1 && d <= 4) loc = d * d * d;

            return loc;
        }
    }



