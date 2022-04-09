package com.lz.entity;

public class Student {
    private Integer id;
    private String name;
    private Byte age;
    public Student(){
        System.out.println("无参构造方法被执行-----------");
    }
   public void init(){
       System.out.println("初始化方法被执行------------------");
   }
   public void destroy(){
       System.out.println("销毁方法被执行-----");
   }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Byte getAge() {
        return age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Byte age) {
        this.age = age;
    }
}
