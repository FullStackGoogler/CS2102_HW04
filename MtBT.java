import java.util.Collections;
import java.util.LinkedList;

public class MtBT implements IBinTree {
    MtBT(){}

    // returns false since empty tree has no elements
    public boolean hasElt(int e) {
        return false;
    }

    // returns 0 since enpty tree has no elements
    public int size() {
        return 0;
    }

    // returns 0 since empty tree has no branches
    public int height() {
        return 0;
    }

    /**
     * Converts the Binary Tree into a List of Integers.
     * @return A Binary Tree stored into a LinkedList of Integers.
     */
    public LinkedList<Integer> getList(){ return new LinkedList<>(); }

    /**
     * Checks if the element has been added properly.
     * @param btOrig The original Binary Tree to be compared to.
     * @param addlElt The element being added.
     * @return True if the element has been added correctly.
     */
    @Override
    public boolean addAccountedFor(IBinTree btOrig, int addlElt) {
        LinkedList<Integer> modList = new LinkedList<>(Collections.singletonList(addlElt));

        return modList.equals(this.getList());
    }

    /**
     * Checks if the element has been removed properly.
     * @param btOrig The original Binary Tree to be compared to.
     * @return True if the element has been removed correctly.
     */
    @Override
    public boolean remAccountedFor(IBinTree btOrig) {
        LinkedList<Integer> modList = btOrig.getList();

        return modList.equals(this.getList());
    }

    /**
     * Checks if the Binary Tree contains elements.
     * @return True of the Binary Tree is not empty.
     */
    @Override
    public boolean isEmpty() {
        return true;
    }
}