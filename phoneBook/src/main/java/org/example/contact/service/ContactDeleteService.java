package org.example.contact.service;

import org.example.contact.ContactSet;
import org.example.contact.dao.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class ContactDeleteService {
    @Resource
    @Qualifier("usedDao")
    ContactDao contactDao;

//    public ContactDeleteService(ContactDao contactDao) {
//        this.contactDao = contactDao;
//    }

    public void delete(String name){
        if (verify(name)) {
            contactDao.delete(name);
        } else {
            System.out.println("The name has already registered");
        }
    }

    public boolean verify(String name) {
        ContactSet contactSet = contactDao.select(name);
        return contactSet != null;
    }
}
