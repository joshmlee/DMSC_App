package css188.drake.myapplication2;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by clayton on 9/12/16.
 */
public class UserAdapter extends BaseAdapter{
    private Context myContext;
    private User[] myUsers;

    public UserAdapter(Context context, User[] users)
    {
        myContext = context;
        myUsers = users;
    }


    @Override
    public int getCount() {
        return myUsers.length;
    }

    @Override
    public Object getItem(int position) {
        return myUsers[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null)
        {
            convertView = LayoutInflater.from(myContext).inflate(R.layout.user_list_item, null);

            holder = new ViewHolder();
            holder.nameView = (TextView) convertView.findViewById(R.id.nameView);
            //3rd add holder.dateView then find by id
            holder.spaceView = (TextView) convertView.findViewById(R.id.spaceView);
            holder.dateTimeView = (TextView) convertView.findViewById(R.id.dateTimeView);
            holder.userCell = (RelativeLayout) convertView.findViewById(R.id.userCell);

            convertView.setTag(holder);
        }
        else{
            holder= (ViewHolder) convertView.getTag();
        }

        User user = myUsers[position];

        holder.nameView.setText(user.getName());
        holder.spaceView.setText(user.getSpace());
        holder.dateTimeView.setText(user.getDateTime());

        //4th then you can set the text in the view

        if(user.getColor().toString().equals("Green"))
        {
          holder.userCell.setBackgroundColor(ContextCompat.getColor(myContext, R.color.greenColor));
        }

        if(user.getColor().toString().equals("Blue"))
        {
            holder.userCell.setBackgroundColor(ContextCompat.getColor(myContext, R.color.blueColor));
        }
        if(user.getColor().toString().equals("Red")) {
            holder.userCell.setBackgroundColor(ContextCompat.getColor(myContext, R.color.redColor));
        }
        if(user.getColor().toString().equals("White")) {
            holder.userCell.setBackgroundColor(ContextCompat.getColor(myContext, R.color.whiteColor));
        }

        return convertView;
    }

    private static class ViewHolder {
        TextView nameView;
        //2nd create another TextView dateView...etc
        TextView spaceView;
        TextView dateTimeView;
        RelativeLayout userCell;
    }
}
