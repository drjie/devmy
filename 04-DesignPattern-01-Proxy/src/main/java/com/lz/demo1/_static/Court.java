package com.lz.demo1._static;

import org.junit.Test;

public class Court {
    @Test
    public void test(){
        //原告永强
        Parties parties = new Parties();
        //律师
        Lawsuit lawyer = new Lawyer(parties);
        lawyer.submit();
        lawyer.defend();
    }
}
