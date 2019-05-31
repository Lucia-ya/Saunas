package com.luciaya.saunas.Helper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luciaya.saunas.R;
import com.luciaya.saunas.TestData.Sauna;

import java.util.List;

public class PromotionsAdapter extends RecyclerView.Adapter<PromotionsAdapter.PromotionsHolder> {

    private static final String TAG = "PromotionsAdapter";
    Context mContext;
    List<Sauna> saunas;
    public PromotionsAdapter(Context applicationContext, List<Sauna> saunas) {
        this.mContext = applicationContext;
        this.saunas = saunas;
    }

    @Override
    public PromotionsAdapter.PromotionsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        //        return new ContactHolder(layoutInflater, parent);
        View itemView = LayoutInflater.
                from(mContext).inflate(R.layout.list_item_promotions, parent, false);
        return new PromotionsAdapter.PromotionsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PromotionsAdapter.PromotionsHolder holder, int position) {
        Sauna sauna = saunas.get(position);
        holder.bind(sauna);
    }

    @Override
    public int getItemCount() {
        if (saunas.isEmpty()) {
            return 0;
        }
        return saunas.size();
    }

    public void setSaunas(List<Sauna> saunas) { //закрепляем данные в адаптере перед отображением
        this.saunas.clear();
        this.saunas.addAll(saunas);
    }


    public class PromotionsHolder extends RecyclerView.ViewHolder {


        public PromotionsHolder(View itemView) {
            super(itemView);

        }

        public void bind(Sauna sauna) {
        }
    }
}
