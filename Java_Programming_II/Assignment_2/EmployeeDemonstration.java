import java.util.Scanner;
import java.io.*;

public class EmployeeDemonstration
{
   static EmployeeMap employeeMap;
   
   private static int getIdFromUser()
   {
      Scanner scan = new Scanner(System.in);
      boolean validInput = false;
      int input = 0;
      
      while(!validInput)
      {
         try
         {
            System.out.println(employeeMap);
            System.out.print("Enter an employee ID to get their data (enter less than 0 to quit): ");
            input = scan.nextInt();
            validInput = true;
         }
         catch (Exception e)
         {
            System.out.println("\nThat was not valid input.\n");
            String s = scan.next();
         }
      }
      
      return input;
   }
   
   public static void menu()
   {
      int id = 0;
      Employee emp;
      
      while (id >= 0)
      {
         id = getIdFromUser();
         emp = employeeMap.getEmployeeFromIdNumber(id);
         
         if (id < 0)
         {
            break;
         }
         
         if (emp == null)
         {
            System.out.println("\n\nThere is no employee with the ID " + id + ".\n\n");
         }
         else
         {
            System.out.println("\n\nEmployee selected:");
            System.out.println(emp);
            System.out.println("\n");
         }
      }
      
      System.out.println("Quitting...");
   }
   
   public static void main(String[] args)
   {
      employeeMap = new EmployeeMap();
      
      employeeMap.addEmployee(new Employee(1, "Devin"));
      employeeMap.addEmployee(new Employee(2, "James"));
      employeeMap.addEmployee(new Employee(3, "Jordan"));
      employeeMap.addEmployee(new Employee(4, "Alexander"));
      employeeMap.addEmployee(new Employee(5, "Brandon"));
      employeeMap.addEmployee(new Employee(6, "Lee"));
      
      menu();
   }
}