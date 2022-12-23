class Market(private var tokens: Double = 100000, private var flatmoney: Double = 100000, private var exchangeRate: Double = 1){
    
    var listOfTransactions: List[Transactions] = List[Transactions]();
    
    def setFiatMoney(value: Double) = flatmoney = value;
    def setTokens(value: Double) = tokens = value;

    def getFiatMoney(): Double = return flatmoney;
    def getTokens(): Double = return tokens;

    def getExchangeRate(): Double = return exchangeRate;
    def setExchangeRate(value: Double) = exchangeRate = value;

    def showMarketInformation()={
        println(s"Market information\nFiat money: ${String.format("%(.2f", getFiatMoney())} Tokens: ${String.format("%(.2f", getTokens())}")
    }

    def showListOfTransactions()={
        var i = 1;
        for(transaction <- listOfTransactions){
            println(i + ") " + transaction.getInformation());
            i += 1;
        }
    }
}
