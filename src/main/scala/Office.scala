import scala.util.Random
import scala.collection.mutable.ListBuffer

class Office(private var adress: Adress) extends Market_Trait with Platform_Trait{
  def firstReward(list: ListBuffer[Student], platform: Platform, market: Market)={
      var tokensForLoggingIn = 100;
      for(student <- list){
        if(platform.getTokens() < tokensForLoggingIn){
          buyTokens((tokensForLoggingIn - platform.getTokens()),  market, platform.getFiatMoney(), platform.getTokens());
        }
        giveReward(platform, tokensForLoggingIn, student);
      }
    }

  def setGrades(list: ListBuffer[Student], teacher: Teacher, platform: Platform, market: Market, contract: Contract)={
    for(validity <- 1 to contract.getValidity()){ 
      for(student <- list){
        var grade = Random.nextInt(5);
        var tokensAmount: Double = 0;
        var coef: Double = 1.0;
        var marketRate = market.getExchangeRate();
        
        grade match
          case 0 =>{
            coef = 0.9;
            tokensAmount = 200 * coef;
          }
          case 1 =>{
            coef = 0.95;
            tokensAmount = 200 * coef;
          }
          case 2 =>{
            coef = 1.1;
            tokensAmount = 200 * coef;
          }
          case 3 =>{
            coef = 1.25;
            tokensAmount = 200 * coef;
          }
          case 4 =>{
            coef = 1.5;
            tokensAmount = 200 * coef;
          }
        
        if(platform.getTokens() < tokensAmount){  
          var result = buyTokens((tokensAmount - platform.getTokens()),  market, platform.getFiatMoney(), platform.getTokens());
          platform.setFiatMoney(result(0));
          platform.setTokens(result(1));
        }
        giveReward(platform, tokensAmount, student);

        if(student.getTokens() < contract.getCoursePrice()){
          var result = buyTokens((contract.getCoursePrice() - student.getTokens()), market, student.getFiatMoney(), student.getTokens());
          student.setFiatMoney(result(0));
          student.setTokens(result(1));
        }
        payForStudy(contract.getCoursePrice(), student, platform);
        
        if(platform.getTokens() < contract.getCoursePrice()){   
          var result = buyTokens((contract.getCoursePrice() - platform.getTokens()),  market, platform.getFiatMoney(), platform.getTokens());
          platform.setFiatMoney(result(0));
          platform.setTokens(result(1));
        }
        setSalary(contract.getCoursePrice(), contract.getFee(), teacher, platform);

        if(student.getTokens() > contract.getCoursePrice()){ //якщо студенти мають надлишок, то вони можуть обміняти токени на гроші
          var overPrice = student.getTokens() - contract.getCoursePrice();
          var result =  sellTokens(overPrice, market, student.getFiatMoney(), student.getTokens());
          student.setFiatMoney(result(0));
          student.setTokens(result(1));
        }

        if(marketRate > 2){ 
          if(platform.getTokens() > contract.getCoursePrice()){            
            var result = sellTokens(contract.getCoursePrice(), market, platform.getFiatMoney(), platform.getTokens());
            platform.setFiatMoney(result(0));
            platform.setTokens(result(1));
          }
          if(teacher.getTokens() > contract.getCoursePrice()){    
            var result = sellTokens(contract.getCoursePrice(), market, teacher.getFiatMoney(), teacher.getTokens());
            teacher.setFiatMoney(result(0));
            teacher.setTokens(result(1));
          }
        }

        if(marketRate < 0.5){ 
          var newCourcePrice = contract.getCoursePrice() * market.getExchangeRate(); 
          
          if(platform.getFiatMoney() > newCourcePrice){
            var result = buyTokens(contract.getCoursePrice(), market, platform.getFiatMoney(), platform.getTokens());
            platform.setFiatMoney(result(0));
            platform.setTokens(result(1));
          }
          if(teacher.getFiatMoney() > newCourcePrice){ 
            var result = buyTokens(contract.getCoursePrice(), market, teacher.getFiatMoney(), teacher.getTokens());
            teacher.setFiatMoney(result(0));
            teacher.setTokens(result(1));
          }
        }
      }
    }
  }
}
