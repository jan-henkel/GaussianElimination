public class IntModP implements Arithmetic<IntModP>,Parse<IntModP>,Latex,HasDelim {
	int x;
	static int p=2;
	public static void setP(int mod) {
		p=mod;
	}
	public boolean isZero() {
		return x==0;
	}
	public boolean isEqual(IntModP other) {
		return (x==other.x);
	}
	public boolean isOne() {
		return (x==1);
	}
	public IntModP add(IntModP other) {
		return new IntModP((this.x+other.x)%p);
	}
	public IntModP	mul(IntModP other) {
		return new IntModP((this.x*other.x)%p);
	}
	public IntModP inv() {
		int z=p,w=x,zx=0,wx=1; //invariant: wx*x+wp*p=w, zx*x+zw*w=z
		int tmp,ratio;
		while(w>1) {
			ratio=z/w;
			tmp=w;
			w=z%x;
			z=tmp;
			tmp=wx;
			wx=zx-ratio*wx;
			zx=tmp;
		}
		return new IntModP((wx%p+p)%p);
	}
	public IntModP neg() {
		return new IntModP((p-x)%p);
	}
	public IntModP(final int number) {
		x=(number%p + p)%p;
	}
	public String latex() {
		return ""+x;
	}
	public void parse(String s) {
		x=(Integer.parseInt(s)%p+p)%p;
	}
}
