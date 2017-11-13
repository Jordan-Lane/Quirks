package cmput301f17t12.quirks.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import cmput301f17t12.quirks.Activities.EditQuirkActivity;
import cmput301f17t12.quirks.Activities.EventListActivity;
import cmput301f17t12.quirks.Activities.QuirksActivity;
import cmput301f17t12.quirks.Models.Event;
import cmput301f17t12.quirks.Models.EventList;
import cmput301f17t12.quirks.R;

public class EventListItemAdapter extends BaseAdapter implements ListAdapter{
    private EventList eventList = new EventList();
    private Context context;

    public EventListItemAdapter(EventList eventList, Context context) {
        this.eventList = eventList;
        this.context = context;
    }

    @Override
    public int getCount(){ return eventList.getList().size(); }

    @Override
    public Object getItem(int i){ return eventList.getEvent(i); }

    @Override //Not sure if this needs to be changed
    public long getItemId(int i){ return 0; }

    @Override //TODO:
    public View getView(final int pos, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.event_item, null);
        }

        Event eventItem = eventList.getEvent(pos);

        // Set item title to event comment
        TextView eventHeader = (TextView) view.findViewById(R.id.el_eventcomment);
        eventHeader.setText(eventItem.getComment());

        // Delete event button
        ImageButton eventView = (ImageButton) view.findViewById(R.id.el_eventview);
        eventView.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (context instanceof EventListActivity) {
                    ((EventListActivity)context).launchEditEvent(pos);
                }
            }
        });




        return view;
    }


}