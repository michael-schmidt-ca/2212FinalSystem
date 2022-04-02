
public class MainSystem {
    public static void main(String[] args) {
        boolean loginValid = false;
        //Display Login UI
        LoginUI.launchLogInUI();
        //If login UI returns false exit system
        //Else start Main UI


        //get user input
        //send user input to UserSelection after each row is added

        //when perform trades button is pressed
        //create and display histogram
        //create and display trade table
    }

    public static void loginCheck(Boolean valid){
        if(valid){
            MainUI.LaunchMainUI();
        }
        else{
            System.exit(0);
        }
    }
}
