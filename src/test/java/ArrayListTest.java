import org.chn.utils.Collections.ArrayList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ArrayListTest {

    @Test
    public void sizeTest() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        assertEquals(3,numbers.size());
    }

    @Test
    public void addTest() {

        ArrayList<Integer> numbers = new ArrayList<>();
        List<Integer> samples = Arrays.asList(1,2,3,4,5,6,6,5,4,3,3,2,1);
        samples.forEach(numbers::add);


        Object[] ar = numbers.toArray();
        for (int i = 0; i < ar.length; i++) {
            assertEquals(samples.get(i), ar[i]);
        }

    }

    @Test
    public void removeAtTest() {

        ArrayList<Integer> numbers = new ArrayList<>();
        List<Integer> samples = new java.util.ArrayList<>();
        Arrays.asList(1,2,3,4,5,6,6,5,4,3,3,2,1).forEach(samples::add);
        Arrays.asList(1,2,3,4,5,6,6,5,4,3,3,2,1).forEach(numbers::add);

        samples.remove(4);
        samples.remove(9);
        numbers.removeAt(4);
        numbers.removeAt(9);

        Object[] ar = numbers.toArray();
        for (int i = 0; i < ar.length; i++) {
            assertEquals(samples.get(i), ar[i]);
        }

        assertEquals(samples.size(), numbers.size());

    }

    @Test
    public void addAllTest() {
        ArrayList<Integer> numbers = new ArrayList<>();
        List<Integer> samples = new java.util.ArrayList<>();
        samples.addAll(Arrays.asList(1,2,3,4,5,6,6,5,4,3,3,2,1));
        numbers.addAll(Arrays.asList(1,2,3,4,5,6,6,5,4,3,3,2,1));

        assertEquals(samples.size(), numbers.size());

        Object[] ar = numbers.toArray();
        for (int i = 0; i < ar.length; i++) {
            assertEquals(samples.get(i), ar[i]);
        }
    }

    @Test
    public void removeTest() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(1,2,3,4,5,6,6,5,4,3,3,2,1));

        numbers.removeAllOccurances(3);
        assertEquals(10 , numbers.size());




    }

    @Test
    public void getTest() {
        ArrayList<Integer> numbers = new ArrayList<>();
        List<Integer> samples = Arrays.asList(1,2,3,4,5,6,6,5,4,3,3,2,1);
        numbers.addAll(samples);

        for (int i = 0; i < numbers.size(); i++) {
            assertEquals(samples.get(i) , numbers.get(i));
        }
    }

}
