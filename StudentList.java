import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) throws  IOException {

		//Check arguments
		if(args.length!=1) {
			showMessage();

			//Exit early.
			return;
		}

		//Containg the file return from the loadStudents method.
		String studentsFile=loadStudents(Constants.studentFile);
		if(args[0].equals(Constants.showallStudents)) {
			System.out.println("Loading data ...");
			String students[] = studentsFile.split(Constants.splitSign);
			for(String student : students) {
				System.out.println(student);
			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals(Constants.showrandomStudent)) {
			System.out.println("Loading data ...");
			String students[] = studentsFile.split(Constants.splitSign);
			Random arandomObject = new Random();
			int randomNumber = arandomObject.nextInt(students.length);
			System.out.println(students[randomNumber]);
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains(Constants.addStudent)){
			System.out.println("Loading data ...");
			String addString = args[0].substring(1);
			updateStudetntList(addString, "students.txt");
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains(Constants.searchStudent))
		{
			System.out.println("Loading data ...");
			String students[] = studentsFile.split(Constants.splitSign);
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
		else if(args[0].contains(Constants.countStudent))
		{
			System.out.println("Loading data ...");
			char allCharacter[] = studentsFile.toCharArray();
			boolean in_word = false;
			int noOfstudents=0;
			for(char character:allCharacter) {
				if(character ==' ')
				{
					if (!in_word) {
						noOfstudents++;
						in_word =true;
					}
					else {
						in_word=false;
					}
				}
			}
			System.out.println(noOfstudents +" word(s) found ");
			System.out.println("Data Loaded.");				
		}
		else {
			showMessage();
		}
	}

	//Method for showing message when invalid argument occurs.
	static void showMessage() {
		System.out.println("No argument or Invalid argument.");
	}

	//Reads student file from the given list and return it in a line.
	static String loadStudents(String fileName) throws IOException{
		BufferedReader fileStream = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		return fileStream.readLine();
	}

	//Writes given string of data to the given list.
	static void updateStudetntList(String addString, String fileName) throws IOException {
		BufferedWriter writerStream = new BufferedWriter(new FileWriter(fileName, true));
		writerStream.write(", " + addString);
		writerStream.close();
	}
}