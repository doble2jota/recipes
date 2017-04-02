package cou.peq.com.recetas.Views.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import cou.peq.com.recetas.R;

/**
 * Created by raquel on 02/04/2017.
 */

public class MainMenuGridAdapter extends BaseAdapter {

        // Keep all Images in array
        public Integer[] mThumbIds = {
                R.drawable.ic_food_and_kitchen_outline_spoon_fork, R.drawable.ic_food_chef,
                R.drawable.ic_search, R.drawable.ic_heart,

        };

        public int[] mThumbColors = {
                R.color.option1, R.color.option2, R.color.option3, R.color.option4
        };

        public String[] mThumbNames = {
                "Categorias", "Ingredientes", "Buscar", "Favoritos"
        };
        private Context mContext;

        // Constructor
        public MainMenuGridAdapter(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {
            return mThumbIds.length;
        }

        @Override
        public Object getItem(int position) {
            return mThumbIds[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


//        ImageView imageView = new ImageView(mContext);
//        imageView.setImageResource(mThumbIds[position]);
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            ViewHolderItem viewHolder;


            if (convertView == null) {

                // inflate the layout
                LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
                convertView = inflater.inflate(R.layout.menu_row_grid, parent, false);
                convertView.setBackgroundColor(mContext.getResources().getColor(mThumbColors[position]));

                // well set up the ViewHolder
                viewHolder = new ViewHolderItem();
                viewHolder.textViewItem = (TextView) convertView.findViewById(R.id.textRowView);

                viewHolder.imageViewItem = (ImageView) convertView.findViewById(R.id.imageRowView);
                // store the holder with the view.
                convertView.setTag(viewHolder);


            } else {
                // we've just avoided calling findViewById() on resource everytime
                // just use the viewHolder
                viewHolder = (ViewHolderItem) convertView.getTag();
            }

            // object item based on the position

            // get the TextView from the ViewHolder and then set the text (item name) and tag (item ID) values
            viewHolder.textViewItem.setText(mThumbNames[position]);
            viewHolder.textViewItem.setTag(position);

            viewHolder.imageViewItem.setImageResource(mThumbIds[position]);


            return convertView;

        }

        // our ViewHolder.
// caches our TextView
        static class ViewHolderItem {
            TextView textViewItem;
            ImageView imageViewItem;
        }


    }