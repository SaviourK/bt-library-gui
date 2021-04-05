package com.kanok.btlibrarygui.controller;

import com.kanok.btlibrarygui.ConfirmBox;
import com.kanok.btlibrarygui.model.TorrentRow;
import com.kanok.btlibrarygui.service.GuiService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class GuiController implements Initializable {

    private static final Logger logger = LoggerFactory.getLogger(GuiController.class);

    private final GuiService service;

    public BorderPane pane;

    public Stage window;

    public Button addTorrentBtn;

    public TableView<TorrentRow> table;

    public TableColumn<TorrentRow, String> nameColumn;
    public TableColumn<TorrentRow, Double> downloadedColumn;
    public TableColumn<TorrentRow, Integer> quantityColumn;

    private FileChooser fc;

    private ObservableList<TorrentRow> torrents;

    public GuiController(GuiService service) {
        this.service = service;
    }


    public void setWindow(Stage window) {
        this.window = window;
    }

    public void handleAddTorrentBtn(ActionEvent actionEvent) {
        service.handleAddTorrentBtn(actionEvent, pane, torrents);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TOOD load all torrents and start download if is downloading
        logger.info("loading user data...");
        addTableContent();
        //window = (Stage) pane.getScene().getWindow();

    }

    public void logginButtonClicked() {
        logger.info("ABC");
    }


    private void createNewTorrentAction() {
        //AlertBox.display("Add torrent", "Add new torrent");
        boolean answer = ConfirmBox.display("None", "Are you sure");
        logger.info("Are you sure: {}", answer);

    }

    private void configAddTorrentBtn() {
        logger.info("Print upload");
    }

    private void addTableContent() {


        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        downloadedColumn.setMinWidth(200);
        downloadedColumn.setCellValueFactory(new PropertyValueFactory<>("downloaded"));

        quantityColumn.setMinWidth(200);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        torrents = getTorrents();
        table.setItems(torrents);

        ContextMenu cm = new ContextMenu();
        MenuItem delete = new MenuItem("Delete");

        delete.setOnAction(e -> {
            logger.info("ab");
            TorrentRow item = table.getSelectionModel().getSelectedItem();
            cm.show(table, 2, 2);
            logger.info(item.toString());

        });
        cm.getItems().add(delete);

        //table.getColumns().addAll(downloadedColumn);
        table.setContextMenu(cm);


    }


    public ObservableList<TorrentRow> getTorrents() {
        ObservableList<TorrentRow> torrentRows = FXCollections.observableArrayList();
        torrentRows.add(new TorrentRow("Windows", 20, 1));
        torrentRows.add(new TorrentRow("ZOO Tycoon", 50, 1));
        torrentRows.add(new TorrentRow("GTA 5", 0, 1));
        return torrentRows;
    }

    private void closeProgram() {
        boolean answer = ConfirmBox.display("Close", "Sure you want to exit?");
        if (answer) {
            //window.close();
            logger.info("File saves");
        }
    }

}
