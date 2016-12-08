package BusinessLogic;


import javafx.collections.ObservableList;

public interface MyProjectInterface {
    String projectInformation(String st);
    ObservableList<String> getProjects();
    ObservableList<String> getAllProjects();
}
