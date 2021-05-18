package bankpros.com;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME="customerinfo.db";
    private static final int DATABASE_VERSION=1;

    public DatabaseOpenHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select * from "+DATABASE_NAME,null);
    }
}
