package students;

import books.Book;
import helper.Help;
import patrons.Patron;
import students.studentoperations.StudentOperations;

public class Student extends Patron implements StudentOperations {

    private String studentId;
    private String guardianName;
    private String guardianContactNo;

    private static int currStudnetIndex = 0;
    private static Student[] students = new Student[Help.studentLimit];

    public void studentStart() {

        int choise = -1;
        String line = null;

        Student tmpStd = null;

        String stdID = null;
        String stdGuardianName = null;
        String stdGuardianContactNo = null;

        int patronId = -1;
        String patronName = null;
        String patronDepartmentName = null;
        String patronEmail = null;
        String patronContactNo = null;
        String patronAddress = null;
        double patronAmount = -1.0;

        Help.generateOptionsList(new String[] {
            "Insert New Student",
            "Search by studentId",
            "Show All Student"
        });

        if ((choise = Help.readInteger()) == -1) {
            Help.echoLn("\nWrong Option!!\n");
            return;
        }

        switch (choise) {
            case 1:
                if ((Student.currStudnetIndex + 1) > Help.studentLimit) {
                    Help.echoLn("\nStudent limit has been reached, can't insert any student\n");
                    return;
                }

                tmpStd = new Student();

                while (true) {
                    Help.echo("\tEnter Student ID: ");
                    stdID = Help.readString();

                    if (!stdID.equals(null)) {
                        break;
                    }
                }

                while (true) {
                    Help.echo("\tEnter Student Name: ");
                    patronName = Help.readString();

                    if (!patronName.equals(null)) {
                        break;
                    }
                }

                while (true) {
                    Help.echo("\tEnter Guardian Name: ");
                    stdGuardianName = Help.readString();

                    if (!stdGuardianName.equals(null)) {
                        break;
                    }
                }

                while (true) {
                    Help.echo("\tEnter Guardian Contact NO: ");
                    stdGuardianContactNo = Help.readString();

                    if (!stdGuardianContactNo.equals(null)) {
                        break;
                    }
                }

                while (true) {
                    Help.echo("\tEnter Patron ID: ");
                    patronId = Help.readInteger();

                    if (patronId != -1) {
                        break;
                    }
                }

                while (true) {
                    Help.echo("\tEnter Department Name: ");
                    patronDepartmentName = Help.readString();

                    if (!patronDepartmentName.equals(null)) {
                        break;
                    }
                }

                while (true) {
                    Help.echo("\tEnter Email: ");
                    patronEmail = Help.readString();

                    if (!patronEmail.equals(null)) {
                        break;
                    }
                }

                while (true) {
                    Help.echo("\tEnter Contact No: ");
                    patronContactNo = Help.readString();

                    if (!patronContactNo.equals(null)) {
                        break;
                    }
                }

                while (true) {
                    Help.echo("\tEnter Address: ");
                    patronAddress = Help.readString();

                    if (!patronAddress.equals(null)) {
                        break;
                    }
                }

                while (true) {
                    Help.echo("\tEnter Amount: ");
                    patronAmount = Help.readDouble();

                    if (patronAmount != -1.0) {
                        break;
                    }
                }

                tmpStd.setStudentId(stdID);
                tmpStd.setName(patronName);
                tmpStd.setGuardianName(stdGuardianName);
                tmpStd.setGuardianContactNo(stdGuardianContactNo);
                tmpStd.setId(patronId);
                tmpStd.setDepartmentName(patronDepartmentName);
                tmpStd.setEmail(patronEmail);
                tmpStd.setContactNo(patronContactNo);
                tmpStd.setAddress(patronAddress);
                tmpStd.setAmount(patronAmount);
                tmpStd.setBookBorrow(null);

                this.insertStudent(tmpStd);

                line = tmpStd.getStudentId() + "    ";
                line += tmpStd.getName() + "    ";
                line += tmpStd.getGuardianName() + "    ";
                line += tmpStd.getGuardianContactNo() + "    ";
                line += tmpStd.getId() + "    ";
                line += tmpStd.getDepartmentName() + "    ";
                line += tmpStd.getEmail() + "    ";
                line += tmpStd.getContactNo() + "    ";
                line += tmpStd.getAddress() + "    ";
                line += tmpStd.getAmount() + "    ";
                line += tmpStd.getBookBorrow() != null ? "bookid-" + tmpStd.getBookBorrow().getId() + "\n"
                        : "bookid-empty\n";

                Help.writeFile(Help.STUDENT_PATH, line, true);

                tmpStd = null;
                stdID = null;
                patronName = null;
                stdGuardianName = null;
                stdGuardianContactNo = null;
                patronId = -1;
                patronDepartmentName = null;
                patronEmail = null;
                patronContactNo = null;
                patronAddress = null;
                patronAmount = -1.0;

                break;

            case 2:
                if (Student.currStudnetIndex <= 0) {
                    Help.echoLn("\nEmpty!!\nTry to insert Student\n");
                    return;
                }

                while (true) {
                    Help.echo("\tEnter Student ID: ");
                    stdID = Help.readString();

                    if (!stdID.equals(null)) {
                        break;
                    }
                }

                tmpStd = this.getStudent(stdID);

                if (tmpStd != null) {
                    Help.echoLn("\nSuccessfully found the Student.\n" );
                    tmpStd.showInfo();
                } else {
                    Help.echoLn("\nCan't Find the Student!!\n");
                }

                tmpStd = null;
                stdID = null;

                break;

            case 3:
                this.showAllStudents();
                break;

            default:
                Help.echoLn("\nWrong Option!!\n");
                break;
        }
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public void setGuardianContactNo(String guardianContactNo) {
        this.guardianContactNo = guardianContactNo;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public String getGuardianName() {
        return this.guardianName;
    }

    public String getGuardianContactNo() {
        return this.guardianContactNo;
    }

    /**
     * Interface Class StudentOperations
     */

    public void insertStudent(Student s) {
        Student.students[Student.currStudnetIndex] = s;
        Student.currStudnetIndex++;
    }

    public void removeStudent(Student s) {
        boolean notFound = true;
        for (int i = 0; i < Student.students.length - 1; i++) {
            if (s.getStudentId().equals(Student.students[i].getStudentId()) && notFound) {
                notFound = false;
                Student.students[i] = null;
            }
            if (!notFound) {
                Student.students[i] = Student.students[i + 1];
            }
        }
        Student.currStudnetIndex--;
    }

    public Student getStudent(String studentId) {
        for (int i = 0; i < Student.currStudnetIndex; i++) {
            if (studentId.equals(Student.students[i].getStudentId())) {
                return Student.students[i];
            }
        }

        return null;
    }

    public void showAllStudents() {
        for (int i = 0; i < Student.currStudnetIndex; i++) {
            Help.echoLn("Student " + (i + 1));
            Student.students[i].showInfo();
        }
    }

    /**
     * Abstract Class Patron
     */

    public void showInfo() {
        Help.echoLn("\tStudent ID           : " + this.getStudentId());
        Help.echoLn("\tStudent Name         : " + this.getName());
        Help.echoLn("\tDepartment Name      : " + this.getDepartmentName());
        Help.echoLn("\tGuardian Name        : " + this.getGuardianName());
        Help.echoLn("\tGuardian Contact No  : " + this.getGuardianContactNo());
        Help.echoLn("\tPatron ID            : " + this.getId());
        Help.echoLn("\tEmail                : " + this.getEmail());
        Help.echoLn("\tContact NO           : " + this.getContactNo());
        Help.echoLn("\tAddress              : " + this.getAddress());
        Help.echoLn("\tAmount               : " + this.getAmount());
        Help.echoLn("\tBorrowed Book ID     : " + (this.getBookBorrow() != null ? this.getBookBorrow().getId() + "" : "No book borrowed"));
    }

    /**
     * Interface Class IBasicOperations
     */

    public void borrow(Patron p, Book b) {
        p.setBookBorrow(b);

        String[] students = Help.readFile(Help.STUDENT_PATH, Help.studentLimit);
        String line = null;
        boolean isSuccessful = false;
        boolean firstIterate = true;

        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                break;
            }

            String[] studentInfo = students[i].split("    ");

            if (studentInfo[10].equals("bookid-empty") && p.getId() == Integer.parseInt(studentInfo[4])) {
                line = students[i];
                line = line.replaceAll("    bookid-empty", "    bookid-" + b.getId());
                students[i] = line;
                isSuccessful = true;
                break;
            } else {
                continue;
            }
        }

        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                break;
            }

