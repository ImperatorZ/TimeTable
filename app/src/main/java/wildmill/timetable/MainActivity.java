package wildmill.timetable;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity{



    String url = "http://vk.com/imperatorz";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }



    public void onClick(View v) {

        Intent intent;

        switch (v.getId()) {
            case R.id.layoutTransitionBtn:
                intent = new Intent(this, BlogTransitionActivity.class);
                startActivity(intent);
                break;

            case R.id.Clock:
                Toast.makeText(MainActivity.this, "Ожидается в скоро времени...", Toast.LENGTH_SHORT).show();
                break;

            case R.id.view_gallery_btn:
                Toast.makeText(MainActivity.this, "Ожидается в скором времени...", Toast.LENGTH_SHORT).show();
                break;


            case R.id.VK:
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
            case R.id.Exit:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder
                        .setTitle("Выход")
                        .setMessage("Вы точно хотите выйти?")
                        .setCancelable(false)
                        .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Intent.ACTION_MAIN);
                                intent.addCategory(Intent.CATEGORY_HOME);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                finish();
                                System.exit(0);
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            
        }

    }

}
