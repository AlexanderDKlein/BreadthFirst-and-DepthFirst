public class Branch {
    //Declares variables
    private Branch right;
    private Branch left;
    private char node;

    //Adds Constructors
    public Branch() {
        node = ' ';
        right = null;
        left = null;
    }
    public Branch(char n) {
        node = n;
        right = null;
        left = null;
    }
    public Branch(char n, Branch l, Branch r) {
        node = n;
        right = r;
        left = l;
    }

    /*
     * Adds functions
     */
    //Adds the getters
    public Branch getRight() {
        return this.right;
    }
    public Branch getLeft() {
        return this.left;
    }
    public char getNode() {
        return this.node;
    }

    //Adds the setters
    public void setRight(Branch r) {
        this.right = r;
    }
    public void setLeft(Branch l) {
        this.left = l;
    }
    public void setNode(char n) {
        this.node = n;
    }
}
