package com.hy.thelines.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.hy.thelines.MainActivity;
import com.hy.thelines.R;
import com.hy.thelines.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String str = getResources().getString(R.string.login_tips);
        SpannableStringBuilder span = new SpannableStringBuilder(str);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Log.d("zx","clickableSpan");
            }
        };

        span.setSpan(clickableSpan,str.length()-14,str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.loginTips.setText(span);
        binding.loginTips.setMovementMethod(LinkMovementMethod.getInstance());

        binding.loginButton.setOnClickListener(v -> {
            if (binding.username.getText().toString().isEmpty()){
                Snackbar.make(view, getString(R.string.username_can_not_null), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                return;
            }

            if (binding.password.getText().toString().isEmpty()){
                Snackbar.make(view, getString(R.string.password_can_not_null), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                return;
            }
            Intent intent = new Intent(getContext(), MainActivity.class);
            startActivity(intent);
            getActivity().finish();
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}