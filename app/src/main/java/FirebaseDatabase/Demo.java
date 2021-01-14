package FirebaseDatabase;

import android.os.Bundle;

import com.example.myapplication.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Demo {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    protected void onCreate(Bundle savedInstanceState) {
        myRef.setValue("Hello, World!");
    }

}
