package pl.kskowronski.mapiclientmaster.data.model;

public class GenericResponse<T> {
    private T body;

    public GenericResponse() {
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
