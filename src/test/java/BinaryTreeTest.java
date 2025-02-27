import lombok.AllArgsConstructor;
import org.chn.utils.Collections.BinaryTree;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;


public class BinaryTreeTest {

    @Test
    public void addTest() {
        BinaryTree<Integer> bt = new BinaryTree<Integer>(Comparator.reverseOrder());

        bt.add(5);
        bt.add(2);
        bt.add(6);
        bt.add(3);

        bt.print();


        Student s1 = new Student(1, "Sagar", new Date());
        Student s2 = new Student(2, "Savita", new Date());
        Student s3 = new Student(3, "Daksh", null);

        HashMap<Student, Double> map = new HashMap<>();
        map.put(s1, 0.1);
        map.put(s2, 0.3);


        System.out.println(map.get(s1));


        BinaryTree<Student> bst = new BinaryTree<Student>(Comparator.comparingInt(o -> o.id));

        bst.add(s2);
        bst.add(s3);
        bst.add(s1);

        bst.print();




    }


    @Test
    public void removeTest() {


        BinaryTree<Integer> bt = new BinaryTree<Integer>(Comparator.naturalOrder());

        bt.add(5);
        bt.add(3);
        bt.add(8);
        bt.add(10);
        bt.add(7);
        bt.add(9);
        bt.add(4);

        bt.print();
        bt.remove(5);
        bt.print();

    }



    @AllArgsConstructor
    public static class Student {
        int id;
        String name;
        Date dob;

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    '}';
        }
    }


}
