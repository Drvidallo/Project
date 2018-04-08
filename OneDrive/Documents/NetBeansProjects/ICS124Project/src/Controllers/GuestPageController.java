/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.Officer;
import Model.OfficerDAO;
import Model.Organization;
import Model.OrganizationDAO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author drvid
 */


public class GuestPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private TableColumn<Officer, String> collegecolumn;
    @FXML
    private TableColumn<Officer, String> firstnamecolumn;
    @FXML
    private TableColumn<Officer, String> middlenamecolumn;
    @FXML
    private TableColumn<Officer, String> acadYearcolumn;
    @FXML
    private TableColumn<Officer, String> lastnamecolumn;
    @FXML
    private TableColumn<Officer, String> positioncolumn;
  
    @FXML
    private TableColumn<Officer, String> organizationcolumn;
    
    //Uniwide
    @FXML
    private TableView<Officer> tableview;
    private ObservableList<Officer> tableviewUniwideList;
    @FXML
    private TableColumn<Officer, String> collegeuniwide;
    @FXML
    private TableColumn<Officer, String> firstnameuniwide;
 
    @FXML
    private TableColumn<Officer, String> middlenameuniwide;
    @FXML
    private TableColumn<Officer, String> acadYearuniwide;
    @FXML
    private TableColumn<Officer, String> lastnameuniwide;
    @FXML
    private TableColumn<Officer, String> orgPositionuniwide;
    @FXML
    private TableColumn<Officer, String> organizationuniwide;
     
    @FXML
    private TableView<Officer> tableviewLocal;
    private ObservableList<Officer> tableviewLocalList;
    @FXML
    private Button LogOut;
  
    @FXML
    private JFXListView<String> colEduc;
    private ObservableList<String> colEducList;
    
    @FXML
    private JFXListView<String> colArchi;
    private ObservableList<String> colArchiList;
    
    @FXML
    private JFXListView<String> colComm;
    private ObservableList<String> colCommList;
    
    @FXML
    private JFXListView<String> conMusic;
    private ObservableList<String> conMusicList;
    
    @FXML
    private JFXListView<String> colNursing;
    private ObservableList<String> colNursingList;
    
    @FXML
    private JFXListView<String> univOrg;
    private ObservableList<String> univOrgList;
    
    @FXML
    private JFXListView<String> colFineArts;
    private ObservableList<String> colFineArtsList;
    
    @FXML
    private JFXListView<String> colRehab;
    private ObservableList<String> colRehabList;
    
     @FXML
    private JFXListView<String> colTourism;
    private ObservableList<String> colTourismList;
    
    @FXML
    private JFXListView<String> colScience;
    private ObservableList<String> colScienceList;
  
    @FXML
    private JFXListView<String> facEccle;
    private ObservableList<String> facEccleList;
    
    @FXML
    private JFXListView<String> facCivilLaw;
    private ObservableList<String> facCivilLawList;
    
    @FXML
    private JFXListView<String> facMed;
    private ObservableList<String> facMedList;
     
    @FXML
    private JFXListView<String> facPharma;
    private ObservableList<String> facPharmaList; 
    
    @FXML
    private JFXListView<String> facEng;
    private ObservableList<String> facEngList;
    
    @FXML
    private JFXListView<String> facArts;
    private ObservableList<String> facArtsList; 
    
    @FXML
    private JFXListView<String> InstPhysical;
    private ObservableList<String> InstPhysicalList; 
    
    @FXML
    private JFXListView<String> InstInfo;
    private ObservableList<String> InstInfoList; 
    
    @FXML
    private JFXListView<String> ustsenior;
    private ObservableList<String> ustseniorList; 
    @FXML
    private JFXListView<String> gradschool;
    private ObservableList<String> gradschoolList; 
    
    @FXML
    private JFXListView<String> ustjunior;
    private ObservableList<String> ustjuniorList;
    
    @FXML
    private JFXListView<String> usteduc;
    private ObservableList<String> usteducList;
     @FXML
    private JFXButton logout;
     @FXML
    private Button refreshbtn;
     
    
    @FXML
    void logOutClicked(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/LoginPage.fxml"));
                Scene adminPageScene = new Scene(root);
                
                Stage adminStage;
                adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                adminStage.setTitle("Thomasian Officers and Organizations Database - Administrator Mode");
                adminStage.hide();
                adminStage.setScene(adminPageScene);
                adminStage.show();
    }
     public void connectOfficer(){
          univOrg.setOnMouseClicked(e ->{
            tableviewUniwideList.clear();
            String univString = (String)univOrg.getSelectionModel().getSelectedItem();
            List<Officer> lists = OfficerDAO.getOfficerUniwideList(univString);
            ObservableList<Officer> olist = FXCollections.observableArrayList(lists);
            tableview.setItems(olist);            
    });
        colScience.setOnMouseClicked(e ->{
            tableviewLocalList.clear();
            String colSciString = (String)colScience.getSelectionModel().getSelectedItem();
            List<Officer> lists = OfficerDAO.getOfficerList(colSciString);
            ObservableList<Officer> olist = FXCollections.observableArrayList(lists);
            tableviewLocal.setItems(olist);            
    });
        colEduc.setOnMouseClicked(e ->{
            tableviewLocalList.clear();
            String colString = (String)colEduc.getSelectionModel().getSelectedItem();
            List<Officer> lists = OfficerDAO.getOfficerList(colString);
            ObservableList<Officer> olist = FXCollections.observableArrayList(lists);
            tableviewLocal.setItems(olist);            
    });
        colArchi.setOnMouseClicked(e ->{
            tableviewLocalList.clear();
            String colString = (String)colArchi.getSelectionModel().getSelectedItem();
            List<Officer> lists = OfficerDAO.getOfficerList(colString);
            ObservableList<Officer> olist = FXCollections.observableArrayList(lists);
            tableviewLocal.setItems(olist);            
    });
         colComm.setOnMouseClicked(e ->{
            tableviewLocalList.clear();
            String colString = (String)colComm.getSelectionModel().getSelectedItem();
            List<Officer> lists = OfficerDAO.getOfficerList(colString);
            ObservableList<Officer> olist = FXCollections.observableArrayList(lists);
            tableviewLocal.setItems(olist);            
    });
          conMusic.setOnMouseClicked(e ->{
            tableviewLocalList.clear();
            String colString = (String)conMusic.getSelectionModel().getSelectedItem();
            List<Officer> lists = OfficerDAO.getOfficerList(colString);
            ObservableList<Officer> olist = FXCollections.observableArrayList(lists);
            tableviewLocal.setItems(olist);            
    });
           colNursing.setOnMouseClicked(e ->{
            tableviewLocalList.clear();
            String colString = (String)colNursing.getSelectionModel().getSelectedItem();
            List<Officer> lists = OfficerDAO.getOfficerList(colString);
            ObservableList<Officer> olist = FXCollections.observableArrayList(lists);
            tableviewLocal.setItems(olist);            
    });
            colFineArts.setOnMouseClicked(e ->{
            tableviewLocalList.clear();
            String colString = (String)colFineArts.getSelectionModel().getSelectedItem();
            List<Officer> lists = OfficerDAO.getOfficerList(colString);
            ObservableList<Officer> olist = FXCollections.observableArrayList(lists);
            tableviewLocal.setItems(olist);            
    });
             colTourism.setOnMouseClicked(e ->{
            tableviewLocalList.clear();
            String colString = (String)colTourism.getSelectionModel().getSelectedItem();
            List<Officer> lists = OfficerDAO.getOfficerList(colString);
            ObservableList<Officer> olist = FXCollections.observableArrayList(lists);
            tableviewLocal.setItems(olist);            
    }); colRehab.setOnMouseClicked(e ->{
            tableviewLocalList.clear();
            String colString = (String)colRehab.getSelectionModel().getSelectedItem();
            List<Officer> lists = OfficerDAO.getOfficerList(colString);
            ObservableList<Officer> olist = FXCollections.observableArrayList(lists);
            tableviewLocal.setItems(olist);            
    });
     facEccle.setOnMouseClicked(e ->{
            tableviewLocalList.clear();
            String colString = (String)facEccle.getSelectionModel().getSelectedItem();
            List<Officer> lists = OfficerDAO.getOfficerList(colString);
            ObservableList<Officer> olist = FXCollections.observableArrayList(lists);
            tableviewLocal.setItems(olist);            
    });
     facCivilLaw.setOnMouseClicked(e ->{
            tableviewLocalList.clear();
            String colString = (String)facCivilLaw.getSelectionModel().getSelectedItem();
            List<Officer> lists = OfficerDAO.getOfficerList(colString);
            ObservableList<Officer> olist = FXCollections.observableArrayList(lists);
            tableviewLocal.setItems(olist);            
    });
     facMed.setOnMouseClicked(e ->{
            tableviewLocalList.clear();
            String colString = (String)facMed.getSelectionModel().getSelectedItem();
            List<Officer> lists = OfficerDAO.getOfficerList(colString);
            ObservableList<Officer> olist = FXCollections.observableArrayList(lists);
            tableviewLocal.setItems(olist);            
    });
     facPharma.setOnMouseClicked(e ->{
            tableviewLocalList.clear();
            String colString = (String)facPharma.getSelectionModel().getSelectedItem();
            List<Officer> lists = OfficerDAO.getOfficerList(colString);
            ObservableList<Officer> olist = FXCollections.observableArrayList(lists);
            tableviewLocal.setItems(olist);            
    });
     facEng.setOnMouseClicked(e ->{
            tableviewLocalList.clear();
            String colString = (String)facEng.getSelectionModel().getSelectedItem();
            List<Officer> lists = OfficerDAO.getOfficerList(colString);
            ObservableList<Officer> olist = FXCollections.observableArrayList(lists);
            tableviewLocal.setItems(olist);            
    });
     facArts.setOnMouseClicked(e ->{
            tableviewLocalList.clear();
            String colString = (String)facArts.getSelectionModel().getSelectedItem();
            List<Officer> lists = OfficerDAO.getOfficerList(colString);
            ObservableList<Officer> olist = FXCollections.observableArrayList(lists);
            tableviewLocal.setItems(olist);            
    });
     InstPhysical.setOnMouseClicked(e ->{
            tableviewLocalList.clear();
            String colString = (String)InstPhysical.getSelectionModel().getSelectedItem();
            List<Officer> lists = OfficerDAO.getOfficerList(colString);
            ObservableList<Officer> olist = FXCollections.observableArrayList(lists);
            tableviewLocal.setItems(olist);            
    });
     InstInfo.setOnMouseClicked(e ->{
            tableviewLocalList.clear();
            String colString = (String)InstInfo.getSelectionModel().getSelectedItem();
            List<Officer> lists = OfficerDAO.getOfficerList(colString);
            ObservableList<Officer> olist = FXCollections.observableArrayList(lists);
            tableviewLocal.setItems(olist);            
    });
     ustsenior.setOnMouseClicked(e ->{
            tableviewLocalList.clear();
            String colString = (String)ustsenior.getSelectionModel().getSelectedItem();
            List<Officer> lists = OfficerDAO.getOfficerList(colString);
            ObservableList<Officer> olist = FXCollections.observableArrayList(lists);
            tableviewLocal.setItems(olist);            
    });
     gradschool.setOnMouseClicked(e ->{
            tableviewLocalList.clear();
            String colString = (String)gradschool.getSelectionModel().getSelectedItem();
            List<Officer> lists = OfficerDAO.getOfficerList(colString);
            ObservableList<Officer> olist = FXCollections.observableArrayList(lists);
            tableviewLocal.setItems(olist);            
    });
     ustjunior.setOnMouseClicked(e ->{
            tableviewLocalList.clear();
            String colString = (String)ustjunior.getSelectionModel().getSelectedItem();
            List<Officer> lists = OfficerDAO.getOfficerList(colString);
            ObservableList<Officer> olist = FXCollections.observableArrayList(lists);
            tableviewLocal.setItems(olist);            
    });
     usteduc.setOnMouseClicked(e ->{
            tableviewLocalList.clear();
            String colString = (String)usteduc.getSelectionModel().getSelectedItem();
            List<Officer> lists = OfficerDAO.getOfficerList(colString);
            ObservableList<Officer> olist = FXCollections.observableArrayList(lists);
            tableviewLocal.setItems(olist);            
    });
    
    }
     @FXML
      void refreshBtnClicked(ActionEvent event) {
        getOfficer();
        getOfficerUniwide();
    }
     
    public void setColEduc(){
        List<String> org= OrganizationDAO.getLocalColEducListName();
       colEducList= FXCollections.observableArrayList(org);
       colEduc.setItems(colEducList);
           }  
    public void setColArchi(){
        List<String> org= OrganizationDAO.getLocalColArchiListName();
       colArchiList= FXCollections.observableArrayList(org);
       colArchi.setItems(colArchiList);
           }
     public void setColComm(){
        List<String> org= OrganizationDAO.getLocalColCommListName();
       colCommList= FXCollections.observableArrayList(org);
       colComm.setItems(colCommList);
           }
    public void setConMusic(){
        List<String> org= OrganizationDAO.getLocalConMusicListName();
       conMusicList= FXCollections.observableArrayList(org);
       conMusic.setItems(conMusicList);
           }
    public void setColNursing(){
        List<String> org= OrganizationDAO.getLocalColNursingListName();
       colNursingList= FXCollections.observableArrayList(org);
       colNursing.setItems(colNursingList);
           }
    public void setColRehab(){
        List<String> org= OrganizationDAO.getLocalColRehabListName();
       colRehabList= FXCollections.observableArrayList(org);
       colRehab.setItems(colRehabList);
           }
    public void setColFineArts(){
        List<String> org= OrganizationDAO.getLocalColFineArtsListName();
       colFineArtsList= FXCollections.observableArrayList(org);
       colFineArts.setItems(colFineArtsList);
           }
    public void setColTourism(){
        List<String> org= OrganizationDAO.getLocalcolTourismListName();
       colTourismList= FXCollections.observableArrayList(org);
       colTourism.setItems(colTourismList);
           }
    public void setColScience(){
        List<String> org= OrganizationDAO.getLocalcolScienceListName();
       colScienceList= FXCollections.observableArrayList(org);
       colScience.setItems(colScienceList);
           }
    
    public void setFacCivilLaw(){
        List<String> org= OrganizationDAO.getLocalfacCivilLawListName();
       facCivilLawList= FXCollections.observableArrayList(org);
       facCivilLaw.setItems(facCivilLawList);
           }
    
    public void setFacEccle(){
        List<String> org= OrganizationDAO.getLocalfacEccleListName();
       facEccleList= FXCollections.observableArrayList(org);
       facEccle.setItems(facEccleList);
           }
    
    public void setFacMed(){
        List<String> org= OrganizationDAO.getLocalfacMedListName();
       facMedList= FXCollections.observableArrayList(org);
       facMed.setItems(facMedList);
           }
    
    public void setFacPharma(){
        List<String> org= OrganizationDAO.getLocalfacPharmaListName();
       facPharmaList= FXCollections.observableArrayList(org);
       facPharma.setItems(facPharmaList);
           }
    
    public void setFacArts(){
        List<String> org= OrganizationDAO.getLocalfacArtsListName();
       facArtsList= FXCollections.observableArrayList(org);
       facArts.setItems(facArtsList);
           }
    
    public void setFacEng(){
        List<String> org= OrganizationDAO.getLocalfacEngListName();
       facEngList= FXCollections.observableArrayList(org);
       facEng.setItems(facEngList);
           }
    
    public void setInstPhysical(){
        List<String> org= OrganizationDAO.getLocalInstPhysicalListName();
       InstPhysicalList= FXCollections.observableArrayList(org);
       InstPhysical.setItems(InstPhysicalList);
           }
    
    public void setInstInfo(){
        List<String> org= OrganizationDAO.getLocalInstInfoListName();
       InstInfoList= FXCollections.observableArrayList(org);
       InstInfo.setItems(InstInfoList);
           }
    
    public void setUstEducHigh(){
        List<String> org= OrganizationDAO.getLocalUstEducListName();
       usteducList= FXCollections.observableArrayList(org);
       usteduc.setItems(usteducList);
           }
    
    public void setUstJuniorHigh(){
        List<String> org= OrganizationDAO.getLocalUstJuniorListName();
       ustjuniorList= FXCollections.observableArrayList(org);
       ustjunior.setItems(ustjuniorList);
           }
    
    public void setUstSeniorHigh(){
        List<String> org= OrganizationDAO.getLocalUstSeniorListName();
       ustseniorList= FXCollections.observableArrayList(org);
       ustsenior.setItems(ustseniorList);
           }
    
    public void setUstGradSchool(){
        List<String> org= OrganizationDAO.getLocalGradSchoolListName();
       gradschoolList= FXCollections.observableArrayList(org);
       gradschool.setItems(gradschoolList);
           }
    
      public void setUnivOrgList(){
       List<String> org= OrganizationDAO.getUniWideListStringName();
       univOrgList= FXCollections.observableArrayList(org);
       univOrg.setItems(univOrgList);
       }

    public void getOfficer(){
        List<Officer> classOfficer = OfficerDAO.getOfficerList();
       tableviewLocalList = FXCollections.observableArrayList(classOfficer);
       tableviewLocal.setItems(tableviewLocalList);
    }
    public void getOfficerUniwide(){
        List<Officer> classOfficer = OfficerDAO.getOfficerUniwideList();
       tableviewUniwideList = FXCollections.observableArrayList(classOfficer);
       tableview.setItems(tableviewUniwideList);
    }
      private void setTableLocal(){
     
        firstnamecolumn.setCellValueFactory(new PropertyValueFactory<Officer, String>("firstname"));
        lastnamecolumn.setCellValueFactory(new PropertyValueFactory<Officer, String>("lastname"));
        middlenamecolumn.setCellValueFactory(new PropertyValueFactory<Officer, String>("middlename"));
        
        collegecolumn.setCellValueFactory(new PropertyValueFactory<Officer, String>("college"));
      
        organizationcolumn.setCellValueFactory(new PropertyValueFactory<Officer, String>("organization"));
        positioncolumn.setCellValueFactory(new PropertyValueFactory<Officer, String>("orgPosition"));
        acadYearcolumn.setCellValueFactory(new PropertyValueFactory<Officer, String>("acadYear"));    
    }
      private void setTableUniwide(){
       
        firstnameuniwide.setCellValueFactory(new PropertyValueFactory<Officer, String>("firstname"));
        lastnameuniwide.setCellValueFactory(new PropertyValueFactory<Officer, String>("lastname"));
        middlenameuniwide.setCellValueFactory(new PropertyValueFactory<Officer, String>("middlename"));
        
        collegeuniwide.setCellValueFactory(new PropertyValueFactory<Officer, String>("college"));
       
        organizationuniwide.setCellValueFactory(new PropertyValueFactory<Officer, String>("organization"));
        orgPositionuniwide.setCellValueFactory(new PropertyValueFactory<Officer, String>("orgPosition"));
        acadYearuniwide.setCellValueFactory(new PropertyValueFactory<Officer, String>("acadYear"));    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        setTableLocal();
        setTableUniwide();
        getOfficer();
        getOfficerUniwide();
        
        setColEduc();
        setColArchi();
        setColComm();
        setConMusic();
        setColNursing();
        setColFineArts();
        setColRehab();
        setColTourism();
        setColScience();
        
        setFacCivilLaw();
        setFacEccle();
        setFacEng();
        setFacArts();
        setFacPharma();
        setInstPhysical();
        setInstInfo();
        setUstEducHigh();
        setUstJuniorHigh();
        setUstSeniorHigh();
        setUstGradSchool();
        setUnivOrgList();
        
        connectOfficer();
    }    
    
}
