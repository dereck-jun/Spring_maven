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
public class MemberConfig2 {

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
}
