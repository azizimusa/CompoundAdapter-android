package com.negusoft.compoundadapter.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.negusoft.compoundadapter.R;
import com.negusoft.compoundadapter.adapter.HeaderAdapter;
import com.negusoft.compoundadapter.adapter.SampleDataAdapter;
import com.negusoft.compoundadapter.adapter.TreeNodeAdapter;
import com.negusoft.compountadapter.recyclerview.AdapterGroup;
import com.negusoft.compountadapter.recyclerview.AdapterPosition;

public class AdapterGroupTreeFragment extends Fragment {

    public static AdapterGroupTreeFragment newInstance() {
        return new AdapterGroupTreeFragment();
    }

    private RecyclerView mRecyclerView;
    private AdapterGroup mAdapterGroup;
    private TreeNodeAdapter mTreeNodeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.recyclerview, container, false);

        Context c = getActivity().getApplicationContext();
        mRecyclerView = ((RecyclerView)result.findViewById(R.id.recyclerview));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(c));
        getActivity().setTitle(R.string.sample_adapter_group_tree);

        mTreeNodeAdapter = new TreeNodeAdapter(getString(R.string.sample_list_title), mListener);
        TreeNodeAdapter one = mTreeNodeAdapter.addNode("1 - ONE");
        one.addNode("1.1 - A");
        one.addNode("1.2 - B");
        one.addNode("1.3 - C");

        TreeNodeAdapter two = mTreeNodeAdapter.addNode("2 - TWO");
        two.addNode("2.1 - A");
        two.addNode("2.2 - B");
        two.addNode("2.3 - C");

        mAdapterGroup = new AdapterGroup();
        mAdapterGroup.addAdapter(mTreeNodeAdapter);
        mRecyclerView.setAdapter(mAdapterGroup);

        return result;
    }

    TreeNodeAdapter.ItemClickListener mListener = new TreeNodeAdapter.ItemClickListener() {
        @Override
        public void onItemClick(int position) {
            // Construct as string with the relative position in each level of the hierarchy
            String message = "Position: ";
            AdapterGroup currentAdapter = mAdapterGroup;
            int currentPosition = position;
            while (true) {
                message += "-" + currentPosition;
                AdapterPosition adapterPosition = currentAdapter.getAdapterAtPosition(currentPosition);
                if (adapterPosition.adapter instanceof AdapterGroup) {
                    currentAdapter = (AdapterGroup)adapterPosition.adapter;
                    currentPosition = adapterPosition.position;
                } else {
                    break;
                }
            }

            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        }
    };
}
