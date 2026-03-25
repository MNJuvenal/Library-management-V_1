
package model;

public class Book {
    private String id;
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    public Book(String id,String title,String author,String isbn, boolean available){
            this.id = id;
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.available = available;
    } 
    
    public String getId(){
        return id;
    }

    
    public String   setTitle(String title){
         this.title=title;
         return "the new title of the book is:"+title;
    }
    public String  getTitle(){
         return this.title;
    }

    public String getAuthor(){
        return this.author;
    }
    public String  setAuthor(String author){
        this.author = author;
        return "the new  author  of the book is:"+author; 
    }

    public String getIsbn() {
        return isbn;
    }

  

    public boolean isAvailable() {
        return available;
    }


    public String  getDetails() {
        if (available) {
            return "[" + id + "] " + title + " by " + author + ", ISBN: " + isbn + " and is available";
        } else {
            return "[" + id + "] " + title + " by " + author + ", ISBN: " + isbn + " and is unavailable";
        }
    }
    public void markAsBorrowed(){
            available=false;
    }

    public void markAsAvailable(){
        available=true;
    }
}
