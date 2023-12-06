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
public class MemberConfig1 {

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

}
