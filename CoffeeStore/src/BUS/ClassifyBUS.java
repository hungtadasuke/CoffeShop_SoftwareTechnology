package BUS;

import DAO.ClassifyDAO;
import DTO.ClassifyDTO;
import java.util.Vector;

public class ClassifyBUS {
    //attribute
    private Vector<ClassifyDTO> classifyList;
    private ClassifyDAO classifyDAO;
    
    //constructor
    public ClassifyBUS() {
        this.classifyDAO = new ClassifyDAO();
        this.classifyList = classifyDAO.readClassifyListFromDatabase();
    }
    
    //setter and getter
    public Vector<ClassifyDTO> getClassifyList() {
        return classifyList;
    }

    public void setClassifyList(Vector<ClassifyDTO> classifyList) {
        this.classifyList = classifyList;
    }

    public ClassifyDAO getClassifyDAO() {
        return classifyDAO;
    }

    public void setClassifyDAO(ClassifyDAO classifyDAO) {
        this.classifyDAO = classifyDAO;
    }
    
    
    //method
    //process get classify list from ClassifyDAO class
    public void resetClassifyList() {
        this.setClassifyList(this.getClassifyDAO().readClassifyListFromDatabase());
    }
    
    public ClassifyDTO getClassifyFromId (String id) {
        ClassifyDTO classify = null;
        for(ClassifyDTO o: this.getClassifyList()) {
            if(o.getClassifyId().equalsIgnoreCase(id)) {
                return o;
            }
        }
        return classify;
    }
    
}
