package studio.akse.dpiexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import studio.akse.dpiexample.R;

public class ForgetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        setTitle("Forget Password");
        final TextView reset = (TextView) findViewById(R.id.berhasil_reset);
        Button resetbtn =(Button) findViewById(R.id.btnreset);
        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout hasil  = (LinearLayout) findViewById(R.id.form_reset);
                hasil.setVisibility(View.GONE);
                reset.setVisibility(View.VISIBLE);
            }
        });
    }
}
