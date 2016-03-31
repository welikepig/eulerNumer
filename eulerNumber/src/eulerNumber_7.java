
public class eulerNumber_7 {
	private int size;
	boolean[] flag1;
	boolean isFind;
	public eulerNumber_7(){
		size=(int)1000000;
		flag1 =new boolean[size];
	}
	public void grow(){
		size=2*size;
		flag1 =new boolean[size];
		
	}
	
	public void find(int n,int start){
		int count=0;
		for(int i=1;i<(int)size;i++){
			if(flag1[i]){
				count++;
				if(count==n){
					System.out.println(i);
					isFind=true;
					break;
				}
			}
		}
		if(!isFind){
			// To grow the size of boolean table in order to get a reasonable size not a very big size at first
			grow();
			prime();
			find(n,size/2);
		}
		
	}
	public void prime(){
		for(int i=3;i<size;i+=2){
			flag1[i]=true;
		}
			flag1[2]=true;
		for(int j=3;j<=Math.sqrt(size);j+=2){	
			if (flag1[j]){
				for(int k=j*j;k<=size;k+=2*j){
					flag1[k]=false;
				}
			}
		}
	}
	public static void main(String[] args){
		eulerNumber_7 eN=new eulerNumber_7();
		
	
		eN.prime();
		boolean[] fl=eN.flag1;
		System.out.println(fl[999109]);
		eN.find(10001,1);
	}
}