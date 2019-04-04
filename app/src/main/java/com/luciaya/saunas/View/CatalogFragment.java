package com.luciaya.saunas.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luciaya.saunas.R;
import com.luciaya.saunas.TestData.Sauna;

import java.util.List;

public class CatalogFragment extends android.support.v4.app.Fragment {

    private SearchView mSearchView;
    private RecyclerView mRecyclerView;
    private SaunaAdapter mAdapter;

    public CatalogFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catalog, container, false);
        mSearchView = (SearchView) view.findViewById(R.id.search_view_catalog);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_catalog);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    //создание ViewHolder - управляет одним элементом в списке
    private class ContactHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Sauna mSauna;

        public ContactHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_catalog, parent, false));
            itemView.setOnClickListener(this); //назначаем слушатель
        }

        public void bind(Sauna sauna) {
            mSauna = sauna;
        }


        @Override
        public void onClick(View view) { //если кликаем на объекте - передаем интент с жтим контактом в ContactPagerActivity
//            Intent intent = SaunaPagerActivity.newIntent(getActivity(), mContact.getContactId());
//            startActivity(intent);
        }
    }


    private class SaunaAdapter extends RecyclerView.Adapter<ContactHolder> { //класс адаптера
        private List<Sauna> mSaunas;
        private List<Sauna> mSaunasFiltered;

        public SaunaAdapter(List<Sauna> saunas) { //конструктор адаптера
            mSaunas = saunas;
            mSaunasFiltered = mSaunas;

        }

        @Override
        public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            Log.d("onCreateViewHold", "вызван");
            return new ContactHolder(layoutInflater, parent);
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


    }
}
