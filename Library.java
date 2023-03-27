import java.util.Hashtable;

public class Library extends Building{

    /* setting up attribute */  
    private Hashtable<String,Boolean> collection;


    /* initializing hashtable and inherited features  */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<>();
    }

    /* methods*/
    public void addTitle(String title){
      this.collection.put(title, true);
    }

    /* remove book from the collection */
    public String removeTitle(String title){
      this.collection.remove(title);
      return title;
    }

    /*check out a book, and change its assocaited boolean value to false */
    public void checkOut(String title){
      this.collection.replace(title, true, false);
    }

    /* returns a book, and change its associated boolean value to true*/
    public void returnBook(String title){
      this.collection.replace(title, false, true);
    }

    /* returns true if the title appears as a key in the Libary's collection, false otherwise */
    public boolean containsTitle(String title){
      return this.collection.containsKey(title);
    }

    /* check if a book is available in the library */
    public boolean isAvailable(String title){
      if (collection.containsKey(title)) {
        return collection.get(title);
    } else {
        return false;
    }
    }

    /* Methods to Print the Library Collection with Check Out status*/
    public void printCollection(){
      System.out.println("Library Collection: ");
      System.out.println("--------------------");
      for (String title : this.collection.keySet()){
        System.out.println(title);
        boolean available = this.collection.get(title);
        String status;
        if (available) {
          status = "Available";
          } else {
          status = "Checked Out";
          }
        System.out.println(title + "--" + status);
      }
    }


  
    public static void main(String[] args) {
      Library myLibrary = new Library("Central Library", "123 Main St.", 2);

    // Add some titles to the collection
    myLibrary.addTitle("To Kill a Mockingbird");
    myLibrary.addTitle("1984");
    myLibrary.addTitle("The Catcher in the Rye");
    myLibrary.addTitle("Brave New World");

    // Print out the collection
    myLibrary.printCollection();

    // Check out a book and print the updated collection
    myLibrary.checkOut("To Kill a Mockingbird");
    System.out.println("After checking out a book:");
    myLibrary.printCollection();

    // Return a book and print the updated collection
    myLibrary.returnBook("To Kill a Mockingbird");
    System.out.println("After returning a book:");
    myLibrary.printCollection();

    // Check if a title is in the collection and if it's available
    System.out.println("Does the collection contain '1984'? " + myLibrary.containsTitle("1984"));
    System.out.println("Is '1984' available? " + myLibrary.isAvailable("1984"));
    }
  
  }