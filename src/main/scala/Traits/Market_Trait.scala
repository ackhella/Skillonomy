import java.util.Date

trait Market_Trait{

  def buyTokens(tokens: Double, market:  Market,  currentFiatMoney: Double, currentTokens: Double): Array[Double] ={
    var needToPayMoney = tokens * market.getExchangeRate();

    market.listOfTransactions ::= new Transactions(new Date(), "Purchase tokens", tokens, needToPayMoney, market.getExchangeRate());

    var newFiatMoney = currentFiatMoney - needToPayMoney;
    var newTokens = currentTokens + tokens;

    market.setFiatMoney(market.getFiatMoney() + needToPayMoney);
    market.setTokens(market.getTokens() - tokens);

    market.setExchangeRate(market.getExchangeRate() + 0.1);

    var balance = Array(newFiatMoney, newTokens);
    return balance;
  }

  def sellTokens(tokens: Double, market:  Market,  currentFiatMoney: Double, currentTokens: Double): Array[Double] = {
    var money = tokens / market.getExchangeRate();

    market.listOfTransactions ::= new Transactions(new Date(), "Selling tokens", tokens, money, market.getExchangeRate());

    var newFiatMoney = currentFiatMoney + money;
    var newTokens = currentTokens - tokens;

    market.setFiatMoney(market.getFiatMoney() - money);
    market.setTokens(market.getTokens() + tokens);

    market.setExchangeRate(market.getExchangeRate() - 0.1);

    var balance = Array(newFiatMoney, newTokens);
    return balance;
  }
}
