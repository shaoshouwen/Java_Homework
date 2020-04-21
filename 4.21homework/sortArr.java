  class sortArr{
  public static void main(String[] args) {
    int []arr1={13,26,-3,4,54,26,37,18,69,-10};
    boolean a=true;
    System.out.println("请输入布尔值：");
    java.util.Scanner sc = new java.util.Scanner(System.in);
    a=sc.nextBoolean();
    Sort(arr1,a);
  }

  static void Sort(int arr[],boolean isAsc)
  {
    int len=arr.length;
            if(isAsc)
            {
              
              sort(arr);
            }
            else{

                   for(int i=0;i<len;i++)
                {
                int max=i;
                int j=i+1;
                while(j<len)
                {
                     if(arr[j]>arr[max])
                     
                       max=j;
                        j++;
                    }
                    if(max!=i)
                    {
                      swap(arr,i,max);
                    }
                    
               }
               print(arr,len);
            }
  }
static void sort(int arr[])
{
  int len=arr.length;
  for(int i=0;i<len;i++)
              {
                int min=i;
                int j=i+1;
                while(j<len)
                {
                     if(arr[j]<arr[min])
                     
                       min=j;
                        j++;
                    }
                    if(min!=i)
                    {
                      swap(arr,i,min);
                    }
                     
              }
               print(arr,len);
}


static  void swap(int arr[],int a,int b){
  int temp=arr[a];
  arr[a]=arr[b];
  arr[b]=temp;
}
 static void print(int arr[], int n)
{
	n=arr.length;

	for (int j = 0; j < n; j++) {
		System.out.printf("[%d]=%d  ", j,arr[j]);
		if((j+1)%5==0)
		{
			System.out.println();
		}

	}
	System.out.printf("\n");
}

}
