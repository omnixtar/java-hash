// top level java file must not have package !!
package hash;

import java.io.File;  // Import the File class
import java.io.FileInputStream;  
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hash.JdkHashCalculatorDigest;
import hash.HashType;

// public class JdkHashCalculator implements HashCalculator {
public class JdkHashCalculator {

   private JdkHashCalculatorDigest jdkHashCalculatorDigest;
   // public JdkHashCalculatorDigest jdkHashCalculatorDigest;

//     private InputStream inputStreamFromUri(@NonNull Context context, @NonNull Uri path) throws Exception {
    private InputStream inputStreamFromUri(String context, String path) throws Exception {
        File initialFile = new File("./JdkHashCalculator.java");
        InputStream targetStream = new FileInputStream(initialFile);
        
        // return context.getContentResolver().openInputStream(path);
        return targetStream;
    }


//     public String fromFile(/* @NonNull */ Context context, @NonNull Uri path) {
    public String fromFile(/* @NonNull */ String context, String path) {
        try {
            InputStream fileStream = inputStreamFromUri(context, path);
            return fromFile(fileStream);
        } catch (Exception e) {
//            LogUtils.e(e);
        }
        return null;
    }

public String fromFile(/* @Nullable */ InputStream inputStream) {
        if (inputStream != null) {
            try {
                byte[] buffer = new byte[1024];
                int read;
                do {
                    read = inputStream.read(buffer);
                    if (read > 0) {
                        jdkHashCalculatorDigest.update(buffer, read);
                    }
                } while (read != -1);
                return jdkHashCalculatorDigest.result();
            } catch (IOException e) {
//                LogUtils.e(e);
            }
        }
        return null;
    }


   public void setHashType(/* @NonNull */ HashType hashType) {
        try {
            if (hashType.isKeccakj()) {
//                jdkHashCalculatorDigest = JdkHashCalculatorDigest.instanceFor(hashType, Constants.PROVIDER);
            } else {
                jdkHashCalculatorDigest = JdkHashCalculatorDigest.instanceFor(hashType);
            }
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
//            LogUtils.e(e);
        }
    }

   
   public String fromString(/* @NonNull */String text) {
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        jdkHashCalculatorDigest.update(bytes);
        return jdkHashCalculatorDigest.result();
   }


   public String fromFolder(/* @Nullable */ List<InputStream> inputStream) {
   
   // JdkHashCalculatorDigest jdkHashCalculatorDigest = new JdkHashCalculatorDigest();
   
        if (inputStream != null) {
            for (InputStream stream : inputStream) {
                try {
                    byte[] buffer = new byte[1024];
                    int read;
                    do {
                        read = stream.read(buffer);
                        if (read > 0) {
                            jdkHashCalculatorDigest.update(buffer, read);
                        }
                    } while (read != -1);
                } catch (IOException e) {
                    // LogUtils.e(e);
                }
            }
            return jdkHashCalculatorDigest.result();
        }
        return null;
    }
    
    // public String fromFolder(/* @NonNull */ Context context,/* @NonNull */ Uri path) {
    public String fromFolder(/* @NonNull */ String context,/* @NonNull */ String path) {
    
  			System.out.println("  fromFolder path " + path + "  " );
    
        try {
            List<InputStream> fileStream = inputStreamsFormFolder(context, path);
            return fromFolder(fileStream);
        } catch (Exception e) {
            // LogUtils.e(e);
        }
        return null;
    }
    
    // private List<InputStream> inputStreamsFormFolder(Context context, Uri folderUri) throws IOException {
    private List<InputStream> inputStreamsFormFolder(String context, String folderUri) throws IOException {
        List<InputStream> inputStreams = new ArrayList<>();

      File f = null;
      String[] paths;            
      try {    
      
         // create new file
         f = new File(folderUri);
                                 
         // array of files and directory
         paths = f.list();
            
         Arrays.sort(paths);
         // for each name in the path array
         for(String path:paths) {
         
            // prints filename and directory name
            System.out.println("  full path "+folderUri+"/"+path);
            
            InputStream targetStream = new FileInputStream(folderUri+"/"+path);
            
            inputStreams.add(targetStream);
         }

      } catch(Exception e) {
         // if any error occurs
         e.printStackTrace();
      }

/*
        ContentResolver contentResolver = context.getContentResolver();
        Uri childrenUri = DocumentsContract.buildChildDocumentsUriUsingTree(folderUri,
                DocumentsContract.getTreeDocumentId(folderUri));

        Cursor cursor = contentResolver.query(childrenUri,
                new String[]{DocumentsContract.Document.COLUMN_DOCUMENT_ID}, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                String documentId = cursor.getString(0);
                Uri documentUri = DocumentsContract.buildDocumentUriUsingTree(folderUri, documentId);

                try {
                    InputStream inputStream = inputStreamFromUri(context, documentUri);
                    if (inputStream != null) {
                        inputStreams.add(inputStream);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            cursor.close();
        }
*/
        return inputStreams;
    }

	public static void main(String args[])
	{
			System.out.println("Name: " 
						+ "Marks : " 
						+ "Department: "
						+ "Computer Science" + '\n');
	  try {					
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
