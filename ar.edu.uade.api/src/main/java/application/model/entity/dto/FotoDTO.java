package application.model.entity.dto;


import org.springframework.web.multipart.MultipartFile;

public class FotoDTO {

    private long id;

    private MultipartFile data;

    public FotoDTO(){}
    public FotoDTO(MultipartFile data) {
        this.data = data;
    }
    public MultipartFile getData() {
        return data;
    }

    public void setData(MultipartFile data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
