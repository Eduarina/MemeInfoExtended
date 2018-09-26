package com.outlook.gonzososa.apps.multiscreenssupport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


@SuppressLint("ValidFragment")
public class InfoFragment extends Fragment {

    private int id;

    public InfoFragment(int id){
        this.id = id;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FragmentActivity activity = getActivity();
        if (activity == null) return;

        RecyclerView recyclerView = activity.findViewById(R.id.rvListado);
        if (recyclerView == null) return;

        String [] descriptions = activity.getResources ().getStringArray (R.array.descriptions);
        String [] urls = activity.getResources ().getStringArray (R.array.urls);

        Drawable imagen = ListadoFragment.images.get(id);
        String name = ListadoFragment.names.get(id);


        recyclerView.setLayoutManager(new LinearLayoutManager (getContext (), LinearLayout.VERTICAL, false));
        recyclerView.setAdapter(new InfoAdapter(getContext(),name,imagen,descriptions[id],urls[id]));

    }

    class InfoAdapter extends RecyclerView.Adapter<InfoViewHolder>{

        private Context context;
        private String name;
        private Drawable imagen;
        private String description;
        private String url;


        public InfoAdapter(Context context, String name, Drawable imagen, String description, String url) {
            this.context = context;
            this.name = name;
            this.imagen = imagen;
            this.description = description;
            this.url = url;
        }

        @NonNull
        @Override
        public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from (context).inflate (R.layout.info_fragmentos, viewGroup, false);
            return new InfoViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull InfoViewHolder InfoViewHolder, int i) {
            InfoViewHolder.bind(name,imagen,description,url);
        }

        @Override
        public int getItemCount() {
            return 1;
        }
    }

    class InfoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView    textView1;
        private TextView    textView2;
        private TextView    textView3;

        public InfoViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imagen1);
            textView1 = itemView.findViewById(R.id.Texto1);
            textView2 = itemView.findViewById(R.id.Texto2);
            textView3 = itemView.findViewById(R.id.Texto3);
        }

        public void bind(String name, Drawable imagen, String description, String url) {

            imageView.setImageDrawable(imagen);
            textView1.setText(name);
            textView2.setText(description);
            textView3.setText(url);

        }
    }

}