
package mainapp;

import java.util.Scanner;

import models.Student;
import models.Course;
import services.EnrollmentManager;

public class Main {

    static Student[] students = new Student[100];
    static int studentCount = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        EnrollmentManager enrollmentManager =
                new EnrollmentManager();

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("===== Student Management System =====");
            System.out.println("1. Enrol Student");
            System.out.println("2. Search Student");
            System.out.println("3. Sort Students");
            System.out.println("4. List Students");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    if (studentCount < students.length) {

                        System.out.print("Enter Student ID: ");
                        String sID = sc.nextLine();

                        System.out.print("Enter Student Name: ");
                        String sName = sc.nextLine();

                        Student student =
                                new Student(sID, sName);

                        students[studentCount] = student;
                        studentCount++;

                        System.out.println(
                                "Student added successfully."
                        );

                    } else {

                        System.out.println(
                                "Registration full."
                        );
                    }

                    break;

                case 2:

                    System.out.print(
                            "Enter Student ID to search: "
                    );

                    String searchID = sc.nextLine();

                    Student foundStudent =
                            searchStudentById(searchID);

                    if (foundStudent != null) {

                        System.out.println(
                                "Student found:"
                        );

                        System.out.println(
                                foundStudent
                        );

                    } else {

                        System.out.println(
                                "Student not found."
                        );
                    }

                    break;

                case 3:

                    sortStudentByName();

                    System.out.println(
                            "Students sorted successfully."
                    );

                    listStudent();

                    break;

                case 4:

                    listStudent();

                    break;

                case 5:

                    running = false;

                    System.out.println(
                            "Thank you for using "
                            + "Student Management System."
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice. "
                            + "Please enter a correct choice."
                    );

                    break;
            }
        }

        sc.close();
    }

    public static Student searchStudentById(String id) {

        for (int i = 0; i < studentCount; i++) {

            if (students[i]
                    .getId()
                    .equalsIgnoreCase(id)) {

                return students[i];
            }
        }

        return null;
    }

    public static void sortStudentByName() {

        for (int i = 0;
             i < studentCount - 1;
             i++) {

            for (int j = 0;
                 j < studentCount - i - 1;
                 j++) {

                if (students[j]
                        .getName()
                        .compareToIgnoreCase(
                                students[j + 1].getName()
                        ) > 0) {

                    Student temp = students[j];

                    students[j] = students[j + 1];

                    students[j + 1] = temp;
                }
            }
        }
    }

    public static void listStudent() {

        if (studentCount == 0) {

            System.out.println(
                    "No students available."
            );

            return;
        }

        System.out.println();
        System.out.println("===== Student List =====");

        for (int i = 0;
             i < studentCount;
             i++) {

            System.out.println(
                    students[i]
            );
        }
    }
}

