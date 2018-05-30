/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacob.contactSpring.web;

import com.jacob.contactSpring.dao.ContactRepository;
import com.jacob.contactSpring.entity.Contact;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author STEINER
 */
@RestController
@CrossOrigin("*")
public class ContactRestService {
    @Autowired
    private ContactRepository contactRepository;
    
    //lISTE DE TOUS LES CONTACTS
    @RequestMapping(value="/contacts", method=RequestMethod.GET)
    public List<Contact> getContact(){
        System.out.println("test");
        return contactRepository.findAll();
    }
    // AFFICHE UN CONTACT EN FONCTION DE SON ID
    @RequestMapping(value="/contacts/{id}", method=RequestMethod.GET)
    public Optional<Contact> getContact(@PathVariable Long id){
        return contactRepository.findById(id);
    }
    // ENREGISTREMENT D'UN CONTACT DANS LA BASE DE DONNEES
    @RequestMapping(value="/contacts", method=RequestMethod.POST)
    public Contact save(@RequestBody Contact c){
        return contactRepository.save(c);
    }
    // MODIFICATION D'UN CONTACT
    @RequestMapping(value="/contacts/{id}", method=RequestMethod.PUT)
    public Contact update(@PathVariable Long id, @RequestBody Contact c){
        c.setId(id);
        return contactRepository.save(c);
    }
    
    //SUPPRESSION D'UN CONTACT
    @RequestMapping(value="/deleteContact/{id}",method=RequestMethod.DELETE)
    public void deleteContact(@PathVariable Long id){        
        contactRepository.deleteById(id);
    }
    
    //lISTE DES CONTACTS EN FONCTION D'UN MOT CLE (NOM)
    @RequestMapping(value="/chercherContact", method=RequestMethod.GET)
    public Page<Contact> chercher(@RequestParam(name="mc",defaultValue="")String mc,
            @RequestParam(name="page",defaultValue="0")int page, 
            @RequestParam(name="size",defaultValue="2")int size){
        return contactRepository.chercherContact("%"+mc+"%", new PageRequest(page, size));
    }
    
}
