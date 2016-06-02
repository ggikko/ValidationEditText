package ggikko.me.validationeditapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ggikko.me.validationeditapp.util.EmailValidator;
import ggikko.me.validationeditapp.util.PasswordValidator;
import ggikko.me.validationeditapp.util.Validator;
import ggikko.me.validationeditapp.widget.ValidationEditText;

public class MainActivity extends AppCompatActivity  {

    @BindView(R.id.main_email) ValidationEditText main_email;
    @BindView(R.id.main_password) ValidationEditText main_password;

    @OnClick(R.id.btn_ok)
    void callOkClick(View view){
        if (main_email.hasValidInput()) Toast.makeText(this, "성공", Toast.LENGTH_SHORT).show();
        if (main_password.hasValidInput()) Toast.makeText(this, "성공", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //TODO : need dagger
        setValidator(main_email, new EmailValidator());
        setValidator(main_password, new PasswordValidator());
    }

    private void setValidator(ValidationEditText validationEditText, Validator validator){
        validationEditText.setValidator(validator);
    }

}
