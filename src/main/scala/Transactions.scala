import java.util.Date

class Transactions(private var date: Date, private var typeTransaction: String, private var tokens: Double, private var fiatmoney: Double, private var exchangeRate: Double){
    def getInformation(): String = return s"Transaction: ${typeTransaction} ${String.format("%(.2f", tokens)}-->${String.format("%(.2f", fiatmoney)} Exchange rate: ${String.format("%(.1f", exchangeRate)}\nDate: ${date}";
}