package net.androidbootcamp.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import net.androidbootcamp.myapplication.ui.store_home.HomeFragment;

import java.util.List;

public class itemList_adapter extends RecyclerView.Adapter<itemList_adapter.ViewHolder> {
    private Context context;
    private List<Product> store_inv;

    public itemList_adapter(Context context, List<Product> store_inv) {
        this.context = context;
        this.store_inv = store_inv;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.inventory_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product inv = store_inv.get(position);
        holder.bind(inv);
    }

    public void clear() {
        store_inv.clear();
        notifyDataSetChanged();
    }//end clear

    public void addAll(List<Product> inv) {
        store_inv.addAll(inv);
        notifyDataSetChanged();
    }//end addAll

    @Override
    public int getItemCount() {
        return store_inv.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView item_name;
        private TextView item_prices;
        private ImageView item_pic;
        private TextView prod_type;
        private TextView item_quantity;
        private ImageButton deleteBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            item_prices = itemView.findViewById(R.id.item_prices);
            item_pic = itemView.findViewById(R.id.item_pic);
            item_quantity = itemView.findViewById(R.id.item_quantity);
            prod_type = itemView.findViewById(R.id.prod_type);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);

        }//end ViewHolder

        public void bind(final Product inv) {

            item_name.setText(inv.getpro_name());
            item_prices.setText("$ " + inv.getpro_price());
            item_quantity.setText("Qty. " + inv.getpro_quantity());
            prod_type.setText(inv.getpro_type());

            ParseFile img = inv.getimg();
            if (img != null) {
                Glide.with(context)
                        .load(img.getUrl())
                        .into(item_pic);
            } else {
                Glide.with(context)
                        .load(R.drawable.ic_menu_camera)
                        .into(item_pic);
            }//end else
            //ref delete button
            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    inv.deleteInBackground();
                    inv.saveInBackground();
                    removeAt(getAdapterPosition());

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    Fragment myFragment = new HomeFragment();
                    activity.getSupportFragmentManager()
                            .beginTransaction().replace(R.id.nav_host_fragment, myFragment)
                            .commit();
                }
            });
        }//end bind

        public void removeAt(int position) {
            store_inv.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, store_inv.size());
        }//end removeAt
    }
}//end class viewholder
