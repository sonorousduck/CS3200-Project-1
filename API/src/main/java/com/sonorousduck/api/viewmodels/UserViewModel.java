package com.sonorousduck.api.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sonorousduck.api.models.User;

import java.util.ArrayList;
import java.util.HashMap;


public class UserViewModel extends ViewModel {
    FirebaseAuth auth;
    DatabaseReference database;
    MutableLiveData<User> user = new MutableLiveData<>();
    MutableLiveData<RuntimeException> loginError = new MutableLiveData<>();


    public UserViewModel() {
        this.auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance().getReference();
        // This will tell us if the user has logged out
        this.auth.addAuthStateListener((FirebaseAuth firebaseAuth) -> {
            FirebaseUser fbUser = auth.getCurrentUser();
            loginError.setValue(null);
            if (fbUser == null) {
                this.user.setValue(null);
            } else {
                user.setValue(new User(fbUser));
            }



        });
    }

    public MutableLiveData<User> getUser() {
        return user;
    }

    public String getEmail() {
        return this.user.getValue().email;
    }

    public void signUp(String name, String email, String password) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener((Task<AuthResult> task) -> {
            AuthResult result = task.getResult();
            if (result.getUser() == null) {
                loginError.setValue(new RuntimeException("Email is already in use"));
            }
        });
    }

    public void signIn(String email, String password) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener((Task<AuthResult> task) -> {
            AuthResult result = task.getResult();
            if (result.getUser() == null) {
                loginError.setValue(new RuntimeException("Incorrect Username/Password"));
            }
        });
    }

    public void signOut() {
        auth.signOut();
    }



    public void storeUserSpecificData(int score, int failures, boolean isSpy) {
        if (user.getValue() != null) {

            String newPostKey = database.getRef().child(user.getValue().uid).push().getKey();

            HashMap<String, String> postData = new HashMap<>();

            postData.put("score", "" + score);
            postData.put("failures", "" + failures);
            postData.put("isSpy", "" + isSpy);

            database.child("userData").child(user.getValue().uid).child(newPostKey).setValue(postData);


//            database.child("userData").child(user.getValue().uid).child("score").setValue("" + score);
//            database.child("userData").child(user.getValue().uid).child("failures").setValue("" + failures);
//            database.child("userData").child(user.getValue().uid).child("isSpy").setValue("" + isSpy);
        }
    }




}
