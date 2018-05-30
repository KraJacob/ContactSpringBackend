/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacob.contactSpring.dao;

import com.jacob.contactSpring.entity.Contact;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author STEINER
 */
public interface ContactRepository extends JpaRepository<Contact, Long> {
    public List<Contact> findContactById(Long id);
    //methode affichant une page de contact en fonction d'un mot clé
    @Query("select c from Contact c where c.nom like :x")
    public Page<Contact> chercherContact(@Param("x") String mc, Pageable page);
}
