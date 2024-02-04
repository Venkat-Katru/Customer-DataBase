package sun.Module;

public class Customer {
	 private int id;
	 private String FirstName;
	 private String LastName;
	 private String Address;
	 private String City;
	 private String State;
	 private String Email;
	 private long Phone;



	 
	public Customer() {
		
	}

	public Customer( String firstName, String lastName, String address, String city, String state, String email,long phone) {
		super();
		this.FirstName = firstName;
		this.LastName = lastName;
		this.Address = address;
		this.City = city;
		this.State = state;
		this.Email = email;
		this.Phone = phone;
	}
	public void setId(int Id) {
		this.id=Id;
	}
	public int getId() {
		return id;
	}


	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		this.City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		this.State = state;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public long getPhone() {
		return Phone;
	}

	public void setPhone(long phone) {
		this.Phone = phone;
	}

	

	

}
