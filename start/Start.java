package start;

import books.Book;
import helper.Help;
import students.Student;
import teachers.Teacher;

public class Start {

    private Book book = new Book();
    private Student student = new Student();
    private Teacher teacher = new Teacher();

    public Start() {

        // Initialization
        this.init();

        int choise = -1;

        while (true) {
            Help.generateOptionsList(new String[] {
                "Student Management",
                "Teacher Management",
                "Book Management",
                "Basic Operations",
                "Exit"
            });

            if ((choise = Help.readInteger()) == -1) {
                Help.echoLn("\nWrong Option!!\n");
                continue;
            }

            switch (choise) {
                case 5:
                    return;

                case 1:
                    this.student.studentStart();
                    break;

                case 2:
                    this.teacher.teacherStart();
                    break;

                case 3:
                    this.book.bookStart();
                    break;

                case 4:
                    this.basicOperations();
                    break;

                default:
                    Help.echoLn("\nWrong Option!!\n");
                    break;
            }
        }
    }

    private void init() {
        String[] books = Help.readFile(Help.BOOK_PATH, Help.bookLimit);
        String[] students = Help.readFile(Help.STUDENT_PATH, Help.studentLimit);
        String[] teachers = Help.readFile(Help.TEACHER_PATH, Help.teacherLimit);

        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                break;
            }

            String[] bookInfo = books[i].split("    ");

            Book book = new Book();

