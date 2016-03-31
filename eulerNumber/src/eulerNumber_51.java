
public class eulerNumber_51 {
	public static void main(String[] args){
		int b=(int)10e6;
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
		//This question is more complicated, what we first need know is how to choose the range
		//Since we know,the last digit of a prime is always 1,3,7,9 
		//So the last digit cannot be replace
		// Due to a num%3==0 equals sum of every digit of num %3==0
		//So, we can prove that there only one way to choose the digits num of part of number 3,6,9....
		//In order to get the samllest one, so 3 is a best number to be choose in this case
		// We can start decide the length of the Num, we can start trying 4,5,6 digits
		int four=fourdigit(flag1);
		System.out.println(four);
		int five=fivedigit(flag1);
		System.out.println(five);
		sixdigit(flag1);
		//The output is 929393, so the smallest is 121313, since I find it in six digits
		//I don't need to calculate seven digits
		System.out.println("According to the output, the samllest one is 121313");
	}
	public static int fourdigit(boolean[] flag){
		loop:for(int i=1;i<=9;i+=2){
				if(i==5) continue;
				int count=10;
				for(int j=9;j>=0;j--){
					if(!flag[1110*j+i]||1110*j+i<1000){
						count--;
						if(count<8){
							continue loop;
						}
					}
				}
				if(count==8){
					return 1110+i;
				}
			}
			return -1;
	}
	public static int fivedigit(boolean[] flag){
			String[] data={"11100","01110","10110","11010"};
			for(int k=0;k<4;k++){
				loop:for(int i=1;i<=99;i+=2){
					  	if(i%5==0) continue;
					  	int first=i/10;
					  	int last=i%10;
						int count=10;
						int num=0;
						for(int j=0;j<=9;j++){
							
							switch(data[k]){
								case"11100":
									num=11100*j+first*10+last;
									break;
								case"01110":
									num=first*10000+1110*j+last;
									break;
								case"10110":
									num=10110*j+first*1000+last;
									break;
								case"11010":
									num=11010*j+first*100+last;
									break;
							}
						if(!flag[num]||num<10000){
							count--;
							if(count<8){
								continue loop;
							}
						}
					}
					if(count==8){
						return num;
					}
					
				}
			}return -1;
		}
	public static void sixdigit(boolean[] flag){
		String[] data={"111000","011100","101100","110100","101010","100110","001110","010110","011010","110010"};
		for(int k=0;k<10;k++){
			loop:for(int i=1;i<=999;i+=2){
				  	if(i%5==0) continue;
				  	int first=i/100;
				  	int middle= (i/10)%10;
				  	int last=i%10;
					int count=10;
					int num=0;
					for(int j=0;j<=9;j++){
						switch(data[k]){
							case"111000":
								num=111000*j+first*100+10*middle+last;
								break;
							case"011100":
								num=first*100000+11100*j+10*middle+last;
								break;
							case"101100":
								num=101100*j+first*10000+10*middle+last;
								break;
							case"110100":
								num=110100*j+first*1000+10*middle+last;
								break;
							case"101010":
								num=101010*j+first*10000+100*middle+last;
								break;
							case"100110":
								num=100110*j+first*10000+1000*middle+last;
								break;
							case"001110":
								num=1110*j+first*100000+10000*middle+last;
								break;
							case"010110":
								num=10110*j+first*100000+1000*middle+last;
								break;
							case"011010":
								num=11010*j+first*100000+100*middle+last;
								break;
							case"110010":
								num=110010*j+first*1000+100*middle+last;
								break;
						}
						if(!flag[num]||num<100000){
							count--;
							if(count<8){
								continue loop;
							}
						}
					}
					if(count==8){
						System.out.println("The string is like: "+data[k]);
						System.out.println("num in string: "+i);
						System.out.println("Final output: "+num);
						continue loop;
					}	
			}
		}
		return;
	}
}
