public class IntModP implements Arithmetic<IntModP>,Parse,Latex,HasDelim {
	int x;
	//could make this non-static if needed
	//(would make objects bigger)
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
		//invariant: wx*x+wp*p=w, zx*x+zp*p=z
		//no need to explicitly track wp, zp
		//(initially wp=0,zp=1)
		int z=p,w=x,zx=0,wx=1; 
		int tmp,ratio;
		while(w>1) {
			ratio=z/w;
			tmp=w;
			w=z%x;
			z=tmp;
			tmp=wx;
			wx=zx-ratio*wx;
			zx=tmp;
			//same linear operation and swap would take place in wp, zp
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
