import scala.collection.mutable.ListBuffer

class Teacher(name: String, surname: String, age: Int, fiatMoney: Double, tokens: Double, email: String, login: String, password: String, private var studyContract: Contract) 
extends Human (name, surname, age, fiatMoney, tokens, email, login, password){

    private val listOfStudents = ListBuffer[Student]();

    def this(name: String, surname: String, age: Int, email: String, login: String, password: String, studyContract: Contract)={
        this(name, surname, age, 0.0, 0.0, email, login, password, studyContract);}

    def addToList(student: Student)={
        listOfStudents += student;
    }

    def showList()={
        for(student <- listOfStudents){
            student.showInformation();
        }
    }

    def getList(): ListBuffer[Student] = return listOfStudents;
}
