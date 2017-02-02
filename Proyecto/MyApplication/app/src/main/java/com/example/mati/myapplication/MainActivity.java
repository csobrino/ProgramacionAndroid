package com.example.mati.myapplication;

        import android.app.Activity;
        import android.app.Dialog;
        import android.content.ContentValues;
        import android.content.Context;
        import android.content.Intent;
        import android.database.Cursor;
        import android.database.SQLException;
        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class MainActivity extends Activity {
    Button btnSignIn,btnSignUp;
    LoginDataBaseAdapter loginDataBaseAdapter;
    static  String userName;
    static  String password;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create a instance of SQLite Database
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        // Get The Refference Of Buttons
        btnSignIn=(Button)findViewById(R.id.buttonSignIn);
        btnSignUp=(Button)findViewById(R.id.buttonSignUP);

        // Set OnClick Listener on SignUp button
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /// Create Intent for SignUpActivity  abd Start The Activity
                Intent intentSignUP=new Intent(getApplicationContext(),SignUPActivity.class);
                startActivity(intentSignUP);
            }
        });
        //Lanzamos metodo LogIN.
        signIn(btnSignIn);
    }
    // Methos to handleClick Event of Sign In Button
    public void signIn(View V)
    {

        final  EditText editTextUserName=(EditText)findViewById(R.id.editTextUserNameToLoginMain);
        final  EditText editTextPassword=(EditText)findViewById(R.id.editTextPasswordToLoginMain);

        Button btnSignIn=(Button)findViewById(R.id.buttonSignIn);


        // Set On ClickListener
        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // get The User name and Password
                userName=editTextUserName.getText().toString();
                password=editTextPassword.getText().toString();

                // fetch the Password form database for respective user name
                String storedPassword=loginDataBaseAdapter.getSinlgeEntry(userName);

                // check if the Stored password matches with  Password entered by user
                if(password.equals(storedPassword))
                {
                    Toast.makeText(MainActivity.this, "Un placer tenerte de vuelta "+userName, Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(MainActivity.this, MainMenuActivity.class);

                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "El usuario o la contraseña no coinciden.", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        loginDataBaseAdapter.close();
    }
}
