public class UsrSelection {
    /* User creates a this by entering strings into the ui this object gets passed to broker factory which then creates a broker object based on the inputed strings
     Thse are the strings entered by user when choosing what he wants to create-
    This is then used and converted to strategies and broker using the appropriate factories */
    private String name;
    private String tckrLst;
    private String strategy;

    UsrSelection(String name, String tckrLst, String strategy){
        setName(name);
        setTckrLst(tckrLst);
        setStrategy(strategy);

    }

    // Generic getter and setter


    public void setName(String n){
        name =n;
    }
    public void setTckrLst(String tLst){
        tckrLst = tLst;
    }

    public void setStrategy(String s){
        strategy = s;
    }
    public String getName(){
        return name;
    }
    public String getTckrLst(){
        return tckrLst;
    }

    public String getStrategy() {
        return strategy;
    }
}
