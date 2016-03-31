
public class eulerNumber_37 {
	public static void main(String[] args){
		int b=(int)10e6;
		int count=0;
		boolean[] flag1 = new boolean[(b+1)];
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
	
		int sum=0;
		for(int i=11;i<=b;i++){
			if(check(i,flag1)){
				count++;
				System.out.print(i+" ");
				sum+=i;
				if(count==11){
					break;
				}
			};
		}
		System.out.println("\nSum of them are "+sum);
	}

	private static boolean check(int i,boolean[] flag) {
		if(i<=10) return false;
		String str=i+"";
		int len=str.length()-1;
		while(i!=0){
			String	temp=str.substring(len--, str.length());
			if(!flag[Integer.valueOf(temp)]){
				return false;
			}
			if(!flag[i]){
				return false;
			}
			i=i/10;

		}
		return true;
	}
}
