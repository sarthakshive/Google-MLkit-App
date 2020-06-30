package  inducesmile.com.mlkitpaid;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import inducesmile.com.mlkitpaid.R;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    ArrayList personNames;
    Context context;
    public CustomAdapter(Context context, ArrayList personNames) {
        this.context = context;
        this.personNames = personNames;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(CustomAdapter.MyViewHolder holder, final int position) {
        // set the data in items
        holder.name.setText(personNames.get(position).toString());
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                //Toast.makeText(context, personNames.get(position).toString(), Toast.LENGTH_SHORT).show();
                Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.paytmmall");
                String sss= personNames.get(position).toString();
                intent.putExtra("query",  sss);

                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  // opens a new "page" instead of overlapping the same app
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return personNames.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;// init the item view's
        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name);
        }
    }
}