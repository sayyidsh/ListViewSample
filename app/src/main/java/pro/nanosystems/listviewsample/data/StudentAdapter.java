package pro.nanosystems.listviewsample.data;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import pro.nanosystems.listviewsample.data.StudentContarct.StudentData;

import pro.nanosystems.listviewsample.R;

/**
 * Created by Sayyid Shaban on 28/12/2017.
 * E-mail: sayyid.ls@gmail.com
 */

public class StudentAdapter extends CursorAdapter {
    public StudentAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.row_items,parent,
                false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView idView, nameView, genderView;
        idView = view.findViewById(R.id.id_view);
        nameView = view.findViewById(R.id.name_view);
        genderView = view.findViewById(R.id.gender);
        idView.setText(""+cursor.getInt(0));
        nameView.setText(cursor.getString(1));
        String genderStr =
     (cursor.getInt(2) == StudentData.MALE) ? "Male" : "Female";
        genderView.setText(genderStr);


    }
}
