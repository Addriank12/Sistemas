package com.example;

import java.io.IOException;
import java.util.List;

import controller.CarController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.CarModel;

public class PrimaryController {

    CarController carController = new CarController();

    @FXML
    private TableView<CarModel> dataTable;

    @FXML
    private TableColumn<CarModel, Integer> column1;

    @FXML
    private TableColumn<CarModel, String> column2;

    @FXML
    private TableColumn<CarModel, String> column3;

    @FXML
    private TextField idField;

    @FXML
    private TextField brandField;

    @FXML
    private TextField modelField;
    
    @FXML
    public void initialize() {
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));
        column2.setCellValueFactory(new PropertyValueFactory<>("brand"));
        column3.setCellValueFactory(new PropertyValueFactory<>("model"));
    }

    @FXML
    private void handleRefresh(ActionEvent event) {
        
        try {
            List<CarModel> cars = carController.getCars();
            ObservableList<CarModel> carList = FXCollections.observableArrayList(cars);
            dataTable.setItems(carList);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleNew(ActionEvent event) {
        idField.setText("");
        brandField.setText("");
        modelField.setText("");
        
    }
    
    @FXML
    private void handleSave(ActionEvent event) {
        try{
            CarModel car = new CarModel();
            car.setId(Integer.valueOf(idField.getText()));
            car.setBrand(brandField.getText());
            car.setModel(modelField.getText());
            carController.createCar(car);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void handleEdit(ActionEvent event) {
        try{
            CarModel car = new CarModel();
            car.setId(Integer.valueOf(idField.getText()));
            car.setBrand(brandField.getText());
            car.setModel(modelField.getText());
            carController.updateCar(String.valueOf(car.getId()), car);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void handleDelete(ActionEvent event) {
        try{
            carController.deleteCar(idField.getText());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



}
