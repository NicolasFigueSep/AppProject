package com.example.mytraining;

private final String TB_EJERCICIO ="Ejercicio";
private final String TB_MUSCULO ="Musculo";
private final String TB_RUTINA ="Rutina";

private ArrayList<Ejercicio> listaEjercicios;
private MyDataBaseHelper dbHelper;
private SQLiteDatabase myDB;

public ReadDataBase(Context context){
    listaEjercicios=new ArrayList<Ejercicio>();
    dbHelper = new MyDataBaseHelper(context);
}
public openDataBase(){
    myDB = dbHelper.getWritableDataBase();
    System.out.println("Base de datos abierta");
}
public closeDataBase(){
    if(myDB != null){
        myDB.close();
        System.out.println("Base de datos cerrada");
    }
}

public ArrayList<Ejercicio> getAllExercise(){
    
}
