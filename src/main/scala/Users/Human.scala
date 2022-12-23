class Human(var name: String, var surname: String, var age: Int, var fiatMoney: Double, var tokens: Double, var email: String, var login: String, var password: String){
    private var _name: String = name;
    private var _surname: String = surname;
    private var _age: Int = age;
    private var _fiatMoney: Double = fiatMoney;
    private var _tokens: Double = tokens; 
    private var _email: String = email;
    private var _login: String = login;
    private var _password: String = password;

    def showInformation() = {
      println(s"${_name} ${_surname} ${_age} email: ${_email} login: ${_login} password: ${_password}\nFiat money: ${String.format("%(.2f", _fiatMoney)} Tokens: ${String.format("%(.2f", _tokens)}");
    }

    def setFiatMoney(value: Double) = _fiatMoney = value;
    def setTokens(value: Double) = _tokens = value;

    def getFiatMoney() = _fiatMoney;
    def getTokens() = _tokens;
}
