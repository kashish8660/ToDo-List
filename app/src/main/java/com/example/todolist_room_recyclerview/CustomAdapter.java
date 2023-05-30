package com.example.todolist_room_recyclerview;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.sql.Array;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private static ArrayList<Task> localDataSet;
    private TextView textView;
    private TextView textView2;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            view.setOnClickListener((this));
        }

        @Override
        public void onClick(View v) {
            int position = this.getAdapterPosition(); //used to get position of item in Adapter(when not given by function(onBindViewHolder() gives it)
            Task task = localDataSet.get(position); //
            Toast.makeText(v.getContext(), "Topic is "+task.getTopic(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(v.getContext(), Edit_Task_Activity.class);
            String topic = task.getTopic();
            String description = task.getDescription();
            intent.putExtra("topic", topic);
            intent.putExtra("description", description);
            v.getContext().startActivity(intent);
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public CustomAdapter(ArrayList<Task> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.task_layout, viewGroup, false);
        textView = (TextView) view.findViewById(R.id.textView);
        textView2 = (TextView) view.findViewById(R.id.textView2);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        textView.setText(localDataSet.get(position).getTopic());
        textView2.setText(localDataSet.get(position).getDescription());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
