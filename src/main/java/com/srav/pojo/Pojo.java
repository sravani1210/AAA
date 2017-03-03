package com.srav.pojo;

public class Pojo {
int age;
String name;
public Pojo(int age, String name) {
	super();
	this.age = age;
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
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
	return "Pojo [age=" + age + ", name=" + name + "]";
}
public Pojo() {
	// TODO Auto-generated constructor stub
}
}
