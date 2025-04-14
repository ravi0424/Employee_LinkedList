import java.io.*;
import java.util.Scanner;

public class  Llistimplementationfors3 {
  public static Llists3.Emp_details readEmployeeDetails(Scanner sc) {
        System.out.print("Enter Employee ID: ");
        int empId = sc.nextInt();
        sc.nextLine();
    
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
    
        System.out.print("Enter Role: ");
        String role = sc.nextLine();
    
        System.out.print("Enter Experience (years): ");
        float exp = sc.nextFloat();
    
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
    
        return new Llists3.Emp_details(empId, name, role, exp, age);
    }
 


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        Llists3 list = new Llists3();
        int choice;
        System.out.println("Welcome to the Employee Linked List Application!");
        File file=new File("D:\\LL\\LL\\DataObject.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        
        try {
          while (true) {
              Object obj = ois.readObject();
              list.insertLast((Llists3.Emp_details)obj);
          }
          } 
        catch (EOFException e) {
              System.out.println("All objects read.");
        } 
        finally {
           ois.close();
          }


        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert employee at beginning");
            System.out.println("2. Insert employee at end");
            System.out.println("3. Insert employee at specific position");
            System.out.println("4. Delete first employee");
            System.out.println("5. Delete last employee");
            System.out.println("6. Delete employee at specific position");
            System.out.println("7. Remove employee by ID");
            System.out.println("8. Search employee by name");
            System.out.println("9. Search employee by id");
            System.out.println("10. Search employees by Role");
            System.out.println("11. Display all employees");
            System.out.println("12. Delete by name");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            int pos,Result;
            
            switch (choice) {
                case 1:
                    Llists3.Emp_details empFirst = readEmployeeDetails(sc);
                    list.insertFirst(empFirst);
                    // scenario 2 at the end of every operation the data in a file is overidded
                    break;

                case 2:
                    Llists3.Emp_details empLast = readEmployeeDetails(sc);
                    list.insertLast(empLast);
                   
                    break;

                case 3:
                    System.out.print("Enter position (0 to " + list.getSize() + "): ");
                    pos = sc.nextInt();
                    sc.nextLine();
                    Llists3.Emp_details empAtPos = readEmployeeDetails(sc);
                    list.insertAtPos(empAtPos, pos);
                   
                    break;

                case 4:
                    list.deleteFirst();
                   
                    break;

                case 5:
                    list.deleteLast();
                   
                    break;

                case 6:
                    System.out.print("Enter position to delete (0 to " + (list.getSize() - 1) + "): ");
                    pos = sc.nextInt();
                    list.delete(pos);
                   
                    break;

                case 7:
                    System.out.print("Enter employee ID to remove: ");
                    int empId = sc.nextInt();
                    Result=list.removeById(empId);
                    System.out.println((Result==-1)?"Not found! / list is empty":"Removed-Employee_Id: "+empId);
                    if(Result!=-1){
                       
                    }
                    break;

                case 8:
                    System.out.print("Enter name to search: ");
                    String name = sc.nextLine();
                    Result=list.findByName(name);
                    System.out.println((Result==0)?"Not found! / list is empty":"");
                    break;
                case 9:
                    System.out.print("Enter the Employee Id to search: ");
                    int id=sc.nextInt();
                    Result=list.findById(id);
                    System.out.println((Result==0)?"Invalid Id! / List is empty":"");
                    break;
                case 10:
                    System.out.print("Enter name to search: ");
                    String Role = sc.nextLine();
                    Result=list.findByRole(Role);
                    System.out.println((Result==0)?"Not found in that Role! / list is empty":"");
                    break;
                case 11:
                    list.display();
                    break;

                case 12:
                    System.out.print("please enter a Employee Name you Want to delete: ");
                    name = sc.next();
                    System.out.println();
                    int result=list.DeleteByName(name);
                    if(result==1){
                        System.out.println("Employee is deleted");
                    }
                    else if (result>1){
                        System.out.print("Entered Name will have more than 1 employee ids please provide a  Employee Id: ");
                        empId = sc.nextInt();
                        Result=list.removeById(empId); 
                    }
                    else{
                        System.out.println("you entered name will not consists in a list / list is empty");
                    }    
                                
                    break;
                case 13:
                    
                    if(!file.exists()){
                      file.createNewFile();
                    }
                    ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
                    list.FinalWrite(oos);
                    oos.close();
                    System.out.println("Exiting program. Thank you!");
                    break;
                
                default:
                    System.out.println("Invalid choice. Please select 1-13.");
            }
        } while (choice != 13);
        sc.close();
    }

}
