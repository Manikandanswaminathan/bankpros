package bankpros.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
public class MainActivity3 extends AppCompatActivity {
    private String[] listitems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Spinner sp1 = findViewById(R.id.s1);
        ArrayAdapter adapter=new ArrayAdapter(MainActivity3.this, android.R.layout.simple_spinner_item,listitems);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp1.setAdapter(adapter);
        String[] TRANSFER_FROM = getResources().getStringArray(R.array.TRANSFER_FROM);
        Spinner sp2 = findViewById(R.id.s2);
        ArrayAdapter adapter1=new ArrayAdapter(MainActivity3.this, android.R.layout.simple_spinner_item, TRANSFER_FROM);
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp2.setAdapter(adapter1);
        String[] TRANSFER_TO = getResources().getStringArray(R.array.TRANSFER_TO);

    }
}
