package com.Stream.StreamTest;

import com.Stream.entity.Author;
import com.Stream.entity.Books;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
/*        List<Author> authors = getAuthors();
        authors.stream()
                //去重
                .distinct()
                //过滤
                .filter(author -> author.getAge() < 18)
                //输出
                .forEach(author -> System.out.println(author.getName()));*/

/*        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        */
        test9();

    }

    private static void test9() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //开启多线程
        stream.parallel()
                //打印输出线程和线程操作的数字
                .peek(integer -> System.out.println(integer+Thread.currentThread().getName()))
                .filter(num->num>5)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }

    private static void test8() {
        //使用reduce求所有作者中的年龄的最大值
        List<Author> authors = getAuthors();
        Integer reduce = authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(Integer.MIN_VALUE, (result, integer) -> result > integer ? result : integer);
        System.out.println(reduce);
    }

    private static void test7() {
        //使用reduce求所有作者年龄和
        List<Author> authors = getAuthors();
        Integer reduce = authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(Integer.MIN_VALUE, (integer, integer2) -> integer + integer2);
        System.out.println(reduce);
    }

    private static void test6() {
        //使用reduce计算所有作者年龄的和
        List<Author> authors = getAuthors();
        Integer reduce = authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(0, (integer, integer2) -> integer + integer2);
        System.out.println(reduce);

    }

    private static void test5() {
        //获取一个map集合，key为作者，value为书名
        List<Author> authors = getAuthors();
        Map<String, List<Books>> map = authors.stream()
                .distinct()
                .collect(Collectors.toMap(author -> author.getName(), author -> author.getBooks()));
        System.out.println(map);
    }

    private static void test4() {
        List<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();
        //打印数据的所有分类，要求对分类进行去重，不能出现这种格式：哲学，爱情
        stream.flatMap(author -> author.getBooks().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(category -> System.out.println(category));

    }

    private static void test3() {
        //排序
        List<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();
        stream.distinct()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .forEach(author -> System.out.println(author.getAge()));
    }

    private static void test1() {
        //数组转化Stream流，使用Arrays的工具类或者使用Stream的of方法
        Integer[] arr = {1, 2, 3, 4, 5};
        /* Stream<Integer> stream = Arrays.stream(arr);*/
        Stream<Integer> stream = Stream.of(arr);
        stream.distinct().forEach(integer -> System.out.println(integer));
    }

    //双列集合
    private static void test2() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("绫小路清隆", 18);
        map.put("一之濑帆波", 19);
        map.put("轻井泽惠", 17);

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Stream<Map.Entry<String, Integer>> stream = entrySet.stream();
        stream.filter((entry) -> entry.getValue() > 17)
                .forEach(entry -> System.out.println(entry));
    }


    private static List<Author> getAuthors() {
        //数据初始化
        Author author = new Author(1L, "蒙多", 33, "一个从才到中明悟哲理的祖安人", null);
        Author author2 = new Author(2L, "亚索", 15, "死亡如风，常伴吾身", null);
        Author author3 = new Author(3L, "洛天依", 18, "洛水河畔，与你相依", null);
        Author author4 = new Author(3L, "洛天依", 18, "洛水河畔，与你相依", null);
        //书籍列表
        List<Books> book1 = new ArrayList<>();
        List<Books> book2 = new ArrayList<>();
        List<Books> book3 = new ArrayList<>();

        book1.add(new Books(1L, "刀的两侧是光明和黑暗", "哲学,爱情", 88, "用一把刀划清了爱恨"));
        book1.add(new Books(2L, "一个人不能死在同一把刀下", "个人成长,爱情", 99, "如何在失败中明悟真理"));

        book2.add(new Books(3L, "那风吹不到的地方", "哲学,爱情", 85, "带你用思维去领悟世界的尽头"));
        book2.add(new Books(3L, "那风吹不到的地方", "哲学,爱情", 85, "带你用思维去领悟世界的尽头"));
        book2.add(new Books(4L, "吹或不吹", "个人传记", 56, "一个哲学家的恋爱观注定很难把他所在的时代理解"));


        book3.add(new Books(5L, "你的剑就是我的剑", "爱情", 56, "无法想象一个武者能对他的伴侣那么宽容"));
        book3.add(new Books(6L, "风雨剑", "个人传记", 100, "两个哲学家灵魂与肉体的碰撞会激起怎样的火花"));
        book3.add(new Books(6L, "风雨剑", "个人传记", 100, "两个哲学家灵魂与肉体的碰撞会激起怎样的火花"));

        author.setBooks(book1);
        author2.setBooks(book2);
        author3.setBooks(book3);
        author4.setBooks(book3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author, author2, author3, author4));
        return authorList;
    }
}
