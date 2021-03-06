package com.etiennelawlor.quickreturn.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.etiennelawlor.quickreturn.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

//import java.util.logging.Handler;

/**
 * Created by etiennelawlor on 7/17/14.
 */
public class CountriesGridLayoutAdapter extends RecyclerView.Adapter<CountriesGridLayoutAdapter.ViewHolder> {

    // region Constants
    // endregion

    // region Member Variables
    private Context mContext;
    private List<String> mCountries;
    private final LayoutInflater mInflater;

    // endregion

    // region Constructors
    public CountriesGridLayoutAdapter(Context context, List<String> countries) {
        mContext = context;
        mCountries = countries;

        mInflater = LayoutInflater.from(mContext);
    }
    // endregion

    @Override
    public CountriesGridLayoutAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.country_grid_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String country = mCountries.get(position);

        if(!TextUtils.isEmpty(country)){
            holder.mCountryTextView.setText(country);
        }
    }

    @Override
    public int getItemCount() {
        return mCountries.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.country_tv) TextView mCountryTextView;

        ViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }
}
