package com.example.tugas_akhir;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tugas_akhir.model.ResultItem_tugas;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class adapter  extends RecyclerView.Adapter<adapter.HolderData> {
    private static CountDownTimer countDownTimer;

    private List<ResultItem_tugas> mList ;
    private Context ctx;
    String status;
    String id_role;
    String id_role_revisi;
    String timer;
    public adapter(Context ctx, List<ResultItem_tugas> mList,String status,String id_role,String id_role_revisi)
    {
        this.ctx = ctx;
        this.status = status;
        this.id_role = id_role;
        this.id_role_revisi = id_role_revisi;
        this.mList = mList;
    }
    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(final HolderData holder, int position) {
        //  Toast.makeText(ctx, waktu, Toast.LENGTH_SHORT).show();
        final ResultItem_tugas dm = mList.get(position);
        String waktu;
        Log.i("status", "onBindViewHolder: "+status);




        holder.nama.setText(dm.getNama());








        Glide.with(ctx)
                .load("http://192.168.1.71/tugas/foto/"+dm.getFoto())
                .apply(new RequestOptions()
                        .fitCenter()
                        .error(R.drawable.ic_launcher_background))
                .into(holder.bg);

        holder.dm = dm;



    }


    @Override
    public int getItemCount() {
        return mList.size();
    }


    class HolderData extends  RecyclerView.ViewHolder{

        @BindView(R.id.txt_nama)
        TextView nama;




        @BindView(R.id.img_foto)
        ImageView bg;

        ResultItem_tugas dm;




        public HolderData (View v)
        {
            super(v);
            ButterKnife.bind(this, itemView);
            nama.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click_desc_data();
                }
            });
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ctx, "ID"+dm.getId(), Toast.LENGTH_SHORT).show();
                    click_desc_data();
                }
            });
        }

        public void click_desc_data(){
            Intent goInput = new Intent(ctx, menu_detail.class);
            goInput.putExtra("id", dm.getId());
            goInput.putExtra("nama", dm.getNama());
            goInput.putExtra("ket", dm.getKet());
            goInput.putExtra("foto", dm.getFoto());
            ctx.startActivity(goInput);
        }

        public void click_desc_track(){

        }


    }


}
