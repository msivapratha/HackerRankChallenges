import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ManipulateArray {

    // Complete the arrayManipulation function below.
    /*static long arrayManipulation(int n, int[][] queries) {
    	long[] manipulateArr = new long[n];
        Arrays.stream(queries).forEach(a -> {
            for(int i=a[0]-1; i < a[1]; i++){
                manipulateArr[i] = manipulateArr[i] + a[2];
            }
        });
    return Arrays.stream(manipulateArr).max().getAsLong();
            
    }*/
	
	static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n];
        for(int i=0;i<n;i++) arr[i]=0;

        Arrays.stream(queries).forEach(a -> {
            arr[a[0]-1]+=a[2];
            if(a[1]<n) arr[a[1]]-=a[2]; 
        });
    
    long max=0,temp = 0;
    for(int i=0; i<n; i++){
        temp += arr[i];
        if(max<temp) max = temp;
    }

    return max;
}
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
