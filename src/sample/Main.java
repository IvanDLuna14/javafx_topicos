package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.Modelos.Conexion;
import sample.Vistas.Calculadora;
import sample.Vistas.ListaPeliculas;
import sample.Vistas.Taquimecanografo;

public class Main extends Application implements EventHandler{

    private Scene escena;
    private MenuBar menuBar;
    private Menu menCompetencia1, menCompetencia2, menSalir;
    private MenuItem itmCalculadora,itmSalir, itmTaqui, itmDatos;
    private BorderPane panel;

    @Override
    public void start(Stage primaryStage) throws Exception{

        panel = new BorderPane();
        CreateMenu();

        TitledPane objTP = new TitledPane();
        objTP.getStyleClass().add("danger");

        Button btn = new Button("Ejemplo Bootstrap");
        btn.getStyleClass().add("warning");

        panel.setLeft(btn);
        escena = new Scene(panel);
        escena.getStylesheets().add(getClass().getResource("CSS/Bootstrap3.css").toExternalForm());
        primaryStage.setTitle("Prácticas Tópicos Avanzado de Programación :)");
        primaryStage.setScene(escena);
        primaryStage.setMaximized(true);
        primaryStage.addEventHandler(WindowEvent.WINDOW_SHOWN,this);
        primaryStage.show();
    }

    public void CreateMenu(){

        menuBar = new MenuBar();

        menCompetencia1 = new Menu("Competencia 1");
        menCompetencia1.setId("menu1");
        menCompetencia2 = new Menu("Competencia 2");
        menCompetencia2.setId("menu2");
        menSalir        = new Menu("Salir");
        menSalir.setId("menu3");

        itmCalculadora = new MenuItem("Calculadora");
        itmTaqui = new MenuItem("Taquimecanógrafo");
        itmCalculadora.setOnAction(event->EventoItem(1));
        itmTaqui.setOnAction(event -> EventoItem(3));
        itmDatos = new MenuItem("Acceso a Datos (BD)");
        itmDatos.setOnAction(event -> EventoItem(4));
        menCompetencia1.getItems().addAll(itmCalculadora,itmTaqui,itmDatos);

        itmSalir = new MenuItem("Bye");
        itmSalir.setOnAction(event -> EventoItem(2));
        itmSalir.setAccelerator(KeyCombination.keyCombination("Ctrl+x"));
        menSalir.getItems().add(itmSalir);


        menuBar.getMenus().addAll(menCompetencia1,menCompetencia2,menSalir);
        panel.setTop(menuBar);
    }

    private void EventoItem(int opc) {
        switch (opc){
            case 1: new Calculadora(); break;
            case 2: // Evento para salir o terminar el stage principal
                    System.exit(0);
                    break;
            case 3: new Taquimecanografo();
                    break;
            case 4: new ListaPeliculas();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(Event event) {
        Conexion.getConexion();
        if( Conexion.con != null ){
            System.out.println("Conexion Exitosa!!");
        }
    }
}
