package ziji.serializable;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private int age;
	private Person spouse;

	private Gender gender;

	public Person() {
		System.out.println("non-paramter construtor");
	}

	public Person(String firstName, String lastName, int age, Gender gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}

	public Person(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		System.out
				.println("ziji.serializable.Person.writeObject(ObjectOutputStream)");
		age <<= 2;
		out.defaultWriteObject();
	}

	private void readObject(java.io.ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		System.out
				.println("ziji.serializable.Person.readObject(ObjectInputStream)");
		in.defaultReadObject();
		age >>= 2;
	}

	private Object writeReplace() {
		System.out.println("ziji.serializable.Person.writeReplace()");
//		return new Person();
		return "abc";
	}

	private Object readResolve() throws InvalidObjectException {
		System.out.println("ziji.serializable.Person.readResolve()");
		return new Person();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + "]";
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the spouse
	 */
	public Person getSpouse() {
		return spouse;
	}

	/**
	 * @param spouse
	 *            the spouse to set
	 */
	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

}

enum Gender {
	MALE, FEMALE
}