
public class HelperUtils {

    public static boolean checkIfEmptyOrBlank(String strToCheck){
        if(strToCheck.isBlank() || strToCheck.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNull(String strToCheck){
        if(null == strToCheck){
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNull(Integer intToCheck){
        if(null == intToCheck){
            return true;
        } else {
            return false;
        }
    }
}
