import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class GaussianElimination {
	public static void main(String[] args) throws IOException {
		Object[][] matEntries;
		int nrows,ncols,dash,t;
		Matrix matrix;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of rows: ");
		nrows=input.nextInt();
		System.out.println("Enter number of columns: ");
		ncols=input.nextInt();
		System.out.println("Enter position of vertical dash (-1 for none): ");
		dash=input.nextInt();
		System.out.println("Enter type of matrix (0 for Z_p, 1 for rational numbers): ");
		t=input.nextInt();
		if(t==0) {
			System.out.println("Enter p: ");
			int p=input.nextInt();
			IntModP.setP(p);
			matEntries=new IntModP[nrows][ncols];
			for(int i=0;i<nrows;++i) {
				for(int j=0;j<ncols;++j) {
					matEntries[i][j]=new IntModP(0);
				}
			}
			matrix=new Matrix<IntModP>((IntModP[][])matEntries,dash);
		}
		else {
			matEntries=new Rational[nrows][ncols];
			for(int i=0;i<nrows;++i) {
				for(int j=0;j<ncols;++j) {
					matEntries[i][j]=new Rational(0);
				}
			}
			matrix=new Matrix<Rational>((Rational[][])matEntries,dash);
		}
		input.nextLine();
		System.out.println("Enter matrix rows:");
		String line;
		for(int i=0;i<nrows;++i) {
			line=input.nextLine();
			matrix.parseFill(line,i);
		}
		FileWriter f=new FileWriter("out.tex");
		String result=matrix.gaussElim();
		//System.out.println(result);
		f.write(result);
		f.close();
	}
}
