package com.example.simpleimageview;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.lang.reflect.Array;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class HelloController implements Initializable {
    @FXML
    private String path = "images";
    @FXML
    private String[] files;
    @FXML
    private int index;
    @FXML
    private Label imagesInfo;
    @FXML
    private ImageView imageView;
    @FXML
    private Button nextButton;

    public void setPath(String path) {
        this.path = path;
    }

    public void setFiles(String[] files) {
        this.files = files;
    }

    public void initialize(URL location, ResourceBundle resources) {
        File file = new File(path);
        setFiles(file.list());
        System.out.println(Arrays.toString(files));
        updateLabel();
        imageView.setImage(new Image("file:" +path + "/" + files[index++] ));
        index = 0;

    }
    @FXML
    protected void onNextButtonClick() {
        index++;
        if(index == files.length){
            index = 0;
        }
        System.out.println(index);
        updateLabel();
        imageView.setImage(new Image("file:" +path + "/" + files[index] ));





    }
    @FXML
    protected void chooseDirectory(){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Wybierz folder z grafiką");
        File file = directoryChooser.showDialog(imagesInfo.getScene().getWindow());
        setPath(file.toString());
        setFiles(file.list());
        System.out.println(Arrays.toString(files));
        index = 0;
        imageView.setImage(new Image("file:" +path + "/" + files[index++] ));
        updateLabel();

    }
    @FXML
    protected void onPreviousButtonClick(){
        index--;
        if(index == -1){
            index = files.length-1;
        }
        System.out.println(index);

        updateLabel();
        imageView.setImage(new Image("file:" +path + "/" + files[index] ));


    }
    @FXML
    protected void updateLabel(){
        imagesInfo.setText((index+1)+"/"+ files.length+": "+files[index]);
    }

}