package com.company;

// Самозакрываемый класс счетчика
public class Cnt implements  AutoCloseable {
    public int cnt = 0;

    public void add() throws  Exception
    {
        cnt++;
    }

    @Override
    public void close() throws Exception {
        cnt--;
    }
}
