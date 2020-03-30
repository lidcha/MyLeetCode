package factorialTrailingZeroes_172;
/**
* @author 
* @createDate ：2020年3月30日
*/
public class FactorialTrailingZeroes_172 {
	
	
	/*
	 * 解法也挺简单的，就是看n中有多少个5，但是一开始并没有想起来，看了题解，其实是有规律的，10!有两个5，于是就有两个0
	 * ，15!中，15/5=3，于是15!结果有3个0；25/5=5，应该算6个5，于是25!结果有6个0；
	 */
	public int trailingZeroes_v1(int n){
		int cnt=0;
		while(n>=5){
			n/=5;
			cnt+=n;
		}
		return cnt;
	}
	public static void main(String[] args) {
		int n = new FactorialTrailingZeroes_172().trailingZeroes_v1(25);
		System.out.println(n);
	}
}
