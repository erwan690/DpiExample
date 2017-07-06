package studio.akse.dpiexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TabHost;

public class LandActivity extends AppCompatActivity {

    private FloatingActionButton add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land);
        setTitle("Land Listing");

        add = (FloatingActionButton) findViewById(R.id.add_tet);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(LandActivity.this, AddLandActivity.class);
                startActivity(main);
            }
        });

        TabHost host = (TabHost) findViewById(R.id.tabhost_land);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab1_land);
        spec.setIndicator("All");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2_land);
        spec.setIndicator("My Listing");
        host.addTab(spec);
    }
}
