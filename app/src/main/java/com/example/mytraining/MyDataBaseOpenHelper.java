package com.example.mytraining;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MyDataBaseOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;
    private static final String NAME="MyTrainingSessionsBD.db.sql";
    private static  final String PATH="/data/data/com.example.mytraining/databases";
    private static Context myContext;
    private static String datosbd="";
    public MyDataBaseOpenHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void recogeSQL(){
        System.out.println("Working 1");
        //Open your local db as the input stream
        try{
            InputStream myInput = myContext.getAssets().open(NAME);
            // Path to the just created empty db
            String outFileName = PATH + NAME;
            //Open the empty db as the output stream
            //transfer bytes from the inputfile to the outputfile
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer))>0)
            {
                //datosbd+=myInput.
            }

        }catch(Exception e){
            e.printStackTrace();

        }


    }
}