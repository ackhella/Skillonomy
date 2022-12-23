class Contract(private var price: Double, private var fee: Double, private var validity: Int = 6){

    def setValidity(value: Int) = validity = value;
    def setCoursePrice(value: Double) = price = value;
    def setFee(value: Double) = fee = value;

    def getValidity(): Int = return validity;
    def getCoursePrice(): Double = return price;
    def getFee(): Double = return fee;
}
