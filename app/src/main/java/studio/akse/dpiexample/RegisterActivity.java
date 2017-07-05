package studio.akse.dpiexample;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    //storage permission code
    private static final int STORAGE_PERMISSION_CODE = 123;
    private static TextView date;
    private Button buttonUpload,submit;
    private int PICK_IMAGE_REQUEST = 1;
    //Bitmap to get image from gallery
    private Bitmap bitmap;
    private Uri filePath;
    private ImageView imagena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Register");
        date =(TextView) findViewById(R.id.tanggal);
        buttonUpload = (Button) findViewById(R.id.uploadphoto);
        imagena = (ImageView) findViewById(R.id.imagena);
        submit =(Button) findViewById(R.id.submitregister);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final TextView berhasil = (TextView) findViewById(R.id.berhasil);
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(RegisterActivity.this);

                //alertDialog.setTitle("Logout"); // Sets title for your alertbox

                alertDialog.setMessage("Data Sudah Benar ?"); // Message to be displayed on alertbox

/* When positive (yes/ok) is clicked */
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ScrollView hidden = (ScrollView) findViewById(R.id.scrolna);
                        hidden.setVisibility(View.GONE);
                        submit.setVisibility(View.GONE);
                        berhasil.setVisibility(View.VISIBLE);

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
        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFileChooser();
            }
        });
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogfragment = new DatePickerDialogTheme();

                dialogfragment.show(getFragmentManager(),"Tanggal");
            }
        });

    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            filePath = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imagena.setVisibility(View.VISIBLE);
                imagena.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class DatePickerDialogTheme extends DialogFragment implements DatePickerDialog.OnDateSetListener{

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState){
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            calendar.set(day, month, year);

            DatePickerDialog datepickerdialog = new DatePickerDialog(getActivity(),AlertDialog.THEME_DEVICE_DEFAULT_DARK,this,year,month,day);

            return datepickerdialog;
        }

        public void onDateSet(DatePicker view, int year, int month, int day){



            String bulan = getMonth(month);

            date.setText(day + " / " + bulan + " / " + year);

        }
        public String getMonth(int month) {
            return new DateFormatSymbols().getMonths()[month];
        }
    }


}
