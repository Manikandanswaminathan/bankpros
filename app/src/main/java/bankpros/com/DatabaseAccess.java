package bankpros.com;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {
    private final SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c=null;

    private DatabaseAccess(Context context){
        this.openHelper=new DatabaseOpenHelper(context);

    }

    public static DatabaseAccess getInstance(Context context){
        if(instance==null){
            instance=new DatabaseAccess(context);
        }
        return instance;
    }
    public void open(){
        this.db=openHelper.getWritableDatabase();
    }
    public  void close(){
        if(db!=null){
            this.db.close();
        }
    }
    public String getEMAIL(String USERNAME){
        c=db.rawQuery("select email from customerinfo where USERNAME='"+USERNAME+"'",new String[]{});
        StringBuilder buffer=new StringBuilder();
        while (c.moveToNext()){
            String EMAIL=c.getString(0);
            buffer.append("").append(EMAIL);

        }
        return buffer.toString();
    }
}
