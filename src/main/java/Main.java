import JAVA_Test.ProjectBean;
import JAVA_Test.ProjectBeanCustom;
import JAVA_Test.ProjectGenericBean;
import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String titre = "Projet Recrutement";
        int numero = 10;
        Date dateDebut = new Date();
        Date dateFin = new Date("12-11-2024");
        String etat = "GOING";

        ProjectBean projectBean = new ProjectBeanCustom(titre,numero,dateDebut, dateFin, etat);

        JSONObject jsonProject = new JSONObject(projectBean);

        ProjectBean projectBeanSaved = (ProjectBean) ProjectGenericBean.saveBean(null, jsonProject, ProjectGenericBean.class, true);
    }
}