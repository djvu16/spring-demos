package org.example.patternproxy;

public class WaitingState implements State {
    AutomatInterface automat;
    public WaitingState(AutomatInterface a)
    {
        automat = a;
    }
    public String gotApplication()
    {
        automat.setState(automat.getGotApplicationState());
        return "Thanks for the application.";
    }
    public String checkApplication()
    {
        return "You have to submit an application.";
    }
    public String rentApartment()
    {
        return "You have to submit an application.";
    }
    public String dispenseKeys()
    {
        return "You have to submit an application.";
    }
}
