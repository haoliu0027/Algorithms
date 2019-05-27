package com.HL.HashCode;

public class Student {
	public int age;
	public int cla;
	public String firstName;
	public String lastName;
	
	public Student(int age, int cla, String firstName, String lastName) {
		this.age = age;
		this.cla = cla;
		this.firstName = firstName;
		this.lastName  = lastName;
	}
	
	@Override
	public int hashCode() {
		int B = 31;
		int hash = 0;
		hash = hash * B + age;
		hash = hash * B + cla;
		hash = hash * B + firstName.toLowerCase().hashCode();
		hash = hash * B + lastName.toLowerCase().hashCode();
		return hash;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		if(getClass() != o.getClass()) return false;
		Student another = (Student) o;
		return this.age == another.age &&
				this.cla == another.cla &&
				this.firstName.toLowerCase().equals(another.firstName.toLowerCase()) &&
				this.lastName.toLowerCase().equals(another.lastName.toLowerCase());
	}
}
