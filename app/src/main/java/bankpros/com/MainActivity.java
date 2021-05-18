package bankpros.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity<Fire> extends AppCompatActivity {
    private EditText et1;
    private EditText et2;
    private EditText et3;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();

        firebaseAuth= FirebaseAuth.getInstance();
        Button b1 = findViewById(R.id.b1);
        b1.setOnClickListener(v -> {
            if(validate()){
                String user_name=et1.getText().toString().trim();
                String user_email=et2.getText().toString().trim();
                String user_balance=et3.getText().toString().trim();

                firebaseAuth.createUserWithEmailAndPassword(user_email,user_name).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "registeration success", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this,MainActivity2.class));

                        }else{
                            Toast.makeText(MainActivity.this,"registeration failed",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }
    private void setupUIViews(){
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        TextView tv1 = (TextView) findViewById(R.id.tv1);
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        TextView tv3 = (TextView) findViewById(R.id.tv3);
    }
    private boolean validate(){
        boolean result= false;
        String username=et1.getText().toString();
        String email=et2.getText().toString();
        String balance=et3.getText().toString();
        if(username.isEmpty() || email.isEmpty() || balance.isEmpty()){
            Toast.makeText(this,"please enter all the details",Toast.LENGTH_SHORT).show();
        }else{
            result=true;
        }
        return result;
    }
}
