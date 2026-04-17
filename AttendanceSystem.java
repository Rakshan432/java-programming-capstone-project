import java.util.*;
class Employee {
int id;
String name;
String attendance;
String leaveStatus;
Employee(int id, String name) {
this.id = id;
this.name = name;
this.attendance = "Not Marked";
this.leaveStatus = "No Leave";
}
}
public class AttendanceSystem {
static Scanner sc = new Scanner(System.in);
static ArrayList<Employee> empList = new ArrayList<>();
public static void main(String[] args) {
int choice;
do {
System.out.println("\n--- Employee Attendance System ---");
System.out.println("1. Add Employee");
System.out.println("2. Mark Attendance");
System.out.println("3. Apply Leave");
System.out.println("4. Approve Leave");
System.out.println("5. View Report");
System.out.println("6. Exit");
System.out.print("Enter choice: ");
choice = sc.nextInt();
switch (choice) {
case 1:
addEmployee();
break;
case 2:
markAttendance();
break;
case 3:
applyLeave();
break;
case 4:
approveLeave();
break;
case 5:
viewReport();
break;
case 6:
System.out.println("Exiting...");
break;
default:
System.out.println("Invalid choice!");
}
} while (choice != 6);
}
static void addEmployee() {
System.out.print("Enter Employee ID: ");
int id = sc.nextInt();
sc.nextLine();
System.out.print("Enter Employee Name: ");
String name = sc.nextLine();
empList.add(new Employee(id, name));
System.out.println("Employee Added Successfully!");
}
static void markAttendance() {
System.out.print("Enter Employee ID: ");
int id = sc.nextInt();
for (Employee e : empList) {
if (e.id == id) {
System.out.print("Mark Attendance (Present/Absent): ");
e.attendance = sc.next();
System.out.println("Attendance Marked!");
return;
}
}
System.out.println("Employee Not Found!");
}
static void applyLeave() {
System.out.print("Enter Employee ID: ");
int id = sc.nextInt();
for (Employee e : empList) {
if (e.id == id) {
e.leaveStatus = "Pending";
System.out.println("Leave Applied Successfully!");
return;
}
}
System.out.println("Employee Not Found!");
}
static void approveLeave() {
System.out.print("Enter Employee ID: ");
int id = sc.nextInt();
for (Employee e : empList) {
if (e.id == id && e.leaveStatus.equals("Pending")) {
System.out.print("Approve Leave? (yes/no): ");
String decision = sc.next();
if (decision.equalsIgnoreCase("yes")) {
e.leaveStatus = "Approved";
} else {
e.leaveStatus = "Rejected";
}
System.out.println("Leave Status Updated!");
return;
}
}
System.out.println("No Pending Leave Found!");
}
static void viewReport() {
System.out.println("\n--- Employee Report ---");
for (Employee e : empList) {
System.out.println("ID: " + e.id);
System.out.println("Name: " + e.name);
System.out.println("Attendance: " + e.attendance);
System.out.println("Leave Status: " + e.leaveStatus);
System.out.println("------------------------");
}
}
}