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
    private User[] featured;
    private User[] today;
    private User[] tomorrow;
    private User[] nextWk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        my_button = (Button) findViewById(R.id.button);
//        edit_text = (EditText) findViewById(R.id.editText);

//        User clayton = new User();
//        clayton.setName("Clayton");
//        clayton.setSpace("Des Moines");
//        clayton.setColor("White");
//
//        User jeff = new User();
//        jeff.setName("Jeff");
//        clayton.setSpace("Des Moines");
//        jeff.setColor("White");
//
//        User joe = new User();
//        joe.setName("Jeff");
//        joe.setSpace("Des Moines");
//        joe.setColor("White");
//
//        User josh = new User();
//        josh.setName("Josh\nDrake University\n\n9/21 | 5:00pm");
//        clayton.setSpace("Des Moines");
//        clayton.setDateTime("9/22 | 7:00pm");
//        josh.setColor("White");
//        //hi there
//        //hello

        //featured events
        User featured1 = new User();
        featured1.setTitle("Pilates Class");
        featured1.setSpace("The Basement");
        featured1.setDateTime("9/26 | 9:00 A.M.");
        featured1.setImagePath("");

        User featured2 = new User();
        featured2.setTitle("Hand to God By Robert Askins");
        featured2.setSpace("Viaduct Gallery");
        featured2.setDateTime("9/26 | 5:00 P.M.");
        //featured2.setImagePath("");

        User featured3 = new User();
        featured3.setTitle("Team Trivia");
        featured3.setSpace("The Basement");
        featured3.setDateTime("9/27 | 7:30 P.M.");
        //featured3.setImagePath("");

        User featured4 = new User();
        featured4.setTitle("The Des Moines Jazz Festival");
        featured4.setSpace("Malo");
        featured4.setDateTime("9/28 | 6:00 P.M.");
        //featured4.setImagePath("");


        //today
        User today1 = new User();
        today1.setTitle("Pilates Class");
        today1.setSpace("The Basement");
        today1.setDateTime("9/26 | 9:00 A.M.");
        //today1.setImagePath("");

        User today2 = new User();
        today2.setTitle("Hand to God By Robert Askins");
        today2.setSpace("Viaduct Gallery");
        today2.setDateTime("9/26 | 5:00 P.M.");
        //today2.setImagePath("");

        User today3 = new User();
        today3.setTitle("Board Game Night");
        today3.setSpace("The Basement");
        today3.setDateTime("9/26 | 7:00 P.M.");
        //today3.setImagePath("");

        User today4 = new User();
        today4.setTitle("CHIFFON / Typ-O / Hannah Keisker");
        today4.setSpace("Kum & Go Theater");
        today4.setDateTime("9/26 | 8:00 P.M.");
        //today4.setImagePath("");


        //tomorrow
        User tomorrow1 = new User();
        tomorrow1.setTitle("Johnny Boyd's \"Cocktails with the Crooner\" Happy Hour");
        tomorrow1.setSpace("Culinary Loft");
        tomorrow1.setDateTime("9/27 | 3:30 P.M.");
        //tomorrow1.setImagePath("");

        User tomorrow2 = new User();
        tomorrow2.setTitle("Hope Arthur + Dang Felton");
        tomorrow2.setSpace("Kum & Go Theater");
        tomorrow2.setDateTime("9/27 | 5:00 P.M.");
        //tomorrow2.setImagePath("");

        User tomorrow3 = new User();
        tomorrow3.setTitle("Team Trivia");
        tomorrow3.setSpace("The Basement");
        tomorrow3.setDateTime("9/27 | 7:30 P.M.");
        //tomorrow3.setImagePath("");

        User tomorrow4 = new User();
        tomorrow4.setTitle("Ola Fresca with Salsa Des Moines Class");
        tomorrow4.setSpace("The Basement");
        tomorrow4.setDateTime("9/27 | 8:00 P.M.");
        //tomorrow4.setImagePath("");


        //next week
        User nextWeek1 = new User();
        nextWeek1.setTitle("The Basement Presents: NRBQ + Los Straitjackets");
        nextWeek1.setSpace("The Basement");
        nextWeek1.setDateTime("9/29 | 9:00 P.M.");
        //nextWeek1.setImagePath("");

        User nextWeek2 = new User();
        nextWeek2.setTitle("Death Of A Salesman");
        nextWeek2.setSpace("Kum & Go Theater");
        nextWeek2.setDateTime("9/30 | 7:00 P.M.");
        //nextWeek2.setImagePath("");

        User nextWeek3 = new User();
        nextWeek3.setTitle("World Food & Music Week: The Dhol Foundation");
        nextWeek3.setSpace("Culinary Loft");
        nextWeek3.setDateTime("8/1 | 9:00 P.M.");
        //nextWeek3.setImagePath("");

        User nextWeek4 = new User();
        nextWeek4.setTitle("Firehouse Flea");
        nextWeek4.setSpace("Kum & Go Theater");
        nextWeek4.setDateTime("8/2 | 10:00 A.M.");
        //nextWeek4.setImagePath("");

        featured = new User[]{featured1,featured2,featured3,featured4};

        today = new User[]{today1,today2,today3,today4};

        tomorrow = new User[]{tomorrow1,tomorrow2,tomorrow3,tomorrow4};

        nextWk = new User[]{nextWeek1,nextWeek2,nextWeek3,nextWeek4};

        //pass in the 4 user arrays
        UserAdapter adapter = new UserAdapter(this, featured, today, tomorrow, nextWk);
        setListAdapter(adapter);

//        my_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.v("CS188", "Hello");
//                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_LONG).show();
//
//                String input = edit_text.getText().toString();
//
//                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
//                intent.putExtra("value", input);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String name = featured[position].getTitle().toString();
        String color = "White";

        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("value", name);
        intent.putExtra("color", color);

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation
                (MainActivity.this, v.findViewById(R.id.userCell), "cell");

        startActivity(intent, options.toBundle());
    }
}
