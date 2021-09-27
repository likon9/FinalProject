package by.epam.finalTask.model.entity;

public class Request {

    private Long requestId;
    private String requestMessage;
    private String requestAnswer;

    public Request() {
    }

    public Request(Long requestId, String requestMessage, String requestAnswer) {
        this.requestId = requestId;
        this.requestMessage = requestMessage;
        this.requestAnswer = requestAnswer;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getRequestMessage() {
        return requestMessage;
    }

    public void setRequestMessage(String requestMessage) {
        this.requestMessage = requestMessage;
    }

    public String getRequestAnswer() {
        return requestAnswer;
    }

    public void setRequestAnswer(String requestAnswer) {
        this.requestAnswer = requestAnswer;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestId=" + requestId +
                ", requestMessage='" + requestMessage + '\'' +
                ", requestAnswer='" + requestAnswer + '\'' +
                '}';
    }
}
