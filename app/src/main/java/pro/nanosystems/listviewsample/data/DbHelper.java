package pro.nanosystems.listviewsample.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import pro.nanosystems.listviewsample.data.StudentContarct.StudentData;

/**
 * Created by Sayyid Shaban on 28/12/2017.
 * E-mail: sayyid.ls@gmail.com
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE = "students.db";
    private static final int  VERSION = 1;
    public DbHelper(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(StudentData.SQL_CREATE);
        ContentValues values = new ContentValues();
        values.put(StudentData.NAME, "Ali");
        values.put(StudentData.GENDER, StudentData.MALE);
        db.insert(StudentData.TABLE_NAME,null,values);
        values.put(StudentData.NAME, "Islam");
        values.put(StudentData.GENDER, StudentData.MALE);
        db.insert(StudentData.TABLE_NAME,null,values);
        values.put(StudentData.NAME, "Afifi");
        values.put(StudentData.GENDER, StudentData.MALE);
        db.insert(StudentData.TABLE_NAME,null,values);
        values.put(StudentData.NAME, "Mahmoud");
        values.put(StudentData.GENDER, StudentData.MALE);
        db.insert(StudentData.TABLE_NAME,null,values);
        values.put(StudentData.NAME, "Mena");
        values.put(StudentData.GENDER, StudentData.MALE);
        db.insert(StudentData.TABLE_NAME,null,values);
        values.put(StudentData.NAME, "Mohamed");
        values.put(StudentData.GENDER, StudentData.MALE);
        db.insert(StudentData.TABLE_NAME,null,values);
        values.put(StudentData.NAME, "Abo Amra");
        values.put(StudentData.GENDER, StudentData.MALE);
        db.insert(StudentData.TABLE_NAME,null,values);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL(StudentData.SQL_DELETE);
        onCreate(db);
    }
}
