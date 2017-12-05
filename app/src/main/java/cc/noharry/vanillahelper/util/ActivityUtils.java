package cc.noharry.vanillahelper.util;

import static com.google.common.base.Preconditions.checkNotNull;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * @author NoHarry
 * @date 2017/12/04
 */

public class ActivityUtils {

  /**
   *
   * @param fragmentManager
   * @param fragment
   * @param frameId
   */
  public static void replaceFragmentInActivity(@NonNull FragmentManager fragmentManager,@NonNull
      Fragment fragment,@NonNull int frameId){
    checkNotNull(fragmentManager);
    checkNotNull(fragment);
    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
    fragmentTransaction.replace(frameId,fragment);
    fragmentTransaction.commit();
  }

  /**
   *
   * @param fragmentManager
   * @param fragment
   * @param tag
   */
  public static void addFragmentInActivity(@NonNull FragmentManager fragmentManager,@NonNull Fragment fragment,@NonNull String tag){
    checkNotNull(fragmentManager);
    checkNotNull(fragment);
    FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
    fragmentTransaction.add(fragment,tag);
    fragmentTransaction.commit();
  }

}
