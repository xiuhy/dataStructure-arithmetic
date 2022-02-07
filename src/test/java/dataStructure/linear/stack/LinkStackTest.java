package dataStructure.linear.stack;

import org.testng.annotations.Test;

import java.util.Stack;

public class LinkStackTest {

    @Test
    public void testPush() {
      LinkStack<String> linkStack=new LinkStack<>();
      linkStack.push("java");
      linkStack.push("groovy");
      linkStack.push("python");

        for (String s : linkStack) {
            System.out.println(s);
        }

    }

    @Test
    public void testPop() {
        LinkStack<String> linkStack=new LinkStack<>();
        linkStack.push("java");
        linkStack.push("groovy");
        linkStack.push("python");

        System.out.println("pop:"+linkStack.pop());
        System.out.println("pop:"+linkStack.pop());
        System.out.println("pop:"+linkStack.pop());
    }

    @Test
    public void testStack(){

        Stack<String> strings=new Stack<>();
        strings.push("a");
        strings.push("b");
        strings.push("c");

        System.out.println(strings.toString());
        System.out.println("pop:"+strings.pop());

    }
}