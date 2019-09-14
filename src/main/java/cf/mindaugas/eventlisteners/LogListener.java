package cf.mindaugas.eventlisteners;

import javax.persistence.PostPersist;

public class LogListener {

    @PostPersist
    public void prepersist(Object movie){
        System.out.println("postpersis called from LogListener");
    }
}
