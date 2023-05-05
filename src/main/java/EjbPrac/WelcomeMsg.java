package EjbPrac;

import javax.ejb.Local;

@Local
public interface WelcomeMsg {
    public String returnWelcomeMsg();
}
