package org.fastcampus.student_management.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.DayOfWeek;

public class CourseRepository {

  private final Map<String, Course> courseMap = new HashMap<>();

  public void save(Course course) {
    courseMap.put(course.getCourseName(), course);
  }

  // 요일을 받고 저장된 수업을 불러오는 메소드
  public List<Course> getCourseDayOfWeek(DayOfWeek dayOfWeek) {
    List<Course> courses = new ArrayList<>();
    for (Course course : courseMap.values()) {
      if (course.isSameDay(dayOfWeek) && course.isActivateUser()) {
        courses.add(course);
      }
    }
    return courses;
  }

  public List<Course> getCourseListByStudent(String studentName) {
    List<Course> courses = new ArrayList<>();
    for (Course course : courseMap.values()) {
      if (course.getStudentName().equals(studentName)) {
        courses.add(course);
      }
    }
    return courses;
  }

  public void saveCourses(List<Course> courses) {
    for (Course course : courses) {
      courseMap.put(course.getCourseName(), course);
    }
  }
}
