package cc.noharry.vanillahelper.ui.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import cc.noharry.vanillahelper.R;
import cc.noharry.vanillahelper.model.OrcItem;
import cc.noharry.vanillahelper.util.FileUtil;
import cc.noharry.vanillahelper.util.L;
import cc.noharry.vanillahelper.util.RecognizeService;
import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.baidu.ocr.ui.camera.CameraActivity;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
  private boolean hasGotToken = false;
  private static final int REQUEST_CODE_GENERAL = 105;
  private static final int REQUEST_CODE_GENERAL_BASIC = 106;
  private static final int REQUEST_CODE_ACCURATE_BASIC = 107;
  private static final int REQUEST_CODE_ACCURATE = 108;
  private static final int REQUEST_CODE_GENERAL_ENHANCED = 109;
  private static final int REQUEST_CODE_GENERAL_WEBIMAGE = 110;
  private static final int REQUEST_CODE_BANKCARD = 111;
  private static final int REQUEST_CODE_VEHICLE_LICENSE = 120;
  private static final int REQUEST_CODE_DRIVING_LICENSE = 121;
  private static final int REQUEST_CODE_LICENSE_PLATE = 122;
  private static final int REQUEST_CODE_BUSINESS_LICENSE = 123;
  private static final int REQUEST_CODE_RECEIPT = 124;
  private AlertDialog.Builder alertDialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    alertDialog = new AlertDialog.Builder(this);
    findViewById(R.id.camera).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        if (!checkTokenStatus()) {
          return;
        }
        Intent intent = new Intent(MainActivity.this, CameraActivity.class);
        intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
            FileUtil.getSaveFile(getApplication()).getAbsolutePath());
        intent.putExtra(CameraActivity.KEY_CONTENT_TYPE,
            CameraActivity.CONTENT_TYPE_GENERAL);
        startActivityForResult(intent, REQUEST_CODE_GENERAL);
      }
    });
    initAccessToken();
  }

  private boolean checkTokenStatus() {
    if (!hasGotToken) {
      Toast.makeText(getApplicationContext(), "token还未成功获取", Toast.LENGTH_LONG).show();
    }
    return hasGotToken;
  }

  private void initAccessToken() {
    OCR.getInstance().initAccessToken(new OnResultListener<AccessToken>() {
      @Override
      public void onResult(AccessToken accessToken) {
        String token = accessToken.getAccessToken();
        hasGotToken = true;
      }

      @Override
      public void onError(OCRError error) {
        error.printStackTrace();
        L.e("licence方式获取token失败", error.getMessage());
      }
    }, getApplicationContext());
  }


  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    // 识别成功回调，通用文字识别（含位置信息）
    if (requestCode == REQUEST_CODE_GENERAL && resultCode == Activity.RESULT_OK) {
      RecognizeService.recGeneral(FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath(),
          new RecognizeService.ServiceListener() {
            @Override
            public void onResult(String result) {
              Gson gson=new Gson();
              OrcItem orcItem = gson.fromJson(result, OrcItem.class);
              L.d("识别文字:"+orcItem.getWords_result().get(0).getWords()+" 位置:"+orcItem.getWords_result().get(0).getLocation());

            }
          });
    }

    // 识别成功回调，通用文字识别（含位置信息高精度版）
    if (requestCode == REQUEST_CODE_ACCURATE && resultCode == Activity.RESULT_OK) {
      RecognizeService.recAccurate(FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath(),
          new RecognizeService.ServiceListener() {
            @Override
            public void onResult(String result) {
              infoPopText(result);
            }
          });
    }

    // 识别成功回调，通用文字识别
    if (requestCode == REQUEST_CODE_GENERAL_BASIC && resultCode == Activity.RESULT_OK) {
      RecognizeService.recGeneralBasic(FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath(),
          new RecognizeService.ServiceListener() {
            @Override
            public void onResult(String result) {
              infoPopText(result);
            }
          });
    }

    // 识别成功回调，通用文字识别（高精度版）
    if (requestCode == REQUEST_CODE_ACCURATE_BASIC && resultCode == Activity.RESULT_OK) {
      RecognizeService.recAccurateBasic(FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath(),
          new RecognizeService.ServiceListener() {
            @Override
            public void onResult(String result) {
              infoPopText(result);
            }
          });
    }

    // 识别成功回调，通用文字识别（含生僻字版）
    if (requestCode == REQUEST_CODE_GENERAL_ENHANCED && resultCode == Activity.RESULT_OK) {
      RecognizeService.recGeneralEnhanced(FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath(),
          new RecognizeService.ServiceListener() {
            @Override
            public void onResult(String result) {
              infoPopText(result);
            }
          });
    }

    // 识别成功回调，网络图片文字识别
    if (requestCode == REQUEST_CODE_GENERAL_WEBIMAGE && resultCode == Activity.RESULT_OK) {
      RecognizeService.recWebimage(FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath(),
          new RecognizeService.ServiceListener() {
            @Override
            public void onResult(String result) {
              infoPopText(result);
            }
          });
    }

    // 识别成功回调，银行卡识别
    if (requestCode == REQUEST_CODE_BANKCARD && resultCode == Activity.RESULT_OK) {
      RecognizeService.recBankCard(FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath(),
          new RecognizeService.ServiceListener() {
            @Override
            public void onResult(String result) {
              infoPopText(result);
            }
          });
    }

    // 识别成功回调，行驶证识别
    if (requestCode == REQUEST_CODE_VEHICLE_LICENSE && resultCode == Activity.RESULT_OK) {
      RecognizeService.recVehicleLicense(FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath(),
          new RecognizeService.ServiceListener() {
            @Override
            public void onResult(String result) {
              infoPopText(result);
            }
          });
    }

    // 识别成功回调，驾驶证识别
    if (requestCode == REQUEST_CODE_DRIVING_LICENSE && resultCode == Activity.RESULT_OK) {
      RecognizeService.recDrivingLicense(FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath(),
          new RecognizeService.ServiceListener() {
            @Override
            public void onResult(String result) {
              infoPopText(result);
            }
          });
    }

    // 识别成功回调，车牌识别
    if (requestCode == REQUEST_CODE_LICENSE_PLATE && resultCode == Activity.RESULT_OK) {
      RecognizeService.recLicensePlate(FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath(),
          new RecognizeService.ServiceListener() {
            @Override
            public void onResult(String result) {
              infoPopText(result);
            }
          });
    }

    // 识别成功回调，营业执照识别
    if (requestCode == REQUEST_CODE_BUSINESS_LICENSE && resultCode == Activity.RESULT_OK) {
      RecognizeService.recBusinessLicense(FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath(),
          new RecognizeService.ServiceListener() {
            @Override
            public void onResult(String result) {
              infoPopText(result);
            }
          });
    }

    // 识别成功回调，通用票据识别
    if (requestCode == REQUEST_CODE_RECEIPT && resultCode == Activity.RESULT_OK) {
      RecognizeService.recReceipt(FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath(),
          new RecognizeService.ServiceListener() {
            @Override
            public void onResult(String result) {
              infoPopText(result);
            }
          });
    }

  }
  private void infoPopText(final String result) {
    alertText("", result);
  }
  private void alertText(final String title, final String message) {
    this.runOnUiThread(new Runnable() {
      @Override
      public void run() {
        alertDialog.setTitle(title)
            .setMessage(message)
            .setPositiveButton("确定", null)
            .show();
      }
    });
  }

}