            book.initBook(bookInfo);
        }

        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                break;
            }

            String[] studentInfo = students[i].split("    ");

            Student student = new Student();

            student.initStudent(studentInfo);

        }

        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) {
                break;
            }

            String[] teacherInfo = teachers[i].split("    ");

            Teacher teacher = new Teacher();

            teacher.initTeacher(teacherInfo);
        }
    }

    private void basicOperations() {
        int choise = -1;

        int bookID = -1;
        double fineAmount = -1.0;

        String tID = null;
        String sID = null;
        Teacher tmpTeacher = null;
        Student tmpStudent = null;
        Book tmpBook = null;

        Help.generateOptionsList(new String[] {
            "Borrow Book",
            "Return Book",
            "Add Fine"
        });

        if ((choise = Help.readInteger()) == -1) {
            Help.echoLn("\nWrong Option!!\n");
            return;
        }

        switch (choise) {
            case 1:
                Help.generateOptionsList(new String[] {
                    "I'm Teacher",
                    "I'm Student"
                });

                if ((choise = Help.readInteger()) == -1) {
                    Help.echoLn("\nWrong Option!!\n");
                    return;
                }

                if (choise == 1) {
                    while (true) {
                        Help.echo("\tEnter Teacher ID: ");
                        tID = Help.readString();

                        if (!tID.equals(null)) {
                            break;
                        }
                    }

                    while (true) {
                        Help.echo("\tEnter Book ID to Borrow: ");
                        bookID = Help.readInteger();

                        if (bookID != -1) {
                            break;
                        }
                    }

                    tmpTeacher = this.teacher.getTeacher(tID);
                    tmpBook = this.book.getBook(bookID);

                    if (tmpTeacher == null) {
                        Help.echoLn("\nCan't find the Teacher!!\n");
                        return;
                    }

                    if (tmpBook == null) {
                        Help.echoLn("\nCan't find the Book!!\n");
                        return;
                    }

                    this.teacher.borrow(tmpTeacher, tmpBook);

                } else if (choise == 2) {
                    while (true) {
                        Help.echo("\tEnter Student ID: ");
                        sID = Help.readString();

                        if (!sID.equals(null)) {
                            break;
                        }
                    }

                    while (true) {
                        Help.echo("\tEnter Book ID to Borrow: ");
                        bookID = Help.readInteger();

                        if (bookID != -1) {
                            break;
                        }
                    }

                    tmpStudent = this.student.getStudent(sID);
                    tmpBook = this.book.getBook(bookID);

                    if (tmpStudent == null) {
                        Help.echoLn("\nCan't find the Student!!\n");
                        return;
                    }

                    if (tmpBook == null) {
                        Help.echoLn("\nCan't find the Book!!\n");
                        return;
                    }

                    this.student.borrow(tmpStudent, tmpBook);

                } else {
                    Help.echoLn("\nWrong Option!!\n");
                    return;
                }

                tID = null;
                sID = null;
                tmpTeacher = null;
                tmpStudent = null;
                tmpBook = null;

                break;

            case 2:
                Help.generateOptionsList(new String[] {
                    "I'm Teacher",
                    "I'm Student"
                });

                if ((choise = Help.readInteger()) == -1) {
                    Help.echoLn("\nWrong Option!!\n");
                    return;
                }

                if (choise == 1) {
                    while (true) {
                        Help.echo("\tEnter Teacher ID: ");
                        tID = Help.readString();

                        if (!tID.equals(null)) {
                            break;
                        }
                    }

                    while (true) {
                        Help.echo("\tEnter Book ID to Return: ");
                        bookID = Help.readInteger();

                        if (bookID != -1) {
                            break;
                        }
                    }

                    tmpTeacher = this.teacher.getTeacher(tID);
                    tmpBook = this.book.getBook(bookID);

                    if (tmpTeacher == null) {
                        Help.echoLn("\nCan't find the Teacher!!\n");
                        return;
                    }

                    if (tmpBook == null) {
                        Help.echoLn("\nCan't find the Book!!\n");
                        return;
                    }

                    this.teacher.returnBook(tmpTeacher, tmpBook);

                } else if (choise == 2) {
                    while (true) {
                        Help.echo("\tEnter Student ID: ");
                        sID = Help.readString();

                        if (!sID.equals(null)) {
                            break;
                        }
                    }

                    while (true) {
                        Help.echo("\tEnter Book ID to Return: ");
                        bookID = Help.readInteger();

                        if (bookID != -1) {
                            break;
                        }
                    }

                    tmpStudent = this.student.getStudent(sID);
                    tmpBook = this.book.getBook(bookID);

                    if (tmpStudent == null) {
                        Help.echoLn("\nCan't find the Student!!\n");
                        return;
                    }

                    if (tmpBook == null) {
                        Help.echoLn("\nCan't find the Book!!\n");
                        return;
                    }

                    this.student.returnBook(tmpStudent, tmpBook);

                } else {
                    Help.echoLn("\nWrong Option!!\n");
                    return;
                }

                bookID = -1;
                tID = null;
                sID = null;
                tmpTeacher = null;
                tmpStudent = null;
                tmpBook = null;

                break;

            case 3:
                Help.generateOptionsList(new String[] {
                    "I'm Teacher",
                    "I'm Student"
                });

                if ((choise = Help.readInteger()) == -1) {
                    Help.echoLn("\nWrong Option!!\n");
                    return;
                }

                if (choise == 1) {
                    while (true) {
                        Help.echo("\tEnter Teacher ID: ");
                        tID = Help.readString();

                        if (!tID.equals(null)) {
                            break;
                        }
                    }

                    while (true) {
                        Help.echo("\tEnter Fine amount: ");
                        fineAmount = Help.readDouble();

                        if (fineAmount != -1.0) {
                            break;
                        }
                    }

                    tmpTeacher = this.teacher.getTeacher(tID);

                    if (tmpTeacher == null) {
                        Help.echoLn("\nCan't find the Teacher!!\n");
                        return;
                    }

                    this.teacher.fine(tmpTeacher, fineAmount);

                } else if (choise == 2) {
                    while (true) {
                        Help.echo("\tEnter Student ID: ");
                        sID = Help.readString();

                        if (!sID.equals(null)) {
                            break;
                        }
                    }

                    while (true) {
                        Help.echo("\tEnter Fine amount: ");
                        fineAmount = Help.readDouble();

                        if (fineAmount != -1.0) {
                            break;
                        }
                    }

                    tmpStudent = this.student.getStudent(sID);

                    if (tmpStudent == null) {
                        Help.echoLn("\nCan't find the Student!!\n");
                        return;
                    }

                    this.student.fine(tmpStudent, fineAmount);

                } else {
                    Help.echoLn("\nWrong Option!!\n");
                    return;
                }

                tID = null;
                sID = null;
                tmpTeacher = null;
                tmpStudent = null;
                tmpBook = null;

                break;

            default:
                Help.echoLn("\nWrong Option!!\n");
                break;
        }
    }

    public static void main(String[] args) {
        new Start();
    }
}