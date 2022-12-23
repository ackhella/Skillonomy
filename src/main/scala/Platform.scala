class Platform(private var tokens: Double = 100000, private var fiatmoney: Double = 100000) {
  def setFiatMoney(value: Double) = fiatmoney = value;
  def setTokens(value: Double) = tokens = value;

  def getFiatMoney(): Double = return fiatmoney;
  def getTokens(): Double = return tokens;

  def showPlatformInformation()={
    println(s"Platform information\nFiat money: ${String.format("%(.2f", getFiatMoney())} Tokens: ${String.format("%(.2f", getTokens())}")
  }
}
