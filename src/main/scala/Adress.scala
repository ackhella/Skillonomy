class Adress(private var country: String, private var city: String, private var street: String){
    def getAdress(): String = return s"${country} ${city} ${street}";

    def setCountry(value: String) = country = value;
    def setCity(value: String) = city = value;
    def setStreet(value: String) = street = value;
  }