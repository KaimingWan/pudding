package jdk;

/**
 * 逆推随机数
 * Created by wanshao on 2017/6/27.
 */
public class CalRandom {
    private static long seed;

    private static final long multiplier = 0x5DEECE66DL;
    private static final long addend = 0xBL;
    private static final long mask = (1L << 48) - 1;

    private static long calcSeed(long nextLong) {
        final long x = 0x5DEECE66DL;
        final long xinv = 0xdfe05bcb1365L;
        final long y = 0xBL;
        final long mask = ((1L << 48)-1);

        long a = nextLong >>> 32;
        long b = nextLong & ((1L<<32)-1);
        if((b & 0x80000000) != 0)
            a++; // b had a sign bit, so we need to restore a
        long q = ((b << 16) - y - (a << 16)*x) & mask;
        for(long k=0; k<=5; k++) {
            long rem = (x - (q + (k<<48))) % x;
            long d = (rem + x)%x; // force positive
            if(d < 65536) {
                long c = ((q + d) * xinv) & mask;
                if(c < 65536) {
                    return ((((a << 16) + c) - y) * xinv) & mask ;
                }
            }
        }
        return 0;
        //throw new RuntimeException("Failed!!");
    }

    static int next(int bits) {
        seed = (seed * multiplier + addend) & mask;
        return (int)(seed >>> (48 - bits));
    }

    static public void initSeed(long data){
        seed = calcSeed(data) ^ multiplier;
        seed =(seed ^ multiplier) & mask;
        if (data != nextLong()) {
            seed = calcSeed(-data) ^ multiplier;
            seed =(seed ^ multiplier) & mask;
        }
    }

    static public long nextLong() {
        // it's okay that the bottom word remains signed.
        return ((long)(next(32)) << 32) + next(32);
    }
}
