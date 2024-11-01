package screen;

import java.awt.Dimension;
import java.io.IOException;

import javax.naming.LimitExceededException;
import javax.swing.JFrame;

import aims.Aims;
import cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import media.Book;
import media.Media;

public class CartScreen extends JFrame {
	private Cart cart;
	
	public CartScreen(Cart cart) {
		super();
		
		this.cart = cart;
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setSize(1080, 768);
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/screen/cart.fxml"));
					CartScreenController controller = new CartScreenController(cart);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
			}
		});
		
	}
	
	public static void main(String[] args) throws LimitExceededException {
		Aims.init();
		Aims.cart.addMedia(Aims.store.getItemsInStore());
		new CartScreen(Aims.cart);
	}
}