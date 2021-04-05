package com.kanok.btlibrarygui.service;

import com.kanok.btlibrarygui.model.TorrentRow;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class GuiService {

    private static final Logger logger = LoggerFactory.getLogger(GuiService.class);

    private FileChooser fc;

    public void handleAddTorrentBtn(ActionEvent actionEvent, BorderPane pane, ObservableList<TorrentRow> torrents) {
        File selectedFile = getFileChooser().showOpenDialog(pane.getScene().getWindow());
        if (selectedFile != null) {
            /*file = fc.getSelectedFile();
            options.setMetaInfoFile(file);
            logger.info("Opening: " + file.getName() + ".");
            selectedFileLbl.setVisible(true);
            selectedFileLbl.setText("Selected file: " + file.getName());
            startDownload(options);*/
            torrents.add(new TorrentRow(selectedFile.getName(), 0, 0));
            logger.info("New torrent added: " + selectedFile.getName());
        } else {
            logger.info("Open command cancelled by user.");
        }
    }

    private FileChooser getFileChooser() {
        if (fc == null) {
            fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Torrent files", "*.torrent"));
        }
        return fc;
    }
}
