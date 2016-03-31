
public class eulerNumber_23 {
	private final int MAX = 28123;
	boolean[] Ab;
	public eulerNumber_23(){
		Ab=new boolean[MAX+1];
	}
	
	public static void main(String[] args){
		int sum=0;
		eulerNumber_23 abundant=new eulerNumber_23();
		boolean[] test=abundant.Abun();
		loop:for(int i=1;i<=abundant.MAX;i++){
			for(int j=1;j<i;j++){
				if(test[j]&&test[i-j]){
					
					continue loop;
				}
			}sum+=i;
		}
		
		System.out.println(sum);

	}
	
	public boolean isAbun(int n){
		if(n<12) return false;
		int sum=1;
		for(int i=2;i<=(int)Math.sqrt(n);i++){
			if(n%i==0){
				sum+=i+n/i;
			}
		}
		if((int)Math.sqrt(n)==Math.sqrt(n)){
			sum-=(int)Math.sqrt(n);
		}
		return sum>n;
		
	}
	public boolean[] Abun(){
		for(int i=12;i<=MAX;i++){
			Ab[i]=isAbun(i);
		}
		return Ab;
	}
}
