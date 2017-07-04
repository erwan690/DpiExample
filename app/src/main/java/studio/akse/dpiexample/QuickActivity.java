package studio.akse.dpiexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QuickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick);
        setTitle("Quick Count");
    }
}
