package books;

import helper.Help;
import books.authors.Author;
import books.publishers.Publisher;
import books.bookoperations.BookOperations;

public class Book implements BookOperations {

    private int id;
    private String title;
    private String subtitle;
    private Author author;
    private Publisher publisher;
    private double price;

    private static int currBookIndex = 0;
    private static Book[] books = new Book[Help.bookLimit];

    public void bookStart() {

        int choise = -1;
        String line = null;

        Book tmpBook = null;

        int bookID = -1;
        String bookTitle = null;
        String bookSubTitle = null;
        Author bookAuthor = null;
        Publisher bookPublisher = null;
        double bookPrice = -1.0;

        int authorId = -1;
        String authorName = null;
        String authorEmail = null;

        int publisherId = -1;
        String publisherName = null;
        String publisherContactNo = null;

        Help.generateOptionsList(new String[] {
            "Insert New Book",
            "Search by bookId",
            "Show All Books"
        });

        if ((choise = Help.readInteger()) == -1) {
            Help.echoLn("\nWrong Option!!\n");
            return;
        }

        switch (choise) {
            case 1:
                if ((Book.currBookIndex + 1) > Help.bookLimit) {
                    Help.echoLn("\nBook limit has been reached, can't insert any Book\n");
                    return;
                }

                tmpBook = new Book();

                while (true) {
                    Help.echo("\tEnter Book ID: ");
                    bookID = Help.readInteger();

                    if (bookID != -1) {
                        break;
                    }
                }

                while (true) {
                    Help.echo("\tEnter Book Title: ");
                    bookTitle = Help.readString();

                    if (!bookTitle.equals(null)) {
                        break;
                    }
                }

                while (true) {
                    Help.echo("\tEnter Book Subtitle: ");
                    bookSubTitle = Help.readString();

                    if (!bookSubTitle.equals(null)) {
                        break;
                    }
                }

                while (true) {
                    Help.echo("\tEnter Author ID: ");
                    authorId = Help.readInteger();

                    if (authorId != -1) {
                        break;
                    }
                }

                while (true) {
                    Help.echo("\tEnter Author Name: ");
                    authorName = Help.readString();

                    if (!authorName.equals(null)) {
                        break;
                    }
                }

                while (true) {
                    Help.echo("\tEnter Author Email: ");
                    authorEmail = Help.readString();

                    if (!authorEmail.equals(null)) {
                        break;
                    }
                }

                while (true) {
                    Help.echo("\tEnter Publisher ID: ");
                    publisherId = Help.readInteger();

                    if (publisherId != -1) {
                        break;
                    }
                }

                while (true) {
                    Help.echo("\tEnter Publisher Name: ");
                    publisherName = Help.readString();

                    if (!publisherName.equals(null)) {
                        break;
                    }
                }

                while (true) {
                    Help.echo("\tEnter Publisher Contact No: ");
                    publisherContactNo = Help.readString();

                    if (!publisherContactNo.equals(null)) {
                        break;
                    }
                }

                while (true) {
                    Help.echo("\tEnter Book Price: ");
                    bookPrice = Help.readDouble();

                    if (bookPrice != -1.0) {
                        break;
                    }
                }

                bookAuthor = new Author();
                bookPublisher = new Publisher();

                bookAuthor.setId(authorId);
                bookAuthor.setName(authorName);
                bookAuthor.setEmail(authorEmail);

                bookPublisher.setId(publisherId);
                bookPublisher.setName(publisherName);
                bookPublisher.setContactNo(publisherContactNo);

                tmpBook.setId(bookID);
                tmpBook.setTitle(bookTitle);
                tmpBook.setSubTitle(bookSubTitle);
                tmpBook.setAuthor(bookAuthor);
                tmpBook.setPublisher(bookPublisher);
                tmpBook.setPrice(bookPrice);

                this.insertBook(tmpBook);

                line = tmpBook.getId() + "    ";
                line += tmpBook.getTitle() + "    ";
                line += tmpBook.getSubTitle() + "    ";
                line += tmpBook.getAuthor().getId() + "    ";
                line += tmpBook.getAuthor().getName() + "    ";
                line += tmpBook.getAuthor().getEmail() + "    ";
                line += tmpBook.getPublisher().getId() + "    ";
                line += tmpBook.getPublisher().getName() + "    ";
                line += tmpBook.getPublisher().getContactNo() + "    ";
                line += tmpBook.getPrice() + "\n";

                Help.writeFile(Help.BOOK_PATH, line, true);

                tmpBook = null;

                bookID = -1;
                bookTitle = null;
                bookSubTitle = null;
                bookAuthor = null;
                bookPublisher = null;
                bookPrice = -1.0;

                authorId = -1;
                authorName = null;
                authorEmail = null;

                publisherId = -1;
                publisherName = null;
                publisherContactNo = null;

                break;

            case 2:
                if (Book.currBookIndex <= 0) {
                    Help.echoLn("\nEmpty!!\nTry to insert Book\n");
                    return;
                }

                while (true) {
                    Help.echo("\tEnter Book ID: ");
                    bookID = Help.readInteger();

                    if (bookID != -1) {
                        break;
                    }
                }

                tmpBook = this.getBook(bookID);

                if (tmpBook != null) {
                    Help.echoLn("\nSuccessfully found the Book.\n");
                    tmpBook.showBookInfo();
                } else {
                    Help.echoLn("\nCan't Find the Book!!\n");
                }

                tmpBook = null;
                bookID = -1;

                break;

            case 3:
                this.showAllBooks();
                break;

            default:
                Help.echoLn("\nWrong Option!!\n");
                break;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubTitle(String subTitle) {
        this.subtitle = subTitle;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSubTitle() {
        return this.subtitle;
    }

    public Author getAuthor() {
        return this.author;
    }

    public Publisher getPublisher() {
        return this.publisher;
    }

    public double getPrice() {
        return this.price;
    }

    

    public void insertBook(Book b) {
        Book.books[Book.currBookIndex] = b;
        Book.currBookIndex++;
    }

    public Book getBook(int bookId) {
        for (int i = 0; i < Book.currBookIndex; i++) {
            if (bookId == Book.books[i].getId()) {
                return Book.books[i];
            }
        }

        return null;
    }

    public void showAllBooks() {
        for (int i = 0; i < Book.currBookIndex; i++) {
            Help.echoLn("Book " + (i + 1));
            Book.books[i].showBookInfo();
        }
    }

    public void showBookInfo() {
        Help.echoLn("\tBook ID                : " + this.getId());
        Help.echoLn("\tBook Title             : " + this.getTitle());
        Help.echoLn("\tBook Subtitle          : " + this.getSubTitle());
        Help.echoLn("\tAuthor ID              : " + this.getAuthor().getId());
        Help.echoLn("\tAuthor Name            : " + this.getAuthor().getName());
        Help.echoLn("\tAuthor Email           : " + this.getAuthor().getEmail());
        Help.echoLn("\tPublisher ID           : " + this.getPublisher().getId());
        Help.echoLn("\tPublisher Name         : " + this.getPublisher().getName());
        Help.echoLn("\tPublisher Contact No   : " + this.getPublisher().getContactNo());
        Help.echoLn("\tBook Price             : " + this.getPrice());
    }

    public void initBook(String[] bookInfo) {
        Book book = new Book();
        Author tmpAuthor = new Author();
        Publisher tmpPublisher = new Publisher();

        book.setId(Integer.parseInt(bookInfo[0]));
        book.setTitle(bookInfo[1]);
        book.setSubTitle(bookInfo[2]);
        tmpAuthor.setId(Integer.parseInt(bookInfo[3]));
        tmpAuthor.setName(bookInfo[4]);
        tmpAuthor.setEmail(bookInfo[5]);
        book.setAuthor(tmpAuthor);
        tmpPublisher.setId(Integer.parseInt(bookInfo[6]));
        tmpPublisher.setName(bookInfo[7]);
        tmpPublisher.setContactNo(bookInfo[8]);
        book.setPublisher(tmpPublisher);
        book.setPrice(Double.parseDouble(bookInfo[9]));

        this.insertBook(book);
    }

}