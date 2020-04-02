package net.androidbootcamp.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class Vendor_Items_Adapter extends RecyclerView.Adapter<Vendor_Items_Adapter.MyViewHolder> {
    private static ArrayList<String> stores;
    WeakReference<Context> mContextWeakReference;

    public Vendor_Items_Adapter(ArrayList<String> studentList, Context context) {
        Pickup_Adapter.studentList = studentList;
        this.mContextWeakReference = new WeakReference<Context>(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = mContextWeakReference.get();

        if (context != null) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user_item, parent, false);
            return new MyViewHolder(itemView, context);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Context context = mContextWeakReference.get();
        if (context == null) {
            return;
        }
        Students_Information currentUser = studentList.get(position);
        holder.vehiclePlateNumber.setText(currentUser.getStudentFName() + " " + currentUser.getStudentLName());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    //holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView vehiclePlateNumber;
        public LinearLayout ll;

        public MyViewHolder(View itemView, final Context context) {
            super(itemView);
            vehiclePlateNumber = itemView.findViewById(R.id.pickup_vehicle_tag_number);
            ll = itemView.findViewById(R.id.ll_layout);

            ll.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    ((Pickup_Activity) context).userItemClick(getAdapterPosition());
                }
            });
        }
    }
}