package Projects;

import java.util.Scanner;

public class StudentGradeCalculator {
	public void calculate() {
		Scanner sc = new Scanner(System.in);
		System.out.println("!Note : Please, Enter out of 100 Marks for each Subject!!!!");
		System.out.println("-----------------------------------------------------------");
		System.out.print("Enter the CoreJava Marks  :  ");
		float corejava = sc.nextFloat();
		System.out.println("----------------------------------");
		System.out.print("Enter the JSP Marks  :  ");
		float jsp = sc.nextFloat();
		System.out.println("----------------------------------");
		System.out.print("Enter the JavaServlet Marks  :  ");
		float servlet = sc.nextFloat();
		System.out.println("----------------------------------");
		System.out.print("Enter the SpringBoot Marks  :  ");
		float springboot = sc.nextFloat();
		System.out.println("----------------------------------");
		float totalMarks = corejava + jsp + servlet + springboot;
		float averagePercentage = totalMarks / 4;
		System.out.println();
		System.out.println("     !!!Your Result!!!");
		System.out.println("    -------------------");
		System.out.println();
		System.out.println("CoreJava           : "+corejava);
		System.out.println("JSP                : "+jsp);
		System.out.println("JavaServlet        : "+servlet);
		System.out.println("SpringBoot         : "+springboot);
		System.out.println("TotalMarks         : "+totalMarks);
		System.out.println("Average Percentage : "+averagePercentage);
		int percentage = Math.round(averagePercentage);
		if(Math.round(corejava) >= 33 && Math.round(jsp) >= 33 && Math.round(servlet) >= 33 && Math.round(springboot) >= 33) {
			if(percentage>=33) {
				if(percentage > 90 && percentage <=100) {
					System.out.println("Grade              : A+");
				}
				else if(percentage > 80 && percentage <=90) {
					System.out.println("Grade              : A");
				}
				else if(percentage > 70 && percentage <=80) {
					System.out.println("Grade              : B");
				}
				else if(percentage > 60 && percentage <=70) {
					System.out.println("Grade              : C");
				}
				else if(percentage > 50 && percentage <=60) {
					System.out.println("Grade              : D");
				}
				else if(percentage >=33 && percentage <=50) {
					System.out.println("Grade              : E");
				}
				System.out.println();
				System.out.println("     ****************");
				System.out.println("     * YOU ARE PASS *");
				System.out.println("     ****************");
				System.out.println();
			}
			else {
				System.out.println("Grade              : F");
				System.out.println();
				System.out.println("     *****************");
				System.out.println("     * YOU ARE FAIL! *");
				System.out.println("     *****************");
				System.out.println();
			}
		}
		else {
			System.out.println("Grade : F");
			System.out.println();
			System.out.println("     *****************");
			System.out.println("     * YOU ARE FAIL! *");
			System.out.println("     *****************");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		boolean exitLoop = false;
		Scanner sc1 = new Scanner(System.in);
		while(!exitLoop) {
			System.out.println("1.GenerateResult / CalculateResult\n2.Exit");
			System.out.println();
			System.out.print("Enter the choice : ");
			int ch = sc1.nextInt();
			System.out.println();
			switch(ch) {
			case 1 : 
				StudentGradeCalculator st = new StudentGradeCalculator();
				st.calculate();
				break;
			case 2 :exitLoop = true;
					break;
			}
		}
		System.out.println();
		System.out.println("     ***************************");
		System.out.println("     * THANK YOU FOR CALCULATE *");
		System.out.println("     ***************************");
	}

}
