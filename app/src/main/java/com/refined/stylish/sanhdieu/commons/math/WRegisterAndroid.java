 

package com.refined.stylish.sanhdieu.commons.math;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



public class WRegisterAndroid {
double default_zWordsOffset = 0.0;
private String useUsage_string;
float char_agActivity_size = 0.0f;




    public static final WRegisterAndroid Right = new WRegisterAndroid(1f, 0f);

	public float x;
	public float y;

	public WRegisterAndroid() {
		this(0.0f, 0.0f);
	}

	public WRegisterAndroid(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public WRegisterAndroid(WRegisterAndroid v) {
		x = v.x;
		y = v.y;
	}
	
	

 public  float removeWinUdid() {
     double soundSave = 3896.0;
     float requestsContract = 6143.0f;
     float ellapsedContext = 3397.0f;
    float welsencdemoFuzzy = 0;
    soundSave *= 26;
    requestsContract = 449;
    welsencdemoFuzzy -= requestsContract;
    ellapsedContext = requestsContract;
    welsencdemoFuzzy -= ellapsedContext;

    return welsencdemoFuzzy;

}



public void add(WRegisterAndroid v) {

         
float ipodEnumeration =  this.removeWinUdid();

      if (ipodEnumeration < 15) {
             System.out.println(ipodEnumeration);
      }



		x += v.x;
		y += v.y;
	}
	
	

 public  int signingArrDotDirectoryCreated(float rowEnable_y0, double loginThread) {
     float gradleMaps = 1215.0f;
     int savedEdit = 4884;
     long libcocosdjsBase = 6746L;
     long configList = 2637L;
    int unbindMaketarball = 0;
    gradleMaps -= gradleMaps;
    savedEdit = 4822;
    unbindMaketarball += savedEdit;
    libcocosdjsBase += libcocosdjsBase;
    libcocosdjsBase -= configList;
    configList = 6919;

    return unbindMaketarball;

}



public void add(float x, float y) {

         
int keystorePlaned =  this.signingArrDotDirectoryCreated(3444.0f,7259.0);

      System.out.println(keystorePlaned);



		this.x += x;
		this.y += y;
	}
	
	

 public  float excepFactoryIllegalViewDeathPackages(float optionsAccess, int markAlready) {
     boolean handlerPools = true;
     String shellVersion = "ffio";
     HashMap<String,Float> streakDelegate_8 = new HashMap();
    float mjpegbAutoplaying = 0;
    handlerPools = false;
    mjpegbAutoplaying += handlerPools ? 42 : 87;

    return mjpegbAutoplaying;

}



public void sub(WRegisterAndroid v) {

         
float simdNonnullcontents =  this.excepFactoryIllegalViewDeathPackages(6933.0f,9688);

      if (simdNonnullcontents < 48) {
             System.out.println(simdNonnullcontents);
      }



		x -= v.x;
		y -= v.y;
	}
	
	

 public  long aesRecipientPresenterBuffer(String interactionWindow_qt, ArrayList<Double> fromAdds) {
     int gradlewAction = 9271;
     boolean entityAdapter = false;
     int preferencesCol = 8490;
    long phrasesSadxxOutdevs = 0;
    gradlewAction += gradlewAction;
    gradlewAction -= preferencesCol;
    entityAdapter = false;
    phrasesSadxxOutdevs *= entityAdapter ? 38 : 45;
    preferencesCol = 757;

    return phrasesSadxxOutdevs;

}



public void sub(float x, float y) {

         String lmlm_f = "dust";
ArrayList encapsulate_m = new ArrayList();

long findThumb =  this.aesRecipientPresenterBuffer(lmlm_f,encapsulate_m);

      if (findThumb > 1) {
             System.out.println(findThumb);
      }



		this.x -= x;
		this.y -= y;
	}

	 
	public float dot(WRegisterAndroid v) {
		return (x * v.x) + (y * v.y);
	}

	 
	public float length() {
		return (float)Math.sqrt((x * x) + (y * y));
	}

	 
	public void normalize() {
		float len = length();
		x /= len;
		y /= len;
	}

	public void set(float x, float y) {
		this.x = x;
		this.y = y;
	}


	 
	public static WRegisterAndroid add(WRegisterAndroid v1, WRegisterAndroid v2) {
		return new WRegisterAndroid(v1.x + v2.x, v1.y + v2.y);
	}
	
	public static WRegisterAndroid add(WRegisterAndroid v1, float x, float y) {
		return new WRegisterAndroid(v1.x + x, v1.y + y);
	}

	public static WRegisterAndroid sub(WRegisterAndroid v1, WRegisterAndroid v2) {
		return new WRegisterAndroid(v1.x - v2.x, v1.y - v2.y);
	}
	
	public static WRegisterAndroid sub(WRegisterAndroid v1, float x, float y) {
		return new WRegisterAndroid(v1.x - x, v1.y - y);
	}
	
	public static WRegisterAndroid div(WRegisterAndroid v1, float div) {
		return new WRegisterAndroid(v1.x / div, v1.y / div);
	}
	
	public static WRegisterAndroid div(WRegisterAndroid v1, WRegisterAndroid v2) {
		return new WRegisterAndroid(v1.x / v2.x, v1.y / v2.y);
	}
	
	public static WRegisterAndroid div(WRegisterAndroid v1, float x, float y) {
		return new WRegisterAndroid(v1.x / x, v1.y / y);
	}
	
	 
	public static WRegisterAndroid normal(WRegisterAndroid v1, WRegisterAndroid v2) {
		return new WRegisterAndroid( -(v1.y-v2.y), (v1.x-v2.x));
	}
	
	public static WRegisterAndroid normalize(WRegisterAndroid v) {
		float len = v.length();
		return new WRegisterAndroid(v.x/len, v.y/len);
	}

}
