package zz.yy.xx.misc;

import lombok.Data;

public class MutablePhaseChainExample {

    public static void main(String[] args) {
        Ccc result = MutablePhaseChain.start(new Human("Paul", "smith", 33))
                .next((source, previous) -> new Aaa(source.getFirstName()))
                .next((source, previous) -> new Bbb(previous.getName(), source.getAge()))
                .next((source, previous) -> {
                    String hiddenName = previous.getName().substring(0, 2)
                            + "*".repeat(previous.getName().length() - 2);
                    Ccc ccc = new Ccc(hiddenName, previous.getAge());
                    return ccc;
                }).result();

        System.out.println(result);
    }

    @Data
    public static class Human {

        public Human(String firstName, String lastName, Integer age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        private String firstName;
        private String lastName;
        private Integer age;
    }

    @Data
    public static class Aaa {

        private Aaa(String name) {
            this.name = name;
        }

        private String name;
    }

    @Data
    public static class Bbb {

        private Bbb(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        private String name;
        private Integer age;
    }

    @Data
    public static class Ccc {

        public Ccc(String hiddenName, Integer age) {
            this.hiddenName = hiddenName;
            this.age = age;
        }

        private String hiddenName;
        private Integer age;
    }

}
