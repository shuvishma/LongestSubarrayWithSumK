import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in)) ;
        int test = Integer.parseInt(read.readLine()) ;
        while(test-- > 0) {
            String[] str = read.readLine().trim().split(" ") ;
            int n = Integer.parseInt(str[0]) ;
            int k = Integer.parseInt(str[1]) ;
            int[] arr = new int[n] ;
            str = read.readLine().trim().split(" ") ;
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(str[i]) ;
            }

            HashMap<Integer,Integer> mp = new HashMap<>() ;
            int maxLength = 0 ;
            int sum = 0 ;
            for(int i=0; i<n; i++) {
                sum += arr[i] ;
                if(sum == k) {
                    maxLength = i+1 ;
                }

                if(mp.containsKey(sum)==false) {
                    mp.put(sum, i) ;
                }
                
                if(mp.containsKey(sum-k)==true) {
                    maxLength = Math.max(maxLength, i-mp.get(sum-k)) ;
                }
            }
            System.out.println(maxLength) ;
        }

    }
}