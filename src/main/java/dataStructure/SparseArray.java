package dataStructure;

import java.io.*;

/**
 * 稀疏数组
 * @author yhx
 * @date 2020/9/24
 * @return
 * @see [相关类/方法]（可选）
 * @since 200826
 */
public class SparseArray {

    public static void main(String[] args)throws Exception {

        //1.原始11*11数组；
        //2.压缩
        int[][] sourceArray=new int[11][11];
        sourceArray[0][3]=1;
        sourceArray[1][4]=2;

        for(int[] tmp:sourceArray){
            for(int subTmp:tmp){
                System.out.printf("\t"+subTmp);
            }
            System.out.println();
        }

        //便利source，检查多少有效数据
        int sum=0;
        for(int[] tmp:sourceArray){
            for(int subTmp:tmp){
               if(subTmp!=0){
                   sum++;
               }
            }
        }
        int[][] sparseArray=new int[sum+1][sum+1];
        sparseArray[0][0]=11;
        sparseArray[0][1]=11;
        sparseArray[0][2]=sum;

        int k=1;
        for(int i=0;i<sourceArray.length;i++){
            for(int j=0;j<sourceArray.length;j++){
                if(sourceArray[i][j]!=0){
                   sparseArray[k][0]=i;
                   sparseArray[k][1]=j;
                   sparseArray[k][2]=sourceArray[i][j];
                    k++;
                }
            }
        }

        System.out.println("稀疏数组效果.......................");

        for(int[] tmp:sparseArray){
            for(int subTmp:tmp){
                System.out.printf("\t"+subTmp);
            }
            System.out.println();
        }

        writeSparseFile(sparseArray);

        readSparseFile();

    }

    public static void readSparseFile()throws Exception{

        try( ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream("./sparseArray.txt"))) {
            int[][] sparseArray=(int[][])inputStream.readObject();

            System.out.println("读取文件数据");
            for(int[] tmp:sparseArray){
                for(int subTmp:tmp){
                    System.out.printf("\t"+subTmp);
                }
                System.out.println();
            }
        }
    }

    public static void writeSparseFile(int[][] sparseArray)throws Exception{

        System.out.println("存储文件数据");
        File file=new File("./sparseArray.txt");
        file.createNewFile();
        try( ObjectOutputStream dataOutputStream=new ObjectOutputStream(new FileOutputStream(file))){
            dataOutputStream.writeObject(sparseArray);
        }
    }

    public static void writeSparseFileByte(int[][] sparseArray)throws Exception{

        System.out.println("存储文件数据");
        File file=new File("./sparseArray.txt");
        file.createNewFile();

        BufferedOutputStream dataOutputStream=new BufferedOutputStream(new FileOutputStream(file));

        byte[] buffer=new byte[1024];
        int offset=0;
        Object ob=sparseArray;
        //数组如何套入到代码文
//        dataOutputStream.write();
       dataOutputStream.close();
    }
}
