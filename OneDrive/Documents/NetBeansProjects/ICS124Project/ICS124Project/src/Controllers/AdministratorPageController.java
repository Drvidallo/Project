package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Model.Officer;
import Model.OfficerDAO;
import Model.OrganizationDAO;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import javafx.stage.StageStyle;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


/**
 * FXML Controller class
 *
 * @author drvid
 */
public class AdministratorPageController implements Initializable {
    //Local
    @FXML
    private TableColumn<Officer, String> collegecolumn;
    @FXML
    private TableColumn<Officer, String> firstnamecolumn;
    @FXML
    private TableColumn<Officer, String> dateofBirthcolumn;
    @FXML
    private TableColumn<Officer, String> yearcolumn;
    @FXML
    private TableColumn<Officer, String> studnocolumn;
    @FXML
    private TableColumn<Officer, String> degreecolumn;
    @FXML
    private TableColumn<Officer, String> middlenamecolumn;
    @FXML
    private TableColumn<Officer, String> acadYearcolumn;
    @FXML
    private TableColumn<Officer, String> lastnamecolumn;
    @FXML
    private TableColumn<Officer, String> positioncolumn;
    @FXML
    private TableColumn<Officer, String> emailAddresscolumn;
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
    private TableColumn<Officer, String> dateofBirthuniwide;
    @FXML
    private TableColumn<Officer, String> yearsecuniwide;
    @FXML
    private TableColumn<Officer, String> studnouniwide;
    @FXML
    private TableColumn<Officer, String> degreeuniwide;
    @FXML
    private TableColumn<Officer, String> middlenameuniwide;
    @FXML
    private TableColumn<Officer, String> acadYearuniwide;
    @FXML
    private TableColumn<Officer, String> lastnameuniwide;
    @FXML
    private TableColumn<Officer, String> orgPositionuniwide;
    @FXML
    private TableColumn<Officer, String> emailAddressuniwide;
    @FXML
    private TableColumn<Officer, String> organizationuniwide;
     
    @FXML
    private Button refreshUniwidebtn;
     
    @FXML
    private JFXTextField searchbar;

     @FXML
    private Button refreshbtn;
    @FXML
    private Button addUniwideBtn;
    @FXML
    private ObservableList<Officer> getOfficer;
    @FXML
    private ObservableList<Officer> getOfficeruniwide;
    @FXML
    private Button LogOut;
    @FXML
    private Button addOfficerUniwide;
    @FXML
    private Button addOfficerLocal;
    @FXML
    private Button editOfficer;
    @FXML
    private Button addLocalBtn;
    
    
     private Connection conn;
     private PreparedStatement pst;
     private ResultSet rs;
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
    public JFXListView<String> facEccle;
    public ObservableList<String> facEccleList;
    
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
    private TableView<Officer> tableviewLocal;
    private ObservableList<Officer> tableviewLocalList;
    
    @FXML
    private Button exportBtn;
    @FXML
    private Button importBtn;
    
