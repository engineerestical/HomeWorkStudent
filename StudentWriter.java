package HomeWork;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class StudentWriter {
	

	@SuppressWarnings("null")
	public static void main(String[] args) throws IOException {
		//Create a file in the project folder
		File file = new File("Student.txt");
		if (!file.exists()) {
            file.createNewFile();
        }
		Scanner input = new Scanner(System.in);
		//Take the number of students
        System.out.print("How many students will you add your file? ");
        int numberOfStudents = input.nextInt();
        
        
        int i = 0;
        
        String studentArray[]=new String[numberOfStudents];
        //Take the names of student and assign values to an array
        for (i=0; i< studentArray.length; i++) {
        	System.out.print("Student-"+ (i+1)+ ":");
        	studentArray[i] = input.next();
        }
       //Sort the array alphabetically
        Arrays.sort(studentArray);
        
        FileWriter fw= null;
        fw = new FileWriter(file);
        //Write the values of array to txt file in new lines
        for (int j = 0; j < studentArray.length; j++) {
            fw.write(studentArray[j] + "\n");
         }
        fw.close();
        System.out.println("File successfully wrote in student.txt file.");
        
        //Take the name of eliminated student from user
        System.out.print("Eliminate a student: ");
        String eliminatedStudent = input.next();

        //Read file and take the student names to a string list
        List<String> afterEliminated = new ArrayList<String>();
        FileReader rd = new FileReader("Student.txt");

        Scanner scnr = new Scanner(rd);
        String str;
        while (scnr.hasNext()) {
        	str = scnr.next();
            afterEliminated.add(str);        
            }
        
        //remove the eliminated student from the list
        afterEliminated.remove(eliminatedStudent);
        scnr.close();
        
        //convert list to an array
        String afterEliminatedArray[]=afterEliminated.toArray(new String[afterEliminated.size()]);
        
        //Write the students to same file again without eliminated student
        FileWriter fw2= null;
        fw2 = new FileWriter(file);
        for (int k = 0; k < afterEliminatedArray.length; k++) {
            fw2.write(afterEliminatedArray[k] + "\n");
         }
        fw2.close();
        
        
        //Read file and take the student names to a string list
        List<String> lastList = new ArrayList<String>();
        FileReader rd2 = new FileReader("Student.txt");
        
        Scanner scnr2 = new Scanner(rd2);
        String str2;
        while (scnr2.hasNext()) {
        	str2 = scnr2.next();
            lastList.add(str2);        
            }
        scnr2.close();
        //convert list to an array
        String lastArray[]=lastList.toArray(new String[lastList.size()]);
        //reverse the array
        reverseArray(lastArray);
        input.close();
	}
	// function that reverses array and stores it 
    // in another array
	public static void reverseArray(String[] arr) {
        // Converting Array to List
        List<String> list = Arrays.asList(arr);
        // Reversing the list using Collections.reverse() method
        Collections.reverse(list);
        // Converting list back to Array
        String[] reversedArray = list.toArray(arr);
        // Printing the reverse Array
        System.out.print("Reverse Array : " + Arrays.toString(reversedArray));
   }

}
