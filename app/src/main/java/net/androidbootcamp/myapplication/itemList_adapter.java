package net.androidbootcamp.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
    //public itemList_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // return null;
        View view = LayoutInflater.from(context).inflate(R.layout.inventory_rv, parent, false);
        return new ViewHolder(view);
    }


    //  public void onBindViewHolder(@NonNull itemList_adapter.ViewHolder holder, int position) {
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            item_prices = itemView.findViewById(R.id.item_prices);
            item_pic = itemView.findViewById(R.id.item_pic);
            item_quantity = itemView.findViewById(R.id.item_quantity);
            prod_type = itemView.findViewById(R.id.prod_type);
        }//end ViewHolder

        public void bind(Product inv) {

            item_name.setText(inv.getpro_name());
            item_prices.setText("$ " + inv.getpro_price());
            item_quantity.setText("Qty. " + inv.getpro_quantity());
            prod_type.setText(inv.getpro_type());
        }//end bind
    }

}//end class viewholder
