package dataStructure.stack;

import org.testng.annotations.Test;

public class ArrayStackTest {

    @Test
    public void testPush() {

        ArrayStack<Integer> integerArrayStack = new ArrayStack<>();
        integerArrayStack.push(121);
        integerArrayStack.push(234);
        integerArrayStack.push(21);
        integerArrayStack.push(90);
        integerArrayStack.push(100);

        System.out.println(integerArrayStack.pop());
    }

    @Test
    public void testPop() {
    }

    @Test
    public void testGrow() {
    }

    @Test
    public void testIterator() {
    }

    @Test
    public void testBracket() {
       boolean result1= ArrayStack.isenableBracke("sfekdf[(]asdfd)");
       assert  !result1;

        boolean result2= ArrayStack.isenableBracke("woxianzheoakd sjfjf");
        assert  result2;

        boolean result3= ArrayStack.isenableBracke("woxianzhe9o0[akd]sjfjf");
        assert  result3;
    }
}