package ocp.fi.faculty;

public class FacultyExample {

    // factorial(3) = 3*2*1

    private static double factorial( double term){
        if( term < 2){
            return term;
        }else{
            return term * factorial( term -1);
        }
    }





    public static void main(String[] args) {

        double result = factorial( 30);
        System.out.println(result);

    }
}
