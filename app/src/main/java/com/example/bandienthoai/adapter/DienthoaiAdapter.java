package com.example.bandienthoai.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bandienthoai.R;
import com.example.bandienthoai.model.Sanpham;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class DienthoaiAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> arraydienthoai;

    public DienthoaiAdapter(Context context, ArrayList<Sanpham> arraydienthoai) {
        this.context = context;
        this.arraydienthoai = arraydienthoai;
    }


    @Override
    public int getCount() {
        return arraydienthoai.size();
    }

    @Override
    public Object getItem(int i) {
        return arraydienthoai.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //có dữ liệu gán lại, đỡ cho chúng ta khi có dữ liệu load đi load lại nhiều lần
    public class ViewHolder {
        public TextView txttendienthoai, txtgiadienthoai, txtmotadienthoai;
        public ImageView imgdienthoai;

    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.dong_dienthoai,null);
            viewHolder.txttendienthoai = view.findViewById(R.id.textviewdienthoai);
            viewHolder.txtgiadienthoai = view.findViewById(R.id.textviewgia);
            viewHolder.txtmotadienthoai = view.findViewById(R.id.textviewmotasanpham);
            viewHolder.imgdienthoai = view.findViewById(R.id.imageviewdienthoai);
            view.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Sanpham sanpham = (Sanpham) getItem(i);
        viewHolder.txttendienthoai.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgiadienthoai.setText("Giá: " +decimalFormat.format(sanpham.getGiasanpham())+ "Đ");
        viewHolder.txtmotadienthoai.setMaxLines(2);
        //Định dạng dấu 3 chấm
        viewHolder.txtmotadienthoai.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtmotadienthoai.setText(sanpham.getMotasanpham());
        Glide.with(context).load(sanpham.getHinhanhsanpham())
                .into(viewHolder.imgdienthoai);
        return view;
    }
}
