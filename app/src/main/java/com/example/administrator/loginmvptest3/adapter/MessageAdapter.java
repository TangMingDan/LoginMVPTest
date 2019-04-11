package com.example.administrator.loginmvptest3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.loginmvptest3.R;
import com.example.administrator.loginmvptest3.model.Message;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageAdapter extends ArrayAdapter<Message> {
    private int resourceId;
    public MessageAdapter(Context context, int resource,List<Message> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        Message message = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }else {
            view = convertView;
        }
        CircleImageView circleImageView = view.findViewById(R.id.circleImageView);
        TextView textView = view.findViewById(R.id.textView);
        TextView textView1 = view.findViewById(R.id.textView2);
        TextView textView2 = view.findViewById(R.id.textView3);
        circleImageView.setImageResource(message.getImgId());
        textView.setText(message.getPerson());
        textView1.setText(message.getContent());
        textView2.setText(message.getTime());
        return view;
    }
}
