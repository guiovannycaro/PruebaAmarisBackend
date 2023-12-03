package com.amaris.config.properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;
import com.amaris.util.SerialClone;



public class Propiedad implements Serializable {

	    Properties propVersion = new Properties();
	    Properties propGlobal = new Properties();


	    private static Propiedad p = null;


	    private Propiedad() {
	        try {
	            InputStream in = this.getClass().getResourceAsStream("/com/amaris/config/properties/version.properties");
	            propVersion.load(in);
	            in.close();

	            in = this.getClass().getResourceAsStream("/com/amaris/config/properties/param.properties");
	            propGlobal.load(in);
	            in.close();

	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        }
	    }

	    public static Propiedad getCurrentInstance() {
	        if (p == null) {
	            p = new Propiedad();
	        }
	        return p;
	    }
	    
	    public String getVersion() {
			return propVersion.getProperty("VERSION");
		}
	    
	    public String getPathJDBC() {
	        return propGlobal.getProperty("JDBC");
	    }

	    
		public String getBDJdbc() {
			return propGlobal.getProperty("BD.JDBC");
		}

		public String getBDUsuario() {
			return propGlobal.getProperty("BD.USUARIO");
		}

		public String getBDClave() {
			return propGlobal.getProperty("BD.CLAVE");
		}
	
		public String getPathTmp() {
			return propGlobal.getProperty("PATH_TMP");
		}
		
		public static void main(String args[]) {
			System.out.println("PARAM="
					+ Propiedad.getCurrentInstance().getVersion() + " " + Propiedad.getCurrentInstance().getBDJdbc() + " " + Propiedad.getCurrentInstance().getBDUsuario() + " " + Propiedad.getCurrentInstance().getBDClave());
		}
	  
}
