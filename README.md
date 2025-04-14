# Employee_LinkedList

Employee Management System Using Linked List

Data Structure
- A singly linked list with head and tail pointers
- Each node contains an Emp_details object and a next pointer
- Size tracking for the list
- Emp_details object contains:
  - Employee ID (int)
  - Name (String)
  - Role (String)
  - Experience (float)
  - Age (int)

Core Operations

Insertion Operations
1. Insert at Beginning 
    insertFirst(Emp_details object):
     validateEmployeeDetails for object validation if it is true insertion operation will takes place
     Create new node with given employee object
     Set new node's next pointer to current head
     Update head to point to new node
     If tail is null (empty list), update tail to point to head
     Increment size

2. Insert at End 
    insertLast(Emp_details object):
     validateEmployeeDetails for object validation if it is true insertion operation will takes place
     If list is empty, call insertFirst(object)
     Create new node with given employee object
     Set current tail's next pointer to new node
     Update tail to point to new node
     Increment size

3. Insert at Position 
    insertAtPos(Emp_details object, index):
     validateEmployeeDetails for object validation if it is true insertion operation will takes place
     If index is out of bounds (index > size), display error message
     If index is 0, call insertFirst(object)
     If index equals size, call insertLast(object)
     
     Get node at (index-1) using getIndex 
     Create new node with given object and set its next to previous node's next
     Set previous node's next to new node
     Increment size

Deletion Operations
1. Delete First Element 
    deleteFirst():
     If list is empty, output error value (Integer.MIN_VALUE)
     Move head to next node
     Store head object to be deleted
     Set object reference to null (for garbage collection)
     If head becomes null, update tail to null as well

     Decrement size
     Output success indicator (1)

2. Delete Last Element 
    deleteLast():
     If list is empty, output error value
     If size is 1, call deleteFirst()
     
     Get second last node using getIndex(size-2)

     Update tail to point to second last node
     Set tail's next to null
     Decrement size
     Output success indicator (1)

3. Delete at Position 
    delete(index):
     If list is empty, output error (-1)
     if index is less than 0 then print please provide proper index 
     If index is 0, call deleteFirst()
     If index is size-1, call deleteLast()
     
     Find node at (index-1) using getIndex
     Store  object to be deleted
     Update previous node's next to skip the node to be unlink from linked-list 
     Set object reference to null (for garbage collection)
     Decrement size
     Output success indicator (1)

4. Delete by Employee ID
    removeById(employeeId):
     If list is empty, output error (-1)
     If employeeId is less than or 0 then print Invalid Id
     Node temp = head
     
     If head node contains the target employee ID:
       Store the employee ID
       Store reference to employee object to be deleted
       Move head to head.next
       Decrement size
       Set object reference to null (for garbage collection)
       Output the stored ID
     
     Traverse the list while temp.next is not null:
       If temp.next.object.Emp_id equals the target ID:
         Store reference to employee object to be deleted
         Update temp.next to temp.next.next (skip the node)
         Set object reference to null (for garbage collection)
         Decrement size
         If temp.next is now null, update tail to temp
         Output the employee ID
     
     If ID not found (-1)
5. DeleteByName
  DeleteByName(Name):
  If the list is empty (head is null), return 0

  Initialize:
    temp as head for traversal
    count for no of ocuurances
    temp2 is for store the temp node it is useful if there is count is 1 

  Traverse the list while temp is not null:
    If temp.object.Name contains the given Name:
      Increment count by 1
      Print the matched object details 
      Store temp in temp2 (reference to the matched node)

    Move temp to the next node

  If count is exactly 1:
    Call removeById(temp2.object.Emp_id) to remove the matched employee
    Return 1 (indicating successful deletion)

  Return count (indicating how many matched, but not deleted if more than 1)


    
Search Operations
1. Find Employee by Name 
    findByName(name):
     If list is empty, output 0
     If length of name is equals to 0 then print please provide proper name which contain more than 1 character
     Initialize check variable to 0
     Traverse the list from head
     For each node, check if employee name contains the search term (case insensitive)
     If match found:
       Print the employee details
       Set check to 1
     Output check value (1 if found, 0 if not found)

