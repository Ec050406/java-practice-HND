//ewan 22/09/26

        public class Person {
            private String name;
            private int age;
            
            public Person(String name, int age) {
                this.name = name;
                this.age = age;



            }
            
            public Person() {
                this.name = "";
                this.age = 0;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setAge(int age) {
                this.age = age;
            }
            public void intro(){
                
                System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
            }
    }
