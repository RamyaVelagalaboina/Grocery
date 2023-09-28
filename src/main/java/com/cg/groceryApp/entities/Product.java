package com.cg.groceryApp.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="product_table")
@SequenceGenerator(name="generator2",sequenceName="gen2",initialValue=5000)
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator2")
	@Column(name="product_id")
	private long productId;
	
	@Column(name = "productname", nullable = false, length = 20)
	private String productname;

	@Column(name="product_image")
	private String image;
	
		@Column(name = "description", nullable = false)
	private String description;	
	
	@Column(name = "mrp_price", nullable = false, precision = 10, scale = 2)
    private double mrpPrice;
	
	@Column(name = "quantity")
	private long quantity;
	
	private Category category;
	
	@Column(name = "measurement")
	private String measurement;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getMrpPrice() {
		return mrpPrice;
	}

	public void setMrpPrice(double mrpPrice) {
		this.mrpPrice = mrpPrice;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productname=" + productname + ", image=" + image
				+ ", description=" + description + ", mrpPrice=" + mrpPrice + ", quantity=" + quantity + ", category="
				+ category + ", measurement=" + measurement + "]";
	}
	
	

}