package lk.edu.ijse.metromanagement.controller;

import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import lk.edu.ijse.metromanagement.business.custom.RegistrationBO;
import lk.edu.ijse.metromanagement.business.custom.WetherBO;
import lk.edu.ijse.metromanagement.business.custom.impl.RegistrationBOImpl;
import lk.edu.ijse.metromanagement.business.custom.impl.WetherBOImpl;
import lk.edu.ijse.metromanagement.common.NotificationController;
import lk.edu.ijse.metromanagement.generator.IDGenerator;
import lk.edu.ijse.metromanagement.model.*;
import lk.edu.ijse.metromanagement.validation.ValidationController;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SynopDataController implements Initializable {

    @FXML
    private JFXTextField txtWetherID;

    @FXML
    private JFXDatePicker dateTodayDate;

    @FXML
    private JFXComboBox<String> comboTImePerioud;

    @FXML
    private JFXTextField txtRegID;

    @FXML
    private JFXTabPane tabPane;

    @FXML
    private JFXTextField txtAttdThermo;

    @FXML
    private JFXTextField txtAsReadInInches;

    @FXML
    private JFXTextField txtLevelMbs;

    @FXML
    private JFXTextField txtGMLevelMBS;

    @FXML
    private JFXTextField txtBaroTendancy;

    @FXML
    private JFXCheckBox rbtnNegetive;

    @FXML
    private JFXTextField txtAsRead_CurrentDry;

    @FXML
    private JFXTextField txtAsRead_CurrentWet;

    @FXML
    private JFXTextField txtAsRead_MaxDry;

    @FXML
    private JFXTextField txtAsRead_MaxWet;

    @FXML
    private JFXTextField txtAsRead_MinDry;

    @FXML
    private JFXTextField txtAsRead_MinWet;

    @FXML
    private JFXTextField txtAsRead_MinOnGrass;

    @FXML
    private JFXTextField txtAfterReseting_CurrentDry;

    @FXML
    private JFXTextField txtAfterReseting_CurrentWet;

    @FXML
    private JFXTextField txtVaporPressure_Current;

    @FXML
    private JFXTextField txtVaporPressure_MaxTemps;

    @FXML
    private JFXTextField txtVaporPrressure_MinTemps;

    @FXML
    private JFXTextField txtRelativeHumidity_Current;

    @FXML
    private JFXTextField txtRelativeHumidity_MaxTemps;

    @FXML
    private JFXTextField txtRelativeHumidity_MinTemps;

    @FXML
    private JFXTextField txtVisibility;

    @FXML
    private JFXTextField txtIndexCorr_CurDry;

    @FXML
    private JFXTextField txtIndexCorr_CurrentWet;

    @FXML
    private JFXTextField txtIndexCorr_MaxDry;

    @FXML
    private JFXTextField txtIndexCorr_MaxWet;

    @FXML
    private JFXTextField txtIndexCorr_MinDry;

    @FXML
    private JFXTextField txtIndexCorr_MinWet;

    @FXML
    private JFXTextField txtIndexCorr_MinOnGrass;

    @FXML
    private JFXTextField txtDewPoint_CurrDry;

    @FXML
    private JFXTextField txtDewPoint_MaxTemp;

    @FXML
    private JFXTextField txtDewPoint_MinTemp;

    @FXML
    private JFXTextField windDrectionTxt;

    @FXML
    private JFXTextField meterFirstReadTxt;

    @FXML
    private JFXTextField meterSecReadTxt;

    @FXML
    private JFXTextField forceInKmhTxt;

    @FXML
    private JFXTextField forceInKnotsTxt;

    @FXML
    private JFXTextField milagePreTxt;

    @FXML
    private JFXTextField txtRain_SinceLOB;

    @FXML
    private JFXTextField txtRain_LRO;

    @FXML
    private JFXTextField txtRain_PreHrs;

    @FXML
    private JFXTextField txtRain_FromJanuaray;

    @FXML
    private JFXTextField txtLCLAmount;

    @FXML
    private JFXTextField txtLCLDirection;

    @FXML
    private JFXTextField txtMCLAmount;

    @FXML
    private JFXTextField txtMCLDirection;

    @FXML
    private JFXTextField hifghCloudAmount;

    @FXML
    private JFXTextField highCloudForm;

    @FXML
    private JFXComboBox<String> comboMCLForm;

    @FXML
    private JFXComboBox<String> comboLCLForm;

    @FXML
    private JFXComboBox<String> highCloudFormCombo;

    @FXML
    private JFXTextField txtSGAmount;

    @FXML
    private JFXTextField txtSGTotal;

    @FXML
    private JFXComboBox<Integer> comboSGForm;

    @FXML
    private JFXTextField txtCodeFigure_Sea;

    @FXML
    private JFXTextField txtCodeFigure_Swell;

    @FXML
    private JFXTextField txtWValue;

    @FXML
    private JFXTextField txtW1Value;

    @FXML
    private JFXTextField presentObs;

    @FXML
    private JFXTextField txtCurrentUser;

    @FXML
    private JFXTextField txtSection1;

    @FXML
    private JFXTextField txtSection2;

    @FXML
    private JFXTextField txtSection3;

    @FXML
    private JFXTextField txtSection5;

    @FXML
    private JFXTextField txtSGHeigiht;

    @FXML
    private Tab synopCodePane;

    @FXML
    private Tab tabSeaState;

    @FXML
    private Tab tabCloud;

    @FXML
    private Tab tabRainNWind;

    @FXML
    private Tab tabTempNHumidity;

    private static WetherBO wetherBO = new WetherBOImpl();

    private static RegistrationBO registrationBO = new RegistrationBOImpl();

    @FXML
    void BtnPreviewOnAction(ActionEvent event) {
        tabPane.getSelectionModel().select(synopCodePane);

        txtSection1.setText("AAXX");

        txtSection2.setText(
                "22" + txtVisibility.getText() + "        " + "44495"  + "        " + "170030"
        );

        txtSection3.setText(
                "10" + txtLevelMbs.getText() + "        " + "20" + txtDewPoint_CurrDry.getText() + "        " + "30" + txtVaporPressure_Current.getText() + "        " + "40" + txtCodeFigure_Sea.getText() + "        "
                + "70" + txtRain_LRO.getText() + "        " + "80" + comboLCLForm.getSelectionModel().getSelectedItem() + txtSGTotal.getText() + "        "
                + "22" + txtRelativeHumidity_MinTemps.getText() + "        " + "9" + txtBaroTendancy.getText() + "        "
        );

        txtSection5.setText(
                "7" + txtRain_PreHrs.getText() + "        " + "8" + highCloudFormCombo.getSelectionModel().getSelectedItem() + txtSGTotal.getText()
                + "        " + "6" + comboMCLForm.getSelectionModel().getSelectedItem() + txtMCLDirection.getText() + "        " + "40" + txtCodeFigure_Sea.getText() + "        "
        );
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws Exception {
        if (ValidationController.isEmpety(txtAttdThermo)){
            if (ValidationController.isEmpety(txtAsRead_CurrentDry)){
                if (ValidationController.isEmpety(txtAfterReseting_CurrentDry)){
                    if (ValidationController.isEmpety(txtIndexCorr_CurDry)){
                        if (ValidationController.isEmpety(txtDewPoint_CurrDry)){
                            if (ValidationController.isEmpety(txtVaporPressure_Current)){
                                if (ValidationController.isEmpety(txtRelativeHumidity_Current)){
                                    if (ValidationController.isEmpety(txtVisibility)){
                                        if (ValidationController.isEmpety(windDrectionTxt)){
                                            if (ValidationController.isEmpety(forceInKmhTxt)){
                                                if (ValidationController.isEmpety(txtRain_SinceLOB)){
                                                    if (ValidationController.isEmpety(txtLCLAmount)){
                                                        if (ValidationController.isEmpety(txtSGAmount)){
                                                            if (ValidationController.isEmpety(txtSGTotal)){
                                                                if (ValidationController.isEmpety(txtCodeFigure_Sea)){
                                                                    if (ValidationController.isEmpety(presentObs)){
                                                                        saveWether();
                                                                    }else {
                                                                        NotificationController.createError("Error", "Present Obs cannot be empty");
                                                                        tabPane.getSelectionModel().select(tabSeaState);
                                                                        presentObs.requestFocus();
                                                                    }
                                                                }else {
                                                                    NotificationController.createError("Error", "Sea code figure cannot be empty");
                                                                    tabPane.getSelectionModel().select(tabSeaState);
                                                                    txtCodeFigure_Sea.requestFocus();
                                                                }
                                                            }else {
                                                                NotificationController.createError("Error", "Significent Layer Cloud total cannot be empty");
                                                                tabPane.getSelectionModel().select(tabCloud);
                                                                txtSGTotal.requestFocus();
                                                            }
                                                        }else {
                                                            NotificationController.createError("Error", "Significent Layer Cloud Amount cannot be empty");
                                                            tabPane.getSelectionModel().select(tabCloud);
                                                            txtSGAmount.requestFocus();
                                                        }
                                                    }else {
                                                        NotificationController.createError("Error", "Low Cloud Amount current be empty");
                                                        tabPane.getSelectionModel().select(tabCloud);
                                                        txtLCLAmount.requestFocus();
                                                    }
                                                }else {
                                                    NotificationController.createError("Error", "Since last Obs cannot be empty");
                                                    tabPane.getSelectionModel().select(tabRainNWind);
                                                    txtRain_SinceLOB.requestFocus();
                                                }
                                            }else {
                                                NotificationController.createError("Error", "Force in kilometer per hour cannot be empty");
                                                tabPane.getSelectionModel().select(tabRainNWind);
                                                forceInKmhTxt.requestFocus();
                                            }
                                        }else {
                                            NotificationController.createError("Error", "Wind Direction cannot be empty");
                                            tabPane.getSelectionModel().select(tabRainNWind);
                                            windDrectionTxt.requestFocus();
                                        }
                                    }else {
                                        NotificationController.createError("Error", "Visibility cannot be empty");
                                        tabPane.getSelectionModel().select(tabTempNHumidity);
                                        txtVisibility.requestFocus();
                                    }
                                }else {
                                    NotificationController.createError("Error", "Relative humidity current cannot be empty");
                                    tabPane.getSelectionModel().select(tabTempNHumidity);
                                    txtRelativeHumidity_Current.requestFocus();
                                }
                            }else {
                                NotificationController.createError("Error", "Vapor Pressure Current pressure Cannot be empty");
                                tabPane.getSelectionModel().select(tabTempNHumidity);
                                txtVaporPressure_Current.requestFocus();
                            }
                        }else {
                            NotificationController.createError("Error", "Dew point current cannot be empty");
                            tabPane.getSelectionModel().select(tabTempNHumidity);
                            txtDewPoint_CurrDry.requestFocus();
                        }
                    }else {
                        NotificationController.createError("Error", "Index correction current dry cannot be empety");
                        tabPane.getSelectionModel().select(tabTempNHumidity);
                        txtIndexCorr_CurDry.requestFocus();
                    }
                }else {
                    NotificationController.createError("Error", "After Resetting current dry cannot be empty");
                    txtAfterReseting_CurrentDry.requestFocus();
                }
            }else {
                NotificationController.createError("Error", "Temeperature as read Current Dry Cannot be Empty");
                txtAsRead_CurrentDry.requestFocus();
            }
        }else {
            NotificationController.createError("Error", "Attd Themometer details Cannot be Empty");
            txtAttdThermo.requestFocus();
        }
    }

    private void saveWether() throws Exception {
        String wetherID = txtWetherID.getText();
        String barometerID = IDGenerator.getNewID("Barometer", "barometerID", "BRM");
        double attdThermo = Double.parseDouble(txtAttdThermo.getText());
        double asReadInInches = Double.parseDouble(txtAsReadInInches.getText());
        double levelMBS = Double.parseDouble(txtLevelMbs.getText());
        double gmLevel = Double.parseDouble(txtGMLevelMBS.getText());
        int baroTendancy = Integer.parseInt(txtBaroTendancy.getText());

        BarometerDTO barometerDTO = new BarometerDTO(barometerID, attdThermo, asReadInInches, levelMBS, gmLevel, baroTendancy, wetherID);

        String thermometerID = IDGenerator.getNewID("thermometer", "thermometerID", "THM");
        int arCur = Integer.parseInt(txtAfterReseting_CurrentDry.getText());
        int arMaxDry = Integer.parseInt(txtAsRead_MaxDry.getText());
        int arMaxWet = Integer.parseInt(txtAsRead_MaxWet.getText());
        int arMinDry = Integer.parseInt(txtAsRead_MinDry.getText());
        int arMinWet = Integer.parseInt(txtAsRead_MinWet.getText());
        int arMinOnGrass = Integer.parseInt(txtAsRead_MinWet.getText());
        int aftRestCurDry = Integer.parseInt(txtAfterReseting_CurrentDry.getText());
        int aftRestCurWet = Integer.parseInt(txtAfterReseting_CurrentWet.getText());
        int icCurDry = Integer.parseInt(txtIndexCorr_CurDry.getText());
        int icCurWet = Integer.parseInt(txtIndexCorr_CurrentWet.getText());
        int icMaxDry = Integer.parseInt(txtIndexCorr_MaxDry.getText());
        int icMaxWet = Integer.parseInt(txtIndexCorr_MaxWet.getText());
        int icMinDry = Integer.parseInt(txtIndexCorr_MinDry.getText());
        int icMinWet = Integer.parseInt(txtIndexCorr_MinWet.getText());
        int icMinOnGrass = Integer.parseInt(txtIndexCorr_MinOnGrass.getText());
        int dpCurTemp = Integer.parseInt(txtDewPoint_CurrDry.getText());
        int dpMaxTemps = Integer.parseInt(txtDewPoint_MaxTemp.getText());
        int dpMinTemps = Integer.parseInt(txtDewPoint_MinTemp.getText());

        ThermometerDTO thermometerDTO = new ThermometerDTO(thermometerID, arCur, arMaxDry, arMaxWet, arMinDry, arMinWet, arMinOnGrass, aftRestCurDry, aftRestCurWet, icCurDry, icCurWet, icMaxDry, icMaxWet, icMinDry, icMinWet, icMinOnGrass, dpCurTemp, dpMaxTemps, dpMinTemps, wetherID);

        String humidityID = IDGenerator.getNewID("Humidity", "humidityID", "HUM");
        int vpCurrent = Integer.parseInt(txtVaporPressure_Current.getText());
        int vpMaxTemps = Integer.parseInt(txtVaporPressure_MaxTemps.getText());
        int vpMinTemps = Integer.parseInt(txtVaporPrressure_MinTemps.getText());
        int rhCurrent = Integer.parseInt(txtRelativeHumidity_Current.getText());
        int rhMaxTemps = Integer.parseInt(txtRelativeHumidity_MaxTemps.getText());
        int rhMinTemps = Integer.parseInt(txtRelativeHumidity_MinTemps.getText());
        String visibility = txtVisibility.getText();

        HumidityDTO humidityDTO = new HumidityDTO(humidityID, vpCurrent, vpMaxTemps, vpMinTemps, rhCurrent, rhMaxTemps, rhMinTemps, visibility, wetherID);

        String windID = IDGenerator.getNewID("wind", "windID", "WND");
        String windDirection = windDrectionTxt.getText();

        int frceInKMH = Integer.parseInt(forceInKmhTxt.getText());
        int frceInKnots = Integer.parseInt(forceInKnotsTxt.getText());
        String mileagePer = milagePreTxt.getText();
        String firstRead = meterFirstReadTxt.getText();
        String secRead = meterSecReadTxt.getText();
        WindDTO windDTO = new WindDTO(windID, windDirection, firstRead, secRead, frceInKMH, frceInKnots, mileagePer, wetherID);

        String rainID = IDGenerator.getNewID("rain", "rainID", "RNM");
        double lastObs = Double.parseDouble(txtRain_SinceLOB.getText());
        double lastRoute = Double.parseDouble(txtRain_LRO.getText());
        double pre8Hrs = Double.parseDouble(txtRain_PreHrs.getText());
        double janFirst = Double.parseDouble(txtRain_FromJanuaray.getText());

        RainDTO rainDTO = new RainDTO(rainID, lastObs, lastRoute, pre8Hrs, janFirst, wetherID);

        String cloudID = IDGenerator.getNewID("cloud", "cloudID", "CLM");
        int lcAmount = Integer.parseInt(txtLCLAmount.getText());
        String lcForm = comboLCLForm.getSelectionModel().getSelectedItem();
        int lcDirection = Integer.parseInt(txtLCLDirection.getText());
        int mcAmount = Integer.parseInt(txtMCLAmount.getText());
        String mcForm = comboMCLForm.getSelectionModel().getSelectedItem();
        int mcDirection = Integer.parseInt(txtMCLDirection.getText());
        int hcAmount = Integer.parseInt(hifghCloudAmount.getText());
        String hcForm = highCloudFormCombo.getSelectionModel().getSelectedItem();
        int hcDirection = Integer.parseInt(highCloudForm.getText());
        int sgAmount = Integer.parseInt(txtSGAmount.getText());
        int sgForm = Integer.parseInt(comboSGForm.getSelectionModel().getSelectedItem().toString());
        int sgHeight = Integer.parseInt(txtSGHeigiht.getText());
        int totalAmount = Integer.parseInt(txtSGTotal.getText());

        CloudDTO cloudDTO = new CloudDTO(cloudID, lcAmount, lcForm, lcDirection, mcAmount, mcForm, mcDirection, hcAmount, hcForm, hcDirection, sgAmount, sgForm, sgHeight, totalAmount, wetherID);

        String seaStateID = IDGenerator.getNewID("seastate", "seaStateID", "SSM");
        String seaCodeFigure = txtCodeFigure_Sea.getText();
        String swellCodeFigure = txtCodeFigure_Swell.getText();
        int wValue = Integer.parseInt(txtWValue.getText());
        int w1Value = Integer.parseInt(txtW1Value.getText());
        int wwValue = Integer.parseInt(presentObs.getText());

        SeaStateDTO seaStateDTO = new SeaStateDTO(seaStateID, seaCodeFigure, swellCodeFigure, wValue, w1Value, wwValue, wetherID);

        WetherDTO wetherDTO = new WetherDTO(
                wetherID,
                comboTImePerioud.getSelectionModel().getSelectedItem(),
                dateTodayDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                txtRegID.getText(),
                barometerDTO,
                thermometerDTO,
                humidityDTO,
                cloudDTO,
                windDTO,
                rainDTO,
                seaStateDTO
        );
        boolean result = wetherBO.addWether(wetherDTO);
        if (result) {
            NotificationController.createSuccesful("Successful", "Wether Details was added!");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadWetherDetail();
            setDefaltValues();
        } catch (Exception e) {
            NotificationController.createError("Error", "Something Went Wrong "+ e.getMessage());
            Logger.getLogger(SynopDataController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void setDefaltValues() {
        txtCurrentUser.setText("Admin");
    }

    private void loadWetherDetail() throws Exception {
        txtWetherID.setText(IDGenerator.getNewID("wether", "wetherid", "WET"));
        dateTodayDate.setValue(LocalDate.now());
        setAllCombos();
        RegistrationDTO searchRegistration = registrationBO.searchRegistration("MTU001");
        txtRegID.setText(searchRegistration.getRegisterID());
    }

    private void setAllCombos() {
        setTimeCombo();
        setCloudForms();
        setDefaultSelect();
    }

    private void setDefaultSelect() {
        comboLCLForm.getSelectionModel().selectFirst();
        comboMCLForm.getSelectionModel().selectFirst();
        highCloudFormCombo.getSelectionModel().selectFirst();
        comboSGForm.getSelectionModel().selectFirst();
        comboTImePerioud.getSelectionModel().selectFirst();
    }

    private void setCloudForms() {
        ArrayList<String> forms = new ArrayList<>();
        for (int i = 0; i<8; i++){
            forms.add("0"+i);
        }
        comboLCLForm.getItems().setAll(forms);
        comboMCLForm.getItems().setAll(forms);
        highCloudFormCombo.getItems().setAll(forms);
        for (String form : forms) {
            comboSGForm.getItems().add(Integer.parseInt(form));
        }
    }

    private void setTimeCombo() {
        comboTImePerioud.getItems().add("02:30");
        comboTImePerioud.getItems().add("05:30");
        comboTImePerioud.getItems().add("08:30");
        comboTImePerioud.getItems().add("11:30");
        comboTImePerioud.getItems().add("14:30");
        comboTImePerioud.getItems().add("17:30");
        comboTImePerioud.getItems().add("20:30");
        comboTImePerioud.getItems().add("21:30");
    }
}
