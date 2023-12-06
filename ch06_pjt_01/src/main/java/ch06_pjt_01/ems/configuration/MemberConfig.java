package ch06_pjt_01.ems.configuration;

import ch06_pjt_01.ems.member.DBConnectionInfo;
import ch06_pjt_01.ems.member.dao.StudentDao;
import ch06_pjt_01.ems.member.service.*;
import ch06_pjt_01.ems.utils.InitSampleData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class MemberConfig {

    @Bean
    public InitSampleData initSampleData() {
        InitSampleData initSampleData = new InitSampleData();

        String[] sNums = {"hbs001", "hbs002", "hbs003", "hbs004", "hbs005"};
        initSampleData.setsNums(sNums);

        String[] sIds = {"rabbit", "hippo", "raccoon", "elephant", "lion"};
        initSampleData.setsIds(sIds);

        String[] sPws = {"p0001", "p0002", "p0003", "p0004", "p0005"};
        initSampleData.setsPws(sPws);

        String[] sNames = {"agatha", "barbara", "chris", "doris", "elva"};
        initSampleData.setsNames(sNames);

        int[] sAges = {19, 22, 23, 26, 20};
        initSampleData.setsAges(sAges);

        char[] sGenders = {'M', 'W', 'W', 'M', 'M'};
        initSampleData.setsGenders(sGenders);

        String[] sMajors = {"English", "Korean" ,"French", "Philosophy", "History"};
        initSampleData.setsMajors(sMajors);

        return initSampleData;
    }

    @Bean
    public StudentDao studentDao() {
        return new StudentDao();
    }

    @Bean
    public StudentRegisterService registerService() {
        return new StudentRegisterService(studentDao());
    }

    @Bean
    public StudentDeleteService deleteService() {
        return new StudentDeleteService(studentDao());
    }

    @Bean
    public StudentSelectService selectService() {
        return new StudentSelectService(studentDao());
    }

    @Bean
    public StudentModifyService modifyService() {
        return new StudentModifyService(studentDao());
    }

    @Bean
    public StudentAllSelectService allSelectService() {
        return new StudentAllSelectService(studentDao());
    }

    @Bean
    public PrintStudentInformationService printStudentInformationService() {
        return new PrintStudentInformationService(allSelectService());
    }

    @Bean
    public DBConnectionInfo dev_DBConnectionInfo() {
        DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
        dbConnectionInfo.setUrl("000.000.000.000");
        dbConnectionInfo.setUserId("admin");
        dbConnectionInfo.setUserPw("0000");

        return dbConnectionInfo;
    }

    @Bean
    public DBConnectionInfo real_DBConnectionInfo() {
        DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
        dbConnectionInfo.setUrl("111.111.111.111");
        dbConnectionInfo.setUserId("master");
        dbConnectionInfo.setUserPw("1111");

        return dbConnectionInfo;
    }

    @Bean
    public EMSInformationService eMSInformationService() {
        EMSInformationService informationService = new EMSInformationService();

        informationService.setInfo("Education Management System program was developed in 2022.");
        informationService.setCopyRight("COPYRIGHT(C) 2022 EMS CO., LTD. ALL RIGHT RESERVED. " +
                "CONTACT MASTER FOR MORE INFORMATION.");
        informationService.setVer("The version is 1.0");

        informationService.setsYear(2022);
        informationService.setsMonth(3);
        informationService.setsDay(1);
        informationService.seteYear(2022);
        informationService.seteMonth(4);
        informationService.seteDay(30);

        List<String> developers = new ArrayList<>();
        developers.add("Cheney.");
        developers.add("Eloy.");
        developers.add("Jasper.");
        developers.add("Dillon.");
        developers.add("Kian.");
        informationService.setDevelopers(developers);

        Map<String, String> administrators = new HashMap<>();
        administrators.put("Cheney", "cheney@spring.org");
        administrators.put("Jasper", "jasper@spring.org");
        informationService.setAdministrators(administrators);

        Map<String, DBConnectionInfo> dbInfos = new HashMap<>();
        dbInfos.put("dev", dev_DBConnectionInfo());
        dbInfos.put("real", real_DBConnectionInfo());
        informationService.setDbInfos(dbInfos);

        return informationService;
    }


}
