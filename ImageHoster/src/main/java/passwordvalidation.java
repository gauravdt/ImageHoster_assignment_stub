public class passwordvalidation {
    public static void main(String[] args) {
      String passwd = "a2@";
      String pattern = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=]).{3,}";
      System.out.println(passwd.matches(pattern));
   }
}