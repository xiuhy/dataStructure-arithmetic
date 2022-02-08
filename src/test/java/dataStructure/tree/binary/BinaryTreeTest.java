package dataStructure.tree.binary;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BinaryTreeTest {

    BinaryTree<SefNumber,String> tree=new BinaryTree<SefNumber, String>();

    @BeforeMethod
    public void beforeClass(){

        tree.put(new SefNumber(15),"15");
        tree.put(new SefNumber(20),"20");
        tree.put(new SefNumber(8),"8");
        tree.put(new SefNumber(25),"25");
        tree.put(new SefNumber(4),"4");
        tree.put(new SefNumber(16),"16");
        tree.put(new SefNumber(9),"9");
        tree.put(new SefNumber(2),"2");
        tree.put(new SefNumber(10),"10");
        tree.put(new SefNumber(26),"26");
        tree.put(new SefNumber(23),"23");
        tree.put(new SefNumber(21),"21");
    }

    @Test
    public void testPut() {

    }

    @Test
    public void testGet() {
       String node= tree.get(new SefNumber(4));
        System.out.println(node);
    }

    @Test
    public void testDel() {
        tree.del(new SefNumber(20));
        System.out.println(tree);
    }

    @Test
    public void testMin(){
        String value=tree.min();
        System.out.println(value);
        assert "2".equals(value);
    }

    @Test
    public void testMax(){
        String value=tree.max();
        System.out.println(value);
        assert "26".equals(value);
    }


    class SefNumber implements Comparable<SefNumber>{

       public Integer value;

        public SefNumber(Integer value){
           this.value=value;
        }

        @Override
        public int compareTo(SefNumber o) {
            return this.value-o.value;
        }
    }
}