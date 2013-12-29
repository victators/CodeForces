import java.io.*;
import java.util.*;
 
public class BeautifulStrings_336D {
	
	public final static int mod = 1000000007;
	static long [] f;
	
	static void fact (int j)
	{
		f = new long[j];
		f[0] = 1;
		for (int i = 1; i < j; i++)
		{
			f[i] = f[i-1]*i%mod;
		}
	}
	
	static long exp (long x, long n)
	{
		x%=mod;
		if (n == 0)
			return 1;
		else if (n == 1)
			return x%mod;
		else if (n%2 == 0)
			return exp(x*x%mod, n/2)%mod;
		else if (n%2 == 1)
			return x*exp(x*x%mod, (n-1)/2)%mod;
		else
			return 1;
	}

	static int ncr (int n, int r)
	{
		return (int)(f[n]*exp(f[n-r]*f[r]%mod,(long)mod-2)%mod);
	}

	void run() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("336D.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		fact(n+m);
		long count = 0;
		if (n == 0 && m == 0)
		{
			System.out.println(count);
			System.exit(0);
		}
		if (n == 0)
		{
			if (m == 1)
			{
				System.out.println(g);
				System.exit(0);
			}
			else
			{	
				System.out.println(1-g);
				System.exit(0);
			}
		}
		if (m == 0)
		{
			if (n%2 == 0)
			{	
				System.out.println(g);
				System.exit(0);
			}
			else
			{
				System.out.println(1-g);
				System.exit(0);
			}
		}
		if (m == 1)
		{
			if (n%2 == 0)
			{
				if (g == 0)
				{
					count--;
				}
				else
				{
					count++;
				}
			}
			else
			{
				if (g == 0)
				{
					count++;
				}
				else
				{
					count--;
				}
			}
			
		}
		if (g == 0)
			for (int i = 1; i <= n+1; i+=2)
			{
				count += ncr(n+m-i,m-1);
				count %= mod;
			}
		else
			for (int i = 2; i <= n+1; i+=2)
			{
				count += ncr(n+m-i,m-1);
				count %= mod;
			}
		System.out.println(count);
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		Fly_336B prog = new Fly_336B();
		prog.run();
	}
}
