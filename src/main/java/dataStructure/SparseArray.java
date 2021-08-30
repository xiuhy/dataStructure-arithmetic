package dataStructure;

import java.io.*;

/**
 * 稀疏数组
 * 在矩阵中，若数值为0的元素数目远远多于非0元素的数目，并且非0元素分布没有规律时，则称该矩阵为稀疏矩阵
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
        sourceArray[3][10]=200;
        sourceArray[8][2]=10;

        for(int[] tmp:sourceArray){
            for(int subTmp:tmp){
                System.out.printf("\t"+subTmp);
            }
            System.out.println();
        }

        //遍历source，检查多少有效数据
        int sum=0;
        for(int[] tmp:sourceArray){
            for(int subTmp:tmp){
               if(subTmp!=0){
                   sum++;
               }
            }
        }

        //根据有效数量创建新数组，第一行前三个分别是原始数据sourceArray，一维和二维的数组长度，第三个是有效总和
        int[][] sparseArray=new int[sum+1][sum+1];
        sparseArray[0][0]=11;
        sparseArray[0][1]=11;
        sparseArray[0][2]=sum;

        int k=1;
        for(int i=0;i<sourceArray.length;i++){
            for(int j=0;j<sourceArray.length;j++){
                if(sourceArray[i][j]!=0){
                    //存储有效数组地址坐标和真实值内容
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
