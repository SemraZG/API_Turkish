package Pojo_Test_Base;

public class todos_pojo_class_pojo01 {
    /*
            "userId": 21,
             "id": 201,
             "title": "Tidy your room",
             "completed": false
     */

    //1.step: değişkenleri private yap
    private  int userId;
    private int id;
    private String title;
    private  boolean completed;

    //2.step: bu değerlere ulaşabilmek için getter ve setter methodlar oluştur


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    //3.step: parametreli ve parametresiz constructor oluşturuyoruz.

    public todos_pojo_class_pojo01() {
    }

    public todos_pojo_class_pojo01(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    //4.step: toString methodu oluşturuyoruz.


    @Override
    public String toString() {
        return "todos_pojo{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }


}
