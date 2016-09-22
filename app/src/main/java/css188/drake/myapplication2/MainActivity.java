package css188.drake.myapplication2;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    private Button my_button;
    private EditText edit_text;
    private User[] users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_button = (Button) findViewById(R.id.button);
//        edit_text = (EditText) findViewById(R.id.editText);

        User clayton = new User();
        clayton.setName("Clayton");
        clayton.setSpace("Des Moines");
        clayton.setColor("White");

        User jeff = new User();
        jeff.setName("Jeff");
        clayton.setSpace("Des Moines");
        jeff.setColor("White");

        User josh = new User();
        josh.setName("Josh\nDrake University\n\n9/21 | 5:00pm");
        clayton.setSpace("Des Moines");
        clayton.setDateTime("9/22 | 7:00pm");
        josh.setColor("White");

        users = new User[]{clayton, jeff, josh};

        UserAdapter adapter = new UserAdapter(this, users);
        setListAdapter(adapter);

        my_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("CS188", "Hello");
                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_LONG).show();

                String input = edit_text.getText().toString();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("value", input);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String name = users[position].getName().toString();
        String color = users[position].getColor().toString();

        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("value", name);
        intent.putExtra("color", color);

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation
                (MainActivity.this, v.findViewById(R.id.userCell), "cell");

        startActivity(intent, options.toBundle());
    }
}
