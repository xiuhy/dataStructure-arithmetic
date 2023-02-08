package dataStructure.graph;

import org.testng.annotations.Test;

public class DepthFirstSearchTest {

    @Test
    public void testDfs() {

        //准备Graph对象
        Graph G = new Graph(13);
        G.addEdge(0,5);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(0,6);

        G.addEdge(5,3);
        G.addEdge(5,4);

        G.addEdge(3,4);
        G.addEdge(4,6);

        G.addEdge(7,8);

        G.addEdge(9,11);
        G.addEdge(9,10);
        G.addEdge(9,12);
        G.addEdge(11,12);

        DepthFirstSearch depthFirstSearch=new DepthFirstSearch(G,0);
        depthFirstSearch.dfs(0);
    }

    @Test
    public void testStr(){
        boolean b = canConstruct("mtssgx","gsegxalmt");
        assert b==false;
    }

    static boolean canConstruct(String ransomNote,String magazine) {
        //PLAN-A loop
//        boolean result=true;
//        for (byte aByte : ransomNote.getBytes()) {
//
//            if(!result){
//                return false;
//            }
//            result=result&&magazine.indexOf(aByte)>-1;
//        }
//        return result;
        /**
         * m s g
         * d s m s s g l
         */

        //#regionB 字符排序然后整段匹配
//        byte[] bytes = ransomNote.getBytes();
//        byte[] bytes1 = magazine.getBytes();
//        List<Integer> indexs=new ArrayList<>();
//
//        for (byte aByte : bytes) {
//            boolean result=false;
//            for (int i=0;i<bytes1.length;i++) {
//                if(aByte!=bytes1[i]){
//                    continue;
//                }
//                if(aByte==bytes1[i]&&!indexs.contains(i)){
//                    result=true;
//                    indexs.add(i);
//                    break;
//                }
//            }
//            if(!result){
//                return false;
//            }
//        }
//        return true;
        //#endregion

        //#region C 标准答案#扩展版本不区分大小写
        int[] chars=new int[26];
        for (char c : magazine.toCharArray()) {
            chars[c-'a']++;
        }

        for (char c : ransomNote.toCharArray()) {

            chars[c-'a']--;

            if(chars[c-'a']<0){
                return false;
            }
        }
        return true;
        //#endregion

        //#region D 标准答案#扩展版本不区分大小写
//        char[] chars=new char[58];
//        for (char c : ransomNote.toCharArray()) {
//            chars[c-'A']++;
//        }
//
//        for (char c : magazine.toCharArray()) {
//
//            chars[c-'A']--;
//
//            if(chars[c-'A']<0){
//                return false;
//            }
//        }
//        return true;
        //#endregion
    }

    @Test
    public void testChar(){
        int[] nums=new int[]{0,0,1,1,1,2,2,3,3,4};
        int tmp=nums[0];
        int index=1;
        for(int i=1;i<nums.length;i++){
            if(tmp==nums[i]){
                continue;
            }else{
                //不同
                tmp=nums[i];
                nums[index]=nums[i];
                index++;
            }
        }

        System.out.println("index="+index);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}