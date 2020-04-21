class time {
	public static void main(String[] args) {
		System.out.println("3456789分钟");
		long minute=3456789;
		converst(minute);
	}
	public static void converst(long minute){
		int years=0,days=0;
		years=(int) minute/(365*24*60);
		days=(int)minute/(60*24)%365;

		System.out.print("3456789分钟是"+years+"年");
		System.out.println(days+"天");

		
	}
}