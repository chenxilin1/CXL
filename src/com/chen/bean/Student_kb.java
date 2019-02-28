package com.chen.bean;

public class Student_kb {
private int id;
private Student Student_id;
private KeBiao kebiao_id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Student getStudent_id() {
	return Student_id;
}
public void setStudent_id(Student student_id) {
	Student_id = student_id;
}
public KeBiao getKebiao_id() {
	return kebiao_id;
}
public void setKebiao_id(KeBiao kebiao_id) {
	this.kebiao_id = kebiao_id;
}
public Student_kb(int id, Student student_id, KeBiao kebiao_id) {
	super();
	this.id = id;
	Student_id = student_id;
	this.kebiao_id = kebiao_id;
}
public Student_kb() {
	super();
}

}