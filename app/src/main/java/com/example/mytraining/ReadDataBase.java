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
    Cursor c;
    String name;
    String description;
    int id;
    try {
        c = db.rawQuery("SELECT * FROM " + TB_EJERCICIO , null);
        if(c == null) return null;
        
        c.moveToFirst();
        do {
            id = c.getInt(1);            
            name = c.getString(2);
            description = c.getString(3);            
            listaEjercicios.add(new Ejercicio(id,name,descriptio,"",0));
        } while (c.moveToNext()); 
        c.close();
    } catch (Exception e) {
        Log.e("tle99", e.getMessage());

        
    }
    return listaEjercicios;
}
