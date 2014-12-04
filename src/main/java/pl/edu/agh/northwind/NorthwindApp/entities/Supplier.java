package pl.edu.agh.northwind.NorthwindApp.entities;

// Generated 2014-10-13 21:10:57 by Hibernate Tools 4.0.0

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Suppliers generated by hbm2java
 */
@Entity
@Table(name = "suppliers")
public class Supplier implements java.io.Serializable {

	private Integer supplierId;
	private String companyName;
	private String contactName;
	private String contactTitle;
	private String address;
	private String city;
	private String region;
	private String postalCode;
	private String country;
	private String phone;
	private String fax;
	private String homePage;
	
	@OneToMany(mappedBy = "supplier")
	private List<Product> products = new ArrayList<>();

	public Supplier() {
	}

	public Supplier(String companyName, String contactName,
			String contactTitle, String address, String city, String region,
			String postalCode, String country, String phone, String fax,
			String homePage) {
		this.companyName = companyName;
		this.contactName = contactName;
		this.contactTitle = contactTitle;
		this.address = address;
		this.city = city;
		this.region = region;
		this.postalCode = postalCode;
		this.country = country;
		this.phone = phone;
		this.fax = fax;
		this.homePage = homePage;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SupplierID", unique = true, nullable = false)
	public Integer getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	@Column(name = "CompanyName", length = 40)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "ContactName", length = 30)
	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	@Column(name = "ContactTitle", length = 30)
	public String getContactTitle() {
		return this.contactTitle;
	}

	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}

	@Column(name = "Address", length = 60)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "City", length = 15)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "Region", length = 15)
	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name = "PostalCode", length = 10)
	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Column(name = "Country", length = 15)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "Phone", length = 24)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "Fax", length = 24)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "HomePage", length = 65535)
	public String getHomePage() {
		return this.homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

}