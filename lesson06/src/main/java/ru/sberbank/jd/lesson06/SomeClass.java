package ru.sberbank.jd.lesson06;

public class SomeClass {

    private String someField;

    public SomeClass(String someField) {
        this.someField = someField;
    }

    static class SomeClassBuilder {

        private String someField;

        public SomeClassBuilder someField(String str) {
            this.someField = str;
            return this;
        }

        public SomeClass build() {
            return new SomeClass(this.someField);
        }
    }

    public static void main(String[] args) {
        SomeClass someClass = new SomeClassBuilder()
                .someField("123")
                .build();

    }
}
