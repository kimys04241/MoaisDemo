package com.moais.demo.utils;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.UUID;

public class PrimaryKeyGenerator {

        private final static char[] DIGITS66 = { 
        		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
        		'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
        		'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 
        		'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 
        		'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 
        		'Y', 'Z', '-' };

        public static String next() {
                UUID u = UUID.randomUUID();
                return System.currentTimeMillis()+toIDString(u.getMostSignificantBits());
        }

        private static String toIDString(long i) {
                char[] buf = new char[10];
                int z = 63; // 1 << 6;
                int cp = 10;
                long b = z - 1;
                do {
                        if( cp == 0 ) break;
                        buf[--cp] = DIGITS66[(int) (i & b)];
                        i >>>= 6;
                } while (i != 0);
                return new String(buf, cp, (10 - cp));
        }

        public static long nextLong() {
                long val = -1;
                do {
                        final UUID uid = UUID.randomUUID();
                        final ByteBuffer buffer = ByteBuffer.wrap(new byte[16]);
                        buffer.putLong(uid.getLeastSignificantBits());
                        buffer.putLong(uid.getMostSignificantBits());
                        final BigInteger bi = new BigInteger(buffer.array());
                        val = bi.longValue();
                } while (val < 0 || val > 9007199254740991L);
                return val;
        }
}