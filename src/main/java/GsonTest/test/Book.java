package GsonTest.test;

/**
 * @author tangxiaoshuang
 * @date 2017/12/8 16:43
 */
public class Book {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
