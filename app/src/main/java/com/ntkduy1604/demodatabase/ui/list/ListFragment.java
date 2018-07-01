package com.ntkduy1604.demodatabase.ui.list;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ntkduy1604.demodatabase.DatabaseDemoApplication;
import com.ntkduy1604.demodatabase.R;
import com.ntkduy1604.demodatabase.db.entity.ListItem;
import com.ntkduy1604.demodatabase.viewmodel.ListItemCollectionViewModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {

    private static final String EXTRA_ITEM_ID = "EXTRA_ITEM_ID";

    private List<ListItem> listOfData;

    private LayoutInflater layoutInflater;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    ListItemCollectionViewModel listItemCollectionViewModel;

    public ListFragment() {
    }

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    /*------------------------------- Lifecycle -------------------------------*/


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((DatabaseDemoApplication) getActivity().getApplication())
                .getApplicationComponent()
                .inject(this);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Set up and subscribe (observe) to the ViewModel
        listItemCollectionViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(ListItemCollectionViewModel.class);

        listItemCollectionViewModel.getAllItems().observe(this, new Observer<List<ListItem>>() {
            @Override
            public void onChanged(@Nullable List<ListItem> listItems) {
                if (listOfData == null) {
                    setListData(listItems);
                }
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, v);

        recyclerView = (RecyclerView) v.findViewById(R.id.rec_list_activity);
        layoutInflater = getActivity().getLayoutInflater();

        FloatingActionButton fabulous = (FloatingActionButton) v.findViewById(R.id.fab_create_new_item);

        fabulous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void setListData(List<ListItem> listOfData) {
        this.listOfData = listOfData;

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);
    }

    /*-------------------- RecyclerView Boilerplate ----------------------*/

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {//6

        @Override
        public CustomAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = layoutInflater.inflate(R.layout.recyclerview_list_item, parent, false);
            return new CustomViewHolder(v);
        }

        @Override
        public void onBindViewHolder(CustomAdapter.CustomViewHolder holder, int position) {
            ListItem currentItem = listOfData.get(position);
            holder.tvItemName.setText(currentItem.getItemName());
            holder.tvItemPrice.setText(String.valueOf(currentItem.getItemPrice()));
            holder.tvItemQty.setText(String.valueOf(currentItem.getItemQty()));

        }

        @Override
        public int getItemCount() {
            return listOfData.size();
        }

        class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            private TextView tvItemName;
            private TextView tvItemPrice;
            private TextView tvItemQty;
            private TextView tvSupplierName;
            private TextView tvSupplierPhone;
            private ViewGroup container;

            public CustomViewHolder(View itemView) {
                super(itemView);
                this.tvItemName = (TextView) itemView.findViewById(R.id.tv_product_name);
                this.tvItemPrice = (TextView) itemView.findViewById(R.id.tv_price_value);
                this.tvItemQty = (TextView) itemView.findViewById(R.id.tv_quantity_value);
//                this.tvSupplierName = (TextView) itemView.findViewById(R.id.tv);
//                this.tvSupplierPhone = (TextView) itemView.findViewById(R.id.pro_item_data);

                this.container = (ViewGroup) itemView.findViewById(R.id.product_info);
            }

            @Override
            public void onClick(View v) {
                ListItem listItem = listOfData.get(
                        this.getAdapterPosition()
                );

            }
        }

    }

}
