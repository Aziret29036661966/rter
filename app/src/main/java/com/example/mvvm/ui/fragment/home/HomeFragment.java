package com.example.mvvm.ui.fragment.home;

import static android.view.PixelCopy.SUCCESS;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import com.example.mvvm.base.BaseFragment;
import com.example.mvvm.databinding.FragmentHomeBinding;


import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends BaseFragment<FragmentHomeBinding> {
    private HomeViewModel viewModel;
    private AdapterHomeFragment adapterHomeFragment;
    private int page = 1;
    private int limit = 10;

    @Override
    protected FragmentHomeBinding getBinding() {
        return FragmentHomeBinding.inflate(getLayoutInflater());
    }

    @Override
    public void setupUI() {
        viewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        viewModel.getCharacter();
        initAdapter();
    }

    private void initAdapter() {
        adapterHomeFragment = new AdapterHomeFragment();
        binding.rvRc.setAdapter(adapterHomeFragment);
    }

    @Override
    protected void setupObservers() {
        getData(page, limit);

    }

    private void getData(int page, int limit) {
        viewModel.getLiveData().observe(getViewLifecycleOwner(), info -> {
            adapterHomeFragment.setList(info.getResults());
        });
    }
}