            if (firstIterate) {
                Help.writeFile(Help.STUDENT_PATH, students[i] + "\n", false);
                firstIterate = false;
            } else {
                Help.writeFile(Help.STUDENT_PATH, students[i] + "\n", true);
            }

        }

        if (isSuccessful) {
            Help.echoLn("\nSuccessfully Borrowed your Book.\n");
            // Help.echoLn("Borrowed Book information: ");
            // b.showBookInfo();
        } else {
            Help.echoLn("\nAlready borrowed a book!!\nFirst Return the previous book then borrow a new one.\n");
        }
    }

    public void returnBook(Patron p, Book b) {

        String[] students = Help.readFile(Help.STUDENT_PATH, Help.studentLimit);
        String line = null;
        boolean isSuccessful = false;
        boolean firstIterate = true;

        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                break;
            }

            String[] studentInfo = students[i].split("    ");

            if (!studentInfo[10].equals("bookid-empty") && p.getBookBorrow() != null) {
                String bookBorrowID = "bookid-" + p.getBookBorrow().getId();
                if (bookBorrowID.equals("bookid-" + b.getId())) {
                    line = students[i];
                    line = line.replaceAll("    bookid-" + b.getId(), "    bookid-empty");
                    students[i] = line;
                    isSuccessful = true;
                    break;
                } else {
                    continue;
                }
            } else {
                continue;
            }

        }

        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                break;
            }

            if (firstIterate) {
                Help.writeFile(Help.STUDENT_PATH, students[i] + "\n", false);
                firstIterate = false;
            } else {
                Help.writeFile(Help.STUDENT_PATH, students[i] + "\n", true);
            }
        }

        if (isSuccessful) {
            Help.echoLn("\nSuccessfully Return your Book.\n");
            // Help.echoLn("Return Book information: ");
            // b.showBookInfo();
        } else {
            Help.echoLn("\nYou don't have a book to return\nFirst Borrow this book.\n");
        }
    }

    public void fine(Patron p, double amount) {
        String line = null;
        line = p.getId() + "    ";
        line += amount + "\n";

        // Help.echoLn("\nStudent Information: ");
        // p.showInfo();

        Help.writeFile(Help.TRANSACTION_PATH, line, true);
    }

    public void initStudent(String[] studentInfo) {
        Student student = new Student();
        Book tmpBook = new Book();

        student.setStudentId(studentInfo[0]);
        student.setName(studentInfo[1]);
        student.setGuardianName(studentInfo[2]);
        student.setGuardianContactNo(studentInfo[3]);
        student.setId(Integer.parseInt(studentInfo[4]));
        student.setDepartmentName(studentInfo[5]);
        student.setEmail(studentInfo[6]);
        student.setContactNo(studentInfo[7]);
        student.setAddress(studentInfo[8]);
        student.setAmount(Double.parseDouble(studentInfo[9]));

        if (!studentInfo[10].equals("bookid-empty")) {
            tmpBook = tmpBook.getBook(Integer.parseInt(studentInfo[10].replaceAll("bookid-", "")));
            student.setBookBorrow(tmpBook);
        }

        this.insertStudent(student);
    }

}