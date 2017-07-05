package studio.akse.dpiexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SurveyProjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_project);

        String date;
        String marks;
        String survey;
        String judul;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                judul = null;
                survey = null;
                marks = null;
                date = null;
            } else {
                judul = extras.getString("judul");
                survey = extras.getString("sry");
                marks = extras.getString("marks");
                date = extras.getString("date");

            }
        } else {
            judul = (String) savedInstanceState.getSerializable("judul");
            survey = (String) savedInstanceState.getSerializable("sry");
            marks = (String) savedInstanceState.getSerializable("marks");
            date = (String) savedInstanceState.getSerializable("date");
        }

        setTitle(judul + "-" + survey);
    }
}
