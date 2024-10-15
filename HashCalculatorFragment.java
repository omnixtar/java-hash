import java.io.File;  // Import the File class
import java.io.FileInputStream;  
import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hash.HashCalculatorTask;
import hash.HashType;
import hash.HashConstants;
// import hash.HashConstants.MD5;

// public class HashCalculatorFragment extends BaseFragment
//        implements TextValueTarget, UserActionTarget, HashTypeSelectTarget {
public class HashCalculatorFragment {

    private String context;

    private String fileUri;
    private String folderUri;

    private boolean isTextSelected;

/*
private final HashCalculatorTask.HashCalculatorTaskTarget hashCalculatorTaskTarget = hashValue -> {
        if (hashValue == null) {
//             etGeneratedHash.setText("");
//             showSnackbarWithoutAction(R.string.message_invalid_selected_source);
        } else {
            boolean useUpperCase = settings.useUpperCase();
            etGeneratedHash.setText(useUpperCase ? hashValue.toUpperCase() : hashValue);
            if (settings.canSaveResultToHistory()) {
                Date date = Calendar.getInstance().getTime();
                String objectValue = tvSelectedObjectName.getText().toString();
                HashType hashType = HashType.getHashTypeFromString(tvSelectedHashType.getText().toString());
                HistoryItem historyItem = new HistoryItem(
                        date,
                        hashType,
                        !isTextSelected,
                        objectValue,
                        hashValue
                );
//                localDataStorage.addHistoryItem(historyItem);
            }
            if (settings.canShowRateAppDialog()) {
                settings.increaseHashGenerationCount();
                new AppAlertDialog(
                        context,
                        R.string.settings_title_rate_app,
                        R.string.rate_app_message,
                        R.string.rate_app_action,
                        (dialog, which) -> WebUtils.openGooglePlay(context, getView(), settings, themeConfig),
                        themeConfig
                ).show();
            } else {
                settings.increaseHashGenerationCount();
            } 
        }
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        } 
    };
*/

private void generateHash() {
        if (fileUri != null || isTextSelected || folderUri != null) {
//            HashType hashType = HashType.getHashTypeFromString(tvSelectedHashType.getText().toString());
            HashType hashType = HashType.getHashTypeFromString("md5");

			System.out.println('\n' + "generateHash()");


//            progressDialog = new AppProgressDialog(context, R.string.message_generate_dialog).getDialog();
//            progressDialog.show();
            if (isTextSelected) {
/*                new HashCalculatorTask(
                        context,
                        hashType,
                        tvSelectedObjectName.getText().toString(),
                        hashCalculatorTaskTarget
                ); // ).execute(); */
            } else if (fileUri != null) {
                  
                HashCalculatorTask HCT = new HashCalculatorTask(
                        context,
                        hashType,
                        fileUri,
                        folderUri
                        // hashCalculatorTaskTarget
                ); // ).execute();
                
          			System.out.println("  fileUri " + HCT.doInBackground() );
                
            } else {
                HashCalculatorTask HCT = new HashCalculatorTask(
                        context,
                        hashType,
                        fileUri,
                        folderUri
                        // hashCalculatorTaskTarget
                ); // ).execute();
                
          			System.out.println("  folderUri " + HCT.doInBackground() );
            }
        } else {
  //          showSnackbarWithoutAction(R.string.message_select_object);
        }
    }

/*
    private void compareHashes() {
        if (fieldIsNotEmpty(etCustomHash) && fieldIsNotEmpty(etGeneratedHash)) {
            boolean equal = compareText(etCustomHash.getText().toString(), etGeneratedHash.getText().toString());
            showSnackbarWithoutAction(
                    equal ? R.string.message_match_result : R.string.message_do_not_match_result
            );
        } else {
            showSnackbarWithoutAction(R.string.message_fill_fields);
        }
    }
*/

	public static void main(String args[])
	{
			System.out.println('\n' + "Calculate MD5 hash " 
						+ "for files in directory " 
						+ args[0]);

      HashCalculatorFragment HCF = new HashCalculatorFragment();
      
      // MD5 for 1 file
      HCF.fileUri = "./HashCalculator.java";
			HCF.generateHash();
			
      HCF.fileUri = null;
	
	    // MD5 for folder
      HCF.folderUri = args[0];
			HCF.generateHash();
							
	  try {					
	  
	  // HashCalculatorTask HCT = new HashCalculatorTask();
    // HCT.doInBackground();	  
	  
    File initialFile = new File("./JdkHashCalculator.java");
    InputStream targetStream = new FileInputStream(initialFile);
    List<InputStream> L_IS = new ArrayList<>();

    // inputStreams.add(inputStream);
    L_IS.add(targetStream);
    
    // JdkHashCalculator JHC = new JdkHashCalculator();
    // jdkHashCalculatorDigest = new JdkHashCalculatorDigest();
    
    			System.out.println("\n"+"Test " 
						+ "Test : " 
						+ "Test: " + '\n');
    
                    } catch (IOException e) {
    }




  }



}
