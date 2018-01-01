package pro.nanosystems.listviewsample;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import pro.nanosystems.listviewsample.data.DbHelper;
import pro.nanosystems.listviewsample.data.StudentAdapter;
import pro.nanosystems.listviewsample.data.StudentContarct.StudentData;
import pro.nanosystems.listviewsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    /**
     * 1- row items. done
     * 2- ListView. done
     * 3-DbHelper. done
     * 4-StudentCursorAdapter extends CursorAdapter. done
     * 5- obj DbHelper , obj SQLiteDatabase, obj StudentAdapter. done
     */
    private StudentAdapter adpater;
    private ListView lv;
    DbHelper dbHelper;
    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.query(StudentData.TABLE_NAME,
                null,
                null, null, null, null, null);
         adpater = new StudentAdapter(this, c);
        lv = findViewById(R.id.list);
        lv.setAdapter(adpater);

        lv.setOnItemClickListener(new ListView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, B.class);
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                Cursor c = db.query(StudentData.TABLE_NAME,
                        null,
                        null, null, null, null, null);
                c.moveToPosition(position);
                i.putExtra("name",c.getString(1));
                i.putExtra("id", c.getInt(0));
                startActivity(i);

            }
        });

    }

    @Override
    protected void onResume() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.query(StudentData.TABLE_NAME,
                null,
                null, null, null, null, null);
        adpater.changeCursor(c);
        super.onResume();
    }
}
