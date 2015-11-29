/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author arthur.hage
 */

@Entity
@Table(name = "tb_address", schema = "public")
public class AddressEntity implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 3586592741276519852L;

	@Id
    @Column(name = "id_address", nullable = false, unique = true)
    @SequenceGenerator(name = "id_address_sq", sequenceName = "sq_address_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_address_sq")
    private Integer id;
    
    @Column(name = "address_city", nullable = false)
    private String city;
    
    @Column(name = "address_state", nullable = false)
    private String state;
    
    @Column(name = "address_neighborhood", nullable = false)
    private String neighborhood;
    
    @Column(name = "address_street", nullable = false)
    private String street;
    
    @Column(name = "address_postalCode", nullable = false)
    private String postalCode;
    
    @Column(name = "address_primaryPhone", nullable = false)
    private String primaryPhone;
    
    @Column(name = "address_secondaryPhone")
    private String secondaryPhone;

//    @PrimaryKeyJoinColumn;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_ong")
    private OngEntity ong;

    public AddressEntity() {
    }

    public AddressEntity(String city, String state, String neighborhood, String street
            , String postalCode, String primaryPhone, String secondaryPhone) {
        this.city = city;
        this.state = state;
        this.neighborhood = neighborhood;
        this.street = street;
        this.postalCode = postalCode;
        this.primaryPhone = primaryPhone;
        this.secondaryPhone = secondaryPhone;
    }
    
     public AddressEntity(String city, String state, String neighborhood, String street
             , String postalCode, String primaryPhone, String secondaryPhone, OngEntity ong) {
        this.city = city;
        this.state = state;
        this.neighborhood = neighborhood;
        this.street = street;
        this.postalCode = postalCode;
        this.primaryPhone = primaryPhone;
        this.secondaryPhone = secondaryPhone;
        this.ong = ong;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }
    
     public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }
    
    public OngEntity getOng() {
        return ong;
    }

    public void setOng(OngEntity ong) {
        this.ong = ong;
    }
    
    @Override
    public String toString() {
        return "Cidade: " + this.city + " Estado: " + this.state + " Bairro: " + this.neighborhood
                + " Rua: " + this.street + " Cep: " + this.postalCode + " Telefone Primario: " + this.primaryPhone 
                + " Telefone Secundario: " + this.secondaryPhone ;
    }
    
}
