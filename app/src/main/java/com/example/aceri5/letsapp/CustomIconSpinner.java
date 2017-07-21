package com.example.aceri5.letsapp;


        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

public class CustomIconSpinner extends BaseAdapter {
    Context context;
    int icons[];
    //String[] countryNames;
    LayoutInflater inflter;

    public CustomIconSpinner(Context applicationContext, int[] flags) {
        this.context = applicationContext;
        this.icons = flags;
        //this.countryNames = countryNames;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return icons.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.custom_icon_spinner_activity, null);
        ImageView icon = (ImageView) view.findViewById(R.id.imageView);
        //TextView names = (TextView) view.findViewById(R.id.textView);
        icon.setImageResource(icons[i]);
        //names.setText(countryNames[i]);
        return view;
    }
}