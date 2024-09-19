package gui;


import java.nio.file.Paths;

import gui.util.Calculo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class ViewControlle {

	@FXML
	private Button btCalcular;

	@FXML
	private Label lablabelTdecorridoTerra;

	@FXML
	private Hyperlink linkLimpar;

	@FXML
	private TextField textTDias;

	@FXML
	private TextField textVelocidadeMS;
	
	@FXML
	private Label Resultado;

	@FXML
	private MediaView mediaview;

	private MediaPlayer mediaplayer;
	
		

	public void onBtActionCalcular() {

		double Tdias = Double.parseDouble(textTDias.getText());
		double VelocidadeMS = Double.parseDouble(textVelocidadeMS.getText());
		
		
		Resultado.setText("Tempo decorrido na Terra em dias foi de");

		Calculo Cal = new Calculo();
		lablabelTdecorridoTerra.setText(String.format("%.2f", Cal.CalculoTempo(Tdias, VelocidadeMS)));
		// rodar video
		try {
			
			String mediaPath = "\\Users\\vsistema\\eclipse-workspace\\ProjetosJava\\ViagemInterestelar\\resource\\midia\\video\\Fundo.mp4";
			String mediaUrl = Paths.get(mediaPath).toUri().toString();

			if (mediaplayer != null) {
				mediaplayer.stop();
				mediaplayer.dispose();
			}

			Media media = new Media(mediaUrl);
			mediaplayer = new MediaPlayer(media);
			mediaview.setMediaPlayer(mediaplayer);

			mediaplayer.play();// playvideo


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onBtLimpar() {
		lablabelTdecorridoTerra.setText("");
		textTDias.clear();
		textVelocidadeMS.clear();

	}

}
