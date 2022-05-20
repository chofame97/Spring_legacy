package Member;

import lombok.Data;

@Data
public class IdDTO {
    private String id;

    public IdDTO(String id) {
        this.id = id;
    }

    public IdDTO() {
    }

   
}
