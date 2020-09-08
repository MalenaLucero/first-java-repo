package ejerciciosCaleb;

public class MultidimensionalArray {
	public static void main(String[] args) {
		int [][] data = {
				{1, 2, 3, 4},
				{10, 20, 30, 40, 50},
				{15,25, 35, 45, 55, 65, 75}
		};
		
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
	}
}
