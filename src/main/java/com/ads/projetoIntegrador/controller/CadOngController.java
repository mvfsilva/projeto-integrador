/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.controller;

import com.ads.projetoIntegrador.appService.OngApplicationService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ads.projetoIntegrador.entity.AddressEntity;
import com.ads.projetoIntegrador.entity.EventsEntity;
import com.ads.projetoIntegrador.entity.NecessityEntity;
import com.ads.projetoIntegrador.entity.OngEntity;
import com.ads.projetoIntegrador.repository.OngRepository;
import com.ads.projetoIntegrador.utils.HibernateUtils;
import java.sql.SQLException;
import java.util.HashSet;
import org.hibernate.Session;

/**
 *
 * @author arthur
 */
@ManagedBean(name = "cadOngController")
@SessionScoped
public class CadOngController {
    
    //private AddressApplicationService addressAppService = new AddressApplicationService();
    //private OngRepository ongRepository = new OngRepository();
    private OngApplicationService ongAppService;
    private AddressEntity address;
    private OngEntity ong;
    private Session session;
    //private List<OngEntity> ongs;

    public CadOngController() {
        this.ongAppService = new OngApplicationService();
        this.address = new AddressEntity();
        this.ong = new OngEntity();
    }
    
    
    public OngEntity getOng() {
        return ong;
    }

    public AddressEntity getAddress() {
        return address;
    }
    
    public void save () throws SQLException,  ClassNotFoundException{
        address.setOng(ong);
        ong.setAddress(address);
        ong.setNecessities(new HashSet<NecessityEntity>());
        ong.setEvents(new HashSet<EventsEntity>());
      
    }
    
}
