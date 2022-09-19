package getStudent;

import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class Student_main {

    static String fileName;
    static Student[] stArr;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("x                                 IT IS  MY FIRST CODING PROJECT                                                       x");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println();
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter student's data file name: ");
        fileName = inp.nextLine();
        readFromFile();

         myLoop:
        while (true) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("What do you want to do?");
            System.out.println();
            System.out.println("1: Adding new student\n2: Editing student\n3: Deleting student\n4: Sorting students\n5: Showing from file\n6: Saving to File\n7: Exit\n");
            System.out.print("Enter Your Choice: ");
            int userChoice = inp.nextInt();

            switch (userChoice) {
                case 1:
                    AddingNewStudent();
                    break;
                case 2:
                    EditingStudent();
                    break;
                case 3:
                    DeletingStudent();
                    break;
                case 4:
                    SortingStudent();
                    break;
                case 5:
                    ShowingFromFile();
                    break;
                case 6:
                    SavingToFile();
                    break;
                case 7:
                    break myLoop;
            }

        }
    }//main

    static void readFromFile() throws FileNotFoundException {
        File f = new File(fileName);

        if (f.exists()) {
            Scanner cin = new Scanner(f);
            while (cin.hasNext()) {
                String stLine = cin.nextLine();
                addStudent(getStudent(stLine));
            }
        }
    }

    static Student getStudent(String line) {
        String[] arr = line.split(",");
        Student st = new Student();
        st.stCode = Long.parseLong(arr[0]);
        st.stName = arr[1];
        st.stField = arr[2];
        st.totalGrade = Double.parseDouble(arr[3]);

        return st;
    }

    static void addStudent(Student st) {
        if (stArr == null) {
            stArr = new Student[1];
        } else {
            stArr = Arrays.copyOf(stArr, stArr.length + 1);
        }
        stArr[stArr.length - 1] = st;
    }

    static void AddingNewStudent() {
        Scanner win = new Scanner(System.in);
        Student st = new Student();

        System.out.print("Enter new student code: ");
        st.stCode = win.nextLong();
        win.nextLine();
        System.out.print("Enter new studrnt name: ");
        st.stName = win.nextLine();
        System.out.print("Enter new student field: ");
        st.stField = win.nextLine();
        System.out.print("Enter new student total grade: ");
        st.totalGrade = win.nextDouble();

        addStudent(st);
    }//add 

    static void EditingStudent() {
        Scanner r = new Scanner(System.in);
        System.out.print("Enter the student Code that you want to edit it: ");
        long code = r.nextLong();
        r.nextLine();
        boolean Flag = false;
        int x = 0;

        for (int i = 0; i < stArr.length; i++) {
            if (code == stArr[i].stCode) {
                x = i;
                Flag = true;
                break;
            }
        }

        if (Flag == false) {
            System.out.println("This student is not in the list!");
        } else {
            System.out.print("Enter the code: ");
            stArr[x].stCode = r.nextLong();
            r.nextLine();
            System.out.print("Enter the name: ");
            stArr[x].stName = r.nextLine();
            System.out.print("Enter the field: ");
            stArr[x].stField = r.nextLine();
            System.out.print("Enter the total grade: ");
            stArr[x].totalGrade = r.nextDouble();
        }
        System.out.println("Edit is done successfuly!");

    }//edit

    static void DeletingStudent() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter the student's code that you want to delete it: ");
        long code = inp.nextLong();

        for (int i = 0; i < stArr.length; i++) {
            if (code == stArr[i].stCode) {
                if (i == stArr.length - 1) {
                    stArr = Arrays.copyOf(stArr, stArr.length - 1);
                } else if (i < stArr.length - 1) {
                    while (i < stArr.length - 1) {
                        stArr[i] = stArr[i + 1];
                        ++i;
                    }
                    stArr = Arrays.copyOf(stArr, stArr.length - 1);
                    break;
                }

            }
        }
    }

    static void SortingStudent() {
        Scanner inpp = new Scanner(System.in);

        loop:
        while (true) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("How do you want to sort?");
            System.out.println("1: name_ASC\n2: name_DESC\n3: field_ASC\n4: field_DESC\n5: code_ASC\n6: code_DESC\n7: total grade_ASC\n8: total Grade_DESC\n9: Exit\n");
            System.out.print("Enter your choice: ");
            int userChoice = inpp.nextInt();

            switch (userChoice) {
                case 1:
                    sortByNameASC();
                    break;
                case 2:
                    sortByNameDESC();
                    break;
                case 3:
                    sortByFieldASC();
                    break;
                case 4:
                    sortByFieldDESC();
                    break;
                case 5:
                    sortByCodeASC();
                    break;
                case 6:
                    sortByCodeDESC();
                    break;
                case 7:
                    sortByTotalGradeASC();
                    break;
                case 8:
                    sortByTotalGradeDESC();
                    break;
                case 9:
                    break loop;
            }

        }
    }

    static void sortByNameASC() {
        if (stArr != null) {
            for (int i = 0; i < stArr.length; i++) {
                for (int j = i + 1; j < stArr.length; j++) {
                    if (stArr[i].stName.compareToIgnoreCase(stArr[j].stName) > 0) {
                        Student t = stArr[i];
                        stArr[i] = stArr[j];
                        stArr[j] = t;
                    }

                }

            }
        }
    }//sort by name ASC

    static void sortByNameDESC() {
        if (stArr != null) {
            for (int i = 0; i < stArr.length; i++) {
                for (int j = i + 1; j < stArr.length; j++) {
                    if (stArr[i].stName.compareToIgnoreCase(stArr[j].stName) < 0) {
                        Student t = stArr[i];
                        stArr[i] = stArr[j];
                        stArr[j] = t;
                    }

                }

            }
        }
    }//sort by name DESC

    static void sortByFieldASC() {
        if (stArr != null) {
            for (int i = 0; i < stArr.length; i++) {
                for (int j = i + 1; j < stArr.length; j++) {
                    if (stArr[i].stField.compareToIgnoreCase(stArr[j].stField) > 0) {
                        Student t = stArr[i];
                        stArr[i] = stArr[j];
                        stArr[j] = t;
                    }

                }

            }
        }
    }

    static void sortByFieldDESC() {
        if (stArr != null) {
            for (int i = 0; i < stArr.length; i++) {
                for (int j = i + 1; j < stArr.length; j++) {
                    if (stArr[i].stField.compareToIgnoreCase(stArr[j].stField) < 0) {
                        Student t = stArr[i];
                        stArr[i] = stArr[j];
                        stArr[j] = t;
                    }

                }

            }
        }
    }

    static void sortByCodeASC() {
        if (stArr != null) {
            for (int i = 0; i < stArr.length; ++i) {
                for (int j = i + 1; j < stArr.length; ++j) {
                    if (stArr[j].stCode < stArr[i].stCode) {
                        Student t = stArr[i];
                        stArr[i] = stArr[j];
                        stArr[j] = t;
                    }
                }
            }
        }
    }

    static void sortByCodeDESC() {
        if (stArr != null) {
            for (int i = 0; i < stArr.length; ++i) {
                for (int j = i + 1; j < stArr.length; ++j) {
                    if (stArr[j].stCode > stArr[i].stCode) {
                        Student t = stArr[i];
                        stArr[i] = stArr[j];
                        stArr[j] = t;
                    }
                }
            }
        }
    }

    static void sortByTotalGradeASC() {
        if (stArr != null) {
            for (int i = 0; i < stArr.length; ++i) {
                for (int j = i + 1; j < stArr.length; ++j) {
                    if (stArr[j].totalGrade < stArr[i].totalGrade) {
                        Student t = stArr[i];
                        stArr[i] = stArr[j];
                        stArr[j] = t;
                    }
                }
            }
        }
    }

    static void sortByTotalGradeDESC() {
        if (stArr != null) {
            for (int i = 0; i < stArr.length; ++i) {
                for (int j = i + 1; j < stArr.length; ++j) {
                    if (stArr[j].totalGrade > stArr[i].totalGrade) {
                        Student t = stArr[i];
                        stArr[i] = stArr[j];
                        stArr[j] = t;
                    }
                }
            }
        }
    }

    static void ShowingFromFile() {
        for (int i = 0; stArr != null && i < stArr.length; i++) {
            System.out.println(stArr[i]);
        }
    }

    static void SavingToFile() throws IOException {
//        File f = new File(fileName);
//        try (FileWriter fw = new FileWriter(f); BufferedWriter bw = new BufferedWriter(fw)) {
//            
//            for (int i = 0; stArr != null && i < stArr.length; i++) {
//                String str = stArr[i].stCode + "," + stArr[i].stName + "," + stArr[i].stField + "," + stArr[i].totalGrade;
//                bw.write(str);
//                bw.newLine();
//            }
//            
//        }
//
//        System.out.println("All of the changes was saved!");
        File f = new File(fileName);
        try(
        FileWriter fw =  new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);){
        System.out.println(stArr.length);
        if(stArr !=null){
        for (int i = 0; i < stArr.length; i++) {
            System.out.println(stArr.length);
            
                String file = stArr[i].stCode + "," + stArr[i].stName + "," + stArr[i].stField + "," + stArr[i].totalGrade;
                bw.write(file);
                bw.newLine();
            }
            
        }
        }

    }
}
