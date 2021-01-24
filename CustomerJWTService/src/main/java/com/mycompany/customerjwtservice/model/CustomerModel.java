/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.customerjwtservice.model;

import com.mycompany.customerjwtservice.entity.CustomerMaster;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Albus
 */
public class CustomerModel {
    EntityManager em;
    Collection<CustomerMaster> customerMasters;

    public CustomerModel() {
        em = Persistence.createEntityManagerFactory("CustomerPU").createEntityManager();
    }

    public Collection<CustomerMaster> getCustomerMasters(String condition,int rating) {
        customerMasters = new ArrayList<>();
        if("lt".equals(condition))
        {
            customerMasters = em.createQuery("SELECT c FROM CustomerMaster c WHERE c.rating < " + rating).getResultList();
        }
        if("gt".equals(condition))
        {
            customerMasters = em.createQuery("SELECT c FROM CustomerMaster c WHERE c.rating > " + rating).getResultList();
        }
        if("lte".equals(condition))
        {
            customerMasters = em.createQuery("SELECT c FROM CustomerMaster c WHERE c.rating <= " + rating).getResultList();
        }
        if("gte".equals(condition))
        {
            customerMasters = em.createQuery("SELECT c FROM CustomerMaster c WHERE c.rating >= " + rating).getResultList();            
        }
        if("eq".equals(condition))
        {
            customerMasters = em.createQuery("SELECT c FROM CustomerMaster c WHERE c.rating = " + rating).getResultList();            
        }
        return customerMasters;
    }
}
