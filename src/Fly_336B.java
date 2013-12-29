import java.io.*;
import java.util.*;
 
public class Fly_336B {
	
	long m;
	int R;
	
	double dist (long i, long j)
	{
		if ((i-1)/m == (j-1)/m)
		{
			return (j-i)*2*R;
		}
		else
		{
			if (j-i == m)
			{
				return 2*R;
			}
			else if (j-i == m+1 || j-i == m-1)
			{
				return (2+Math.sqrt(2))*R;
			}
			else
			{
				return (2*(Math.abs(j-i-m)-1)+2*Math.sqrt(2))*R;
			}
		}
	}

	void run() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("336B.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		double avg = 2*m*R;
		for (int i = 1; i < m; i++)
		{
			avg += 2*(m-i)*dist(i/m + 1, m+1+i%m);
		}
		System.out.println(avg/(m*m));
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		Fly_336B prog = new Fly_336B();
		prog.run();
	}
}

