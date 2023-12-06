package ch04_pjt_01.ems;

import ch04_pjt_01.ems.member.service.*;
import org.springframework.context.support.GenericXmlApplicationContext;

import ch04_pjt_01.ems.member.Student;
import ch04_pjt_01.ems.utils.InitSampleData;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
        String[] appCtxs = {"classpath:appCtx1.xml", "classpath:appCtx2.xml", "classpath:appCtx3.xml"};
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(appCtxs);

		Scanner scan = new Scanner(System.in);

		// 샘플 데이터
		InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);
		String[] sNums = initSampleData.getsNums();
		String[] sIds = initSampleData.getsIds();
		String[] sPws = initSampleData.getsPws();
		String[] sNames = initSampleData.getsNames();
		int[] sAges = initSampleData.getsAges();
		char[] sGenders = initSampleData.getsGenders();
		String[] sMajors = initSampleData.getsMajors();

		// 데이터베이스에 샘플 데이터 등록
		StudentRegisterService registerService = ctx.getBean("studentRegisterService", StudentRegisterService.class);
		for (int i = 0; i < sNums.length; i++) {
			registerService
					.register(new Student(sNums[i], sIds[i], sPws[i], sNames[i], sAges[i], sGenders[i], sMajors[i]));
		}
		// 학생 리스트
		PrintStudentInformationService printStudentInformationService = ctx.getBean("printStudentInformationService",
				PrintStudentInformationService.class);
		printStudentInformationService.printStudentsInfo(); // 학생 리스트

		// 학생 등록
		registerService = ctx.getBean("studentRegisterService", StudentRegisterService.class);
		registerService.register(new Student("hbs006", "deer", "p0006", "melissa", 26, 'w', "Music"));

		printStudentInformationService.printStudentsInfo(); // 학생 리스트


		// 학생 출력
		StudentSelectService selectService = ctx.getBean("studentSelectService", StudentSelectService.class);
		Student selectedstudent = selectService.select("hbs006");

		// 학생 수정
		StudentModifyService modifyService = ctx.getBean("studentModifyService", StudentModifyService.class);

		// 학생 삭제
		StudentDeleteService deleteService = ctx.getBean("studentDeleteService", StudentDeleteService.class);

		System.out.println("STUDENT START ------------------");
		System.out.print("sNum:" + selectedstudent.getsNum() + "\t");
		System.out.print("|sId:" + selectedstudent.getsId() + "\t");
		System.out.print("|sPw:" + selectedstudent.getsPw() + "\t");
		System.out.print("|sName:" + selectedstudent.getsName() + "\t");
		System.out.print("|sAge:" + selectedstudent.getsAge() + "\t");
		System.out.print("|sGender:" + selectedstudent.getsGender() + "\t");
		System.out.println("|sMajor:" + selectedstudent.getsMajor());
		System.out.println("END ----------------------------");


		while (true) {
			System.out.println("Select number.");
			System.out.println("1.Check student information");
			System.out.println("2.Register student information");
			System.out.println("3.Modify student information");
			System.out.println("4.Delete student information");
			System.out.println("5.Check all student information");
			System.out.println("6.Exit");
			int menu = scan.nextInt();

			if (menu == 1) {
				System.out.println("Please input your sNum.");
				String sNum = scan.next();

				selectedstudent = selectService.select(sNum);

				System.out.print("sNum:" + selectedstudent.getsNum());
				System.out.print(" | sId:" + selectedstudent.getsId());
				System.out.print(" | sPw:" + selectedstudent.getsPw());
				System.out.print(" | sName:" + selectedstudent.getsName());
				System.out.print(" | sAge:" + selectedstudent.getsAge());
				System.out.print(" | sGender:" + selectedstudent.getsGender());
				System.out.println(" | sMajor:" + selectedstudent.getsMajor());
				System.out.println("=============================================");
			} else if (menu == 2) {
				System.out.println("Please input your sNum");
				String sNum = scan.next();
				System.out.println("Please input your sId");
				String sId = scan.next();
				System.out.println("Please input your sPw");
				String sPw = scan.next();
				System.out.println("Please input your sName");
				String sName = scan.next();
				System.out.println("Please input your sAge");
				int sAge = scan.nextInt();
				System.out.println("Please input your sGender");
				char sGender = scan.next().charAt(0);
				System.out.println("Please input your sMajor");
				scan.nextLine();
				String sMajor = scan.nextLine();

				registerService.register(new Student(sNum, sId, sPw, sName, sAge, sGender, sMajor));

				System.out.println("Done");
			} else if (menu == 3) {
				System.out.println("Please input your sNum");
				String sNum = scan.next();
				selectedstudent = selectService.select(sNum);

				System.out.println("Please input your new sId");
				String sId = scan.next();
				System.out.println("Please input your new sPw");
				String sPw = scan.next();
				System.out.println("Please input your new sName");
				String sName = scan.next();
				System.out.println("Please input your new sAge");
				int sAge = scan.nextInt();
				System.out.println("Please input your new sGender");
				char sGender = scan.next().charAt(0);
				System.out.println("Please input your new sMajor");
				scan.nextLine();
				String sMajor = scan.nextLine();

				modifyService.modify(new Student(sNum, sId, sPw, sName, sAge, sGender, sMajor));

				System.out.println("Done");

			} else if (menu == 4) {
				System.out.println("Please input your sNum");
				String sNum = scan.next();

				deleteService.delete(sNum);

				System.out.println("Done");
			} else if (menu == 5) {
				printStudentInformationService.printStudentsInfo();
			} else if (menu == 6) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}

		ctx.close();
	}
}