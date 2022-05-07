package Control;

import View.MyView;


public class main {

	public static void main(String[] args) {

		try {
			MyView window = new MyView();
			window.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
