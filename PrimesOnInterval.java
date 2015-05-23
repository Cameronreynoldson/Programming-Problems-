import java.util.Arrays;
import java.util.Scanner;


public class PrimesOnInterval {
	primeSieve PS;
  int A,B,K;
  
  
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		A = sc.nextInt();
		B = sc.nextInt();
		K = sc.nextInt();
		
		PS = new primeSieve(B+B+10);
		
		int low = K;
		int high = B-A+1;
		
		int mid = (low+high)/2;
		int ans = -1;
		
		while(low<=high){
			mid = (low+high)/2;
			if(F(mid)){
				ans = mid;
				high = mid - 1;
			}
			else {
				low = mid+1;
			}
		}

		
		System.out.println(ans);
		
		

	}

	public static boolean F(int L) {
		int count = 0;
		for(int a=A;a<A+L;a++){
			if(PS.isPrime(a))count++;
		}
		if(count<K)return false;
		for(int b=A+L;b<=B;b++){
			if(PS.isPrime(b-L))count--;
			if(PS.isPrime(b))count++;
			if(count<K)return false;
		}
		return true;
	}

 class primeSieve {
	int[] prime;
	primeSieve(int N){
		prime = new int[N+1];
		prime[1] = -1;
		int M = (int)Math.sqrt(N);
		for(int a=2;a<=M;a++)
			if(prime[a]==0)
				for(int b=a*a;b<=N;b+=a)
					if(prime[b]==0)
						prime[b]=a;
	}	
	boolean isPrime(int N){
		return prime[N]==0;
	}
}

}
