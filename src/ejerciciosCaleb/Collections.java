package ejerciciosCaleb;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Collections {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("inputFile.txt"));
		List<String> lyrics = new ArrayList<String>();
		while(sc.hasNextLine()) {
			lyrics.add(sc.nextLine());
		}
		for(int i=0; i<lyrics.size(); i++) {
			System.out.println(lyrics.get(i));
		}
		sc.close();
	}
}
 