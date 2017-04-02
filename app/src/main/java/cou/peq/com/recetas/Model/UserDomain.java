package cou.peq.com.recetas.Model;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import cou.peq.com.recetas.Presenters.Events.UserEvent;
import cou.peq.com.recetas.Utils.EventBusUtils;
/**
 * Created by Javier- on 01/04/2017.
 */

public class UserDomain extends AbstactDomain{

    private static final String TAG ="UserDomain";

    FirebaseAuth auth = FirebaseAuth.getInstance();

    public void createUser(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.d(TAG," fail exception"+task.getException());
                            manageErrorServer("Error de autenticacion");
                            Log.d(TAG," fail");
                        }else {
                            Log.d(TAG," success");
                            UserEvent userEvent = new UserEvent();
                            userEvent.setTag(UserEvent.EVENT_SUCCESS_REGISTER_USER);
                            EventBusUtils.post(userEvent);
                        }
                    }
                });
    }
}
