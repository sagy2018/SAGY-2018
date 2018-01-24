package com.example.jason.sagy;

import android.app.Notification;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.onesignal.OneSignal;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();


    private static final int RC_SIGN_IN =2 ;
    Button b1,b4;
    EditText e1,e2;
    FirebaseAuth mAuth;
    TextView t1;
    ProgressBar progressBa1;
    GoogleSignInClient mGoogleSignInClient;
    //private String email="yugandar.bala@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBa1=(ProgressBar)findViewById(R.id.progressBar1);
        b1=(Button) findViewById(R.id.button);
        b4 = (Button)findViewById(R.id.button4); 
        e1=(EditText)findViewById(R.id.emailID);
        e2=(EditText)findViewById(R.id.editText2);
        mAuth=FirebaseAuth.getInstance();
        t1=(TextView)findViewById(R.id.textView);
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();

        //OneSignal.syncHashedEmail(String.valueOf(e1));


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("817301648730-ku52vgsgs64klpnk0v3ka08uu446gspu.apps.googleusercontent.com")
                .requestEmail()
                .build();
        mGoogleSignInClient =  GoogleSignIn.getClient(this, gso);
        Log.i(TAG, "onCreate: "+getString(R.string.default_web_client_id));

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Registration.class);
                startActivity(intent);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userlogin();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleSignIn();
            }
        });


    }

    private void googleSignIn() {

        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Log.i(TAG, "onActivityResult: In request code");
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.i(TAG, "onActivityResult: "+e);
                // ...
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {


        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(MainActivity.this, "Successfully signed in!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this,Grid.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.i(TAG, "onComplete: Failed");
                            Snackbar.make(findViewById(R.id.main_layout), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }

    private void userlogin(){


        String user1=e1.getText().toString().trim();
        String pass1=e2.getText().toString().trim();
        if(user1.isEmpty()){
            e1.setError("EMail is required");
            e1.requestFocus();
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(user1).matches()){
            e1.setError("Please enter a valid EMail");
            e1.requestFocus();
            return;
        }
        if(pass1.isEmpty()){


            e2.setError("Password is required");
            e2.requestFocus();
            return;
        }
        if(pass1.length()<6){
            e2.setError("Minimum length of password must be 6");
            e2.requestFocus();
            return;
        }
        OneSignal.syncHashedEmail(user1); progressBa1.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(user1,pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBa1.setVisibility(View.GONE);
                if(task.isSuccessful()){

                    Intent intent=new Intent(MainActivity.this,Grid.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"User Logged in",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}


