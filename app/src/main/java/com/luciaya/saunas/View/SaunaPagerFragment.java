package com.luciaya.saunas.View;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.luciaya.saunas.Helper.ImageAdapter;
import com.luciaya.saunas.R;
import com.luciaya.saunas.TestData.Sauna;
import com.luciaya.saunas.TestData.SaunaLab;

import java.util.UUID;

public class SaunaPagerFragment extends Fragment implements View.OnClickListener, OnMapReadyCallback, GoogleMap.OnMapClickListener {
    private Sauna mSauna;
    private static final String ARG_SAUNA_ID = "sauna_id";
    private final String TAG = "SaunaPagerFragment";
    private ImageView starOfMonth;
    private TextView textOfMonth;
    private TextView nameOfSauna;
    private RecyclerView imageRecyclerView;
    private LinearLayout inFavoriteButton;
    private LinearLayout shareButton;
    private TextView price;
    private TextView romminess;
    private TextView minTime;
    private TextView workingHours;
    private TextView description;
    private TextView rentDescription;
    private TextView address;
    private MapView mapView;
    private ImageView firstReviewLike;
    private ImageView firstViewDislike;
    private TextView firstreviewName;
    private TextView firstReviewDate;
    private TextView firstReview;
    private View firstReviewLine;
    private ImageView secondReviewLike;
    private ImageView secondViewDislike;
    private TextView secondreviewName;
    private TextView secondReviewDate;
    private TextView secondReview;
    private TextView noReviews;
    private Button takeReview;
    private ImageView firstSaunaBesideImage;
    private TextView firstSaunaBesideName;
    private TextView firstSaunaBesideAddress;
    private ImageView secondSaunaBesideImage;
    private TextView secondSaunaBesideName;
    private TextView secondSaunaBesideAddress;

    private boolean mapsSupported;

    private GoogleMap googleMap;

    private Bundle mapViewBundle = null;



