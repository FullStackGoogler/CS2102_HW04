import org.junit.Test;
import static org.junit.Assert.*;

public class Examples {
    HeapChecker checker = new HeapChecker();

    //Empty Heap
    IHeap mtyHeap = new MtHeap();

    //Single Heaps
    IHeap sglHeap1 = new DataHeap(2, mtyHeap, mtyHeap);
    IHeap sglHeap2 = new DataHeap(3, mtyHeap, mtyHeap);
    IHeap sglHeap3 = new DataHeap(5, mtyHeap, mtyHeap);
    IHeap sglHeap4 = new DataHeap(7, mtyHeap, mtyHeap);
    IHeap sglHeap5 = new DataHeap(8, mtyHeap, mtyHeap);
    IHeap sglHeap6 = new DataHeap(10, mtyHeap, mtyHeap);
    IHeap sglHeap7 = new DataHeap(13, mtyHeap, mtyHeap);
    IHeap sglHeap8 = new DataHeap(16, mtyHeap, mtyHeap);
    IHeap sglHeap9 = new DataHeap(19, mtyHeap, mtyHeap);

    //Valid Heaps
    IHeap heap1 = new DataHeap(1, sglHeap1, sglHeap2);
    IHeap heap2 = new DataHeap(3, sglHeap3, sglHeap4);
    IHeap heap3 = new DataHeap(1, sglHeap1, sglHeap5);
    IHeap heap4 = new DataHeap(6, sglHeap6, sglHeap8);
    IHeap heap5 = new DataHeap(4, sglHeap4, sglHeap5);
    IHeap heap6 = new DataHeap(9, sglHeap7, sglHeap9);

    //Valid Heaps with subtrees
    IHeap supHeap1 = new DataHeap(1, heap2, heap4);
    IHeap supHeap2 = new DataHeap(3, heap5, heap6);
    IHeap supHeap3 = new DataHeap(5, heap4, heap6);

    //Heaps with duplicate elements
    IHeap dupHeap1 = new DataHeap(1, heap1, heap2);
    IHeap dupHeap2 = new DataHeap(1, heap3, heap2);

    //Broken Heaps
    IHeap badSupHeap1 = new DataHeap(5, heap1, heap3);
    IHeap badSupHeap2 = new DataHeap(3, heap3, heap5);
    IHeap badHeap1 = new DataHeap(9, sglHeap4, sglHeap9);
    IHeap badHeap2 = new DataHeap(6, sglHeap9, sglHeap1);

    @Test
    public void checkAddEltTester() {
        assertTrue(checker.addEltTester(supHeap1, 7, supHeap1.addElt(7)));
        assertTrue(checker.addEltTester(supHeap2, 2, supHeap2.addElt(2)));
        assertTrue(checker.addEltTester(supHeap3, 104123123, supHeap3.addElt(104123123)));
        assertTrue(checker.addEltTester(heap1, 1, heap1.addElt(1)));
        assertTrue(checker.addEltTester(heap1, -1, heap1.addElt(-1)));
        assertTrue(checker.addEltTester(heap3, 7, heap3.addElt(7)));
        assertTrue(checker.addEltTester(heap6, 9, heap6.addElt(9)));
        assertTrue(checker.addEltTester(sglHeap1, 1, sglHeap1.addElt(1)));
        assertTrue(checker.addEltTester(sglHeap1, 2, sglHeap1.addElt(2)));
        assertTrue(checker.addEltTester(sglHeap7, 7, sglHeap7.addElt(7)));
        assertTrue(checker.addEltTester(sglHeap7, 256, sglHeap7.addElt(256)));
        assertTrue(checker.addEltTester(dupHeap1, 1, dupHeap1.addElt(1)));
        assertTrue(checker.addEltTester(dupHeap1, 2, dupHeap1.addElt(2)));
        assertTrue(checker.addEltTester(dupHeap1, -1, dupHeap1.addElt(-1)));
        assertTrue(checker.addEltTester(dupHeap2, 2, dupHeap2.addElt(2)));

        assertFalse(checker.addEltTester(supHeap1, 2, supHeap1.addElt(7)));
        assertFalse(checker.addEltTester(supHeap3, 12401924, supHeap3.addElt(2340682)));
        assertFalse(checker.addEltTester(dupHeap1, -1, dupHeap1.addElt(1)));
        assertFalse(checker.addEltTester(dupHeap2, -5, dupHeap2.addElt(5)));
        assertFalse(checker.addEltTester(heap1, 1321232, heap1.addElt(-5)));
        assertFalse(checker.addEltTester(sglHeap1, 195, sglHeap1.addElt(-6235)));
        assertFalse(checker.addEltTester(badSupHeap1, 9, badSupHeap1.addElt(9)));
        assertFalse(checker.addEltTester(badSupHeap1, 7, badSupHeap1.addElt(11)));
        assertFalse(checker.addEltTester(badSupHeap2, 11, badSupHeap2.addElt(11)));
        assertFalse(checker.addEltTester(badHeap1, 14, badHeap1.addElt(14)));
        assertFalse(checker.addEltTester(badHeap2, 7, badHeap2.addElt(7)));
        assertFalse(checker.addEltTester(badHeap2, 9, badHeap2.addElt(7)));
    }

    @Test
    public void checkIsHeap() {
        assertTrue(sglHeap1.isHeap());
        assertTrue(heap1.isHeap());
        assertTrue(supHeap1.isHeap());
        assertTrue(dupHeap1.isHeap());

        assertFalse(badSupHeap1.isHeap());
        assertFalse(badSupHeap2.isHeap());
        assertFalse(badHeap1.isHeap());
        assertFalse(badHeap2.isHeap());
    }

    @Test
    public void checkRemMinEltTester() {
        assertTrue(checker.remMinEltTester(supHeap1, supHeap1.remMinElt()));
        assertTrue(checker.remMinEltTester(heap1, heap1.remMinElt()));
        assertTrue(checker.remMinEltTester(heap6, heap6.remMinElt()));
        assertTrue(checker.remMinEltTester(dupHeap1, dupHeap1.remMinElt()));

        assertFalse(checker.remMinEltTester(badSupHeap1, badSupHeap1.remMinElt()));
        assertFalse(checker.remMinEltTester(badHeap2, badHeap2.remMinElt()));
    }
}