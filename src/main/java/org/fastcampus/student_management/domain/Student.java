package org.fastcampus.student_management.domain;

public class Student {

  private final String name;
  private final int age;
  private final String address;
  private boolean activated;

  public Student(String name, int age, String address) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("이름은 필수 입력값입니다.");
    }

    this.name = name;
    this.age = age;
    this.address = address;
    this.activated = true;
  }


  // 아래의 setter방식은 결국 뭐가됐든 확실히 가독성도 떨어지고, 캡슐화 기능이 떨어짐. 그렇기에 layer별로 정보를 전달하기 위한 dto객체가 아니라면 setter사용 지양.
//  public void setActivated(boolean activated){
//    if(activated && this.activated){
//      throw new IllegalArgumentException();
//    }
//
//    if (!activated && !this.activated){
//      throw  new IllegalArgumentException();
//    }
//
//    // 강사님은 위에처럼 if문 2개를 써서 활성->활성, 비활성->비활성 사태를 막으심.
//    // 근데 그냥 아래처럼하면 위의 2가지 케이스를 모두 막을 수 있는 것 아닌가? 같은 상태->같은상태로 변환되는것만 막으면 되니까!
//    if (this.activated == activated){
//      throw new IllegalArgumentException();
//    }
//
//    this.activated = activated;
//  }

  //새로 구현하는 좋은 방식
  /* 의문점 :  아래처럼하면 true->true는 막을 수 있지만, 만약 false->false인 경우에는 무시되는건가? 예외처리를 안하는 건가..? 왜냐면 이렇게 되면 false->false를 누군가 요청을 보냈어.
              그러면 오류를 띄우거나, 아니면 예외처리가 안되어있어서 false->false로 그대로 변경되거나 해야함에도 불구하고 무조건 false->true만 되자나.
              그럼 겉으로 보기엔 요청을 보낸 사람은 에러가 없으므로 false->false로 잘 되었구나 하고 생각할 수도 있지 않을까..? 사실상 false가 아닌 true로 아예 상태가 바뀌었는데!!!
  */
  public void activate(){
    if(this.activated){
      throw new IllegalArgumentException();
    }

    this.activated = true;
  }

  // 아 설마 deactive도 만들어서 가독성 편하게 해결하는 방법쓰나?? 일단 영상 뒤에보기전에 먼저 만들어는 봄. 연습할겸..
  // 미쳤다. 이게 맞네? 이정도는 분리해도 되는구나? 가독성 개편함...
  public void deactivate(){
    if(!this.activated){
      throw new IllegalArgumentException();
    }

    this.activated=false;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getAddress() {
    return address;
  }
  public boolean isActivate() {
    return activated;
  }
}
