package com.luciaya.saunas.Helper;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.luciaya.saunas.R;
import com.luciaya.saunas.TestData.Sauna;
import com.luciaya.saunas.View.MainActivity;

import java.util.List;

public class SaunaAdapter extends RecyclerView.Adapter<SaunaAdapter.ContactHolder> { //класс адаптера
    private List<Sauna> mSaunas;
    private List<Sauna> mSaunasFiltered;

    public SaunaAdapter(List<Sauna> saunas) { //конструктор адаптера
        mSaunas = saunas;
        mSaunasFiltered = mSaunas;

    }

    @Override
    public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).inflate(R.layout.list_item_catalog, parent, false);
        Log.d("onCreateViewHold", "вызван");
        return new ContactHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactHolder holder, int position) {
        Sauna sauna = mSaunasFiltered.get(position);
        holder.bind(sauna);
    }

    @Override
    public int getItemCount() {
        if (mSaunasFiltered.isEmpty()) {
            return 0;
        }
        return mSaunasFiltered.size();
    }

    public void setSaunas(List<Sauna> saunas) { //закрепляем данные в адаптере перед отображением
        this.mSaunasFiltered.clear();
        this.mSaunasFiltered.addAll(saunas);
    }

    //создание ViewHolder - управляет одним элементом в списке
    public final static class ContactHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Sauna mSauna;
        private ImageView saunaOfMonthImage;
        private TextView saunaOfMonthText;
        private TextView saunaName;
        private RecyclerView mRecyclerView;
        private TextView price;
        private RecyclerView imagesRecyclerView;
        private TextView numOfPeoples;
        private TextView numOfHours;
        private TextView address;
        private ImageButton openOnMap;
        private ImageButton addToFavorite;
        private LinearLayout call;

        public ContactHolder(View itemView) {
            super(itemView);
            saunaOfMonthImage = (ImageView)itemView.findViewById(R.id.star_of_month);
            saunaOfMonthText = (TextView) itemView.findViewById(R.id.text_of_month_catalog);
            saunaName = (TextView) itemView.findViewById(R.id.catalog_sauna_name);
            imagesRecyclerView = (RecyclerView) itemView.findViewById(R.id.image_recycler_view_catalog);
            imagesRecyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
            price = (TextView) itemView.findViewById(R.id.sauna_price_catalog);
            numOfPeoples = (TextView) itemView.findViewById(R.id.num_of_peoples_catalog);
            numOfHours = (TextView) itemView.findViewById(R.id.num_of_hours_catalog);
            address = (TextView) itemView.findViewById(R.id.address_text_catalog);
            openOnMap = (ImageButton) itemView.findViewById(R.id.open_on_map_catalog);
            addToFavorite = (ImageButton) itemView.findViewById(R.id.favorite_button_cat);
            call = (LinearLayout) itemView.findViewById(R.id.call_catalog);
            itemView.setOnClickListener(this); //назначаем слушатель
        }

        public void bind(Sauna sauna) {
            mSauna = sauna;
            if (mSauna.isSauna_of_month()) {
                saunaOfMonthImage.setVisibility(View.VISIBLE);
                saunaOfMonthText.setVisibility(View.VISIBLE);
            } else {
                saunaOfMonthImage.setVisibility(View.GONE);
                saunaOfMonthText.setVisibility(View.GONE);
            }
            saunaName.setText(mSauna.getName());
            imagesRecyclerView.setAdapter(new ImageAdapter(mSauna.getImagesUrl()));
            price.setText(mSauna.getPrice() + " рублей в час");
            numOfPeoples.setText("до " + mSauna.getNumber_of_persons() + " человек");
            numOfHours.setText("до " + mSauna.getNumber_of_hours() + " часов");
            address.setText(mSauna.getAddress());
        }

        @Override
        public void onClick(View view) { //если кликаем на объекте - передаем интент с жтим контактом в ContactPagerActivity
            ((MainActivity) view.getContext()).onTouchItem(mSauna.getUUID());
        }
    }


}