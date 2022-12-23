trait Platform_Trait{

  def giveReward(platform: Platform, tokens: Double, student: Student)={
    platform.setTokens(platform.getTokens() - tokens);
    student.setTokens(student.getTokens() + tokens);
  }

  def payForStudy(priceForCourse: Double, student: Student, platform: Platform)={
    student.setTokens(student.getTokens() - priceForCourse);
    platform.setTokens(platform.getTokens() + priceForCourse);
  }

  def setSalary(priceForCourse: Double, feeFoUsingOffice: Double ,teacher: Teacher, platform: Platform)={
    var newFeeFoUsingOffice = (feeFoUsingOffice * priceForCourse) / 100;
    var newPriceForCourse = priceForCourse - newFeeFoUsingOffice; //від зарплати віднімається відсоток за користування офісом

    platform.setFiatMoney(platform.getFiatMoney() - newPriceForCourse);
    teacher.setFiatMoney(teacher.getFiatMoney() + newPriceForCourse);
  } 
}
