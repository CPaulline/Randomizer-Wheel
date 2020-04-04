public class ColesList implements List210 {
    private ColesNode head; //head of the list
    private ColesNode tail; //tail of the list

    /**
     * Ctor for the list
     */
    public ColesList(){
        head = tail = null;
    }

    /**
     * Copy ctor
     * @param copy The List to copy
     */
    public ColesList (ColesList copy){
        head = tail = null;
        ColesNode n = copy.head;
        while(n != null){
            this.addToEnd(n.getValue());
            n = n.next;
        }
    }

    /**
     * Add to end of list
     */
    public void addToEnd( String str) {
        // always need a new node to add to end
        ColesNode n = new ColesNode(str);

        // case of empty list
        if( head == null) {
            head = n;
            tail = n;
        }
        // case to add to end of existing list
        else {
            n.prev = tail;
            tail.next = n;
            tail = n;
        }
    }

    /**
     * Returns the number of items
     */
    public int numItems(){
        int count = 0;
        ColesNode n = head;
        while(n != null){
            count++;
            n = n.next;
        }
        return count;
    }

    /**
     * Get the first item
     */
    public String getFirst() {
        String s = null;
        if( head != null) {
            s = head.getValue();
        }
        return s;
    }

    /**
     * Get the last item
     */
    public String getLast() {
        String s = null;
        if( tail != null) {
            s = tail.getValue();
        }
        return s;
    }

    /**
     * Get the item at the desired index i
     */
    public String get(int i){
        String item = null;
        ColesNode n = head;
        int count = 0;

        //finds the right node by using a counter and if the desired index and count match, returns value of node
        while(n != null){
            count++;
            if(count == i){
                item = n.getValue();
                break;
            }
            n = n.next;
        }
        return item;
    }

    /**
     * Remove an item
     */
    public boolean remove(int i){
        boolean found = false;

        ColesNode n = head;
        int count = 0;
        while(n != null){
            count++;
            if(count == i){
                removeNode(n);
                found = true;
                break;
            }
            n = n.next;
        }
        return found;
    }

    /**
     * Clear list of all items
     */
    public void clear() {
        head = null;
        tail = null;
    }

    /**
     * Reverse order of items
     */
    public void reverse(){
        if(isEmpty()) {return;}

        ColesNode n = head;
        ColesNode temp;
        while(n != null){ //set of swapping variables
            temp = n.next;
            n.next = n.prev;
            n.prev = temp;
            n = temp;
        }
        
        //swaps the head and tail variables
        temp = head;
        head = tail;
        tail = temp;
    }

    /**
     * Removes a node from the list
     * @param n The node being removed
     */
    private void removeNode(ColesNode n){
        if(n == head){ //case 1 : remove head of list
            head = n.next;
            if(head != null) {head.prev = null;}
        }else if(n == tail){ // case 2 : remove tail of list
            tail = n.prev;
            if(tail != null) {tail.next = null;}
        }else{ // case 3 : remove node in the middle of list
            ColesNode before = n.prev;
            before.next = n.next;
            ColesNode after = n.next;
            after.prev = n.prev;
        }
    }

    /**
     * Returns string for list, items are seperated by commas
     * empty list return and empty string
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        ColesNode n = head;
        while(n != null)  {
            if(!first) {sb.append(", ");}
            sb.append(n.getValue());

            first = false;
            n = n.next;
        }
        return sb.toString();
    }

    /**
     * Checks if the list is empty
     * @return true if the list is empty
     */
    public boolean isEmpty(){
        return (head == null);
    }
}