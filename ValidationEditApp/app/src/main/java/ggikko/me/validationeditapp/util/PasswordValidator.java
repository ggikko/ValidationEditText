package ggikko.me.validationeditapp.util;


/**
 * Created by admin on 16. 6. 2..
 */
public class PasswordValidator implements Validator {

    @Override
    public boolean validate(String input) {
        if (input.length() >4) return true;
        return false;
    }

}