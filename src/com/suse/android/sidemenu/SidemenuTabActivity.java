package com.suse.android.sidemenu;

import com.suse.android.sidemenu.utils.ViewAbove;
import com.suse.android.sidemenu.utils.ViewBehind;
import com.suse.android.sidemenu.utils.ViewAbove.LayoutParams;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

public class SidemenuTabActivity extends TabActivity
{
	
	 private Sidemenu msidemenu;
     private View mLayout;
     private boolean mContentViewCalled = false;
     private boolean mBehindContentViewCalled = false;
     
     protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             
             requestWindowFeature(Window.FEATURE_NO_TITLE);
             
             super.setContentView(R.layout.sidemenutabmain);
             
             msidemenu = (Sidemenu)super.findViewById(R.id.sidemenulayout);
             msidemenu.registerViews((ViewAbove) findViewById(R.id.sidemenuabove),
                             (ViewBehind) findViewById(R.id.sidemenubehind));
             mLayout = super.findViewById(R.id.sidemenulayout);
     }

     public void onPostCreate(Bundle savedInstanceState) {
             super.onPostCreate(savedInstanceState);
             if (!mContentViewCalled || !mBehindContentViewCalled) {
                     throw new IllegalStateException("Both setContentView and" +
                                     "setBehindContentView must be called in onCreate.");
             }
             msidemenu.setStatic(isStatic());
     }

     @Override
     public void setContentView(int id) {
             setContentView(getLayoutInflater().inflate(id, null));
     }

     public void setContentView(View v) {
             setContentView(v, null);
     }

     public void setContentView(View v, LayoutParams params) {
             if (!mContentViewCalled) {
                     mContentViewCalled = !mContentViewCalled;
             }
             msidemenu.setAboveContent(v, params);
     }
     
     public void setBehindContentView(int id) {
             setBehindContentView(getLayoutInflater().inflate(id, null));
     }

     public void setBehindContentView(View v) {
             setBehindContentView(v, null);
     }
     
     public void setBehindContentView(View v, LayoutParams params) {
             if (!mBehindContentViewCalled) {
                     mBehindContentViewCalled = !mBehindContentViewCalled;
             }
             msidemenu.setBehindContent(v);
     }
     
     private boolean isStatic() {
             return mLayout instanceof LinearLayout;
     }
             
     public int getBehindOffset() {

             return 0;
     }
     
     public void setBehindOffset(int i) {
             msidemenu.setBehindOffset(i);
     }
     
     public float getBehindScrollScale() {
             return 0;
     }
     
     public void setBehindScrollScale(float f) {
             msidemenu.setScrollScale(f);
     }

     @Override
     public View findViewById(int id) {
             return msidemenu.findViewById(id);
     }

     
     public void toggle() {
             if (msidemenu.isMenuOpen()) {
                     showContent();
             } else {
                     showMenu();
             }
     }

     public void showMenu() {
             msidemenu.showMenu();
     }

     public void showContent() {
             msidemenu.showContent();
     }


}
