package ggikko.me.validationeditapp.util;


/**
 * Created by admin on 16. 6. 2..
 */
public class EmailValidator implements Validator {

    @Override
    public boolean validate(String input) {
        if (input.contains("@")) return true;
        return false;
    }

}