import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
            long sLength = (n/s.length());
            long extraChar = (n % s.length());
            long count = 0l;

            long tempCount = 0l;
            for(int i=0; i< s.length() ; i++){

                if('a' ==s.charAt(i)){
                    ++tempCount;
                }
            }
         
            count = sLength*tempCount;

            
            tempCount = 0l;
            for(int i=0; i< extraChar ; i++){
                if('a' ==s.charAt(i)){
                    ++tempCount;
                }
            }

            count = count + tempCount;
            
            return count;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
