import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class FxMenuExampleextendsApplication
{
//CreatetheMessageLabel
Label messageLbl = new Label("PressanyMenuItemtoseethemessage");
public static void main(String[] args)
{
    Application.launch(args);
}
@Override
public void start(Stagestage)
{
//Createsomemenus
    Menu fileMenu=new Menu("File");
    Menu editMenu=new Menu("Edit");
//CreatetheMenuItem New
    MenuItem newItem=new MenuItem("New");
    newItem.setOnAction(newEventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent e)
        {
            printMessage("You have pressed the NewMenuItem");
        }
    });
//CreatetheMenuItem Open
    MenuItem openItem=new MenuItem("Open");
    openItem.setOnAction(newEventHandler<ActionEvent>()
    {
        @Override
                publicvoidhandle(ActionEvente)
        {
            printMessage("Youhave pressedtheOpenMenuItem");
        }
    })
//Addmenuitemsto theFilemenu
    fileMenu.getItems().addAll(newItem,openItem);
//CreatetheMenuItem Copy
    MenuItemcopyItem=newMenuItem("Copy");
    copyItem.setOnAction(newEventHandler<ActionEvent>()
    {
        @Override
                public void handle(ActionEvente)
        {
            printMessage("Youhave pressedtheCopyMenuItem");
        }
})
//CreatetheMenuItem Paste
    MenuItempasteItem= newMenuItem("Paste");
    pasteItem.setOnAction(newEventHandler<ActionEvent>()
    {
        @Override
                public void handle(ActionEvente)
        {
            printMessage("Youhave pressedthePasteMenuItem");
        }
    })
//Addmenuitemsto theEditmenu
    editMenu.getItems().addAll(copyItem,pasteItem);
//Createamenubar
    MenuBar menuBar=new MenuBar();
//Addmenustoamenu bar
    menuBar.getMenus().addAll(fileMenu,editMenu);
//CreatetheMenuBox
    HBox menu=new HBox();
//AddtheMenuBartotheMenuBox
    menu.getChildren().add(menuBar);
//CreatetheVBox
    VBox root=new VBox();
//Addthechildrento theVBox
    root.getChildren().addAll(menu,messageLbl);
//SettheSizeofthe VBox
    root.setMinSize(350, 250);
    /*
     * SetthepaddingoftheVBox
     * Settheborder-styleoftheVBox
     * Settheborder-widthoftheVBox
     * Settheborder-insetsoftheVBox
     * Settheborder-radiusoftheVBox
     * Settheborder-coloroftheVBox
     */
    root.setStyle("-fx-padding:10;"+
            "-fx-border-style:solidinside;"+
            "-fx-border-width:2;"+
            "-fx-border-insets:5;"+
            "-fx-border-radius:5;"+
            "-fx-border-color:blue;");
//CreatetheScene
    Scenescene=newScene(root);
//AddthescenetotheStage
    stage.setScene(scene);
//SetthetitleoftheStage
    stage.setTitle("AMenu Example");
//DisplaytheStage
    stage.show();
}
public void printMessage(Stringmessage)
{
    // Set the Text of the Label
    messageLbl.setText(message);
}
}