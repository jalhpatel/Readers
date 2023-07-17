package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RegularFileReader {

	public static void main(String[] args) {

		try {
			FileReader fr = new FileReader(
					"C:\\Users\\16309\\NewSelfLearn\\RedearsSelfLearning\\resources\\output.txt");
			BufferedReader reader = new BufferedReader(fr);

			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
