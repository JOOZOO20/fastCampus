package org.fastcampus.student_management.application.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.fastcampus.student_management.application.student.dto.StudentInfoDto;
import org.fastcampus.student_management.domain.Student;
import org.fastcampus.student_management.repo.StudentRepository;

public class StudentService {

  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public void saveStudent(StudentInfoDto studentInfoDto) {
    Student student = new Student(studentInfoDto.getName(), studentInfoDto.getAge(), studentInfoDto.getAddress());
    studentRepository.save(student);
  }

  public Student getStudent(String name) {
    return studentRepository.findByName(name)
        .orElseThrow(() -> new IllegalArgumentException("해당하는 학생이 없습니다."));
  }


  // 2. 수강생들의 상태 변경 관련
  public void activateStudent(String name) {
    // TODO: 과제 구현 부분
    // 원래 계획 : student의 이름과 매개변수로 받은 name과 같은 객체 하나 생성. 그리고 그 객체의 상태가 true가 아니면 true로 바꾸도록 하고, 이미 true면 걍 기존정보 return
//    List<StudentInfoDto> studentInfoDto = new ArrayList<>();
//    List<Student> students = new ArrayList<>();
//
//    if(studentInfoDto.getActived()!= true){
//      students.
//    }
//
//    if(studentRepository.equals(name) && students.get())
    // 여기서부터 강사님 따라 작성
    Student student = getStudent(name);
    student.activate();
  }


  public void deactivateStudent(String name) {
    // TODO: 과제 구현 부분
    Student student = getStudent(name);
//    student.setActivated(false);
    student.deactivate();
  }

}
