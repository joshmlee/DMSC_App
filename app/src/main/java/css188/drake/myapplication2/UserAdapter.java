package css188.drake.myapplication2;

import android.content.Context;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import static java.lang.System.out;
import java.util.ArrayList;

/**
 * Created by clayton on 9/12/16.
 */
public class UserAdapter extends BaseAdapter{
    private Context myContext;
    private User[] featured;
    private User[] today;
    private User[] tomorrow;
    private User[] nextWk;
    private ArrayList<User> events = new ArrayList<User>();
    //arraylist to append featured, today, tomorrow, nextweek and headers to

    public UserAdapter(Context context, User[] feat, User[] tod, User[] tom, User[] next)
    {
        myContext = context;
        featured = feat;
        today = tod;
        tomorrow = tom;
        nextWk = next;
        //change so the dates line up

        User header1 = new User();
        header1.setHeader(true);
        header1.setTitle("Featured");
        header1.setDateTime("");
        header1.setSpace("");
        header1.setImagePath("");
        events.add(header1);
        for (int i=0;i<featured.length;i++){
            events.add(featured[i]);
        }

        User header2 = new User();
        header2.setHeader(true);
        header2.setTitle("Today");
        header2.setDateTime("");
        header2.setSpace("");
        header2.setImagePath("");
        events.add(header2);
        for (int i=0;i<today.length;i++){
            events.add(today[i]);
        }

        User header3 = new User();
        header3.setHeader(true);
        header3.setTitle("Tomorrow");
        header3.setDateTime("");
        header3.setSpace("");
        header3.setImagePath("");
        events.add(header3);
        for (int i=0;i<tomorrow.length;i++){
            events.add(tomorrow[i]);
        }

        User header4 = new User();
        header4.setHeader(true);
        header4.setTitle("Next Week");
        header4.setDateTime("");
        header4.setSpace("");
        header4.setImagePath("");
        events.add(header4);
        for (int i=0;i<nextWk.length;i++){
            events.add(nextWk[i]);
        }

    }


    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object getItem(int position) {
        return events.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        //change the array to arraylist
        User event = events.get(position);

        if(convertView == null)
        {
            holder = new ViewHolder();
            //if it's a header then inflate user_list_item

//            convertView = LayoutInflater.from(myContext).inflate(R.layout.user_list_item, null);
//            holder.titleView = (TextView) convertView.findViewById(R.id.titleView);
//            holder.spaceView = (TextView) convertView.findViewById(R.id.spaceView);
//            holder.dateTimeView = (TextView) convertView.findViewById(R.id.dateTimeView);
//            holder.userCell = (RelativeLayout) convertView.findViewById(R.id.userCell);

            if(event.isHeader()){
                convertView = LayoutInflater.from(myContext).inflate(R.layout.user_list_header, null);
                holder.headerView = (TextView) convertView.findViewById(R.id.headerView);
            }
            else{
                //create a new user_list_item layout called user_list_header
                //set our certain layout items in the corresponding file
                //3rd add holder.dateView then find by id
                convertView = LayoutInflater.from(myContext).inflate(R.layout.user_list_item, null);
                holder.titleView = (TextView) convertView.findViewById(R.id.titleView);
                holder.spaceView = (TextView) convertView.findViewById(R.id.spaceView);
                holder.dateTimeView = (TextView) convertView.findViewById(R.id.dateTimeView);
                holder.userCell = (RelativeLayout) convertView.findViewById(R.id.userCell);
            }

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        //check to see if it is header
        //set the certain text values for the corresponding files
        //4th then you can set the text in the view
//        System.out.println(event.getTitle());
//        holder.titleView.setText(event.getTitle());
//        holder.spaceView.setText(event.getSpace());
//        holder.dateTimeView.setText(event.getDateTime());

        if(event.isHeader()){
            holder.headerView.setText(event.getTitle());
            holder.headerView.setBackgroundColor(ContextCompat.getColor(myContext, R.color.lightGreenColor));
        }
        else{
            //check to see if it is header
            //set the certain text values for the corresponding files
            //4th then you can set the text in the view
            System.out.println(event.getTitle());
            holder.titleView.setText(event.getTitle());
            holder.spaceView.setText(event.getSpace());
            holder.dateTimeView.setText(event.getDateTime());
            holder.userCell.setBackgroundColor(ContextCompat.getColor(myContext, R.color.whiteColor));
        }


//        if(event.getColor().toString().equals("Green"))
//        {
//          holder.userCell.setBackgroundColor(ContextCompat.getColor(myContext, R.color.greenColor));
//        }
//
//        if(event.getColor().toString().equals("Blue"))
//        {
//            holder.userCell.setBackgroundColor(ContextCompat.getColor(myContext, R.color.blueColor));
//        }
//        if(event.getColor().toString().equals("Red")) {
//            holder.userCell.setBackgroundColor(ContextCompat.getColor(myContext, R.color.redColor));
//        }
//        if(event.getColor().toString().equals("White")) {
//            holder.userCell.setBackgroundColor(ContextCompat.getColor(myContext, R.color.whiteColor));
//        }

        return convertView;
    }

    private static class ViewHolder {
        TextView titleView;
        //2nd create another TextView dateView...etc
        TextView spaceView;
        TextView dateTimeView;
        TextView headerView;
        RelativeLayout userCell;
    }
}
