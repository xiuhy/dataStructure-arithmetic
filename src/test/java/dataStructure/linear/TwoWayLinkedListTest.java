package dataStructure.linear;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TwoWayLinkedListTest {

    TwoWayLinkedList<String> sequenceArray;
    @BeforeMethod
    public void before(){
        sequenceArray=new TwoWayLinkedList();
        this.sequenceArray.insert("java");
        this.sequenceArray.insert("groovy");
        this.sequenceArray.insert("javascript");
        this.sequenceArray.insert("mysql");
    }

    @Test
    public void testClear() {
        this.sequenceArray.clear();
       assert !"java".equals(this.sequenceArray.get(0));
    }

    @Test(dependsOnMethods = {"testGet"})
    public void testInsert() {

        this.sequenceArray.insert("vuejs");
        assert "vuejs".equals(this.sequenceArray.get(this.sequenceArray.cnt-1));

    }

    @Test
    public void testTestInsert() {
        this.sequenceArray.insert(2,"python");
        assert "python".equals(this.sequenceArray.get(2));
        assert this.sequenceArray.cnt==5;
        for (String s : this.sequenceArray) {
            System.out.println(s);
        }
    }

    @Test
    public void testRemove() {
       String result= this.sequenceArray.remove(2);
       assert "javascript".equals(result);
    }

    @Test
    public void testGet() {
        assert "java".equals(this.sequenceArray.get(0));
    }

    @Test(dependsOnMethods ={"testTestInsert"})
    public void testIterator() {
        this.sequenceArray.insert(3,"GO");
        for (String s : this.sequenceArray) {
            System.out.println(s);
        }
    }

    /**
     * 通过快慢指针判断是否存在循环
     * 并且循环切入点
     * @author bigmoon
     * @params []
     * @return boolean
     * @see [相关类/方法]（可选）
     * @since
     */
    @Test
    public void  isClecir(){
        Node<String> five=new Node<>("5",null);
        Node<String> four=new Node<>("4",five);
        Node<String> three=new Node<>("3",four);
        Node<String> two=new Node<>("2",three);
        Node<String> one=new Node<>("1",two);
        Node<String> six=new Node<>("6",null);
        five.setNext(six);
        six.setNext(three);

       boolean result= Node.isCircle(one);
        System.out.println(result);
        System.out.println("-------------------------");
        System.out.println(Node.circlePoint(one).item);
    }
}