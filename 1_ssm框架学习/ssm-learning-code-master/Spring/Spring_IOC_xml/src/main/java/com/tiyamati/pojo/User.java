package com.tiyamati.pojo;

public class User {
    private Integer id;
    private String name;
    private String password;
    private Integer age;

    public User() {
        System.out.println("生命周期1：实例化");
    }

    public User(Integer id, String name, String password, Integer age) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("生命周期2：依赖注入");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
    public void init(){
        System.out.println("生命周期3：初始化");
    }
    public void destroy(){
        System.out.println("生命周期4：销毁");
    }
}
