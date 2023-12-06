package com.example.productlist;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DB_handler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "List Of Products";
    private static final String TABLE_NAME= "numbers";
    private static final String ID = "id";
    private static final String NUMBER = "number";
    private Context context;

    DB_handler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY,"
                + NUMBER + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    void addNumber(NumberModel product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NUMBER, product.getNumber());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public NumberModel getNumbers(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[] { ID, NUMBER}, ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        NumberModel number = new NumberModel(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        return number;
    }

    public List<NumberModel> getAllNumbers() {
        List<NumberModel> number = new ArrayList<NumberModel>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                NumberModel numberModel = new NumberModel();
                numberModel.setId(Integer.parseInt(cursor.getString(0)));
                numberModel.setNumber(Integer.parseInt(cursor.getString(1)));
                number.add(numberModel);
            } while (cursor.moveToNext());
        }

        return number;
    }

    public int updateNumber(NumberModel numberModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NUMBER, numberModel.getNumber());

        return db.update(TABLE_NAME, values, ID + " = ?",
                new String[]{String.valueOf(numberModel.getId())});
    }

    public void deleteNumber(NumberModel numberModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, ID + " = ?",
                new String[] { String.valueOf(numberModel.getId()) });
        db.close();
    }

    public boolean doesDatabaseExist() {
        File dbFile = this.context.getDatabasePath(DATABASE_NAME);
        return dbFile.exists();
    }
}
