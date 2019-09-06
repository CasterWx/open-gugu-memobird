package domain;

public class Content {
    private long id ;
    private String name ;
    private String content ;
    private String data ;

    @Override
    public String toString() {
        return "Content{" +
                " id=" + id +
                ",  name='" + name + '\'' +
                ",  content='" + content + '\'' +
                ",  data='" + data + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
