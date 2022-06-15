package ru.javarush.ogarkov.island;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ru.javarush.ogarkov.island.entity.Statistics;
import ru.javarush.ogarkov.island.location.Island;
import ru.javarush.ogarkov.island.location.Location;
import ru.javarush.ogarkov.island.settings.Setting;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    private Island islandModel;
    private Location locationModel;
    private Statistics statistics = new Statistics();
    private View view;
    private Controller controller;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        createSimulation();
        loadSimulationForm(stage);
    }

    public void createSimulation () {
        locationModel = Location.createModel();
        view = new View();
        statistics = new Statistics();
        controller = new Controller(this, locationModel,  view, statistics);
        Island.setController(controller);
        islandModel = Island.createModel();
        controller.setIslandModel(islandModel);
    }


    private void loadSimulationForm (Stage stage) throws IOException {
        // Загрузка формы simulationForm.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/simulationForm.fxml"));
        fxmlLoader.setController(controller);
        stage.getIcons().add(new Image((Objects.requireNonNull(getClass().getResourceAsStream("/icon.png")))));
        Scene scene = new Scene((Parent) fxmlLoader.load(), Setting.ISLAND_WIDTH_FORM, Setting.ISLAND_HEIGHT_FORM);
        stage.setTitle(Setting.SIMULATION_NAME);
        stage.setScene(scene);
        stage.show();
    }
}