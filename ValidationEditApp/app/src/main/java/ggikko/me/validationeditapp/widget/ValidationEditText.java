package ggikko.me.validationeditapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import ggikko.me.validationeditapp.util.Validator;

/**
 * Created by ggikko on 16. 6. 2..
 */
public class ValidationEditText  extends EditText {

    private Validator validator;

    public ValidationEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public ValidationEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ValidationEditText(Context context) {
        super(context);
        init();
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    public boolean hasValidInput() {
        if (validator == null) throw new InstantiationError("validator 가 필요합니다.");

        boolean valid = validator.validate(getText().toString());

        if (!valid) notifyUser();

        return valid;
    }

    private void notifyUser() {
        Animation shake = new TranslateAnimation(0, 5, 0, 0);
        shake.setInterpolator(new CycleInterpolator(5));
        shake.setDuration(300);
        startAnimation(shake);
    }

    private void init() {
        setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (EditorInfo.IME_ACTION_DONE == actionId) {
                    hasValidInput();
                }
                return false;
            }
        });
    }

}
