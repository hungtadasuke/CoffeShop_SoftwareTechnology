package DTO;

public class ClassifyDTO {
    //attribute
    private String classifyId;
    private String classifyName;
    
    //constructor
    public ClassifyDTO (String classifyId, String classifyName) {
        this.classifyId = classifyId;
        this.classifyName = classifyName;
    }
    
    //setter and getter
    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }
}
