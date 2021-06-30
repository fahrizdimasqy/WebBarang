/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webbarang.controller;

import com.webbarang.entity.Barang;
import com.webbarang.entity.BarangFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Fahriz
 */
@ManagedBean
@SessionScoped
public class BarangController {

    /**
     * Creates a new instance of BarangController
     */
    
    @EJB
    private BarangFacade facade;
    private Barang barang;
    
    public List<Barang> getDaftarBarang() {
        return facade.findAll();
    }
    
    public Barang getBarang(){
        return barang;
    }
    
    public String prepareCreate(){
        barang = new Barang();
        return "/create";
    }
    
    public String create(){
        facade.create(barang);
        return "/index";
    }
    
    public String prepareedit(String id){
        barang = facade.find(id);
        return "/edit";
    }
     
    public String edit(){
        facade.edit(barang);
        return "/index"; 
    }
    
     public String delete(String kode){
        barang = facade.find(kode);
        facade.remove(barang);
        return "/index";
    }
    
    public BarangController() {
    }
    
}
