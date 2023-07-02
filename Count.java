package backend;

public class Count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1212345;
		int temp = n;
		int c=0;
		while(temp>0){
			temp=temp/10;
			c++;
		}
		System.out.println(c);

	}

}
