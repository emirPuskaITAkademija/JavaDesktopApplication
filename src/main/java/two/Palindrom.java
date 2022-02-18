package two;

public class Palindrom {
    public static void main(String[] args) {
        String name = "ana voli milovana";
        Palindrom palindrom = new Palindrom();
        System.out.println(palindrom.isPalindrom(name) ? "JESTE" :"NIJE PALINDROM");
    }

    private boolean isPalindromEfficient(String text){
        String name = text.replace(" ", "");
        StringBuffer stringBuffer = new StringBuffer(name);
        String reverseName = stringBuffer.reverse().toString();
        return name.equals(reverseName);
    }

    private boolean isPalindrom(String text) {
        String name = text.replace(" ", "");
        String empty = "";
        char[] chars = name.toCharArray();
        for (int i = (chars.length - 1); i >= 0; i--) {
            empty = empty+chars[i];
        }
        if(empty.equals(name)){
            return true;
        }
        return false;
    }
}
