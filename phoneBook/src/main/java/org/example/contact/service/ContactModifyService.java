package org.example.contact.service;

import org.example.contact.ContactSet;
import org.example.contact.dao.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.inject.Inject;
import javax.inject.Named;

public class ContactModifyService {
    @Inject
    @Named("contactDao1")
    ContactDao contactDao;

//    public ContactModifyService(ContactDao contactDao) {
//        this.contactDao = contactDao;
//    }

    public void modify(ContactSet contactSet) {
        if (verify(contactSet.getName())) {
            contactDao.update(contactSet);
        } else {
            System.out.println("The name has already registered");
        }
    }

    public boolean verify(String name) {
        ContactSet contactSet = contactDao.select(name);
        return contactSet != null;
    }
}
