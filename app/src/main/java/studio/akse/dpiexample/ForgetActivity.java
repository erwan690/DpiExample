package studio.akse.dpiexample;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

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
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ForgetActivity.this);

                //alertDialog.setTitle("Logout"); // Sets title for your alertbox

                alertDialog.setMessage("Email Sudah Benar ?"); // Message to be displayed on alertbox

/* When positive (yes/ok) is clicked */
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        LinearLayout hasil = (LinearLayout) findViewById(R.id.form_reset);
                        hasil.setVisibility(View.GONE);
                        reset.setVisibility(View.VISIBLE);

                    }
                });

/* When negative (No/cancel) button is clicked*/
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
                alertDialog.show();

            }
        });
    }
}
