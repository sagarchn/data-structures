import org.chn.utils.Collections.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    private static final List<Integer> SAMPLES = Arrays.asList(1, 2, 4, 5, 6, 7, 8, 9, 0);

    @Test
    public void addTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        SAMPLES.forEach(linkedList::addFirst);
        linkedList.print();

        assertEquals(SAMPLES.size(), linkedList.size());
        assertEquals(SAMPLES.get(SAMPLES.size() - 1), linkedList.getFirst());
        assertEquals(SAMPLES.get(0), linkedList.getLast());

        linkedList.clear();
        linkedList.print();
        assertEquals(0, linkedList.size());

        SAMPLES.forEach(linkedList::addLast);
        linkedList.print();
        assertEquals(SAMPLES.size(), linkedList.size());
        assertEquals(SAMPLES.get(SAMPLES.size() - 1), linkedList.getLast());
        assertEquals(SAMPLES.get(0), linkedList.getFirst());

        for (Integer sample : SAMPLES
        ) {
            assertEquals(true, linkedList.contains(sample));
        }

        assertEquals(SAMPLES.get(0), linkedList.removeFirst());
        linkedList.print();
        assertEquals(SAMPLES.get(SAMPLES.size()-1), linkedList.removeLast());
        linkedList.print();

    }
}
