package blockchain_car;

public class Employee {
	private String id, firstName, lastName, gender, email, phoneNumber, position;

	public Employee(String id, String firstName, String lastName, String gender, String email, String phoneNumber,
			String position) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.position = position;
	}

	
	
	
	public String getId() {
		
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPhoneNumber() {
		return phoneNumber;
	}




	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}




	public String getPosition() {
		return position;
	}




	public void setPosition(String position) {
		this.position = position;
	}




	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", position=" + position + "]";
	}

	
	
	
}
