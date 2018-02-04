package vn.edu.fpt.se04476.mydocterproject.managers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by EDGY on 2/1/2018.
 */

public class ScreenManager{
    /*
        - Open another fragment
        - Add old fragment to stack => press 'back button' will return old fragment
     */
        public static void openFragment(FragmentManager fragmentManager, Fragment fragment,
                                        int layoutID, boolean addToBackStack, boolean haveAnimation){
            FragmentTransaction fragmentTransaction = fragmentManager
                    .beginTransaction()
                    .replace(layoutID, fragment);
            if(addToBackStack){
                fragmentTransaction.addToBackStack(null);
            }
            if(haveAnimation){

            }
            fragmentTransaction.commit();
        }


        public static void backFragment(FragmentManager fragmentManager){
            fragmentManager.popBackStack();
        }
}
