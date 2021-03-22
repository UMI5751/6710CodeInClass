package Class;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class JFXHelloWorld extends Application {

    @Override
    public void start(Stage stage) throws Exception { // 菜单Code-implement-自动实现此方法
        stage.setTitle("Hello");// stage类似Windows窗口
        StackPane root = new StackPane(); //Pane是Node的container,未来会把要显示的东西放这里面
        Scene scene = new Scene(root, 300, 300); //Scene 是Scene Graph的container,设置长宽
        stage.setScene(scene);

        Rectangle r = new Rectangle(0, 0, 280, 70);
        r.setFill(Color.BLUE);//intellj很可能会自动import错误的package
        root.getChildren().add(r);
        r.setOpacity(0.5);//设置透明度


        Text hi = new Text("Hello World");
        hi.setFont(Font.font("Tahoma", FontWeight.BLACK, 40));
        hi.setFill(Color.RED);
        root.getChildren().add(hi);//增加节点显示？
        //代码的先后顺序会影响显示图层的顺序

        stage.show();

        /*
        To fix this, could you please go to "Run" -> "Edit Configurations...", and on the left-hand side column click on "JavaFxHello" (this might be under a category called "Application"). Then, there should be a box with the words "Program arguments" inside. Could you please paste the following inside that box?

        --module-path ${PATH_TO_FX} --add-modules=javafx.controls,javafx.fxml,javafx.media

        Note that you will have needed to correctly set up PATH_TO_FX for this to work.
         */


    }
}
