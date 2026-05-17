package project.portfolio.dto;

public class ApiResponse<T> {
    private String message;
    private boolean status;
    private T data;

    public ApiResponse(boolean status, String message, T data){
        this.message = message;
        this.status = status;
        this.data = data;
    }
    public String getMessage(){
        return message;
    }
    public boolean getStatus(){
        return status;
    }
    public T getData(){
        return data;
    }

}
