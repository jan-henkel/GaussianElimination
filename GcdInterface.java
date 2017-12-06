public class Gcd<T> {
	public static T gcd(T a, T b) {
		if(b==0) {
			return a;
		}
		return gcd(b,a%b);
	}
}
