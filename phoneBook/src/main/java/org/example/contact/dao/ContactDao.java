package org.example.contact.dao;

import org.example.contact.ContactSet;

import java.util.HashMap;
import java.util.Map;

public class ContactDao {
    private Map<String, ContactSet> contactDB = new HashMap<>();

    public void insert(ContactSet contactSet) {
        contactDB.put(contactSet.getName(), contactSet);
    }

    public ContactSet select(String name) {
        return contactDB.get(name);
    }

    public void delete(String name) {
        contactDB.remove(name);
    }

    public void update(ContactSet contactSet) {
        contactDB.put(contactSet.getName(), contactSet);
    }

    public Map<String, ContactSet> getContactDB() {
        return contactDB;
    }
}
