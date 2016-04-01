
public class eulerNumber_71 {
	public static void main(String[] args){
		int nu=1;
		int de=1;
		double close=3.0/7-2.0/5;
		double nuClose=2;
		double deClose=5;
		for(int i=1;i<=1000000;i++){
			de=de+1;
			double b=3.0/7-((double)nu)/de;
			if(b<=0){
				continue;
			}
			while(b<close){
				close=b;
				nuClose=nu;
				deClose=de;
			}
			nu=nu+1;
		}
		System.out.println((int)nuClose+"/"+(int)deClose);
	}
}
