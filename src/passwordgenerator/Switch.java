package passwordgenerator;

/**
 * Created by t848 on 11-Jan-16.
 */
public class Switch {

    // Process to convert received string to binary
    private String binaryConverter(int x) {
        
        String y = Integer.toBinaryString(x);
        return String.format("%.3s",y);
    }

    // Process to convert received string to octal
    private String octalConverter(int x) {
        return Integer.toOctalString(x);
    }

    // Process to convert received string to hexa decimal
    private String hexConverter(int x) {
        return Integer.toHexString(x);
    }


    // The main switcher
    String switcher(int choiceOfUser, int valueToBeConverted, String name) {
        // OBJECT TO USE CLASS ROM OPTION 5
        Option5 Do = new Option5();

        String x = null;

        switch (choiceOfUser) {

            // Converting string to binary format
            case 1:x = binaryConverter(valueToBeConverted);
                break;

            case 2:

                // Converting string to octal
                x = octalConverter(valueToBeConverted);
                break;

            case 3:
                 // Converting string to hexadecimal
                x = hexConverter(valueToBeConverted);
                break;
            case 4:
                // Sending string to the wordgen 

                if(name == null) x= Do.genWord(valueToBeConverted);
                
                // Sending it to the Name specific word generator
                else x= Do.genWord(name,valueToBeConverted);
                break;

                default:
                System.out.println("Error :  wrong input chosen, choices range from 1-4.");
                System.exit(5);
                break;
        }

        return x;
    }
}
