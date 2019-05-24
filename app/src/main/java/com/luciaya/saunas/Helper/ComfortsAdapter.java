package com.luciaya.saunas.Helper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.luciaya.saunas.R;

import java.util.List;

public class ComfortsAdapter extends RecyclerView.Adapter<ComfortsAdapter.ComfortHolder> {
    private List<String> comforts;
    private Context context;

    public ComfortsAdapter(Context context, List<String> comforts) {
        this.comforts = comforts;
        this.context = context;
    }

    public void setComforts(List<String> comforts) {
        this.comforts.clear();
        this.comforts.addAll(comforts);
    }

    @NonNull
    @Override
    public ComfortsAdapter.ComfortHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(context).inflate(R.layout.list_item_comfort, parent, false);
        return new ComfortsAdapter.ComfortHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ComfortsAdapter.ComfortHolder holder, int position) {
        String comfort = comforts.get(position);
        holder.bind(comfort);
    }

    @Override
    public int getItemCount() {
        if (comforts.isEmpty()) {
            return 0;
        }
        return comforts.size();
    }

    public class ComfortHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private String comfort;
        private TextView text;
        private ImageButton checked;
        private boolean isChecked = false;
        public ComfortHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.comfort_item_name);
            checked = itemView.findViewById(R.id.comfort_item_checked_button);
            checked.setOnClickListener(this);
        }

        public void bind(String comfort) {
            this.comfort = comfort;
            text.setText(comfort);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.comfort_item_checked_button:
                    if (!isChecked) {
                        checked.setImageResource(R.drawable.comforts_checked);
                        isChecked = true;
                    } else {
                        checked.setImageResource(R.drawable.comforts_unchecked);
                        isChecked = false;
                    }
            }
        }
    }
}
