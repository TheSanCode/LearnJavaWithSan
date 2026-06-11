import java.util.Scanner;

class Student {
    String name;
    int studentClass;
    float result;

    // Constructor: Sets variables and prints the "Added student" message
    public Student(String s, int sClass) {
        this.name = s;
        this.studentClass = sClass;
        System.out.println("Added student: " + this.name + " to the roll of class: " + this.studentClass);
    }

    public String getName() {
        return this.name;
    }

    // Returns promotion/retention message based on the 33.33 threshold
    public String publish() {
        if (this.result >= 33.33f) {
            return this.name + " has been promoted to class: " + (this.studentClass + 1);
        } else {
            return this.name + " has been retained in class: " + this.studentClass;
        }
    }
}

class Result extends Student {
    int subject1;
    int subject2;
    int subject3;

    // Constructor: Assigns values and prints individual subject marks
    public Result(int a, int b, int c, String s, int sClass) {
        super(s, sClass); // Passes name and class to the parent Student constructor
        this.subject1 = a;
        this.subject2 = b;
        this.subject3 = c;

        System.out.println(s + " obtained " + a + " marks in subject1");
        System.out.println(s + " obtained " + b + " marks in subject2");
        System.out.println(s + " obtained " + c + " marks in subject3");
    }

    // Calculates the average using floating-point math and triggers publish()
    public String calculateResult() {
        this.result = (float) (this.subject1 + this.subject2 + this.subject3) / 3;
        return publish();
    }

    // Updates the specific subject marks and prints out the recheck result message
    public String changeMarks(int newMarks, String subject) {
        System.out.println(this.name + " has ordered a recheck in " + subject);
        
        if ("subject1".equals(subject)) {
            this.subject1 = newMarks;
        } else if ("subject2".equals(subject)) {
            this.subject2 = newMarks;
        } else if ("subject3".equals(subject)) {
            this.subject3 = newMarks;
        }

        return "Following is the new result: " + calculateResult();
    }
}

/*
Write the implementations of the Student and Result classes.
The following are output string formats for cut and paste:
Added student: {name} to the roll of class: {sClass}
{name} has been promoted to class: {studentClass +1}
{name} has been retained in class: {studentClass}
{name} obtained {marks} marks in subject1
{name} obtained {marks} marks in subject2
{name} obtained {marks} marks in subject3
{name} has ordered a recheck in {subject}
Following is the new result: {name} has been promoted  to class: {studentClass + 1}
Following is the new result: {name} has been retained in class: {studentClass}
*/

public class Solution{
 public static void main(String[] args){
  
  Scanner sc = new Scanner(System.in);
  String[] names = sc.nextLine().split(" ");
  int[][] marks = new int[names.length][3];

  for(int i = 0; i < names.length; i++){
   String[] temp = sc.nextLine().split(" ");
   marks[i][0] = Integer.parseInt(temp[0]);
   marks[i][1] = Integer.parseInt(temp[1]);
   marks[i][2] = Integer.parseInt(temp[2]);	
  }
  String[] cla = sc.nextLine().split(" ");

  Result r1 = new Result(marks[0][0], marks[0][1], marks[0][2],names[0], Integer.parseInt(cla[0]));
  Result r2 = new Result(marks[1][0], marks[1][1], marks[1][2],names[1], Integer.parseInt(cla[1]));
  Result r3 = new Result(marks[2][0], marks[2][1], marks[2][2],names[2], Integer.parseInt(cla[2]));
  Result r4 = new Result(marks[3][0],marks[3][1], marks[3][2], names[3],Integer.parseInt(cla[3]));
  Result r5 = new Result(marks[4][0], marks[4][1], marks[4][2], names[4], Integer.parseInt(cla[4]));
  String sub = sc.nextLine();
  int newMarks = Integer.parseInt(sc.nextLine());

  System.out.println(r1.calculateResult());
  System.out.println(r2.calculateResult());
  System.out.println(r3.calculateResult());
  System.out.println(r4.calculateResult());
  System.out.println(r5.calculateResult());
     
  System.out.println(r1.changeMarks(newMarks,sub));
  System.out.println(r3.changeMarks(newMarks,sub));
  System.out.println(r5.changeMarks(newMarks,sub));
 }	
}