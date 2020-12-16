import java.util.LinkedList;

public interface IBinTree {
    // determines whether element is in the tree
    boolean hasElt(int e);

    // returns number of nodes in the tree; counts duplicate elements as separate items
    int size();

    // returns depth of longest branch in the tree
    int height();

    /**
     * Checks if the Binary Tree contains elements.
     * @return True of the Binary Tree is not empty.
     */
    boolean isEmpty();

    /**
     * Checks if the element has been added properly.
     * @param btOrig The original Binary Tree to be compared to.
     * @param addlElt The element being added.
     * @return True if the element has been added correctly.
     */
    boolean addAccountedFor(IBinTree btOrig, int addlElt);

    /**
     * Checks if the element has been removed properly.
     * @param btOrig The original Binary Tree to be compared to.
     * @return True if the element has been removed correctly.
     */
    boolean remAccountedFor(IBinTree btOrig);

    /**
     * Converts the Binary Tree into a List of Integers.
     * @return A Binary Tree stored into a LinkedList of Integers.
     */
    LinkedList<Integer> getList();
}