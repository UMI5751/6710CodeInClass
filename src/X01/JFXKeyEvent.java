package X01;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JFXKeyEvent extends Application {
    @Override
   public void start(Stage stage) throws Exception { // 菜单Code-implement-自动实现此方法
        stage.setTitle("Hello");// stage类似Windows窗口
        StackPane root = new StackPane(); //Pane是Node的container,未来会把要显示的东西放这里面
        Scene scene = new Scene(root, 300, 300); //Scene 是Scene Graph的container,设置长宽
        stage.setScene(scene);


        Text hi = new Text("Hello World");
        hi.setFont(Font.font("Tahoma", FontWeight.BLACK, 40));
        hi.setFill(Color.RED);
        root.getChildren().add(hi);//增加节点显示？
        //代码的先后顺序会影响显示图层的顺序

        scene.setOnKeyTyped(event -> { //eventhandler，仅当event触发时执行这段代码
            String c = event.getCharacter();//获取按了哪个键
            if (c.equals("q")) {
                Platform.exit();//退出gui
                //System.exit(1);//彻底退出程序
            }
            hi.setText(c);


        });

        stage.show();
    }
}
