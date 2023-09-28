package com.cg.groceryApp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin_table")
public class Admin 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="admin_id")
	private long adminId;
	
	@Column(name="first_name",length=20)
	
	
	public String firstName;
	
	@Column(name="last_name",length=20)
	
	public String lastName;
	@Column(name="email_id",unique=true,length=30)
	
	
	public String adminEmailId;
	
	@Column(name="password",length=20)
	
	public String adminPassword;

	public long getAdminId() 
	{
		return adminId;
	}

	public void setAdminId(int adminId) 
	{
		this.adminId = adminId;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public String getAdminEmailId() 
	{
		return adminEmailId;
	}

	public void setAdminEmailId(String adminEmailId) 
	{
		this.adminEmailId = adminEmailId;
	}

	public String getAdminPassword() 
	{
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) 
	{
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() 
	{
		return "Admin [adminId=" + adminId + ", firstName=" + firstName + ", lastName=" + lastName + ", adminEmailId="
				+ adminEmailId + ", adminPassword=" + adminPassword + "]";
	}

}
