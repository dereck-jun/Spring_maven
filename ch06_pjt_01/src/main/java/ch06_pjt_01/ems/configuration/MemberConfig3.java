package ch06_pjt_01.ems.configuration;

import ch06_pjt_01.ems.member.DBConnectionInfo;
import ch06_pjt_01.ems.member.dao.StudentDao;
import ch06_pjt_01.ems.member.service.*;
import ch06_pjt_01.ems.utils.InitSampleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class MemberConfig3 {

    @Autowired
    DBConnectionInfo dev_DBConnectionInfo;

    @Autowired
    DBConnectionInfo real_DBConnectionInfo;

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
        dbInfos.put("dev", dev_DBConnectionInfo);
        dbInfos.put("real", real_DBConnectionInfo);
        informationService.setDbInfos(dbInfos);

        return informationService;
    }


}
