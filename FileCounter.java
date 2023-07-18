import java.io.File;
import java.util.Scanner;

class FileCounter{

    private static int countFiles(File dir){
        int fileCount=0;

        File fileArr[] = dir.listFiles();
        for(int i=0;i<fileArr.length;i++){

            if(fileArr[i].isFile()){
                fileCount++;
            }
            if(fileArr[i].isDirectory()){
                fileCount+=countFiles(fileArr[i]);
            }
        }

        return fileCount;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the directory path for which you want to count the files.\n");

        String str=sc.nextLine();

        File file=new File(str);

        if(!file.exists()){
            System.err.println("The system can't find the file or directory through given path.");
            return;
        }


        int totalFiles = countFiles(file);
        System.out.println(totalFiles);
    }
}