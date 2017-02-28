package uniandes.teolen.parserJavaCC.mundoParser;

import java.util.*;

import uniandes.teolen.parserJavaCC.LRP.LRP;

public class MundoParsers {
	
	// Nombres de los Parsers
	private  ArrayList  <String> parsers  = new ArrayList <String> (); 
	
	// Parser que se est� usando
	private int currentParser;
	
	
	public  MundoParsers () {
  	
		//Add the parser Name
		
	    //parsers.add("name");
		parsers.add("LRP");
	    
	    currentParser =  0;

	}
	
	//Define a method to call the Parser
	
	public String getStringCurrentParser(){
		return parsers.get(currentParser);
	}
	
	public int getCurrentParser() {
		return currentParser;
	}
	
	public void setCurrentParser(int p) {
		currentParser = p;
	}
	
	public String getParser(int i) {
		return parsers.get(i);
	}
	
	public int sizeParsers() {
		return parsers.size();
	}
	
	public LRP getLRP(){
		return new LRP(System.in);
	}
	
	public String  procesarCadena(String texto) {
		String resp = "";
		//call the parser
		if(parsers.get(currentParser).equals("LRP")){
			LRP parser= getLRP();
			parser.ReInit(new java.io.StringReader(texto));
			try{
				parser.one_line();
				resp="OK      \n";
			}
			catch(Exception e){
				resp="Error de Sintaxis: "+e.getMessage();
			}
			catch(Error e){
				resp="Error lexico: "+e.getMessage();
			}
		}
		else{
			resp="No PARSER";
		}
		
		return "\n SISTEMA " + parsers.get(currentParser) + ": " + resp + "\n";
	}

}
