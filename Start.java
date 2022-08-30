import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws Exception 
	{
		System.out.println("welcome to student managment app");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true)
		{
			System.out.println("Press 1 to  Add student");
			System.out.println("Press 2 to delete student");
			System.out.println("press 3 to display student");
			System.out.println("press 4 to exit app");
			
			int ch=Integer.parseInt(br.readLine());
			
			if(ch==1)
			{
				//add student
				
				System.out.println("Enter student name");
				String name=br.readLine();
				
				System.out.println("Enter student phone");
				String phone=br.readLine();
				
				System.out.println("Enter student city");
				String city=br.readLine();
				
				Student st=new Student(name, phone, city);
				boolean answer=StudentDao.insertStudentToDb(st);
				System.out.println(st);
				
				if(answer)
				{
					System.out.println("student successfully added.....");
				}
				
				
				
				
			}
			else if(ch==2)
			{
				//delete student
				System.out.println("please enter student id to delete student");
				int userId=Integer.parseInt(br.readLine());
				boolean answer=StudentDao.deleteStudent(userId);
				
				if(answer)
				{
					System.out.println("student successfully deleted");
				}
				else
				{
					System.out.println("something went wrong");
				}
				
				
				
			}
			else if(ch==3)
			{
				//display student
				StudentDao.showAllStudents();
			}
			else if(ch==4)
			{
				//exit the app
				break;
			}
			else
			{
				
			}
		}
		System.out.println("Thank you for using my application....bye bye");

	}

}
