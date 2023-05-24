package Nio.File;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author luoqixi77
 * @version 1.0
 * @date 2023/3/22 11:30
 * @Description Path类
 */
public class test_2 {
    public static void main(String[] args) {
        Path path = Paths.get("src/main/java/Nio/File/he.txt");
        Path path1 = Paths.get("src/main/java/Nio/File/h.txt");
        //路径
        System.out.println(path);
        //正常化路径
        System.out.println(path.normalize());
        //文件是否存在
        System.out.println(path.toFile().exists());
        //创建一级目录
        try {
            Files.createDirectory(path1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //拷贝文件，从path拷贝到path1,如果希望覆盖掉，可以在后面添加StandardCopyOption.REPLACE_EXISTING
        try {
            Files.copy(path,path1, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //删除文件，也可以最直接删除目录（目录中不能中不能出现文件，如果存在会报错）
        try {
            Files.delete(path1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //遍历目录文件
    public static void traverse(){
        Path path = Paths.get("C:\\Program Files\\Java\\jdk1.8.0_91");
        AtomicInteger dirCount = new AtomicInteger();
        AtomicInteger fileCount = new AtomicInteger();
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                        throws IOException {
                    System.out.println(dir);
                    dirCount.incrementAndGet();
                    return super.preVisitDirectory(dir, attrs);
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                        throws IOException {
                    System.out.println(file);
                    fileCount.incrementAndGet();
                    return super.visitFile(file, attrs);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 133
        System.out.println(dirCount);
        // 1479
        System.out.println(fileCount);
    }
}
