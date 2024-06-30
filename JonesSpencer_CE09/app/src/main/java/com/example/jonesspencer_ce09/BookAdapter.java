// Spencer Jones
// MDV3832-0 - 062024
// BookAdapter.java

package com.example.jonesspencer_ce09;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class BookAdapter extends BaseAdapter {
    private Context context;
    private List<Book> books;

    public BookAdapter(Context context, List<Book> books) {
        this.context = context;
        this.books = books;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
        }

        TextView title = convertView.findViewById(R.id.bookTitle);
        ImageView image = convertView.findViewById(R.id.bookImage);

        Book book = books.get(position);
        title.setText(book.getTitle());
        Picasso.get().load(book.getImageUrl()).into(image);

        return convertView;
    }
}
