package com.hy.thelines.ui.fragment;

import static androidx.navigation.fragment.FragmentKt.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.hy.thelines.R;
import com.hy.thelines.databinding.FragmentFeedbackBinding;

public class FeedbackFragment extends Fragment {

    private FragmentFeedbackBinding binding = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFeedbackBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.submit.setOnClickListener(v -> {
            if (binding.titleEdit.getText().toString().isEmpty()){
                Snackbar.make(view, getString(R.string.feedback_title_can_not_null), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                return;
            }

            if (binding.discuss.getText().toString().isEmpty()){
                Snackbar.make(view, getString(R.string.feedback_content_can_not_null), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                return;
            }

            Snackbar.make(view, "反馈成功", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            findNavController(this).navigate(R.id.action_feedback_to_main);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
