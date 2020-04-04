import java.util.Random;

/**
 * Class that stores and modifies the items of the program
 */
public class Wheel{
    private String name; //wheel name
    private List210 items; //items in the list
    private Random rand; //randomizer variable
    private boolean spinning; //boolean variable to see if the wheel is currently being spun
    private List210 reloadItems; //copy of the list of items

    /**
     * Ctor to initiate the main variables of the program
     */
    public Wheel() {
        name = "Unknown Wheel";
        items = new ColesList();
        rand = new Random();
        spinning = false;
        reloadItems = null;
    }

    /**
     * Gets the name of the wheel
     * @return wheel name created
     */
    public String getName() {return name;}

    /**
     * Sets the name of the wheel in the function
     * @param nm desired name for the wheel
     */
    public void setName(String nm){
        if(nm.isEmpty()) {return;}
        name = nm;
    }

    /**
     * Method that adds items to the list of wheel items
     * @param item name of the item desired to be added
     */
    public void addItem(String item){
        if(item.isEmpty()) {return;}
        items.addToEnd(item);
        spinning = false; //when set to false the reload is then updated
        reloadItems = null;
    }

    /**
     * Gets the amount of items in the list
     * @return the amount of items in the list
     */
    public int size(){
        return items.numItems();
    }

    /**
     * Gets the first item in the list
     * @return the first item of the list
     */
    public String firstItem(){
        return items.getFirst();
    }

    /**
     * Gets the last item of the list
     * @return the last item of the list
     */
    public String lastItem(){
        return items.getLast();
    }

    /**
     * Randomizes and selects a random item without deleting it
     * @return a random item selected with the randomizer
     */
    public String randomItem(){
        int n = size();
        if(n <= 0) {return null;}

        int index = rand.nextInt(n)+1;
        String item = items.get(index);
        return item;
    }

    /**
     * Clears the items in the list
     */
    public void clearItems(){
        items.clear();
    }

    /**
     * Reverses the order of the item list
     */
    public void reverseItems(){
        items.reverse();
    }

    /**
     * Spins for an item at random and then deletes the selected item from the list
     * @return a random item selected
     */
    public String spin(){
        int n = size();
        if(n <= 0) {return null;}

        //if spinning false it sets the reload copy list to the current list items
        if(!spinning){
            reloadItems = new ColesList((ColesList) items);
            spinning = true;
        }

        int index = rand.nextInt(n) + 1;
        String item = items.get(index);
        items.remove(index);
        return item;
    }

    /**
     * Reloads the list of items before spinning started
     * @return true if reload was successful
     */
    public boolean reloadItems(){
        boolean flag = false;

        //if reload isn't empty it takes the reload copy and swaps over to the normal list and deletes the copy list
        if(reloadItems != null){
            items = reloadItems;
            reloadItems = null;
            flag = true;
        }

        spinning = false; //sets spinning to false 
        return flag;
    }
    
    /**
     * Prints the toString defined in the ColesList class
     */
    public String toString(){
        return items.toString();
    }
}