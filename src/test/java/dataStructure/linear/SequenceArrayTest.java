package dataStructure.linear;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SequenceArrayTest  {

    LinkedList<String> sequenceArray;
    @BeforeMethod
    public void before(){
        sequenceArray=new LinkedList();
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

    @Test
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

    @Test
    public void testIterator() {
        this.sequenceArray.insert(3,"GO");
        for (String s : this.sequenceArray) {
            System.out.println(s);
        }
    }
}