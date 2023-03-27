package com.example.android1lesson2;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.Nullable;
public class ThirdFragment extends Fragment {
    EditText userNameEditText;
    EditText passwordEditText;
    Button button;

    private final String USERNAME = "admin";
    private final String PASSWORD = "admin";

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userNameEditText = view.findViewById(R.id.ed_username);
        passwordEditText = view.findViewById(R.id.ed_password);
        button = view.findViewById(R.id.btn);
        registerButton();
    }
    private void registerButton() {
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String userNameText = userNameEditText.getText().toString();
                String editPas = passwordEditText.getText().toString();
                if (userNameText.equals(USERNAME) && editPas.equals(PASSWORD)) {
                    getParentFragmentManager().beginTransaction()
                            .replace(R.id.fragment_second_view, new HomeFragment())
                            .addToBackStack(null)
                            .commit();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };
        userNameEditText.addTextChangedListener(textWatcher);
        passwordEditText.addTextChangedListener(textWatcher);

        }

}