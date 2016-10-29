package com.itsmarta.apps.martaforeveryone.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.itsmarta.apps.martaforeveryone.R;
import com.itsmarta.apps.martaforeveryone.models.Train;

import java.util.ArrayList;

/**
 * Created by violetaria on 10/29/16.
 */

public class ScheduleAdapter extends ArrayAdapter<Train> {
    // View lookup cache
    private static class ViewHolder {
        TextView tvStationName;
        TextView tvETA;
        TextView tvDirection;
    }

    public ScheduleAdapter(Context context, ArrayList<Train> users) {
        super(context, R.layout.item_train, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Train train = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_train, parent, false);
            viewHolder.tvStationName = (TextView) convertView.findViewById(R.id.tvStationName);
            viewHolder.tvETA = (TextView) convertView.findViewById(R.id.tvETA);
            viewHolder.tvDirection = (TextView) convertView.findViewById(R.id.tvDirection);
            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        viewHolder.tvStationName.setText(train.getStation());
        viewHolder.tvETA.setText(train.getWaitingTime()); // TODO fix this
        viewHolder.tvDirection.setText(train.getDirection());
        // Return the completed view to render on screen
        return convertView;
    }
}
