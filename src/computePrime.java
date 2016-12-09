import java.util.Scanner;
/* @Project: Compute prime
 * 
 * @Author: Juncheng Li
 * 
 * @Feature: This program could compute prime numbers between 2 trillion and 2 trillion + 100k in 50ms !
 */
public class computePrime {
    public static void main(String[] args) {
        long start;
        long end;
        System.out.println("Start=");
        start=new Scanner(System.in).nextLong();
        System.out.println("End=");
        end=new Scanner(System.in).nextLong();
        System.out.println("In Computing...Please Wait...");
        int diff = (int) (end - start); /* the length of array must be less than int */
        int count = 0;
        boolean prime[] = new boolean[diff + 1];
        long time = System.currentTimeMillis();
        for (int i = 0; i <= diff; i++) {
            prime[i] = true;
        }
        if(start == 1)
        	prime[0] = false;
        double endR = Math.sqrt(end);
        for (int i = 2; i <= endR; i++) {
        	if(start<=100000){   /*avoid the accuracy problem when start variable is small*/
                for (long j = i * i ; j <= end; j = j + i) {
                	if (j >= start){
                		int k = (int) (j - start); /* do this to record the result from start variable */
                        prime[k] = false;
                	}
                }
        	}else{
            for (long j = i * ((long)(start / i)) ; j <= end; j = j + i) {
            	if (j >= start){
            		int k = (int) (j - start); /* do this to record the result from start variable */
                    prime[k] = false;
            	}
            }
        }
        }

        for (int i = 0; i <= diff; i++) {
            if (prime[i] == true) {
                count++;
            }

        }
        
        System.out.println("The number of prime is : " + count);
        System.out.println("Running Time : " + (System.currentTimeMillis() - time)+ "ms");

    }

}