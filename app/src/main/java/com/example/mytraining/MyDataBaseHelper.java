package com.example.mytraining;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//si hay problemas al usar sqliteAssetHelper ver aqui https://stackoverflow.com/questions/24479755/installing-android-sqlite-asset-helperhttps://stackoverflow.com/questions/24479755/installing-android-sqlite-asset-helper
public class MyDataBaseHelper extends SQLiteOpenHelper {

    public static String DB_PATH = "/data/data/com.example.mytraining/databases/";

    public static String DB_NAME = "sqlite.db";
    public static final int DB_VERSION = 1;

    public static final String TB_EJERCICIO = "Ejercicio";

    private SQLiteDatabase myDB;
    private Context context;

    public MyDataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

    @Override
    public synchronized void close(){
        if(myDB!=null){
            myDB.close();
        }
        super.close();
    }
    private boolean checkDataBase() {
        SQLiteDatabase tempDB = null;
        boolean existe = false;
        try {
            String myPath = DB_PATH + DB_NAME;
            tempDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
            existe=true;
        } catch (SQLiteException e) {
            Log.e("tle99 - check", e.getMessage());
        }
        if (tempDB != null)
            tempDB.close();
        return existe;
    }
        /***
     * Copy database from source code assets to device
     * @throws IOException
     */
    public void copyDataBase() throws IOException {
        try {
            InputStream myInput = context.getAssets().open(DB_NAME);
            String outputFileName = DB_PATH + DB_NAME;
            OutputStream myOutput = new FileOutputStream(outputFileName);

            byte[] buffer = new byte[1024];
            int length;

            while((length = myInput.read(buffer))>0){
                myOutput.write(buffer, 0, length);
                System.out.println("leer " + length);
            }

            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (Exception e) {
            Log.e("tle99 - copyDatabase", e.getMessage());
            e.printStackTrace();
        }

    }
    /***
     * Open database
     * @throws SQLException
     */
    public void openDataBase() throws SQLException {
        String myPath = DB_PATH + DB_NAME;
        myDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }
    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();        

        if (dbExist) {
            System.out.println("LA BASE DE DATOS EXISTE");
        } else {
            this.getReadableDatabase();
            try {
                copyDataBase();

            } catch (IOException e) {
                Log.e("tle99 - create", e.getMessage());
            }
        }
    }

}
