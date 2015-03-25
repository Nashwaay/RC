import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class RC {
	
	private static PrintWriter writer;
	private static BufferedReader bReader;


	public static void main(String[] args) throws IOException{
	byte[] initialKey=new byte[256];
	byte[] plainTextFile, cipherTextFile;
	String path;
	
	//taking input to browse plain text file
	Scanner input = new Scanner(System.in);
    System.out.println ("Please enter path of file:");
    path = input.next();
    input.close();
 	
    //reading contents of plain text file
    plainTextFile = readFile(path);
    
    //initializing and doing permutation
 	Logic test=new Logic();
 	test.initialize(initialKey);
 	
 	//encrypt
 	cipherTextFile=test.encrypt(plainTextFile);
 	
 	//writing content into cipher text file
 	writeFile(cipherTextFile);
	}
	
	public static byte[] readFile(String path) throws IOException{
		FileReader reader = null;
		try {
			reader = new FileReader(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bReader = new BufferedReader(reader);
		String text, allText = null;
		byte[] fileArray;
		while((text=bReader.readLine())!=null)
			allText+=text+"\n";
		fileArray=allText.getBytes();
		return fileArray;
	}
	
	
	public static void writeFile(byte[] fileArray) throws IOException{
		String allText;
		allText = fileArray.toString();
		writer = new PrintWriter(new FileWriter("D:\\output.txt"));
		writer.println(allText);		
	}

}
