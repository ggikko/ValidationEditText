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
        if (main_email.hasValidInput()) showShortToast("이메일 성공");
        if (main_password.hasValidInput()) showShortToast("패스워드 성공");
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

    private void showShortToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
