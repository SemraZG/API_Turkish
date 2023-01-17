package Pojo_Test_Base;

public class Get15_pojo_expected {
    private String status;
    private Get15_pojo_Data data;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Get15_pojo_Data getData() {
        return data;
    }

    public void setData(Get15_pojo_Data data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Get15_pojo_expected() {
    }

    public Get15_pojo_expected(String status, Get15_pojo_Data data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Get15_pojo{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
