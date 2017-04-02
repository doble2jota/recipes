package cou.peq.com.recetas.Presenters.Events;

/**
 * Created by Javier- on 01/04/2017.
 */

public class BaseEvent {
    protected Exception exception;

    public BaseEvent(){super();}

    public BaseEvent(Exception excepton){this.exception = excepton;}

    public boolean hasError(){return exception!=null;}

}
