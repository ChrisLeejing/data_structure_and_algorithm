package com.jikeshijian.chris.sort1;

/**
 * This is description.
 *
 * @author Chris Lee
 * @date 2020/7/5 19:05
 */
public class Student implements Comparable<Student> {

    private String username;
    private Integer age;

    public Student(String username, int age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return this.getAge() - o.getAge();
    }
}
