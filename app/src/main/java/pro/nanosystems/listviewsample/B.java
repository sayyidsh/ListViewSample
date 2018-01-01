package pro.nanosystems.listviewsample;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import pro.nanosystems.listviewsample.data.DbHelper;
import pro.nanosystems.listviewsample.data.StudentContarct.StudentData;
import pro.nanosystems.listviewsample.databinding.ActivityBBinding;

public class B extends AppCompatActivity {
    private EditText nameEd;
    private Button saveBtn;
    int id;
    ActivityBBinding bBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_b);
        bBinding = DataBindingUtil.setContentView(this, R.layout.activity_b);

        // nameEd = findViewById(R.id.name_edit);
        Intent i = getIntent();
        bBinding.nameEdit.setText(i.getStringExtra("name"));
        id = i.getIntExtra("id", 0);
        //saveBtn = findViewById(R.id.save_btn);
        //  bBinding.nameEdit.setText("WOWOWOWOWOW");
        bBinding.saveBtn.setOnClickListener(v -> {
            DbHelper dbHelper = new DbHelper(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(StudentData.NAME, bBinding.nameEdit.getText().toString().trim());
            db.update(StudentData.TABLE_NAME, values,
                    StudentData._ID + "=" + id, null);
            //  db.insert(StudentData.TABLE_NAME,null,values)
            finish();
        });


    }
}
