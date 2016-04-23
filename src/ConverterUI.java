import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ConverterUI extends JFrame{

	// attributes for graphical components
	private JButton converterButton ;
	private UnitConverter unitconverter  ;
	private JComboBox<Unit> unit1ComboBox ;
	private JComboBox<Unit> unit2ComboBox ;
	private Container sumcontents ;
	private Container contents ;
	private Container contents2 ;
	private JButton Clear ;
	private JTextField inputField1 ;
	private JTextField inputField2 ;
	private Unit firstUnit ;
	private Unit secondUnit ;
	private JRadioButton LeftToright ;
	private JRadioButton rightToLeft ;

	public ConverterUI(UnitConverter uc){
		this.unitconverter = uc ;
		this.setTitle("Length Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}
	/* 
	 initialize component in the window
	 */
	private void initComponents(){
		converterButton = new JButton("Convert");
		Clear = new JButton("Clear");
		unit1ComboBox = new JComboBox<Unit>();
		unit2ComboBox  = new JComboBox<Unit>();
		sumcontents = new Container();
		contents = new Container();
		contents2 = new Container();
		inputField1 = new JTextField(7);
		inputField2 = new JTextField(7);
		LeftToright = new JRadioButton("Left->right");
		rightToLeft = new JRadioButton("right->Left");
		unitconverter = new UnitConverter();


		ButtonGroup Button =  new ButtonGroup();
		Button.add(LeftToright);
		Button.add(rightToLeft);

		inputField2.setEnabled(false);
		LeftToright.setSelected(true);

		leftToright();
		rightToleft();
		ClearB();

		Unit[] lengths = unitconverter.getUnit();
		for(Unit u : lengths) 
			unit1ComboBox.addItem(u);
		unit1ComboBox = new JComboBox<Unit>(lengths);

		Unit[] lengths2 = unitconverter.getUnit();
		for(Unit u : lengths2) 
			unit2ComboBox.addItem(u);
		unit2ComboBox = new JComboBox<Unit>(lengths2);


		ActionListener listener = new ConvertButtonListener();
		converterButton.addActionListener(listener);

		inputField1.addKeyListener(new KeyListener(){
			// convert when press ENTER Key
			public void keyPressed(KeyEvent e){

				if(e.getKeyChar() == KeyEvent.VK_ENTER){
					String s = inputField1.getText().trim();

					firstUnit = (Unit) unit1ComboBox.getSelectedItem();
					secondUnit = (Unit) unit2ComboBox.getSelectedItem();



					if(s.length() > 0){
						try{
							double value1 = Double.valueOf(s);
							System.out.println(s);
							if(LeftToright.isSelected()){

								inputField2.setText(String.valueOf(unitconverter.convert(value1,firstUnit ,secondUnit)));
								System.out.println(unitconverter.convert(value1,firstUnit ,secondUnit));

							}else{

								inputField1.setText(String.valueOf(unitconverter.convert(value1,secondUnit, firstUnit)));
								System.out.println(unitconverter.convert(value1,secondUnit, firstUnit));

							}
						}catch( NumberFormatException e1 ){
							System.out.println(e1);
						}
					}

				}       
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		}

				);
		inputField2.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e){

				if(e.getKeyChar() == KeyEvent.VK_ENTER){
					String s = inputField1.getText().trim();

					firstUnit = (Unit) unit1ComboBox.getSelectedItem();
					secondUnit = (Unit) unit2ComboBox.getSelectedItem();



					if(s.length() > 0){
						try{
							double value1 = Double.valueOf(s);
							System.out.println(s);
							if(LeftToright.isSelected()){

								inputField2.setText(String.valueOf(unitconverter.convert(value1,firstUnit ,secondUnit)));
								System.out.println(unitconverter.convert(value1,firstUnit ,secondUnit));

							}else{

								inputField1.setText(String.valueOf(unitconverter.convert(value1,secondUnit, firstUnit)));
								System.out.println(unitconverter.convert(value1,secondUnit, firstUnit));

							}
						}catch( NumberFormatException e1 ){
							System.out.println(e1);
						}
					}

				}       
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		}

				);
		sumcontents.setLayout(new BoxLayout(sumcontents,BoxLayout.Y_AXIS));
		contents.setLayout(new FlowLayout());
		contents2.setLayout(new FlowLayout());



		contents.add(inputField1);
		contents.add(unit1ComboBox);
		contents.add(inputField2);
		contents.add(unit2ComboBox);
		contents.add(converterButton);
		contents.add(Clear);
		contents2.add(LeftToright);
		contents2.add(rightToLeft);
		sumcontents.add(contents);
		sumcontents.add(contents2);
		this.add(sumcontents);
		getContentPane().add(sumcontents);


		this.pack(); 	// resize the Frame to match size of components
	}
	/* ConvertButtonLixtener is an ActionListener that performs an action when
	 * the button is pressed. It is an inner class so it can access private 
	 * attributes of ConvertUI.
	 * It read the text from a JTextField, convert the value to a number,
	 * call the unitconverter to convert , and write result in other text field.
	 */

	class ConvertButtonListener implements ActionListener {
		/* The action to perform action when the "convert" button is pressed */
		public void actionPerformed(ActionEvent evt){

			String s = inputField1.getText().trim();

			firstUnit = (Unit) unit1ComboBox.getSelectedItem();
			secondUnit = (Unit) unit2ComboBox.getSelectedItem();



			if(s.length() > 0){
				try{
					double value1 = Double.valueOf(s);
					System.out.println(s);
					if(LeftToright.isSelected()){

						inputField2.setText(String.valueOf(unitconverter.convert(value1,firstUnit ,secondUnit)));


					}else{

						inputField1.setText(String.valueOf(unitconverter.convert(value1,secondUnit, firstUnit)));


					}
				}catch( NumberFormatException e ){
					System.out.println(e);
				}




			}
		}








	} // end of the inner class for ConvertButtonListener
	/*
	 * this method use when choose LeftToright JRadioBox and 
	 * Don't allowed input(editing) in the right TextField
	 */
	public void leftToright(){
		LeftToright.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				inputField1.setEnabled(true);
				inputField2.setEnabled(false);

			}

		});
	}
	/*
	 * this method use when choose rightToleft JRadioBox and 
	 * Don't allowed input(editing) in the Left TextField
	 */
	public void rightToleft(){
		rightToLeft.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				inputField1.setEnabled(false);
				inputField2.setEnabled(true);

			}

		});
	}
	/*
	 * this method clear all of TextField.
	 */
	public void ClearB(){
		Clear.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				inputField1.setText(" ");
				inputField2.setText(" ");

			}

		});
	}




	public static void main(String[]arg){
		UnitConverter uc = new UnitConverter();
		ConverterUI view = new ConverterUI(uc);
		view.run();
	}
	public void run(){
		setVisible(true);
	}


}


