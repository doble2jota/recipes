package cou.peq.com.recetas.Model;

import cou.peq.com.recetas.Presenters.Events.GenericServerErrorEvent;
import cou.peq.com.recetas.Utils.EventBusUtils;

/**
 * Created by Javier- on 01/04/2017.
 */

public class AbstactDomain {

    public void manageErrorServer(String nameError){
        GenericServerErrorEvent genericServerErrorEvent = new GenericServerErrorEvent();
        genericServerErrorEvent.setTag(GenericServerErrorEvent.ERROR_LOGIN);
        genericServerErrorEvent.setMessage(nameError);
        EventBusUtils.post(genericServerErrorEvent);
    }

}
