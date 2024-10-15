package hash;
// package com.smlnskgmail.jaman.hashchecker.components.hashcalculator.api;

// import android.annotation.SuppressLint;
// import android.content.Context;
// import android.net.Uri;
// import android.os.AsyncTask;

// import androidx.annotation.NonNull;
// import androidx.annotation.Nullable;

// import com.smlnskgmail.jaman.hashchecker.components.hashcalculator.jdk.JdkHashCalculator;

import java.io.File;  // Import the File class
import java.io.FileInputStream;  
import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hash.JdkHashCalculator;
import hash.HashCalculator;
import hash.HashType;
// import com.smlnskgmail.jaman.hashchecker.utils.LogUtils;

// public class HashCalculatorTask extends AsyncTask<Void, String, String> {
public class HashCalculatorTask {

    // @SuppressLint("StaticFieldLeak")
    // private final Context context;
    private final String context;

    // private final HashCalculatorTaskTarget completeListener;
    private final HashType hashType;

    private String fileUri;
    private String folderUri;
    private String textValue;

    private final boolean isText;

    public HashCalculatorTask(
//            /* @NonNull */ Context context,
            /* @NonNull */ String context,
            /* @NonNull */ HashType hashType,
            /* @NonNull */ String fileUri,
            /* @NonNull */ String folderUri
            /* @NonNull */ // HashCalculatorTaskTarget completeListener
    ) {
        // this(context, hashType, completeListener, false);
        this(context, hashType, false);
        this.fileUri = fileUri;
        this.folderUri = folderUri;
    }

    public HashCalculatorTask(
//            /* @NonNull */ Context context,
            /* @NonNull */ String context,
            /* @NonNull */ HashType hashType,
            /* @NonNull */ String textValue
            /* @NonNull */ // HashCalculatorTaskTarget completeListener
    ) {
        // this(context, hashType, completeListener, true);
        this(context, hashType, true);
        this.textValue = textValue;

    }

    private HashCalculatorTask(
            // /* @NonNull */ Context context,
            /* @NonNull */ String context,
            /* @NonNull */ HashType hashType,
            /* @NonNull */ // HashCalculatorTaskTarget completeListener,
            boolean isText
    ) {
        this.hashType = hashType;
        this.context = context;
        // this.completeListener = completeListener;
        this.isText = isText;
    }

//    @Nullable
    @SuppressWarnings("MethodParametersAnnotationCheck")
//    @Override
    // protected String doInBackground(Void... voids) {
    public String doInBackground(Void... voids) {
        try {
            // HashCalculator hashCalculator = new JdkHashCalculator();
            JdkHashCalculator hashCalculator = new JdkHashCalculator();
            hashCalculator.setHashType(hashType);
            if (isText) {
                return hashCalculator.fromString(textValue);
            } else if (fileUri != null) {
                return hashCalculator.fromFile(context, fileUri);
            } else {
                return hashCalculator.fromFolder(context, folderUri);
            }
        } catch (Exception e) {
  //          LogUtils.e(e);
            return null;
        }
    }

    @SuppressWarnings("MethodParametersAnnotationCheck")
//    @Override
    protected void onPostExecute(String result) {
        // completeListener.hashCalculationComplete(result);
    }

    public interface HashCalculatorTaskTarget {

        void hashCalculationComplete(/* @Nullable */String hashValue);

    }

	public static void main(String args[])
	{
			System.out.println("Name: " 
						+ "Marks : " 
						+ "Department: "
						+ "Computer Science" + '\n');
	  try {					
	  
	  // HashCalculatorTask HCT = new HashCalculatorTask();
    // HCT.doInBackground();	  
	  
    File initialFile = new File("./JdkHashCalculator.java");
    InputStream targetStream = new FileInputStream(initialFile);
    List<InputStream> L_IS = new ArrayList<>();

    // inputStreams.add(inputStream);
    L_IS.add(targetStream);
    
    JdkHashCalculator JHC = new JdkHashCalculator();
    // jdkHashCalculatorDigest = new JdkHashCalculatorDigest();
    
    			System.out.println("Name: " 
						+ "Marks : " 
						+ "Department: "
						+ "Computer Science" + JHC.fromFolder(L_IS) + '\n');
    
    
                    } catch (IOException e) {
    }




  }

}

