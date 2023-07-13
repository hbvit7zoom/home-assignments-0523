package ru.sberbank.jd.module10.di;

public class DiExample {
}

class C {

}
class A {
    private C c;

    public A(C c) {
        this.c = c;
    }
    public String sayHello() {
        return "Hello, A";
    }
}

class B {
    private A a;
    public B(A a) {
        this.a = a;
    }
    public void method() {
        System.out.println(a.sayHello());
    }
}
