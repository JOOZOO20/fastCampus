package org.fastcampus.student_management.application.course.dto;

import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.DayOfWeek;

public class CourseInfoDto {
  private final String courseName;
  private final int fee;
  private final DayOfWeek dayOfWeek; // Q. 열거형 클래스로 이미 작성을 했는데 또 다시 final로 선언한 이유가 있나? 그냥 가져다 쓰면 되는거 아닌가?
  private final String studentName;
  private final Long courseTime;

  public CourseInfoDto(String courseName, int fee, String dayOfWeek, String studentName, Long courseTime) {
    this.courseName = courseName;
    this.fee = fee;
    this.dayOfWeek = DayOfWeek.valueOf(dayOfWeek);
    this.studentName = studentName;
    this.courseTime = courseTime;
  }

  public CourseInfoDto(Course course) {
    this.courseName = course.getCourseName();
    this.fee = course.getFee();
    this.dayOfWeek = course.getDayOfWeek();
    this.studentName = course.getStudentName();
    this.courseTime = course.getCourseTime();
  }

  public String getCourseName() {
    return courseName;
  }

  public int getFee() {
    return fee;
  }

  public DayOfWeek getDayOfWeek() {
    return dayOfWeek;
  }

  public String getStudentName() {
    return studentName;
  }

  public Long getCourseTime() {
    return courseTime;
  }
}
