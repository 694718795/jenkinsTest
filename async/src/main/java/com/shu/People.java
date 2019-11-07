package com.shu;

public class People {
    private Long id;
    private String age;
    private String name;

    public People() {
    }

    public People(Long id, String age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", age='" + age + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
