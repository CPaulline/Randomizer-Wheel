/**
 * Interface to the linked list in Program #1.
 * The list holds String  values and is built by hand, no JCF.
 * 
 * Issues: 1) How to print? 2) How does reload really work?
 * 3) How to create a copy of the list?
 */
public interface List210 {
// adding methods
public void addToEnd( String str);
// public void addToBeginning(String str);

// getting or finding methods
// public boolean get( String str);
public String get( int i);
public String getFirst();
public String getLast();

// removal methods; return true if successful
// public boolean remove( String str);
public boolean remove( int i);

// etc - fun methods without a category
public int numItems();
public void clear();
public void reverse();
}