2. Find Employee by ID 
    findById(id):
     If list is empty, output -1
     If employeeId is less than or equal to 0 then print Invalid Id
     Initialize check variable to 0
     Traverse the list from head
     For each node, check if employee ID matches the search ID
     If match found:
       Print the employee details
       Set check to 1
     Output check value (1 if found, 0 if not found)

3. Find Employee by Role 
    findByRole(role):
     If list is empty, output 0
     If length of Role is equals to 0 then print please provide proper Role which contain more than 1 character
     Initialize check variable to 0
     Traverse the list from head
     For each node, check if employee role contains the search term (case insensitive)
     If match found:
       Print the employee details
       Set check to 1
     Output check value (1 if found, 0 if not found)

Utility Operations
1. Get Node at Index 
    getIndex(index):
     If list is empty or index is out of bounds, output null
     Traverse the list from head to the index position
     Output the node at the index

2. Display List 
    display():
     Traverse from head to end
     Print each employee's details followed by an arrow
     Print "END" at the end

3. Get Size
    getSize():
     Output the current size of the list

4. Get Tail
    getTail():
     Output the employee object at the tail node

5. validation of object
    validateEmployeeDetails(object)
    if object is null then print Employee object cannot be null
    If the employee ID is not a positive number (i.e., ≤ 0),Print "Enter a positive employee ID"
    If the name is null, empty, or less than 2 characters, or  contains only special characters.Print "Enter a proper name"
    If the role is null or empty,Print "Role cannot be empty"
    If the experience is negative,Print "Experience cannot be negative"
    If the age is less than 18,Print "Age must be at least 18"
    if any of the above conditions will be true return true
Read & Write operations 

1. writeEmployeedetails
    the method is used to get the string which consists object instance variables with separated by ","
2. FinalWrite() (for scenario 1 and 2)
    If the list is empty (head is null) list is empty

    Initialize an empty string s
    assign temp to head for traversal
    Traverse the list while temp is not null:
      Call writeEmployeedetails(temp.object) to get string representation
      Append the string to s followed by a newline character
      Move temp to the next node

    After traversal, trim any trailing whitespace or newlines from s
    Return the resulting string
3. ReadFromFile(): (for scenario1 and 2)
    Create a File object with the path to the data file
    if file doesnt exists in a path then create a new file
    Create a Scanner object to read from the file

    While the scanner has more lines to read:
      Read the next line from the file store in a string 
      Split the string by "," into an array of strings (NodeData)

      Parse and extract employee details from NodeData:
        Convert NodeData[0] to an integer as id
        Trim and assign NodeData[1] as name
        Trim and assign NodeData[2] as role
        Convert NodeData[3] to a float as experience
        Convert NodeData[4] to an integer as age

      Create a new Emp_details object using the parsed data

      Insert the employee object at the end of the linked list using insertLast() method

    Close the scanner
4. FinalWrite(oos): (for scenario 3)
    If the list is empty (head is null):
       nothing to write in a file

    Initialize head as temp

    Traverse the list while temp is not null:
      Write the employee object (temp.object) into the file
      Move temp to the next node

5. ReadObjectsFromFile(): (for scenario 3)
     Create a File object with the path to the data file
     Create an ObjectInputStream using a FileInputStream on the file
    using try and catch block read the objects and type cast the object to Emp_details and insert at last
    whenever it reaches to endoffile raise exception and then all the objects are stored into a linkedlist
    Close the ObjectInputStream


User Interface Algorithm
1. Initialize a scanner for input and create an empty linked list
2. Create a new file and if not exists and read the data from file into the linkedlist
3. Display a menu with options for all linked list operations
4. Read user choice
5. Based on choice:
   - For insertion: Read employee details (ID, name, role, experience, age) and call appropriate insert method
   - For deletion: Read position or employee ID and call appropriate delete method
   - For search: Read name/ID/role and call appropriate find method
   - For display: Call display method
6. For search operations, display "Not found" message if the result is 0
7. Repeat until user chooses to exit (option 13)
8. Whenever user choose a 13 then  and  write the data of FinalWrite() resulted string for s1
9. Whenever user performs operations like insertFirst,insertLast,insertAtPos,deleteFirst,deleteLast,DeleteByName,removeById for each operation the data will be overidded for s2
