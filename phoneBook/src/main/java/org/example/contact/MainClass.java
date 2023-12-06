package org.example.contact;

import org.example.contact.service.*;
import org.example.contact.utils.InitSampleData;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
        Scanner scan = new Scanner(System.in);

        InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);
        String[] names = initSampleData.getNames();
        String[] phoneNumbers = initSampleData.getPhoneNumbers();

        ContactRegisterService registerService = ctx.getBean("contactRegisterService", ContactRegisterService.class);
        for (int i = 0; i < names.length; i++) {
            ContactSet contactSet = new ContactSet(names[i], phoneNumbers[i]);
            registerService.register(contactSet);
        }

        ContactSearchService searchService = ctx.getBean("contactSearchService", ContactSearchService.class);
        ContactModifyService modifyService = ctx.getBean("contactModifyService", ContactModifyService.class);
        ContactDeleteService deleteService = ctx.getBean("contactDeleteService", ContactDeleteService.class);

        System.out.println("Welcome to the contact program!!");

        while (true) {
            System.out.println("Please enter the menu");
            System.out.println("1. register | 2. search | 3. modify | 4. delete | 5. exit");
            System.out.print("input: ");
            int menu = scan.nextInt();

            if (menu == 1) {    // 등록
                System.out.print("Please input your name: ");
                String name = scan.next();
                System.out.print("Please input your phoneNumber: ");
                String phoneNumber = scan.next();

                registerService.register(new ContactSet(name, phoneNumber));

                System.out.println();
                System.out.println("------ Done ------");
            } else if (menu == 2) { // 찾기
                System.out.print("Please enter the name: ");
                String name = scan.next();

                ContactSet selectedInstance = searchService.search(name);

                System.out.println("Name: " + selectedInstance.getName());
                System.out.println("Phone Number: " + selectedInstance.getPhoneNumber());

                System.out.println();
                System.out.println("------ Done ------");

            } else if (menu == 3) { // 수정
                System.out.print("Please input name: ");
                String name = scan.next();

                searchService.search(name);

                System.out.print("Please enter the phone number you want to change: ");
                String phoneNumber = scan.next();

                modifyService.modify(new ContactSet(name, phoneNumber));

                System.out.println();
                System.out.println("------ Done ------");
            } else if (menu == 4) { // 삭제
                System.out.print("Please enter the name you want to delete: ");
                String name = scan.next();

                deleteService.delete(name);

                System.out.println();
                System.out.println("------ Done ------");
            } else { // 종료
                System.out.println("------ Thank you ------");
                break;
            }
        }
    }
}