    public static SaunaPagerFragment newInstance(UUID saunaId) { //принимаем параметры от активности
        Bundle args = new Bundle();
        args.putSerializable(ARG_SAUNA_ID, saunaId);
        SaunaPagerFragment fragment = new SaunaPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID saunaId = (UUID) getArguments().getSerializable(ARG_SAUNA_ID);
        mSauna = SaunaLab.get().getSauna(saunaId);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        View view = inflater.inflate(R.layout.fragment_pager_sauna, container, false);

        starOfMonth = (ImageView) view.findViewById(R.id.sauna_star_of_month);
        textOfMonth = (TextView) view.findViewById(R.id.sauna_text_of_month);
        nameOfSauna = (TextView) view.findViewById(R.id.item_sauna_name);
        imageRecyclerView = (RecyclerView) view.findViewById(R.id.image_recycler_view_item);
        imageRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        inFavoriteButton = (LinearLayout) view.findViewById(R.id.item_in_favorite);
        shareButton = (LinearLayout) view.findViewById(R.id.share_item);
        price = view.findViewById(R.id.item_sauna_price);
        romminess = view.findViewById(R.id.item_sauna_roominess);
        minTime = view.findViewById(R.id.item_minimum_time);
        workingHours = view.findViewById(R.id.item_working_hours);
        description = view.findViewById(R.id.item_description);
        rentDescription = view.findViewById(R.id.item_rent_descriptions);
        address = view.findViewById(R.id.item_address_text);
        mapView = view.findViewById(R.id.item_mapView);
        firstReviewLike = view.findViewById(R.id.item_like);
        firstViewDislike = view.findViewById(R.id.item_dislike);
        firstreviewName = view.findViewById(R.id.item_first_review_name);
        firstReviewDate = view.findViewById(R.id.item_first_review_data);
        firstReview = view.findViewById(R.id.item_first_review_description);
        firstReviewLine = view.findViewById(R.id.item_line_first_review);
        secondReviewLike = view.findViewById(R.id.item_like_second);
        secondViewDislike = view.findViewById(R.id.item_dislike_second);
        secondreviewName = view.findViewById(R.id.item_second_review_name);
        secondReviewDate = view.findViewById(R.id.item_second_review_data);
        secondReview = view.findViewById(R.id.item_second_review_description);
        noReviews = view.findViewById(R.id.item_text_no_reviews);
        takeReview = view.findViewById(R.id.item_button_take_review);
        firstSaunaBesideImage = view.findViewById(R.id.item_first_sauna_beside_img);
        firstSaunaBesideName = view.findViewById(R.id.item_first_sauna_beside_name);
        firstSaunaBesideAddress = view.findViewById(R.id.item_first_sauna_beside_address);
        secondSaunaBesideImage = view.findViewById(R.id.item_second_sauna_beside_img);
        secondSaunaBesideName = view.findViewById(R.id.item_second_sauna_beside_name);
        secondSaunaBesideAddress = view.findViewById(R.id.item_second_sauna_beside_address);

        //передача текста в текстовые поля макета из данных выбранной сауны
        if (!mSauna.isSauna_of_month()) {
            starOfMonth.setVisibility(View.GONE);
            textOfMonth.setVisibility(View.GONE);
        }
        nameOfSauna.setText(mSauna.getName());
        imageRecyclerView.setAdapter(new ImageAdapter(mSauna.getImagesUrl()));
        price.setText(mSauna.getPrice() + " рублей в час");
        romminess.setText("до " + mSauna.getNumber_of_persons() + " человек");
        minTime.setText("от " + mSauna.getNumber_of_hours() + " часов");
        workingHours.setText(mSauna.getWorkingHours());
        description.setText(mSauna.getDescription());
        rentDescription.setText(mSauna.getRentDescription());
        address.setText(mSauna.getAddress());

        if (!mSauna.getReviews().isEmpty()) {

            if (mSauna.getReviews().get(0) != null) {
                noReviews.setVisibility(View.GONE);
                if (mSauna.getReviews().get(0).isLike()) {
                    firstReviewLike.setVisibility(View.VISIBLE);
                    firstViewDislike.setVisibility(View.GONE);
                } else {
                    firstViewDislike.setVisibility(View.VISIBLE);
                    firstReviewLike.setVisibility(View.GONE);
                }
                firstreviewName.setVisibility(View.VISIBLE);
                firstreviewName.setText(mSauna.getReviews().get(0).getName());
                firstReviewDate.setVisibility(View.VISIBLE);
                firstReviewDate.setText(mSauna.getReviews().get(0).getDate());
                firstReview.setVisibility(View.VISIBLE);
                firstReview.setText(mSauna.getReviews().get(0).getDescription());
            }
            if (mSauna.getReviews().get(1) != null) {
                firstReviewLine.setVisibility(View.VISIBLE);
                if (mSauna.getReviews().get(1).isLike()) {
                    secondReviewLike.setVisibility(View.VISIBLE);
                    secondViewDislike.setVisibility(View.INVISIBLE);
                } else {
                    secondViewDislike.setVisibility(View.VISIBLE);
                    secondReviewLike.setVisibility(View.INVISIBLE);
                }
                secondreviewName.setVisibility(View.VISIBLE);
                secondreviewName.setText(mSauna.getReviews().get(1).getName());
                secondReviewDate.setVisibility(View.VISIBLE);
                secondReviewDate.setText(mSauna.getReviews().get(1).getDate());
                secondReview.setVisibility(View.VISIBLE);
                secondReview.setText(mSauna.getReviews().get(1).getDescription());
            }
            takeReview.setOnClickListener(this);
        }

        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);


        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.sauna_fragment, menu);
    }


    //listener for all buttons
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.item_button_take_review:
                Log.d(TAG, "onClick take review: sauna id = " + mSauna.getUUID().toString());
                Intent intent = NewReviewActivity.newIntent(getContext(), mSauna.getUUID());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            default:break;
        }
    }


    //for ggogleMap. Initialize, set Markers etc
    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (googleMap != null) {
            this.googleMap = googleMap;
            //листенер виджета карты
            googleMap.setOnMapClickListener(this);
        }
        MapsInitializer.initialize(this.getActivity());
        LatLng tashkent = new LatLng(41.3167, 69.2500);
        googleMap.addMarker(new MarkerOptions().position(tashkent).title("Ташкент").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tashkent, 15));
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
//listener mapView - show dialog with other MapView
    @Override
    public void onMapClick(LatLng latLng) {
        Log.d(TAG, "onMapClick: on Map clicked");
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View promptView = layoutInflater.inflate(R.layout.fragment_map_sauna_dialog, null);
        alertDialog.setView(promptView);

        MapView mMapView = (MapView) promptView.findViewById(R.id.map_view_dialog);
        MapsInitializer.initialize(getActivity());

        mMapView.onCreate(alertDialog.onSaveInstanceState());
        mMapView.onResume();
        mMapView.getMapAsync(this);

        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Назад", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which){}

        });
        alertDialog.show();
    }
}
