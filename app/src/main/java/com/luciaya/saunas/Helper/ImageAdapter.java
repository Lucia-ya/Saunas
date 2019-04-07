package com.luciaya.saunas.Helper;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.luciaya.saunas.R;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder>{
   List<String> imagesUrl;

    public ImageAdapter(String[] imagesUrl) {
        this.imagesUrl = Arrays.asList(imagesUrl);
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.list_item_images, parent, false);
        return new ImageHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder holder, int position) {
        String url = imagesUrl.get(position);
        holder.bind(url);

    }

    @Override
    public int getItemCount() {
        if (imagesUrl.isEmpty()) {
            return 0;
        } else return imagesUrl.size();
    }

    public final static class ImageHolder extends RecyclerView.ViewHolder {
        ImageView image;
        String imageUrl;

        public ImageHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image_item_catalog);
        }

        public void bind(String url) {
            Picasso.get()
                    .load(url)
                    .placeholder(R.drawable.catalog_placeholder)
                    .error(R.drawable.catalog_placeholder_error)
                    .into(image);
        }
    }


}
