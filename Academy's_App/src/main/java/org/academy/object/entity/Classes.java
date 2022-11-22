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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CLASSES")
public class Classes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="class_id")
	private int class_id;
	
	@Column(name="FLOOR_LEVEL")
	private String floor_level;
	
	@Column(name="CAPACITY")
	private String capacity;
	
	@Column(name="ACCESS") /*Accessible keyword in DB*/
	private String accessible;
	
	@Column(name="CLASS_NAME")
	private String class_name;
	
	@Column(name="CLASS_SIZE")
	private String class_size;
	
	@ManyToMany(mappedBy="classes")/** Many classes to Many subjects **/
	private List<Subjects> subjects;
	
	@OneToMany()
	@JoinColumn(name="class_id",referencedColumnName ="class_id")
    private List<Teachers> teachers; /* One Class To Many Teachers */
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="class_id",referencedColumnName="class_id") /* student_id to class_id*/ /*cascade=CascadeType.ALL*/
	private Students students;   /** One Class To One Student **/  
	
	public Classes() {
		super();
	}

	public Classes(String floor_level, String capacity, String accessible, String class_name,String class_size) {
		super();
		
		this.floor_level = floor_level;
		this.capacity = capacity;
		this.accessible = accessible;
		this.class_name = class_name;
		this.class_size = class_size;
		
	}

	public Classes(String floor_level, String capacity, String accessible, String class_name,String class_size, List<Subjects> subjects, List<Teachers> teachers, Students students) {
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
		
	public Classes(int class_id, String floor_level, String capacity, String accessible, String class_name,String class_size, List<Subjects> subjects, List<Teachers> teachers, Students students) {
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

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getAccessible() {
		return accessible;
	}

	public void setAccessible(String accessible) {
		this.accessible = accessible;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getClass_size() {
		return class_size;
	}

	public void setClass_size(String class_size) {
		this.class_size = class_size;
	}

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}

	public List<Teachers> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teachers> teachers) {
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