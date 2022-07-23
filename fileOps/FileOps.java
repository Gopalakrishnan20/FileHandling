package fileOps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileOps {
	
	File file=new File("C:\\Users\\USER\\Desktop\\Mphasis\\JAVA\\FileOps\\src\\fileOps\\test.txt");
	
	void readFile() {
		int lineCount=0;
		int sentanceCount=0;
		int wordCount=0;
		int charCount=0;
		try {
			FileReader reader=new FileReader(file);
			BufferedReader Bread=new BufferedReader(reader);
			String line=Bread.readLine();
			System.out.println("The Content:");
			while(line!=null)
			{
				String[] sentance=line.split("[.]");
				sentanceCount+=sentance.length;
				String[] word=line.split(" ");
				wordCount+=word.length;
				System.out.println("\t"+line);
				charCount+=line.length();
				line=Bread.readLine();
				++lineCount;
			}
			System.out.println("No of Lines:"+lineCount);
			System.out.println("No of sentances:"+sentanceCount);
			System.out.println("No of words:"+wordCount);
			System.out.println("No of characters:"+charCount);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void reWriteFile(String input)
	{
		try {
			FileWriter w=new FileWriter(file);
			BufferedWriter b=new BufferedWriter(w);
			b.write(input);
			b.flush();
			System.out.println("Contents ReWriten");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void writeFile(String input)
	{
		FileWriter writer;
		try {
			writer = new FileWriter(file,true);
			BufferedWriter Bwrite=new BufferedWriter(writer);
			Bwrite.write(input);
			Bwrite.flush();
			System.out.println("String Appended Successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opt;
		int flag=0;
		String input;
		FileOps obj=new FileOps();
		Scanner in=new Scanner(System.in);
		do {
			
			System.out.println("\t !..Welcome to File Handler..!");
			System.out.println("Operations Available:");
			System.out.println("1.Read a File");
			System.out.println("2.ReWrite a File");
			System.out.println("3.Append to the Existing File");
			System.out.println("Enter the operations you want to perform:");
			opt=in.nextInt();
			switch(opt)
			{	
			case 1:
			{
				obj.readFile();	
				break;
			}
			case 2:
			{
				System.out.println("\t Note:This will erase existing contents in the file!!!");
				System.out.println("Enter the String to be rewrited:");
				input=in.next();
				obj.reWriteFile(input);
				break;
				
			}				
			case 3:
			{
				System.out.println("Enter the String to Append:");
				input=in.next();
				obj.writeFile(input);
				break;
			}
				
			default:
				System.out.println("Invalid Option.");
				flag=1;
				break;
			}
		}
		while(flag==1);

	}

}
