import java.sql.SQLOutput;

public class UC2_UNIT_TEST {
    /*
    * 1) CREATE A USER SELECTION OBJECT
    * 2) CREATE A BROKER FACTORY (THIS SHOULD CALL THE STRATEGY FACTORY)
    * 3) Create 2 brokers
    * 4) ADD BROKERS INSTANCE TO BROKER LOG
    * 5) CHANGE THE COINS
    * 6) CHANGE THE STRATEGY
    * 7) DELETE THE BROKER
    * */
    public static void main(String[] args) {
        // CREATING THE BROKER CONTAINER
        BrokerList brokerList = new BrokerList();

// 1)
        UsrSelection usrSelect1 = new UsrSelection("Fidelity","BTC,ETH","GammaSqueeze");
        UsrSelection usrSelect2 = new UsrSelection("CharleSchwab","COINA,COINB","ValueInvestingStrategy");
// 2)
        BrokerFactory brokerFactory = new BrokerFactory();  // 2)

// 3)
        Broker fidelity = brokerFactory.create(usrSelect1); // CREATING A BROKER
        Broker charlesSchwab = brokerFactory.create(usrSelect2); // second broker

        // NOW I NEED TO TEST IF EVERYTHING PROPERLY CREATED INCLUDING STRATEGY OBJECT
        // TESTING CONTENT OF FIDELITY
        Strategy stratFidelity  = fidelity.getStrategy();
        String[] tckrLstF = fidelity.getCryptoTickerList();


        // FIDELITY BROKER RES
        System.out.println("FIDELITY RESULTS");
        String nameF = fidelity.getName();
        System.out.println(stratFidelity.getClass());
        System.out.println(tckrLstF[0]);// I FUCKING SWEAR IF I GET A NULL POINTER IM GONNA FLIP
        System.out.println(tckrLstF[1]);

        // TESTING CHARLES SCHWAB

        Strategy stratCharles  = charlesSchwab.getStrategy();
        String[] tckrLstCharles = charlesSchwab.getCryptoTickerList();
        String nameCharles = charlesSchwab.getName();

        System.out.println("CHARLES RESULTS");
        System.out.println(stratCharles.getClass());
        System.out.println(tckrLstCharles[0]);
        System.out.println(tckrLstCharles[1]);





// 4)
//        brokerList.addBroker(fidelity); // ADDING BROKER TO LIST
//        brokerList.addBroker(charlesSchwab);
//        // TEST TO SEE IF SUCCESFULLY ADDED








    }
}
