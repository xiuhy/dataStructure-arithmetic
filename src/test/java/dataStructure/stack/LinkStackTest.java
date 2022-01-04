package dataStructure.stack;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

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
}