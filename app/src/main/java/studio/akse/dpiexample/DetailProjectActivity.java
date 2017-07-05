package studio.akse.dpiexample;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class DetailProjectActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView lokasiTxt, survey1Txt, survey2Txt, survey3Txt, date1Txt, date2Txt, date3Txt, marks1Txt, marks2Txt, marks3Txt;

    private String date, marks, survey, judul, newString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_project);

        lokasiTxt = (TextView) findViewById(R.id.alamt);
        survey1Txt = (TextView) findViewById(R.id.survey1);
        survey2Txt = (TextView) findViewById(R.id.survey2);
        survey3Txt = (TextView) findViewById(R.id.survey3);
        date1Txt = (TextView) findViewById(R.id.date1);
        date2Txt = (TextView) findViewById(R.id.date2);
        date3Txt = (TextView) findViewById(R.id.date3);
        marks1Txt = (TextView) findViewById(R.id.marks1);
        marks2Txt = (TextView) findViewById(R.id.marks2);
        marks3Txt = (TextView) findViewById(R.id.marks3);

        survey1Txt.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        survey2Txt.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        survey3Txt.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        survey1Txt.setOnClickListener(this);
        survey2Txt.setOnClickListener(this);
        survey3Txt.setOnClickListener(this);

        String lokasi;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                newString = null;
                lokasi = null;
            } else {
                newString = extras.getString("id");
                lokasi = extras.getString("lokasi");
            }
        } else {
            newString = (String) savedInstanceState.getSerializable("id");
            lokasi = (String) savedInstanceState.getSerializable("lokasi");
        }

        setTitle(newString + " Project");
        lokasiTxt.setText(lokasi);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.survey1:
                judul = newString + " Project";
                survey = survey1Txt.getText().toString();
                marks = marks1Txt.getText().toString();
                date = date1Txt.getText().toString();
                Intent sry1 = new Intent(DetailProjectActivity.this, SurveyProjectActivity.class);
                sry1.putExtra("judul", judul);
                sry1.putExtra("sry", survey);
                sry1.putExtra("marks", marks);
                sry1.putExtra("date", date);
                startActivity(sry1);
                break;
            case R.id.survey2:
                judul = newString + " Project";
                survey = survey2Txt.getText().toString();
                marks = marks2Txt.getText().toString();
                date = date2Txt.getText().toString();
                Intent sry2 = new Intent(DetailProjectActivity.this, SurveyProjectActivity.class);
                sry2.putExtra("judul", judul);
                sry2.putExtra("sry", survey);
                sry2.putExtra("marks", marks);
                sry2.putExtra("date", date);
                startActivity(sry2);
                break;
            case R.id.survey3:
                judul = newString + " Project";
                survey = survey3Txt.getText().toString();
                marks = marks3Txt.getText().toString();
                date = date3Txt.getText().toString();
                Intent sry3 = new Intent(DetailProjectActivity.this, SurveyProjectActivity.class);
                sry3.putExtra("judul", judul);
                sry3.putExtra("sry", survey);
                sry3.putExtra("marks", marks);
                sry3.putExtra("date", date);
                startActivity(sry3);
                break;
        }

    }
}
