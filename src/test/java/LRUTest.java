import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LRUTest {


    @Test
    public void testWithSize1() {
        LRUCache cache = new LRUCache(1);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.print();
        assertEquals(-1, cache.get(1));
        cache.put(3, 3);
        cache.print();
        assertEquals(-1, cache.get(2));
        cache.put(4, 4);
        cache.print();
        assertEquals(-1, cache.get(1));
        assertEquals(-1, cache.get(3));
        cache.print();
        assertEquals(4, cache.get(4));
        cache.print();
    }

    @Test
    public void testWithSize2() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.print();
        assertEquals(1, cache.get(1));
        cache.put(3, 3);
        cache.print();
        assertEquals(-1, cache.get(2));
        cache.put(4, 4);
        cache.print();
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        cache.print();
        assertEquals(4, cache.get(4));
        cache.print();


    }


    @Test
    public void testWithSize3() {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.print();
        assertEquals(1, cache.get(1));
        cache.put(3, 3);
        cache.print();
        assertEquals(2, cache.get(2));
        cache.put(4, 4);
        cache.print();
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        cache.print();
        assertEquals(4, cache.get(4));
        cache.print();


    }

    @Test
    public void additionalTests() {
        LRUCache cache = new LRUCache(2);
        assertEquals(-1, cache.get(2));
        cache.put(2, 6);
        cache.print();
        assertEquals(-1, cache.get(1));
        cache.put(1, 5);
        cache.print();
        cache.put(1, 2);
        cache.print();
        assertEquals(2, cache.get(1));
        cache.print();
        assertEquals(6, cache.get(2));
        cache.print();
    }
}
