package application.model.entity.dto;


public class FotoDTO {

    private long id;

    private byte[] data;

    public FotoDTO(){}
    public FotoDTO(byte[] data) {
        this.data = data;
    }
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
