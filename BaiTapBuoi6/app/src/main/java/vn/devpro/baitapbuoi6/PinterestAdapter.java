package vn.devpro.baitapbuoi6;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PinterestAdapter extends RecyclerView.Adapter<PinterestAdapter.PinViewHolder> {

    private Context context;
    private int[] imageList;

    public PinterestAdapter(Context context, int[] imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public PinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pinterest, parent, false);
        return new PinViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PinViewHolder holder, int position) {

        int imageResId = imageList[position];
        holder.ivPin.setImageResource(imageResId);


        holder.ivPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("IMAGE_ID", imageResId);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageList.length;
    }

    public static class PinViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPin;

        public PinViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPin = itemView.findViewById(R.id.ivPin);
        }
    }
}
