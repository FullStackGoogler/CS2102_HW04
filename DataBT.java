import java.lang.Math;
import java.util.Collections;
import java.util.LinkedList;

public class DataBT implements IBinTree {
    int data;
    IBinTree left;
    IBinTree right;

    DataBT(int data, IBinTree left, IBinTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // an alternate constructor for when both subtrees are empty
    DataBT(int data) {
        this.data = data;
        this.left = new MtBT();
        this.right = new MtBT();
    }

    // determines whether this node or node in subtree has given element
    public boolean hasElt(int e) {
        return this.data == e || this.left.hasElt(e) || this.right.hasElt(e) ;
    }

    // adds 1 to the number of nodes in the left and right subtrees
    public int size() {
        return 1 + this.left.size() + this.right.size();
    }

    // adds 1 to the height of the taller subtree
    public int height() {
        return 1 + Math.max(this.left.height(), this.right.height());
    }

    /**
     * Converts the Binary Tree into a List of Integers.
     * @return A Binary Tree stored into a LinkedList of Integers.
     */
    @Override
    public LinkedList<Integer> getList() {
        LinkedList<Integer> result = new LinkedList<>(this.right.getList());

        result.addAll(this.left.getList());
        result.add(data);

        return result;
    }

    /**
     * Checks if the element has been added properly.
     * @param btOrig The original Binary Tree to be compared to.
     * @param addlElt The element being added.
     * @return True if the element has been added correctly.
     */
    @Override
    public boolean addAccountedFor(IBinTree btOrig, int addlElt) {
        LinkedList<Integer> origList = this.getList();
        Collections.sort(origList);

        LinkedList<Integer> modList = btOrig.getList();
        modList.add(addlElt);
        Collections.sort(modList);

        return modList.equals(origList);
    }

    /**
     * Checks if the element has been removed properly.
     * @param btOrig The original Binary Tree to be compared to.
     * @return True if the element has been removed correctly.
     */
    @Override
    public boolean remAccountedFor(IBinTree btOrig) {
        LinkedList<Integer> origList = this.getList();
        Collections.sort(origList);

        LinkedList<Integer> modList = btOrig.getList();
        int smallest = Integer.MAX_VALUE;

        for(int i : modList) {
            if(i < smallest)
                smallest = i;
        }

        modList.removeFirstOccurrence(smallest);
        Collections.sort(modList);

        return modList.equals(origList);
    }

    /**
     * Checks if the Binary Tree contains elements.
     * @return True of the Binary Tree is not empty.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}