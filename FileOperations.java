import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class FileOperations {
	public static ArrayList<Character> getBoardConfiguration(String fileName) throws IOException{
		String line = null;
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		line = bufferedReader.readLine();
		ArrayList<Character> output = new ArrayList<Character>();
		for (char a : line.toCharArray())
			output.add(a);
		bufferedReader.close();
		return output;
	}
	
	public static void writeOutput(Output output, String fileName) throws IOException{
		FileWriter fileWriter = new FileWriter(fileName);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(output.toString());
		bufferedWriter.close();
	}
}
