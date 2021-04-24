package Day3_031321;

public class if_else {
    public static void main(String[] args) {
        int a,b;
        a = 4;
        b = 3;
        if(a < b){
            System.out.println("a is less than b");
        }//end of if followed by else_if

        else if(a < b){
            System.out.println("a is less than b");
        } else{
            System.out.println("a is >= b");
        }//if_else
        if(a <= b){
            System.out.println("a is <= b");
        }//if_or
    }
}
