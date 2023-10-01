package application.model.entity.dto;

public class FotoDTO {
    private byte[] Data;

    public FotoDTO(byte[] data){
        this.Data = data;

    }

    public byte[] getData() {
        return Data;
    }


}
