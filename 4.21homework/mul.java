 class mul {
 	public static void main(String[] args) {
 		int num1=0,num2=0;
 		int mul=0;
 		System.out.println("请输入两个数：");
 		java.util.Scanner sc = new java.util.Scanner(System.in);
 		num1=sc.nextInt();
 		num2=sc.nextInt();
 		mul=multiply(num1,num2);
 		System.out.printf("两数之积为%d\n",mul);
 	}
    public static int multiply (int n1,int n2){
    	int result=0;
    	for (int i=0;i<n1;i++){
 			result+=n2; 
 		}
 		return result;
    }

 }

 