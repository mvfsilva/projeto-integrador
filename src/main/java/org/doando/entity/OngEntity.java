package org.doando.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author arthur
 */
@Entity
@NamedQueries(value = {
	    @NamedQuery(name = "findByEmailPass",
	            query = "SELECT c FROM OngEntity c WHERE c.email = :email AND c.password = :password")})
@Table(name = "tb_ong", schema = "public")
public class OngEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8348124056614554485L;

	public static final String FIND_BY_EMAIL_PASS = "findByEmailPass";

	public static final String LOGGED_IN_USER = "loggedInUser";
	
	@Id
	@Column(name = "id_ong", nullable = false, unique = true)
	@SequenceGenerator(name = "id_ong_sq", sequenceName = "sq_ong_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_ong_sq")
	private Integer id;

	// CNPJ – Brazilian Registration of Corporate Taxpayers
	@Column(name = "ong_cnpj", nullable = false, unique = true)
	private String cnpj;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "ong")
	@Cascade(CascadeType.ALL)
	private AddressEntity address;

	@Column(name = "ong_name", nullable = false)
	private String name;

	@Column(name = "ong_email", nullable = false)
	private String email;

	@Column(name = "ong_password")
        private String password;
	
	@Column(name = "ong_website")
	private String website;

	@Column(name = "ong_type")
        private String type;

	public OngEntity() {
		this.type = "";
		this.cnpj = "";
		this.name = "";
		this.email = "";
		this.website = "";
		this.password = "";
	}
	
	public OngEntity(String cnpj, AddressEntity address, String name, String email, String password, String website, String type) {
		this.cnpj = cnpj;
		this.address = address;
		this.name = name;
		this.email = email;
		this.password = password;
		this.website = website;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
        
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
