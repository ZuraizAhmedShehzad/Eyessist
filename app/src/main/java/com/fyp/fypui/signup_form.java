package com.fyp.fypui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup_form extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText mAcPin, mEmail, mPassword, mUserName, mCPassword;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;
    boolean errCheck = false;
    private DatabaseReference mDatabase;

    //    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);

        mAcPin   = findViewById(R.id.acPin);
        mUserName   = findViewById(R.id.userName);
        mEmail      = findViewById(R.id.Email);
        mPassword   = findViewById(R.id.password);
        mCPassword   = findViewById(R.id.cpassword);
        mRegisterBtn= findViewById(R.id.registerBtn);

        fAuth = FirebaseAuth.getInstance();



//        if(fAuth.getCurrentUser() != null){
//            startActivity(new Intent(getApplicationContext(),appliance.class));
//            finish();
//        }

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String cpassword = mCPassword.getText().toString().trim();
                String acpin = mAcPin.getText().toString().trim();
                String username = mUserName.getText().toString().trim();
                mDatabase = FirebaseDatabase.getInstance().getReference();



                mDatabase.child(acpin).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {


                            Log.d("firebase", String.valueOf(task.getResult().getValue()));
                            if(String.valueOf(task.getResult().getValue()).equals("null"))
                            {
                                Toast.makeText(signup_form.this, "Ac Pin Doesn't Exist", Toast.LENGTH_SHORT).show();
                            }


                    }
                });






                if(TextUtils.isEmpty(username)){
                    mUserName.setError("User Name is Required.");
                    errCheck = true;
                }



                if(TextUtils.isEmpty(acpin)){
                    mAcPin.setError("Ac Pin is Required.");
                    errCheck = true;
                }





                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required.");
                    errCheck = true;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required.");
                    errCheck = true;
                }



                if(password.length() < 6){
                    mPassword.setError("Password Must Be Atleast 6 Characters");
                    errCheck = true;
                }


                    if (!(password.equals(cpassword))) {
                        Toast.makeText(signup_form.this, "Password Doestn't Match.", Toast.LENGTH_SHORT).show();
                        errCheck = true;
                    }

                 if (!errCheck) {
                     fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                         @Override
                         public void onComplete(@NonNull Task<AuthResult> task) {
                             if (task.isSuccessful()) {
                                 Toast.makeText(signup_form.this, "User Created.", Toast.LENGTH_SHORT).show();
                                 mDatabase.child(fAuth.getCurrentUser().getUid().toString()).setValue(acpin);

                             } else {
                                 Toast.makeText(signup_form.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                             }

                         }


                     });





                 }
            }
        });



            }

}
