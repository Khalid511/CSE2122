import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) throws  IOException {

//		Check arguments
		if(args.length!=1) {
			showMessage();
			return;
		}
		String studentsFile=loadStudents("students.txt");
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");
			String students[] = studentsFile.split(", ");
			for(String student : students) {
				System.out.println(student);
			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) {
			System.out.println("Loading data ...");
			String students[] = studentsFile.split(", ");
			Random arandomObject = new Random();
			int randomNumber = arandomObject.nextInt(students.length);
			System.out.println(students[randomNumber]);
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");
			String addString = args[0].substring(1);
			updateStudetntList(addString, "students.txt");
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");
			String students[] = studentsFile.split(", ");
			boolean done = false;
			String searchString = args[0].substring(1);
			for(int idx = 0; idx<students.length && !done; idx++) {
				if(students[idx].equals(searchString)) {
					System.out.println("We found it!");
						done=true;
				}
			}
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");
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
			System.out.println("Data Loaded.");				
		}
		else {
			showMessage();
		}
	}
	static void showMessage() {
		System.out.println("No argument or Invalid argument.");
	}
	static String loadStudents(String fileName) throws IOException{
		BufferedReader fileStream = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		return fileStream.readLine();
	}
	static void updateStudetntList(String addString, String fileName) throws IOException {
		BufferedWriter writerStream = new BufferedWriter(new FileWriter(fileName, true));
		writerStream.write(", " + addString);
		writerStream.close();
	}
}