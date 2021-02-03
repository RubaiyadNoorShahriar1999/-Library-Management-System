package teachers;

import books.Book;
import helper.Help;
import patrons.Patron;
import teachers.teacheroperations.TeacherOperations;

public class Teacher extends Patron implements TeacherOperations {

    private String teacherId;

    private static int currTeacherIndex = 0;
    private static Teacher[] teachers = new Teacher[Help.teacherLimit];

    public void teacherStart() {

        int choise = -1;
        String line = null;

        Teacher tmpTchr = null;

        String tID = null;

        int patronId = -1;
        String patronName = null;
        String patronDepartmentName = null;
        String patronEmail = null;
        String patronContactNo = null;
        String patronAddress = null;
        double patronAmount = -1.0;

        Help.generateOptionsList(new String[] {
            "Insert New Teacher",
            "Search by teacherId",
            "Show All Teacher"
        });

        if ((choise = Help.readInteger()) == -1) {
            Help.echoLn("\nWrong Option!!\n");
            return;
        }

        switch (choise) {
            case 1:
                if((Teacher.currTeacherIndex + 1) > Help.teacherLimit){
                    Help.echoLn("\nTeacher limit has been reached, can't insert any teacher\n");
                    return;
                }

                tmpTchr = new Teacher();

                while(true) {
                    Help.echo("\tEnter Teacher ID: ");
                    tID = Help.readString();

                    if(!tID.equals(null)){
                        break;
                    }
                }

                while(true) {
                    Help.echo("\tEnter Teacher Name: ");
                    patronName = Help.readString();

                    if(!patronName.equals(null)){
                        break;
                    }
                }

                while(true) {
                    Help.echo("\tEnter Patron ID: ");
                    patronId = Help.readInteger();

                    if(patronId != -1){
                        break;
                    }
                }

                while(true) {
                    Help.echo("\tEnter Department Name: ");
                    patronDepartmentName = Help.readString();

                    if(!patronDepartmentName.equals(null)){
                        break;
                    }
                }

                while(true) {
                    Help.echo("\tEnter Email: ");
                    patronEmail = Help.readString();

                    if(!patronEmail.equals(null)){
                        break;
                    }
                }

                while(true) {
                    Help.echo("\tEnter Contact No: ");
                    patronContactNo = Help.readString();

                    if(!patronContactNo.equals(null)){
                        break;
                    }
                }

                while(true) {
                    Help.echo("\tEnter Address: ");
                    patronAddress = Help.readString();

                    if(!patronAddress.equals(null)){
                        break;
                    }
                }

                while(true) {
                    Help.echo("\tEnter Amount: ");
                    patronAmount = Help.readDouble();

                    if(patronAmount != -1.0){
                        break;
                    }
                }

                tmpTchr.setTeacherId(tID);
                tmpTchr.setName(patronName);
                tmpTchr.setId(patronId);
                tmpTchr.setDepartmentName(patronDepartmentName);
                tmpTchr.setEmail(patronEmail);
                tmpTchr.setContactNo(patronContactNo);
                tmpTchr.setAddress(patronAddress);
                tmpTchr.setAmount(patronAmount);
                tmpTchr.setBookBorrow(null);

                this.insertTeacher(tmpTchr);

                line = tmpTchr.getTeacherId() + "    ";
                line += tmpTchr.getName() + "    ";
                line += tmpTchr.getId() + "    ";
                line += tmpTchr.getDepartmentName() + "    ";
                line += tmpTchr.getEmail() + "    ";
                line += tmpTchr.getContactNo() + "    ";
                line += tmpTchr.getAddress() + "    ";
                line += tmpTchr.getAmount() + "    ";
                line += tmpTchr.getBookBorrow() != null ? "bookid-" + tmpTchr.getBookBorrow().getId() + "\n" : "bookid-empty\n";

                Help.writeFile(Help.TEACHER_PATH, line, true);

                tmpTchr = null;
                tID = null;
                patronName = null;
                patronId = -1;
                patronDepartmentName = null;
                patronEmail = null;
                patronContactNo = null;
                patronAddress = null;
                patronAmount = -1.0;

                break;

            case 2:
                if(Teacher.currTeacherIndex <= 0) {
                    Help.echoLn("\nEmpty!!\nTry to insert Teacher\n");
                    return;
                }

                while(true) {
                    Help.echo("\tEnter Teacher ID: ");
                    tID = Help.readString();

                    if(!tID.equals(null)) {
                        break;
                    }
                }

                tmpTchr = this.getTeacher(tID);

                if(tmpTchr != null) {
                    Help.echoLn("\nSuccessfully found the Teacher.\n");
                    tmpTchr.showInfo();
                } else {
                    Help.echoLn("\nCan't Find the Teacher!!\n");
                }

                tmpTchr = null;
                tID = null;

                break;

            case 3:
                this.showAllTeachers();
                break;
        
            default:
                Help.echoLn("\nWrong Option!!\n");
                break;
        }
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherId() {
        return this.teacherId;
    }

    /**
     * Interface Class TeacherOperations
     */

    public void insertTeacher(Teacher t) {
        Teacher.teachers[Teacher.currTeacherIndex] = t;
        Teacher.currTeacherIndex++;
    }

    public Teacher getTeacher(String teacherId) {
        for(int i = 0; i < Teacher.currTeacherIndex; i++) {
            if(teacherId.equals(Teacher.teachers[i].getTeacherId())) {
                return Teacher.teachers[i];
            }
        }

        return null;
    }

    public void showAllTeachers() {
        for(int i = 0; i < Teacher.currTeacherIndex; i++) {
            Help.echoLn("Teacher " + (i+1));
            Teacher.teachers[i].showInfo();
        }
    }

    /**
     * Abstract Class Patron
     */

    public void showInfo() {
        Help.echoLn("\tTeacher ID           : " + this.getTeacherId());
        Help.echoLn("\tStudent Name         : " + this.getName());
        Help.echoLn("\tDepartment Name      : " + this.getDepartmentName());
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

        String[] teachers = Help.readFile(Help.TEACHER_PATH, Help.teacherLimit);
        String line = null;
        boolean isSuccessful = false;
        boolean firstIterate = true;

        for(int i = 0; i < teachers.length; i++) {
            if(teachers[i] == null) {
                break;
            }

            String[] teacherInfo = teachers[i].split("    ");

            if(teacherInfo[8].equals("bookid-empty") && p.getId() == Integer.parseInt(teacherInfo[2])) {
                line = teachers[i];
                line = line.replaceAll("    bookid-empty", "    bookid-" + b.getId());
                teachers[i] = line;
                isSuccessful = true;
                break;
            } else {
                continue;
            }
        }

        for(int i = 0; i < teachers.length; i++) {
            if(teachers[i] == null) {
                break;
            }

            if(firstIterate){
                Help.writeFile(Help.TEACHER_PATH, teachers[i] + "\n", false);
                firstIterate = false;
            } else {
                Help.writeFile(Help.TEACHER_PATH, teachers[i] + "\n", true);
            }
        }

        if (isSuccessful) {
            Help.echoLn("\nSuccessfully Borrowed your Book.\n");
            // Help.echoLn("Borrowed Book information: ");
            // b.showBookInfo();
        } else {
            Help.echoLn("\nAlready borrowing a book!!\nFirst Return the previous book then borrow a new one.\n");
        }
    }

    public void returnBook(Patron p, Book b) {

        String[] teachers = Help.readFile(Help.TEACHER_PATH, Help.teacherLimit);
        String line = null;
        boolean isSuccessful = false;
        boolean firstIterate = true;

        for(int i = 0; i < teachers.length; i++) {
            if(teachers[i] == null) {
                break;
            }

            String[] teacherInfo = teachers[i].split("    ");

            if(!teacherInfo[8].equals("bookid-empty") && p.getBookBorrow() != null) {
                String bookBorrowID = "bookid-" + p.getBookBorrow().getId();
                if(bookBorrowID.equals("bookid-" + b.getId())) {
                    line = teachers[i];
                    line = line.replaceAll("    bookid-" + b.getId(), "    bookid-empty");
                    teachers[i] = line;
                    isSuccessful = true;
                    break;
                } else {
                    continue;
                }
            } else {
                continue;
            }

        }

        for(int i = 0; i < teachers.length; i++) {
            if(teachers[i] == null) {
                break;
            }

            if(firstIterate){
                Help.writeFile(Help.TEACHER_PATH, teachers[i] + "\n", false);
                firstIterate = false;
            } else {
                Help.writeFile(Help.TEACHER_PATH, teachers[i] + "\n", true);
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

    public void initTeacher(String[] teacherInfo) {
        Teacher teacher = new Teacher();
        Book tmpBook = new Book();

        teacher.setTeacherId(teacherInfo[0]);
        teacher.setName(teacherInfo[1]);
        teacher.setId(Integer.parseInt(teacherInfo[2]));
        teacher.setDepartmentName(teacherInfo[3]);
        teacher.setEmail(teacherInfo[4]);
        teacher.setContactNo(teacherInfo[5]);
        teacher.setAddress(teacherInfo[6]);
        teacher.setAmount(Double.parseDouble(teacherInfo[7]));

        if(!teacherInfo[8].equals("bookid-empty")) {
            tmpBook = tmpBook.getBook(Integer.parseInt(teacherInfo[8].replaceAll("bookid-", "")));
            teacher.setBookBorrow(tmpBook);
        }

        this.insertTeacher(teacher);
    }
}