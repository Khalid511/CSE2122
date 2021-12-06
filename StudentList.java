import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		if(args.length!=1) {
			showMessage();
			return;
		}
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
			BufferedReader fileStream = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			String studentsFile = fileStream.readLine();
			String students[] = studentsFile.split(", ");
			for(String student : students) {
				System.out.println(student);
			}
			} catch (Exception e){} 
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) {
			System.out.println("Loading data ...");			
			try {
			BufferedReader fileStream = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			String studentsFile = fileStream.readLine();
			String students[] = studentsFile.split(", ");
			Random arandomObject = new Random();
			int randomNumber = arandomObject.nextInt(students.length);
			System.out.println(students[randomNumber]);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
			BufferedWriter writerStream = new BufferedWriter(new FileWriter("students.txt", true));
			String addString = args[0].substring(1);
			writerStream.write(", " + addString);
			writerStream.close();
			} catch (Exception e){}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader fileStream = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			String studentsFile = fileStream.readLine();
			String students[] = studentsFile.split(", ");
			boolean done = false;
			String searchString = args[0].substring(1);
			for(int idx = 0; idx<students.length && !done; idx++) {
				if(students[idx].equals(searchString)) {
					System.out.println("We found it!");
						done=true;
				}
			}
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader fileStream = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			String studentsFile = fileStream.readLine();
			char allCharacter[] = studentsFile.toCharArray();
			boolean in_word = false;
			int count=0;
			for(char character:allCharacter) {
				if(character ==' ')
				{
					if (!in_word) {
						count++;
						in_word =true;
					}
					else {
						in_word=false;
					}
				}
			}
			System.out.println(count +" word(s) found ");
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
		else {
			showMessage();
		}
	}
	static void showMessage() {
		System.out.println("No argument or Invalid argument.");
	}
}