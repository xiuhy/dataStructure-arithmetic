package dataStructure.linear.queue;

import org.testng.annotations.Test;

import java.util.concurrent.LinkedBlockingQueue;

public class SelfQueueTest {

    @Test
    public void testAdd() {

        SelfQueue<String> selfQueue=new SelfQueue<>();
        selfQueue.add("JAVA");
        selfQueue.add("MYSQL");
        selfQueue.add("PLSQL");
        selfQueue.add("GROOVY");

        System.out.println("-------------------");
        for (String s : selfQueue) {
            System.out.println(s);
        }

        System.out.println("-------------------");

        System.out.println("出："+selfQueue.remove());
        System.out.println("出："+selfQueue.remove());
        System.out.println("出："+selfQueue.remove());
        System.out.println("出："+selfQueue.remove());
    }

    @Test
    public void testOffer() {
        SelfQueue<String> selfQueue=new SelfQueue<>();
        selfQueue.offer("JAVA");
        selfQueue.offer("MYSQL");
        selfQueue.offer("PLSQL");
        selfQueue.offer("GROOVY");
        String value=selfQueue.remove();
        System.out.println("value:"+value);
        System.out.println("出："+selfQueue.remove());
        System.out.println("出："+selfQueue.remove());
        System.out.println("出："+selfQueue.remove());
    }

    @Test
    public void testRemove() {
    }

    @Test
    public void testPoll() {
        SelfQueue<String> selfQueue=new SelfQueue<>();
        selfQueue.offer("JAVA");
        selfQueue.offer("MYSQL");
        selfQueue.offer("PLSQL");
        selfQueue.offer("GROOVY");
        System.out.println("出："+selfQueue.poll());
        System.out.println("出："+selfQueue.poll());
        System.out.println("出："+selfQueue.poll());
        System.out.println("出："+selfQueue.poll());
    }

    @Test
    public void testPeek() {
        SelfQueue<String> selfQueue=new SelfQueue<>();
        selfQueue.offer("JAVA");
        selfQueue.offer("MYSQL");
        selfQueue.offer("PLSQL");
        selfQueue.offer("GROOVY");
        System.out.println("peek："+selfQueue.peek());
        System.out.println("peek2："+selfQueue.peek());
    }

    @Test
    public void testSize() {
        SelfQueue<String> selfQueue=new SelfQueue<>();
        selfQueue.offer("JAVA");
        selfQueue.offer("MYSQL");
        selfQueue.offer("PLSQL");
        selfQueue.offer("GROOVY");
        System.out.println(selfQueue.size());

        selfQueue.offer("GO");
        System.out.println(selfQueue.size());
        selfQueue.poll();
        System.out.println(selfQueue.size());
    }

    @Test
    public void testIsEmpty() {
    }

    @Test
    public void testIterator() {
    }


    @Test
    public void testBlockingQueue(){

        LinkedBlockingQueue<String> linkStack=new LinkedBlockingQueue<>();
        linkStack.add("java");
        linkStack.offer("groovy");
        linkStack.offer("python");

        System.out.println(linkStack.poll());
    }

}