package club.banyuan;

import java.util.Random;

class randomTest{
static private int i;

public static int randomInt(int from,int to){
	Random random = new Random();
	i = random.nextInt(to - from + 1) + from;
	return i;
}
public static void main(String[] args) {
	randomTest r = new randomTest();
	System.out.println(r.randomInt(-10,5));
}

}
