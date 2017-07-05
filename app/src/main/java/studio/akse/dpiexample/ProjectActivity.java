package studio.akse.dpiexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class ProjectActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView depokTxt, jakartaTxt, bandungTxt, semarangTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        setTitle("Project");
        depokTxt = (TextView) findViewById(R.id.depok);
        jakartaTxt = (TextView) findViewById(R.id.jakarta);
        bandungTxt = (TextView) findViewById(R.id.bandung);
        semarangTxt = (TextView) findViewById(R.id.semarang);

        depokTxt.setOnClickListener(this);
        jakartaTxt.setOnClickListener(this);
        bandungTxt.setOnClickListener(this);
        semarangTxt.setOnClickListener(this);

        TabHost host = (TabHost) findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Participated");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Not Participated");
        host.addTab(spec);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.depok:
                Intent depok = new Intent(ProjectActivity.this, DetailProjectActivity.class);
                depok.putExtra("id", "DEPOK");
                depok.putExtra("lokasi", ": Jl. Margonda no. 21, Depok");
                startActivity(depok);
                break;
            case R.id.jakarta:
                Intent jakarta = new Intent(ProjectActivity.this, DetailProjectActivity.class);
                jakarta.putExtra("id", "JAKARTA");
                jakarta.putExtra("lokasi", ": Jl. Margonda no. 21, Jakarta");
                startActivity(jakarta);
                break;
            case R.id.bandung:
                Intent bandung = new Intent(ProjectActivity.this, DetailProjectActivity.class);
                bandung.putExtra("id", "BANDUNG");
                bandung.putExtra("lokasi", ": Jl. Margonda no. 21, Bandung");
                startActivity(bandung);
                break;
            case R.id.semarang:
                Intent semarang = new Intent(ProjectActivity.this, DetailProjectActivity.class);
                semarang.putExtra("id", "SEMARANG");
                semarang.putExtra("lokasi", ": Jl. Margonda no. 21, Semarang");
                startActivity(semarang);
                break;
        }

    }
}
