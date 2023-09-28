package com.cg.groceryApp.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="customer_table")
@SequenceGenerator(name="generator1",sequenceName="gen1",initialValue=1000)
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator1")
	@Column(name="customer_id")
	private long customerId;
	
	@Column(name="first_name" ,length=20)
	private String firstName;
	
	@Column(name="last_name" ,length=20)
	private String lastName;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="district",length=20)
	private String district;
	
	@Column(name="state",length=20)
	private String state;
	
	@Column(name="pin_code")
	private String pinCode;
	
	@Column(name="gender",length=30)
	public String gender;
	
	@Column(name="email_id",unique=true,length=30)
	public String customerEmailId;
	
	@Column(name="password",length=20)
	public String customerPassword;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", district=" + district + ", state=" + state + ", pinCode="
				+ pinCode + ", customerEmailId=" + customerEmailId + ", gender=" + gender + ", customerPassword="
				+ customerPassword + "]";
	}

	
	
}