package convexhullalgorithm;

import java.util.LinkedList;

public class ConvexHullConstructor3D {
	private PointCloud points;
	private int error;
	private String errorString;
	private LinkedList<PointReference> currentPoints = new LinkedList<PointReference>();
	
	
	
	private double maxX = Double.MIN_VALUE;
	private double minX = Double.MAX_VALUE;
	private double maxY = maxX;
	private double minY = minX;
	private double maxZ = maxX;
	private double minZ = minX;
	private int[] minMaxIndices ={-1,-1,-1,-1,-1,-1}; //0 - minX, 1 - maxX, 2 -minY, ...
	
	
	public ConvexHullConstructor3D(PointCloud p){
		points = p;
	}
	
	public Polytop construct(){	
		//Validitäts Überprüfung
		if(points == null){errorString = "Punkte wurden nicht gesetzt";return null;}
		if(points.numPoints()<4){errorString = "Weniger als 4 Punkte"; return null;}
		
		//Initialisierungen
		currentPoints.clear();
		for (int i = 0; i< points.numPoints();i++){
			currentPoints.add(new PointReference(i));
		}
		
		//Baue erstes Simplex------------------------------------------
		//Finde Punkte mit maximaler x, y, z koordinate
		findMinMaxValuesIndices();
		int[] p ={-1,-1,-1,-1,-1,-1};
		p[0] = minMaxIndices[0];
		for(int i = 1; i<6;i++){
			boolean b = true;
			int j =i-1;
			while(j>=0 ){
				b = b && (minMaxIndices[i] != p[j]);
				j--;
			}
			if(b){
				p[i] = minMaxIndices[i];
			}
		}
		
		
		
		
		return null;
	}
	
	
	private void findMinMaxValuesIndices(){
		for(int i = 0; i<points.numPoints();i++){
			double[] p = points.at(i);
			if(p[0]>maxX){
				maxX = p[0];
				minMaxIndices[1] = i;
			}
			if(p[0]<minX){
				minX = p[0];
				minMaxIndices[0] = i;
			}
			if(p[0]>maxY){
				maxY = p[1];
				minMaxIndices[3] = i;
			}
			if(p[0]<minY){
				minY = p[1];
				minMaxIndices[2] = i;
			}
			if(p[0]>maxZ){
				maxZ = p[2];
				minMaxIndices[5] = i;
			}
			if(p[0]<minZ){
				minZ = p[2];
				minMaxIndices[4] = i;
			}
		}
	}
}
