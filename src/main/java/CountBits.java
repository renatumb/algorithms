public class CountBits {

    public static void main(String[] args) {

        /*int number = 1024;
        int parity = 0;

        int i = 0;
        while( number != 0 ){
            System.out.println(++i + " number:" + number);
            parity ^= 1;
            number &= (number-1);

        }
        System.out.println( "result: " + parity);


        number = 1024;
        parity = 0;

        i = 0;
        while( number != 0 ){
            System.out.println(++i + " number:" + number);
            parity ^=  ( number & 1 );
            number >>= 1;

        }
        System.out.print( "result: " + parity);/**/

        _43();
    }

    public static void _43() {

        int number = 57345; // = 16387

        StringBuffer result = new StringBuffer();
        while (number > 0) {
            result.append(number & 1);
            number >>= 1;
        }
        System.out.println(result);
        System.out.println(result.reverse());
    }

}
