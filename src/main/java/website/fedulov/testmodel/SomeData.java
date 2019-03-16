package website.fedulov.testmodel;

import org.springframework.stereotype.Component;

@Component
public class SomeData {

	private Integer id;

	private String name;

	private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public SomeData(Integer id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public SomeData() {

    }

    @Override
    public String toString() {
        return "SomeData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}