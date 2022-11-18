package org.academy.object.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CLASSES")
public class Classes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CLASS_ID")
	private int class_id;
	
	@Column(name="FLOOR_LEVEL")
	private String floor_level;
	
	@Column(name="CAPACITY")
	private int capacity;
	
	@Column(name="ACCESSIBLE")
	private boolean accessible;
	
	@Column(name="CLASS_NAME")
	private String class_name;
	
	@Column(name="CLASS_SIZE")
	private int class_size;
	
	@ManyToMany(mappedBy="classes")/** Many subjects to Many classes **/
	private List<Subjects> subjects;
	
	@ManyToOne
	@JoinColumn(name="class_id",referencedColumnName ="CLASS_ID")
    private List<String> teachers;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="student_id",referencedColumnName="STUDENT_ID")
	private Students students;   /** One Class To One Student **/
	
	public Classes() {
		super();
	}

	public Classes(String floor_level, int capacity, boolean accessible, String class_name,int class_size, List<Subjects> subjects, List<String> teachers){
		super();
		this.floor_level = floor_level;
		this.capacity = capacity;
		this.accessible = accessible;
		this.class_name = class_name;
		this.class_size = class_size;
		this.subjects = subjects;
		this.teachers = teachers;
		
	}
	
	public Classes(String floor_level, int capacity, boolean accessible, String class_name,int class_size, List<Subjects> subjects, List<String> teachers, Students students){
		super();
		this.floor_level = floor_level;
		this.capacity = capacity;
		this.accessible = accessible;
		this.class_name = class_name;
		this.class_size = class_size;
		this.subjects = subjects;
		this.teachers = teachers;
		this.students = students;
	}
	public Classes(int class_id, String floor_level, int capacity, boolean accessible, String class_name,int class_size, List<Subjects> subjects, List<String> teachers, Students students){
		super();
		this.class_id = class_id;
		this.floor_level = floor_level;
		this.capacity = capacity;
		this.accessible = accessible;
		this.class_name = class_name;
		this.class_size = class_size;
		this.subjects = subjects;
		this.teachers = teachers;
		this.students = students;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getFloor_level() {
		return floor_level;
	}

	public void setFloor_level(String floor_level) {
		this.floor_level = floor_level;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isAccessible() {
		return accessible;
	}

	public void setAccessible(boolean accessible) {
		this.accessible = accessible;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public int getClass_size() {
		return class_size;
	}

	public void setClass_size(int class_size) {
		this.class_size = class_size;
	}

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}

	public List<String> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<String> teachers) {
		this.teachers = teachers;
	}

	public Students getStudents() {
		return students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Classes [class_id=" + class_id + ", floor_level=" + floor_level + ", capacity=" + capacity
				+ ", accessible=" + accessible + ", class_name=" + class_name + ", class_size=" + class_size
				+ ", subjects=" + subjects + ", teachers=" + teachers + ", students=" + students + "]";
	}
		
}