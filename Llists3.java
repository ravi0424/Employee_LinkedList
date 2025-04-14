import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Llists3 {
  
  private Node head;
  private Node tail;
  private int size;

//   Validates an Emp_details object and prints errors to console
  public static boolean validateEmployee(Emp_details employee) {

      if (employee == null) {
          System.out.println("Error: Employee object cannot be null");
          return false;
      }

      boolean isValid = true;

      if (employee.getEmp_id()<=0){
          System.out.println("- ID must be positive");
          isValid = false;
      }
      if (employee.getName() == null || employee.getName().trim().isEmpty()) {
          System.out.println("- Name cannot be empty");
          isValid = false;
      }
      if (employee.getRole() == null || employee.getRole().trim().isEmpty()) {
          System.out.println("- Role cannot be empty");
          isValid = false;
      }
      if (employee.getExperience() < 0) {
          System.out.println("- Experience cannot be negative");
          isValid = false;
      }
      if (employee.getAge() < 18) {
          System.out.println("- Age must be at least 18");
          isValid = false;
      }

      return isValid;
  }
  public void FinalWrite(ObjectOutputStream oos) throws IOException{
    if(head==null){
      return ;
    }
    Node temp=head;
    while (temp!=null){
      oos.writeObject(temp.object);
      temp=temp.next;
    }
  }

  public void insertFirst(Emp_details object){
      if(!validateEmployee(object)){
          return ;
      }
      Node temp=new Node(object);
      temp.next=head;
      head=temp;
      if (tail==null){
          tail=head;
      }
      size++;
  }

  public void insertLast(Emp_details object){
      if(!validateEmployee(object)){
          return ;
      }
      if (tail==null){
          insertFirst(object);
          return ;
      }
      Node temp=new Node(object);
      tail.next=temp;
      tail=temp;
      size++;
  }

  public void insertAtPos(Emp_details object,int index){
      if(!validateEmployee(object)){
          return ;
      }
      if(index>size){
          System.out.println("IndexOutofRange");
          return ;
      }
      if(index==0){
          insertFirst(object);
          return;
      }
      if(index==size){
          insertLast(object);
          return;
      }
      Node temp=head;
      // for(int i=1;i<index;i++){
      //     temp=temp.next;
      // }
      Node prev_node=getIndex(index-1); 
      Node dummy=new Node(object,prev_node.next);
      prev_node.next=dummy;      
      // Node dummy=new Node(value,temp.next);
      // temp.next=dummy;
      size++;
  }

  public void display(){
      Node temp=head;
      while(temp!=null){
          System.out.print(temp.object+"  ->  ");
          temp=temp.next;
      }
      System.out.println("END");
  }

  public int deleteFirst(){
      // int val=head.value;
      if (size==0){
          return Integer.MIN_VALUE;
      }
      head=head.next;
      if(head==null){
          tail=null;
      }
      size--;
      // System.out.println(val);
      return 1;

  }

  public int deleteLast(){
      if (size==0){
          return Integer.MIN_VALUE;
      }
      if(size<=1){
          return deleteFirst();
      }
      Node secondLast=getIndex(size-2);
      // int val=tail.value;
      tail=secondLast;
      secondLast.next=null;
      size--;
      return 1;
  }

  public int delete(int index){
      if (size==0){
          return -1;
      }
      if(index==0){
          return deleteFirst();
      }
      if(index==size-1){
          return deleteLast();
      }
      Node prev=getIndex(index-1);
      Emp_details val=prev.next.object;
      prev.next=prev.next.next;
      size--;
      return 1;
  }
  public int removeById(int value){
      if (size==0){
          return -1;
      }
      Node temp=head;
      if (head.object.Emp_id==value){
          head=head.next;
          return value;
      }
      while (temp.next != null) {
          if (temp.next.object.Emp_id == value) {
              Emp_details removedEmployee = temp.next.object;
              temp.next = temp.next.next;
              size--;
              if (temp.next == null) {
                  tail = temp; 
              }
              removedEmployee=null;
              return value;
          }
          temp = temp.next;
      }
      return -1;

  }
  public int DeleteByName(String Name){
      if(head==null) return 0;
      Node temp=head;
      int count =0;
      Node temp2=null;
      while(temp!=null){
          if(temp.object.Name.contains(Name)){
              count+=1;
              System.out.println(temp.object.toString());
              temp2=temp;
          }
          temp=temp.next;
      }
      if(count==1){
          removeById(temp2.object.Emp_id);
          return 1;
      }
      return count;
  }
  public int findByName(String Name){
      if (size==0){
          return 0;
      }
      if(Name.length()==0){
          System.out.println("Please Provide the Proper Name which contains >1 character");
          return -1;
      }
      Node temp=head;
      int check=0;
      while(temp!=null){
          if(temp.object.Name.toLowerCase().contains(Name.toLowerCase())){
              System.out.println(temp.object);
              check=1;
          }
          temp=temp.next;
      }
      return check;
  }
  public int findById(int id){
      if(size==0){
          return -1 ;
      }
      if (id<=0){
          System.out.println("Please Provide the Proper id greater than 0");
          return -2;
      }
      Node temp=head;
      int check=0;
      while(temp!=null){
          if(temp.object.Emp_id==id){
              System.out.println(temp.object);

              check=1;
          }
          temp=temp.next;
      }
      return check;
  }
  public int findByRole(String Role){
      if (size==0){
          return 0;
      }
      if(Role.length()==0){
          System.out.println("Please Provide the Proper Role which contains >1 character");
          return -1;
      }
      Node temp=head;
      int check=0;
      while(temp!=null){
          if(temp.object.Role.toLowerCase().contains(Role.toLowerCase())){
              System.out.println(temp.object);
              check=1;
          }
          temp=temp.next;
      }
      return check;
  }
  public Node getIndex(int index){
       if (size==0 || index>=size){
          return null;
      }
      Node temp=head;
      for(int i=0;i<index;i++){
          temp=temp.next;
      }
      return temp;
  }

  public int getSize() {
      return size;
  }
  
  public Llists3() {
      this.size = 0;
  }
  
  public Llists3.Emp_details getTail() {
      return tail.object;
  }

  private  class Node {
      private Emp_details object;
      private Node next;

      public Node(Emp_details object) {
          this.object = object;
      }

      public Node(Emp_details object, Llists3.Node next) {
          this.object = object;
          this.next = next;
      }
      
  }
  public static class Emp_details implements Serializable{
      private int Emp_id;
      private String Name;
      private String Role;
      private float Experience;
      private int age;
      public Emp_details(int emp_id, String name, String role, float experience, int age) {
          Emp_id = emp_id;
          Name = name;
          Role = role;
          Experience = experience;
          this.age = age;
      }
      public int getEmp_id() {
          return Emp_id;
      }
      public String getName() {
          return Name;
      }
      public String getRole() {
          return Role;
      }
      public float getExperience() {
          return Experience;
      }
      public int getAge() {
          return age;
      }
    
      public String toString() {
          return "Emp_details [Emp_id=" + Emp_id + ", Name=" + Name + ", Role=" + Role + ", Experience=" + Experience
                  + ", age=" + age + "]";
      }
      
      
  } 

  
}