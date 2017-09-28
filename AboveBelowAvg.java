import java.util.Scanner;

public class AboveBelowAvg {

    public static void main(String[] args) {
        int[] chicken = new int [100];
        Scanner potato = new Scanner(System.in);
        int avg = 0;
        int below = 0;
        int above = 0;
        int equal = 0;
        int count = 0;
        
        for ( int j = 0; j < chicken.length; j++) {
        System.out.println("Type the number:");
        chicken[j] = potato.nextInt();
            if (chicken[j] >= 0) {
                avg += chicken[j];
                count++;
                if (chicken[j] > avg / count ) {
                    above += 1;
                }
                if (chicken[j] < avg / count) {
                    below += 1;
                } else {
                    equal += 1;

                }
                
            }
            else{
                j = 101;
               
        }
    }
        System.out.println("There are " + above + " numbers above average");
        System.out.println("There are " + below + " numbers below average");
        System.out.println("There are " + equal + " numbers are equal to the average");
    

}
}
