
public class eulerNumber_46 {
	public static void main(String[] args){
		int b=(int)10e5;
		int count=0;
		boolean[] flag1 = new boolean[(b+1)];
		int[] prime=new int[100000];
		for(int i=3;i<=b;i+=2){
			flag1[i]=true;
		}
			flag1[2]=true;
		for(int j=3;j<=Math.sqrt(b);j+=2){	
			if (flag1[j]){
				for(int k=j*j;k<=b;k+=2*j){
					flag1[k]=false;
				}
			}
		}
		for(int i=3;i<=(int)b;i++){
			if(flag1[i]){
				prime[count]=i;
				count++;
			}
		}
		int small=findSmall(prime);
		System.out.println(small);
	}
	public static int findSmall(int[] prime){
		int test=1;
		boolean found = false;
		loop:while(!found){
			test+=2;
			int j=0;
			while(test>=prime[j]){
				if(Math.sqrt((test-prime[j])/2)==(int)Math.sqrt((test-prime[j])/2)){
					continue loop;
				}
				j++;
			}
			found=true;
		}
		return test;
	}
}
