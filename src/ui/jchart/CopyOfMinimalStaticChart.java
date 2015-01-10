package ui.jchart;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Random;

import javax.swing.JFrame;

import audio.play.WavePlayer;
import info.monitorenter.gui.chart.Chart2D;
import info.monitorenter.gui.chart.ITrace2D;
import info.monitorenter.gui.chart.ZoomableChart;
import info.monitorenter.gui.chart.traces.Trace2DSimple;

public class CopyOfMinimalStaticChart {

	public static void main(String[] args) {
		File file = new File("src/res/sqr-10-2Hz.wav");
		WavePlayer player = new WavePlayer(file);
		player.setup();
		int[] datas = player.analyze();
		player.close();
		
		ZoomableChart chart = new ZoomableChart();
		
		ITrace2D trace = new Trace2DSimple();
		chart.addTrace(trace);
		int j = 0;
		
		for(int i : datas){
			trace.addPoint(j,i);
			j++;
		}
		
		JFrame frame = new JFrame("MinimalStaticChart");
		frame.getContentPane().add(chart);
		frame.setSize(400, 300);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		frame.setVisible(true);
	}

}