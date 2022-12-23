object Main extends App{

  var officeAdress = new Adress("Ukraine", "Kyiv", "Shevchenka Street 8"); //адреса офісу

  var basicContract = new Contract(200, 10);
  var teacherContract = new Contract(200, 10, 6); 

  var teacher = new Teacher("Oleksandr", "Rybak", 39, "rybak27oleksandr@gmail.com", "oleks22", "123", teacherContract);

  teacher.addToList(new Student("Liza", "Bondarenko", 18, 100, 100, "liza1@gmail.com", "liza222", "111", basicContract));
  teacher.addToList(new Student("Yana", "Kozoriz", 19, "ddd52@gmail.com", "cdcdcd", "1112", basicContract));
  teacher.addToList(new Student("Ann", "Ivanyuk", 19, "ann211@gmail.com", "vfvbgt", "1862", basicContract));
  teacher.addToList(new Student("Tom", "Miller", 19, "tom781@gmail.com", "btybol2", "152", basicContract));
  teacher.addToList(new Student("Kate", "Dobritsa", 18, "kate@gmail.com", "olvfd", "11552", basicContract));
  teacher.addToList(new Student("Lera", "Ivanova", 18, 100, 100, "lerattt1@gmail.com", "olevfd2", "000", basicContract));
  teacher.addToList(new Student("Masha", "Dorina", 19, "fff1@gmail.com", "vsolsfs2", "123", basicContract));

  var market = new Market;
  var platform = new Platform;
  var office = new Office(officeAdress); 

  office.firstReward(teacher.getList(), platform, market); //нагорода за реєстрацію

  println("Initial information about students:")
  teacher.showList();
  println();
  println("Initial information about the teacher:")
  teacher.showInformation();
  println();

  office.setGrades(teacher.getList(), teacher, platform, market, basicContract);
  
  println("Latest information about students:")
  teacher.showList();
  println();
  println("Latest information about the teacher:")
  teacher.showInformation();
  println();

  market.showMarketInformation();
  platform.showPlatformInformation();
  println();

  println("Information about transactions:\n");
  market.showListOfTransactions();
}