package com.example.mytraining;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

public class ReadDataBase{
    private final String TB_EJERCICIO ="Ejercicio";
    private final String TB_MUSCULO ="Musculo";
    private final String TB_RUTINA ="Rutina";

    private ArrayList<Ejercicio> listaEjercicios;
    private MyDataBaseHelper dbHelper;
    private SQLiteDatabase myDB;

    public ReadDataBase(Context context){
        listaEjercicios=new ArrayList<Ejercicio>();
        dbHelper = new MyDataBaseHelper(context);
        createDataBase();
    }
    public void createDataBase(){
        try {
            dbHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void openDataBase(){
        myDB = dbHelper.getWritableDatabase();
        System.out.println("******************************************          \n Base de datos abierta");
    }
    public void closeDataBase(){
        if(myDB != null){
            myDB.close();
            System.out.println("******************************************          \nBase de datos cerrada");
        }
    }
    public ArrayList<Ejercicio> getAllExercise(){
        Cursor c;
        String name;
        String description;
        int id;
        String url;
        double calorias;
        try {
            c = myDB.rawQuery("SELECT * FROM Ejercicio" , null);
            if(c == null) return null;

            c.moveToFirst();
            do {
                id = c.getInt(0);
                name = c.getString(1);
                description = c.getString(2);
                url = c.getString(3);
                calorias = c.getDouble(4);
                listaEjercicios.add(new Ejercicio(id,name,description,url,calorias));
            } while (c.moveToNext());
            c.close();
        } catch (Exception e) {
            Log.e("tle99", e.getMessage());
            //llenaListaEjercicios();
        }
        return listaEjercicios;
    }
    public void llenaListaEjercicios(){
        listaEjercicios = new ArrayList<Ejercicio>();
        listaEjercicios.add(new Ejercicio(1,"Elevaciones de hombros con mancuernas","Sostén una mancuerna en cada mano y levanta los hombros hacia las orejas, manteniendo los brazos rectos. Mantén la posición durante un segundo y luego baja los hombros lentamente.",
                "https://youtu.be/xeJjTRIYOIM",0.060));
        listaEjercicios.add(new Ejercicio(2,"Remo con barra","Mantén la espalda recta y levanta la barra hacia tu pecho, manteniendo los codos cerca del cuerpo. Baja la barra lentamente y repite el ejercicio.",
                "https://www.youtube.com/watch?v=G8l_8chR5BE",0.100));
        listaEjercicios.add(new Ejercicio(3,"Encogimientos de hombros con cable"," Agarra un cable con una polea baja en cada mano y tira de ellos hacia arriba hasta que tus hombros estén cerca de tus oídos. Mantén la posición durante un segundo y luego baja lentamente los cables.",
                "https://youtu.be/v7QczJNuWIg",0.060));
    }




}

