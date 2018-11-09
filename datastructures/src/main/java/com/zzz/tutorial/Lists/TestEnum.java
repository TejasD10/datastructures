package com.zzz.tutorial.Lists;

public enum TestEnum {
    INSTANCE("Hello");

    private String s;

    TestEnum(String s) {
        this.s = s;
    }

    public String getString() {
        return this.s;
    }

    public static void main(String args[]) {
        for (TestEnum t : TestEnum.values()) {
            System.out.println(t.getString());
        }
    }
}

