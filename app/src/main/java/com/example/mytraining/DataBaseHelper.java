package com.example.mytraining;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
// hecho con la siguiente informacion https://icedtealabs.com/android/android-use-existing-sqlite-database-in-android-app/
public class DataBaseHelper extends SQLiteOpenHelper {
    private static String PATH = "/data/data/com.example.mytraining/databases";
    private static String NAME = "MyTrainingSessionsBD.db.sql";

    public SQLiteDatabase myDataBase;
    private static Context myContext;

    /*
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */
    public DataBaseHelper(Context context) {
        super(context, NAME, null, 1);
        myContext = context;
    }
    /*
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    public void createDataBase() throws IOException {
        boolean dbExist = tryOpenDataBase();
        if(dbExist)
        {
            System.out.println("Database already exist");
        }
        else
        {
            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();
            try
            {
                copyDataBase();
            }
            catch (IOException e)
            {
                System.out.println("Error copying data"+e.toString()+e.getMessage());
            }
        }
    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    private boolean tryOpenDataBase()
    {
        SQLiteDatabase checkDB = null;
        try
        {
            String myPath = PATH + NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
            System.out.println("checkdb::"+checkDB);
        }
        catch(SQLiteException e)
        {
            System.out.println("&amp;&amp;&amp;&amp;&amp;&amp;&amp;&amp;&amp;&amp;&amp;&amp;&amp;&amp;&amp;&amp;&amp;&amp;&amp;&amp;&amp;&amp;&amp;&amp;&amp;&amp;&amp;&amp;"+e.toString());
        }
        if(checkDB != null)
        {
            System.out.println("DB found");
            checkDB.close();
        }
        else
        {
            System.out.println("DB not found");
        }
        return checkDB != null ? true : false;
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     * */
    private void copyDataBase() throws IOException
    {
        System.out.println("Working 1");
        //Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open(NAME);
        // Path to the just created empty db
        String outFileName = PATH + NAME;
        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);
        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0)
        {
            myOutput.write(buffer, 0, length);
        }
        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }
    public void openDataBase() throws SQLException {
        //Open the database
        String myPath = PATH + NAME;
        System.out.println("DBpath::"+myPath);
        //myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN&amp;#95;READONLY);
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        System.out.println("success");
    }

    @Override
    public synchronized void close() {
        if(myDataBase != null)
            myDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

}
