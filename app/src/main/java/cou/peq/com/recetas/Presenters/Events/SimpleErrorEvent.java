package cou.peq.com.recetas.Presenters.Events;

/**
 * Created by Javier- on 01/04/2017.
 */

public class SimpleErrorEvent extends BaseEvent {

    private boolean warningMode = false;
    private Exception errorType;
    private String exceptionMessage = "";

    public SimpleErrorEvent(String exceptionMessage){

        this. exceptionMessage = exceptionMessage;
    }

    public SimpleErrorEvent(String exceptionMessage, boolean warningMode){

        this.warningMode = warningMode;
        this. exceptionMessage = exceptionMessage;
    }

    public SimpleErrorEvent(Exception errorType) {

        this.errorType = errorType;

    }

    public Exception getErrorType() {
        return errorType;
    }

    public String getErrorMessage(){

        if (exceptionMessage.equals("")){

            return errorType.toString();

        }else{
            return exceptionMessage;
        }

    }

    public boolean isWarningMode() {
        return warningMode;
    }

    public void setWarningMode(boolean warningMode) {
        this.warningMode = warningMode;
    }
}