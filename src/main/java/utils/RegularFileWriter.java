package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class RegularFileWriter {

	public RegularFileWriter(String string) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		String[] names = { "abc", "pqr", "xyz" };
		FileWriter fw = null;
		try {
			fw = new FileWriter("C:\\Users\\16309\\NewSelfLearn\\RedearsSelfLearning\\resources\\output.txt");
			BufferedWriter writer = new BufferedWriter(fw);

			writer.write("This is a First Line.");
			writer.write("\nThis is Second Line.");

			for (String name : names) {
				writer.write("\n" + name);
			}

			writer.close();

			System.out.println("The file has ben written successfully.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
