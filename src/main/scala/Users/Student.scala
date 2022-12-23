class Student(name: String, surname: String, age: Int, fiatMoney: Double, tokens: Double, email: String, login: String, password: String, private var studyContract: Contract) 
extends Human (name, surname, age, fiatMoney, tokens, email, login, password){

    def this(name: String, surname: String, age: Int, email: String, login: String, password: String, studyContract: Contract)={
        this(name, surname, age, 0.0, 0.0, email, login, password, studyContract);}
}

