Android Sidemenu (Yet another Fly-in-Menu)
==========================================

-----------------

What is it
----------

Screenshots

![Overlay](https://github.com/maddeye/android-sidemenu/raw/master/resources/AboveScreen.jpg?raw=true) 
![Toggle Button](https://github.com/maddeye/android-sidemenu/raw/master/resources/Toggle.jpg?raw=true) 
![Drag](https://github.com/maddeye/android-sidemenu/raw/master/resources/Drag.jpg?raw=true)

Version
-------

0.0.1(beta)


Android Version
---------------

Android 2.2 API Level 8


How to use it
-------------

Activity where you want the menu

```Java
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.suse.android.sidemenu.SidemenuActivity;

public class SidemenuSampleActivity extends SidemenuActivity {
    
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setBehindContentView(R.layout.main2);
        
        ((Button)this.findViewById(R.id.btn_toggle)).setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                        toggle();
                }
        });
        
        setBehindOffset(60);
        setBehindScrollScale(0.5f);
    }
}
```


with **setContentView** you set the main screen layout (the screen with the white background) and with **setBehindContentView** you set the menu layout (grey background).

**toggle()** open/close the menu. You also can open the menu when you drag the left border.


License
-------

Copyright © 2011 SUSE LINUX Products GmbH.

Android-Sidemenu is licensed under the MIT license. See MIT-LICENSE for details.
