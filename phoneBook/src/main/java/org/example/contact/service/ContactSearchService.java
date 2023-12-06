package org.example.contact.service;

import org.example.contact.ContactSet;
import org.example.contact.dao.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class ContactSearchService {
    @Resource
    @Qualifier("usedDao")
    private ContactDao contactDao;

//    public ContactSearchService(ContactDao contactDao) {
//        this.contactDao = contactDao;
//    }

    public ContactSet search(String name) {
        if (verify(name)) {
            return contactDao.select(name);
        } else {
            System.out.println("Contact information is available");
        }

        return null;
    }

    public boolean verify(String name) {
        ContactSet contactSet = contactDao.select(name);
        return contactSet != null;
    }

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }
}
