package org.example.patternproxy;

import java.util.Random;

public class GotApplicationState implements State {
    AutomatInterface automat;
    Random random;
    public GotApplicationState(AutomatInterface a)
    {
        automat = a;
        random = new Random(System.currentTimeMillis());
    }
    public String gotApplication()
    {
        return "We already got your application.";
    }
    public String checkApplication()
    {int yesno = random.nextInt() % 10;
        if (yesno > 4 && automat.getCount() > 0) {
            automat.setState(automat.getApartmentRentedState());
            return "Congratulations, you were approved.";
        } else {
            automat.setState(automat.getWaitingState());
            return "Sorry, you were not approved.";
        }
    }
    public String rentApartment()
    {
        return "You must have your application checked.";
    }
    public String dispenseKeys()
    {
        return "You must have your application checked.";
    }
}
