package com.example.anh.mvpvm.screen.main;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.anh.mvpvm.R;
import com.example.anh.mvpvm.data.model.User;
import com.example.anh.mvpvm.databinding.ListItemBinding;
import java.util.List;

/**
 * Created by anh on 12/09/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.BindingHolder> {
    private List<User> mUserList;

    public UserAdapter(List<User> userList) {
        mUserList = userList;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ListItemBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.list_item, parent, false);
        return new BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        holder.bind(mUserList.get(position));
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ListItemBinding mBinding;

        public BindingHolder(ListItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(User user) {
            mBinding.setViewModel(new ItemMainViewModel(user));
            mBinding.executePendingBindings();
        }
    }
}
