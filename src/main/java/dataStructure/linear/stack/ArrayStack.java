package dataStructure.stack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;

import static java.util.Optional.ofNullable;

/**
 * 顺序数组存储方式实现栈
 * @author bigmoon
 * @date 2022/1/10
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class ArrayStack<T> implements Iterable {

    private Object[] elementData;
    private int elementLength=0;

    public ArrayStack(){
        elementData=new Object[5];
    }

   final static Map<String, String> map = Map.of("[", "]","(", ")","{", "}");
    final static  String regex = "[a-zA-Z\\+]";
    final static Pattern pattern = Pattern.compile(regex);

    public ArrayStack(int size){
        elementData=new Object[size];
    }


    public T push(T item){

        if(this.elementLength>=this.elementData.length){
            // grow
            this.elementData=grow();
        }else{
            this.elementData[this.elementLength]=item;
            ++this.elementLength;
        }

        return item;
    }

    public T pop(){

        if(this.elementLength<0){
            throw  new IndexOutOfBoundsException();
        }

        return (T)this.elementData[this.elementLength-1];
    }

    public Object[] grow(){
        return Arrays.copyOf(this.elementData,this.elementData.length*2);
    }


    @Override
    public Iterator iterator() {
        return null;
    }

    public final class selfIterator<T> implements Iterator{
        Object[] list;
        int currentIndex=0;

        public selfIterator(){
            this.list=elementData;
            this.currentIndex=this.list.length;
        }

        @Override
        public boolean hasNext() {

            if(this.currentIndex>=this.list.length){
                return false;
            }else{
                return true;
            }
        }

        @Override
        public Object next() {
            return this.list[--this.currentIndex];
        }
    }

    /**
     * 判断输入字符内容的括号是否正确匹配
     * @author bigmoon
     * @params []
     * @return boolean
     * @see [相关类/方法]（可选）
     * @since
     */
    public static boolean isenableBracke(String content){
        //校验括号对称有效性，避免括号不对称。通过stack特性，验证括号有效性
        String[] chars = content.split("");
        Stack<String> strings = new Stack<>();

        for (String aChar : chars) {

            if (map.containsKey(aChar)) {
                strings.push(aChar);
            }

            //非括弧字符直接跳过
            if (pattern.matcher(aChar).matches()) {
                continue;
            }

            if (map.containsValue(aChar)) {
                //匹配栈中内容，先peek(拿出来看下，不擅长)，如果真符合再删除
                String value = strings.peek();
                if (map.get(value).equals(aChar)) {
                    System.out.println("当前括号匹配：" + value + ":" + aChar);
                    strings.pop();
                }
            }
        }

        if(strings.empty()){
            System.out.println("当前字符括号匹配有效");
            return true;
        }else{
            System.out.println("当前字符匹配无效");
            return false;
        }
    }

    /**
     * 逆波兰表达式
     * @author bigmoon
     * @params [content]
     * @return java.lang.Object
     * @see [相关类/方法]（可选）
     * @since
     */
    public static Object reversePolish(String[] content){
        //逆波兰表达式解析，
        // 1. 通过识别操作符向栈中获取前两个操作符，然后操作；
        // 2. 在操作完成之后将结果集push到队列

        Stack<String> stack=new Stack<>();
        Integer result=0;

        ofNullable(content).ifPresent(list->{
            String operator1;
            String operator2;
            for (String s : list) {

                Integer tmpResult=null;
                switch (s){
                    case "+":
                        operator2= stack.pop();
                        operator1= stack.pop();
                        tmpResult=Integer.valueOf(operator1)+Integer.valueOf(operator2);
                        break;
                    case "-":
                        operator2= stack.pop();
                        operator1= stack.pop();
                        tmpResult=Integer.valueOf(operator1)-Integer.valueOf(operator2);
                        break;
                    case "*":
                        operator2= stack.pop();
                        operator1= stack.pop();
                        tmpResult=Integer.valueOf(operator1)*Integer.valueOf(operator2);
                        break;
                    case "/":
                        operator2= stack.pop();
                        operator1= stack.pop();
                        tmpResult=Integer.valueOf(operator1)/Integer.valueOf(operator2);
                        break;
                    default:stack.push(s);
                }

                if(null!=tmpResult){
                    stack.push(tmpResult.toString());
                }
            }
        });
        if(!stack.isEmpty()){
            result=Integer.valueOf(stack.pop());
        }
        return result;
    }
}
