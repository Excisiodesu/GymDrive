package com.mtqn.gymdrive;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CommandAdapter extends RecyclerView.Adapter<CommandAdapter.CommandViewHolder> {

    private ArrayList<CommandItem> commandItems;

    public static class CommandViewHolder extends RecyclerView.ViewHolder{

        public ImageView commandIcon;

        public ImageView removeOne;
        public ImageView addOne;
        public ImageView delete;

        public TextView commandName;
        public TextView commandPrice;
        public TextView commandCount;


        public CommandViewHolder(@NonNull View itemView) {
            super(itemView);

            commandIcon = itemView.findViewById(R.id.iv_command_item_icon);

            removeOne = itemView.findViewById(R.id.btn_remove_one);
            addOne = itemView.findViewById(R.id.btn_add_one);
            delete = itemView.findViewById(R.id.btn_delete);

            commandName = itemView.findViewById(R.id.ic_command_item_name);
            commandPrice = itemView.findViewById(R.id.ic_command_item_price);
            commandCount = itemView.findViewById(R.id.tw_item_count);
        }
    }

    public CommandAdapter(ArrayList<CommandItem> commandList){
        commandItems = commandList;
    }


    @NonNull
    @Override
    public CommandViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.commande_item, viewGroup, false);
        CommandViewHolder cvh = new CommandViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CommandViewHolder commandViewHolder, int i) {
        CommandItem currentItem = commandItems.get(i);

        commandViewHolder.commandIcon.setImageResource(currentItem.GetImageResource());
        commandViewHolder.commandName.setText(currentItem.GetName());
        commandViewHolder.commandPrice.setText(Float.toString(currentItem.GetPrice()) + "€");
        commandViewHolder.commandCount.setText(Integer.toString(currentItem.GetCount()));
    }

    @Override
    public int getItemCount() {
        return commandItems.size();
    }
}
