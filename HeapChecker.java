public class HeapChecker {
    /**
     * Verify if the given Binary Tree is a valid Heap.
     * @param hOrig The original Heap.
     * @param elt The element to be added.
     * @param hMod The modified Heap.
     * @return True if the given Binary Tree is a valid Heap.
     */
    public boolean addEltTester(IHeap hOrig, int elt, IBinTree hMod) {
        return hOrig.isHeap() && (hMod.size() == hOrig.size() + 1) && hMod.hasElt(elt) && hMod.addAccountedFor(hOrig, elt);
    }

    /**
     * Verify if the given Binary Tree is a valid Heap.
     * @param hOrig The original Heap.
     * @param hRem The modified Heap.
     * @return True of the given Binary Tree is a valid Heap.
     */
    public boolean remMinEltTester(IHeap hOrig, IBinTree hRem) {
        if(!hRem.isEmpty()) {
            return hOrig.isHeap() && (hRem.size() == hOrig.size() - 1) && hRem.remAccountedFor(hOrig);
        }
        return hOrig.isHeap() && (hRem.size() == hOrig.size()) && hRem.remAccountedFor(hOrig);
    }
}
