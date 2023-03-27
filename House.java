import java.util.ArrayList;

/* Inherit Building.java */
public class House extends Building{

  /* Setting up attributes needed */
  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  public House(String name, String address, int nFloors,boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String> ();
    this.hasDiningRoom = hasDiningRoom;

  }

  /* setting up accessors */
  /* check if the house has dining room */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /* get the number of residents */
  public int nResidents(){
    return this.residents.size();
  }


  /* methods for move in and move out */
  public void moveIn(String name){
    this.residents.add(name);
  }

  public String moveOut(String name){
    if(this.residents.contains(name)){
      this.residents.remove(name);
      return name;
    } else{
      throw new RuntimeException("Unsuccessful attempt to remove resident");
    }
  }

  /* check does the house contain a certain resident */
  public boolean isResident(String person){
    return this.residents.contains(person);
  }

  public static void main(String[] args) {
    new House();
  }

}