   @FXML
    void addLocalClicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("FXML/addOrganizationWindow.fxml"));
            Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setTitle("Add Organization");
                stage.setScene(new Scene(root));
                stage.show();
           
                setFacEccle();
    }

    @FXML
    void addUniwideClicked(ActionEvent event) throws IOException {
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("FXML/addUniwideOrganization.fxml"));
            Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setTitle("Add Organization");
                stage.setScene(new Scene(root));
                stage.show();
       
    }


    @FXML
    void LogOutClicked(ActionEvent event) throws IOException {
      
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/LoginPage.fxml"));
                Scene adminPageScene = new Scene(root);
                
                Stage adminStage;
                adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                adminStage.setTitle("Thomasian Officers and Organizations Database - Administrator Mode");
                adminStage.hide();
                adminStage.setScene(adminPageScene);
                adminStage.show();
    }
  
    
   // public void 
   
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
    void refreshbtnClicked(ActionEvent event) {
        getOfficer();
        
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
    }
     @FXML
    void refreshUniwidebtnClicked(ActionEvent event) {
        getOfficerUniwide();
         setUnivOrgList();
    }
    
        private void setTableLocal(){
        studnocolumn.setCellValueFactory(new PropertyValueFactory<Officer, String>("studno"));
        firstnamecolumn.setCellValueFactory(new PropertyValueFactory<Officer, String>("firstname"));
        lastnamecolumn.setCellValueFactory(new PropertyValueFactory<Officer, String>("lastname"));
        middlenamecolumn.setCellValueFactory(new PropertyValueFactory<Officer, String>("middlename"));
        dateofBirthcolumn.setCellValueFactory(new PropertyValueFactory<Officer, String>("dateofBirth"));
        emailAddresscolumn.setCellValueFactory(new PropertyValueFactory<Officer, String>("emailAddress"));
        degreecolumn.setCellValueFactory(new PropertyValueFactory<Officer, String>("degree"));
        collegecolumn.setCellValueFactory(new PropertyValueFactory<Officer, String>("college"));
        yearcolumn.setCellValueFactory(new PropertyValueFactory<Officer, String>("yearsec"));
        organizationcolumn.setCellValueFactory(new PropertyValueFactory<Officer, String>("organization"));
        positioncolumn.setCellValueFactory(new PropertyValueFactory<Officer, String>("orgPosition"));
        acadYearcolumn.setCellValueFactory(new PropertyValueFactory<Officer, String>("acadYear"));    
    }
      private void setTableUniwide(){
        studnouniwide.setCellValueFactory(new PropertyValueFactory<Officer, String>("studno"));
        firstnameuniwide.setCellValueFactory(new PropertyValueFactory<Officer, String>("firstname"));
        lastnameuniwide.setCellValueFactory(new PropertyValueFactory<Officer, String>("lastname"));
        middlenameuniwide.setCellValueFactory(new PropertyValueFactory<Officer, String>("middlename"));
        dateofBirthuniwide.setCellValueFactory(new PropertyValueFactory<Officer, String>("dateofBirth"));
        emailAddressuniwide.setCellValueFactory(new PropertyValueFactory<Officer, String>("emailAddress"));
        degreeuniwide.setCellValueFactory(new PropertyValueFactory<Officer, String>("degree"));
        collegeuniwide.setCellValueFactory(new PropertyValueFactory<Officer, String>("college"));
        yearsecuniwide.setCellValueFactory(new PropertyValueFactory<Officer, String>("yearsec"));
        organizationuniwide.setCellValueFactory(new PropertyValueFactory<Officer, String>("organization"));
        orgPositionuniwide.setCellValueFactory(new PropertyValueFactory<Officer, String>("orgPosition"));
        acadYearuniwide.setCellValueFactory(new PropertyValueFactory<Officer, String>("acadYear"));    
    }
    
       private static String url = "jdbc:sqlite:C:\\Users\\Public\\TeamPapsie.db";
    private static String EXCEL_FILE_LOCATION = "C:\\Users\\drvid\\Desktop\\ORGANIZATION.xls";
    private static String EXCEL_FILE_LOCATION2 = "C:\\Users\\drvid\\Desktop\\OFFICERS.xls";
    public static Connection cons = null;
    public static PreparedStatement ps = null;
    
        public static Connection con() {
        try {
            cons = DriverManager.getConnection(url);
            return cons;
        } catch (SQLException ex) {
            Logger.getLogger(AdministratorPageController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    @FXML
    void exportBtnClicked(ActionEvent event) {
   

        cons = con();

        WritableWorkbook myFirstWbook = null;
        WritableWorkbook myFirstWbook2 = null;
        try {
            myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION));
            myFirstWbook2 = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION2));
        } catch (IOException ex) {
            Logger.getLogger(AdministratorPageController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ps = cons.prepareStatement("SELECT * FROM ORGANIZATION");
            rs = ps.executeQuery();
            try {
        WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);

                Label label = new Label(0, 0, "ORG_ID");
                excelSheet.addCell(label);
                label = new Label(1, 0, "NAME ");
                excelSheet.addCell(label);
                label = new Label(2, 0, "YEAR_ESTABLISHED");
                excelSheet.addCell(label);
                label = new Label(3, 0, "IS_UWIDE ");
                excelSheet.addCell(label);
                label = new Label(4, 0, "CODE_COLLEGE ");
                excelSheet.addCell(label);
                int ctr = 1;
                int xz = 0;
                while (rs.next()) {
                    label = new Label(0, ctr, rs.getString(1));
                    excelSheet.addCell(label);
                    label = new Label(1, ctr, rs.getString(2));
                    excelSheet.addCell(label);
                    label = new Label(2, ctr, rs.getString(3));
                    excelSheet.addCell(label);
                    label = new Label(3, ctr, rs.getString(4));
                    excelSheet.addCell(label);
                    label = new Label(4, ctr, rs.getString(5));
                    excelSheet.addCell(label);
                    label = new Label(5, ctr, rs.getString(6));
                    excelSheet.addCell(label);
                    ctr = ctr + 1;
                }
                    myFirstWbook.write();
                    myFirstWbook.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdministratorPageController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ps = cons.prepareStatement("SELECT * FROM OFFICERS");
            rs = ps.executeQuery();
            try {

        WritableSheet excelSheet2 = myFirstWbook2.createSheet("Sheet 1", 0);
                Label label = new Label(0, 0, "ID");
                excelSheet2.addCell(label);
                label = new Label(1, 0, "studno");
                excelSheet2.addCell(label);
                label = new Label(2, 0, "firstname");
                excelSheet2.addCell(label);
                label = new Label(3, 0, "middlename");
                excelSheet2.addCell(label);
                label = new Label(4, 0, "lastname");
                excelSheet2.addCell(label);
                label = new Label(5, 0, "dateofBirth");
                excelSheet2.addCell(label);
                label = new Label(6, 0, "emailAddress");
                excelSheet2.addCell(label);
                label = new Label(7, 0, "degree");
                excelSheet2.addCell(label);
                label = new Label(8, 0, "college");
                excelSheet2.addCell(label);
                label = new Label(9, 0, "yearsec");
                excelSheet2.addCell(label);
                label = new Label(10, 0, "organization");
                excelSheet2.addCell(label);
                label = new Label(11, 0, "orgPosition");
                excelSheet2.addCell(label);
                label = new Label(12, 0, "acadYear");
                excelSheet2.addCell(label);
                
                int ctr = 1;
                int xz = 0;
                while (rs.next()) {
                    label = new Label(0, ctr, rs.getString(1));
                    excelSheet2.addCell(label);
                    label = new Label(1, ctr, rs.getString(2));
                    excelSheet2.addCell(label);
                    label = new Label(2, ctr, rs.getString(3));
                    excelSheet2.addCell(label);
                    label = new Label(3, ctr, rs.getString(4));
                    excelSheet2.addCell(label);
                    label = new Label(4, ctr, rs.getString(5));
                    excelSheet2.addCell(label);
                    label = new Label(5, ctr, rs.getString(6));
                    excelSheet2.addCell(label);
                    label = new Label(6, ctr, rs.getString(7));
                    excelSheet2.addCell(label);
                    label = new Label(7, ctr, rs.getString(8));
                    excelSheet2.addCell(label);
                    label = new Label(8, ctr, rs.getString(9));
                    excelSheet2.addCell(label);
                    label = new Label(9, ctr, rs.getString(10));
                    excelSheet2.addCell(label);
                    label = new Label(10, ctr, rs.getString(11));
                    excelSheet2.addCell(label);
                    label = new Label(11, ctr, rs.getString(12));
                    excelSheet2.addCell(label);
                    label = new Label(12, ctr, rs.getString(13));
                    excelSheet2.addCell(label);
                    ctr = ctr + 1;
                }
                    myFirstWbook2.write();
                    myFirstWbook2.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs.close();
            ps.close();

        } catch (Exception ex) {
            Logger.getLogger(AdministratorPageController.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }
    
    @FXML
    void importBtnClicked(ActionEvent event) {

    }
    
     
      @FXML
    void addOfficerLocalClicked(ActionEvent event) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("FXML/addOfficerWindow.fxml"));
            Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setTitle("Add Organization");
                stage.setScene(new Scene(root));
                stage.show();
    }
     @FXML
    void addOfficerUniwideClicked(ActionEvent event) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("FXML/addOfficerUniwide.fxml"));
            Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setTitle("Add Organization");
                stage.setScene(new Scene(root));
                stage.show();
    }
    @FXML
    void editOfficerClicked(ActionEvent event) {

    }      
    
  
    public Connection getConnection() 
    {
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/TeamPapsie", "Papsie", "Papsie");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
         
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Tables
        setTableLocal();
        setTableUniwide();
        getOfficer();
        getOfficerUniwide();
        
        setUnivOrgList();
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
        
        //On click get selection
         connectOfficer();
 
        
            }
    

            
            
    }
   
   

