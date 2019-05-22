package com.luciaya.saunas.View;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.luciaya.saunas.R;
import com.luciaya.saunas.TestData.Review;
import com.luciaya.saunas.TestData.Sauna;
import com.luciaya.saunas.TestData.SaunaLab;

import java.util.Date;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewReviewActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.review_like_button)
    LinearLayout like_button;
    @BindView(R.id.review_dislike_button)
    LinearLayout dislike_button;
    @BindView(R.id.review_name)
    EditText name;
    @BindView(R.id.review_email)
    EditText email;
    @BindView(R.id.review_phone)
    EditText phone;
    @BindView(R.id.review_your_review)
    EditText review;
    @BindView(R.id.review_like_image)
    ImageView like_image;
    @BindView(R.id.review_like_text)
    TextView like_text;
    @BindView(R.id.review_dislike_image)
    ImageView dislike_image;
    @BindView(R.id.review_dislike_text)
    TextView dislike_text;

    private static final String EXTRA_SAUNA_ID = "com.lucia-ya.android.saunas.sauna_id";
    private static final String TAG = "NewReviewActivity";

    private View headerView;
    private Sauna mSauna;
    private boolean isLike;
    private String user_name;
    private String user_email;
    private String user_phone;
    private String user_review;
    private boolean isClicked;

    public static Intent newIntent(Context packageContext, UUID saunaId) { //добавление интента с передачей параметров
        Intent intent = new Intent(packageContext, NewReviewActivity.class);
        intent.putExtra(EXTRA_SAUNA_ID, saunaId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_review);

        ButterKnife.bind(this);
        UUID saunaId = (UUID) getIntent().getSerializableExtra(EXTRA_SAUNA_ID); //принимаем интент с парамером - айди
        Log.d(TAG, "onCreate: UUID from intent, UUID = " + saunaId.toString());
        mSauna = SaunaLab.get().getSauna(saunaId);
        like_button.setOnClickListener(this);
        dislike_button.setOnClickListener(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayUseLogoEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.review_action_bar);
        headerView = actionBar.getCustomView();

        headerView.findViewById(R.id.review_bar_cancel).setOnClickListener(this);
        headerView.findViewById(R.id.review_bar_send).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.review_like_button:
                like_image.setColorFilter(ContextCompat.getColor(this, R.color.green));
                like_text.setTextColor(Color.BLACK);
                dislike_image.setColorFilter(ContextCompat.getColor(this, R.color.text_gray));
                dislike_text.setTextColor(ContextCompat.getColor(this, R.color.text_gray));
                isClicked = true;
                isLike = true;
                Log.d(TAG, "onClick like Button: isLike = " + isLike);
                break;
            case R.id.review_dislike_button:
                like_image.setColorFilter(ContextCompat.getColor(this, R.color.text_gray));
                like_text.setTextColor(ContextCompat.getColor(this, R.color.text_gray));
                dislike_image.setColorFilter(ContextCompat.getColor(this, R.color.red_sauna_of_month));
                dislike_text.setTextColor(Color.BLACK);
                isClicked = true;
                isLike = false;
                Log.d(TAG, "onClick dislike Button: isLike = " + isLike);
                break;
            case R.id.review_bar_cancel:
                onBackPressed();
                break;
            case R.id.review_bar_send:
                user_name = name.getText().toString().trim();
                user_email = email.getText().toString().trim();
                user_phone = email.getText().toString().trim();
                user_review = review.getText().toString().trim();

                Log.d(TAG, "send pressed : name = " + user_name + ", email = " +
                        user_email + ", phone = " + user_phone + ", isLike = " + isLike + ", review = "
                        + user_review);
                if (mSauna != null) {

                    Log.d(TAG, "onClick: send pressed sauna reviews: " + mSauna.getReviews().toString());

                    if (!user_name.isEmpty() && !user_email.isEmpty() && !user_phone.isEmpty() && !user_review.isEmpty()) {
                        if (isClicked) {
                            if (!mSauna.getReviews().isEmpty()) {
                                Log.d(TAG, "onClick: send -if - okay - not empty");

                                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                              builder.setTitle("Политика конфиденциальности");
                                builder.setPositiveButton("Отправить", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Review review = new Review(user_name, new Date().toString(), user_review, isLike, user_email, user_phone);
                                        mSauna.getReviews().add(review);
                                        onBackPressed();
                                    }
                                }).setNegativeButton("Не отправлять", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                });
                                builder.setMessage(R.string.alert_dialog_politic);
                                AlertDialog alert1 = builder.create();
                                 alert1.show();
                                 break;
                            } else {
                                Log.d(TAG, "onClick: send -if - okay - sauna empty");
                                Toast.makeText(this, "Что-то пошло не так...", Toast.LENGTH_LONG).show();
                                break;
                            }
                        } else {
                            Log.d(TAG, "onClick Укажите, понравилось вам или нет");
                            Toast.makeText(this, "Укажите, понравилось вам или нет", Toast.LENGTH_LONG).show();
                            break;
                        }
                    } else {
                        Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_LONG).show();
                        Log.d(TAG, "onClick: Заполните все поля!");
                        break;
                    }
                }
                break;

        }
    }

}
