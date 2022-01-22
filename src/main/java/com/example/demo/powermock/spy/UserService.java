package com.example.demo.powermock.spy;

public class UserService {

    public void foo(String arg) {
        log();
    }

    private void log() {
        System.out.println("I am console log.");
    }

    public boolean checkExist(String username){
        throw new UnsupportedOperationException();
    }
}
