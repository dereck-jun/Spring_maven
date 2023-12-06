package ch06_pjt_01.ems.member.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ch06_pjt_01.ems.member.Student;

public class PrintStudentInformationService {

	StudentAllSelectService allSelectService;

	public PrintStudentInformationService(StudentAllSelectService allSelectService) {
		this.allSelectService = allSelectService;
	}

	public void printStudentsInfo() {
		Map<String, Student> allStudent = allSelectService.allSelect();
		Set<String> keys = allStudent.keySet();
		Iterator<String> iterator = keys.iterator();
		System.out.println("STUDENT LIST START -------------");
		while (iterator.hasNext()) {
			String key = iterator.next();
			Student student = allStudent.get(key);
			System.out.print("sNum:" + student.getsNum());
			System.out.print(" | sId:" + student.getsId());
			System.out.print(" | sPw:" + student.getsPw());
			System.out.print(" | sName:" + student.getsName());
			System.out.print(" | sAge:" + student.getsAge());
			System.out.print(" | sGender:" + student.getsGender());
			System.out.println(" | sMajor:" + student.getsMajor());

		}
		System.out.println("END ----------------------------");
	}

}