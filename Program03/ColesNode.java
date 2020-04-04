public class ColesNode {
    private String value; //string value of list item (immutable)
    public ColesNode next; //next node in list
    public ColesNode prev; //previous node in list

    /**
     * Ctor requires a value (immutable)
     * @param value the nodes value
     */
    public ColesNode( String value) {
        this.value = value;
    }

    /**
     * Getter for the value attribute
     * @return the node's value
     */
    public String getValue() {
        return this.value;
    }
}