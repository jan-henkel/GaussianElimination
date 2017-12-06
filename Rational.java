public class Rational implements Arithmetic<Rational>,Parse<Rational>,Latex,HasDelim {
	int a,b;
	public boolean isEqual(Rational other) {
		return (a==other.a) && (b==other.b);
	}
	public boolean isOne() {
		return (a==b);
	}
	public Rational add(Rational other) {
		return new Rational(a*other.b+other.a*b,b*other.b);
	}
	public Rational	neg() {
		return new Rational(-a,b);
	}
	public Rational	mul(Rational other) {
		return new Rational(a*other.a,b*other.b);
	}
	public Rational	inv() {
		return new Rational(b,a);
	}
	public Rational() {
		a=0;
		b=1;
	}
	public Rational(final int numerator) {
		a=numerator;
		b=1;
	}
	public Rational(final int numerator,final int denominator) {
		a=numerator;
		b=denominator;
		simplify();
	}
	private void simplify() {
		if(b<0) {
			a=-a;
			b=-b;
		}
		int g=Gcd.gcd(Math.abs(a),Math.abs(b));
		a/=g;
		b/=g;
	}
	public boolean isZero() {
		return a==0;
	}
	public String latex() {
		if(b!=1) {
			return "\\frac{"+a+"}{"+b+"}";
		}
		else {
			return ""+a;
		}
	}
	public void parse(String s) {
		String[] nd=s.split("/");
		a=Integer.parseInt(nd[0]);
		b=1;
		if(nd.length>1) {
			b=Integer.parseInt(nd[1]);
		}
		simplify();
	}
	public boolean hasDelim() {
		return (a<0);
	}
}
