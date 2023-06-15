import javax.lang.model.type.NullType;

public class CILab implements CILabInterface {
    private String myString;

    @Override
    public String getString() {
        return myString;
    }

    @Override
    public void setString(String string) {
        myString = string;
    }

    @Override
    public boolean detectCapitalUse() {
        if(myString == null) {
            return false;
        }
        if(myString.isEmpty()) {
            return false;
        }
        for (char c : myString.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }
}

