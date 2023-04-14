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
            listaEjercicios.add(new Ejercicio(id,name,description,"",0));
        } while (c.moveToNext()); 
        c.close();
    } catch (Exception e) {
        Log.e("tle99", e.getMessage());
        llenaListaEjercicios()
        
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
